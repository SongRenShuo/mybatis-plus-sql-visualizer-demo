package cn.song.sqlvis.repro;

/**
 * 最小 class 文件读取器：只做两件事——取接口表、算「活引用闭包」。
 *
 * <p>为什么不用 ASM：本复现要证明的正是「ASM 在运行期不可见」，用 ASM 去分析等于把待证对象
 * 塞进了测量工具里。这里手写常量池 + 属性遍历，无任何第三方依赖。
 *
 * <p>「活引用」的定义：从 this/super/interfaces、字段与方法描述符、以及各类属性（Code 的字节码
 * 操作数、StackMapTable 的 Object 项、Exceptions、InnerClasses、NestHost 等）出发，顺着常量池
 * 的引用边扩张到不动点。**只有落在闭包里的常量池项才算运行期会被解析的引用**；未落进闭包的
 * Class 项是 `ClassWriter(reader, flags)` 拷贝常量池留下的死条目（打包器的典型副产物），
 * 它们不会引发 NoClassDefFoundError。
 */
public final class ClassFileModel {

    private static final int CP_UTF8 = 1, CP_INT = 3, CP_FLOAT = 4, CP_LONG = 5, CP_DOUBLE = 6,
            CP_CLASS = 7, CP_STRING = 8, CP_FIELDREF = 9, CP_METHODREF = 10, CP_IMETHODREF = 11,
            CP_NAMEANDTYPE = 12, CP_METHODHANDLE = 15, CP_METHODTYPE = 16, CP_DYNAMIC = 17,
            CP_INVOKEDYNAMIC = 18, CP_MODULE = 19, CP_PACKAGE = 20;

    public final int[] tags;
    public final int[] refA;
    public final int[] refB;
    public final String[] utf8;
    public final int cpSize;

    public final int access;
    public final int thisClass;
    public final int superClass;
    public final int[] interfaces;

    /** interfaces_count 字段在字节流中的偏移（供「物理删接口」实验做无损改写）。 */
    public final int interfacesCountOffset;
    /** 接口数组结束后的偏移（字段表起点）。 */
    public final int interfacesEndOffset;

    private final java.util.Set<Integer> roots = new java.util.LinkedHashSet<Integer>();
    private final java.util.Set<Integer> live = new java.util.LinkedHashSet<Integer>();

    /** 方法（{@code name desc}）→ 该方法 Code 区间内直接引用的成员（{@code owner.name:desc}）。 */
    public final java.util.Map<String, java.util.List<String>> methodMemberRefs =
            new java.util.LinkedHashMap<String, java.util.List<String>>();
    private final java.util.Set<Integer> currentMethodCp = new java.util.LinkedHashSet<Integer>();
    private String currentMethodKey;

    private ClassFileModel(byte[] bytes) {
        Cursor in = new Cursor(bytes);
        int magic = (int) in.u4();
        if (magic != 0xCAFEBABE) {
            throw new IllegalArgumentException("not a class file");
        }
        in.u2(); // minor
        in.u2(); // major
        cpSize = in.u2();
        tags = new int[cpSize];
        refA = new int[cpSize];
        refB = new int[cpSize];
        utf8 = new String[cpSize];
        for (int i = 1; i < cpSize; i++) {
            int tag = in.u1();
            tags[i] = tag;
            switch (tag) {
                case CP_UTF8 -> utf8[i] = in.modifiedUtf8();
                case CP_INT, CP_FLOAT -> in.skip(4);
                case CP_LONG, CP_DOUBLE -> {
                    in.skip(8);
                    i++; // 8 字节常量占两个槽
                }
                case CP_CLASS, CP_STRING, CP_METHODTYPE, CP_MODULE, CP_PACKAGE -> refA[i] = in.u2();
                case CP_FIELDREF, CP_METHODREF, CP_IMETHODREF, CP_NAMEANDTYPE,
                        CP_DYNAMIC, CP_INVOKEDYNAMIC -> {
                    refA[i] = in.u2();
                    refB[i] = in.u2();
                }
                case CP_METHODHANDLE -> {
                    refA[i] = in.u1();
                    refB[i] = in.u2();
                }
                default -> throw new IllegalStateException("bad cp tag " + tag + " at " + i);
            }
        }
        access = in.u2();
        thisClass = in.u2();
        superClass = in.u2();
        interfacesCountOffset = in.pos();
        interfaces = new int[in.u2()];
        for (int i = 0; i < interfaces.length; i++) {
            interfaces[i] = in.u2();
        }
        interfacesEndOffset = in.pos();
        readMembers(in, false);
        readMembers(in, true);
        readAttributes(in);
        expand();
    }

    public static ClassFileModel parse(byte[] bytes) {
        return new ClassFileModel(bytes);
    }

    private void readMembers(Cursor in, boolean method) {
        int count = in.u2();
        for (int i = 0; i < count; i++) {
            in.u2(); // access
            int nameIdx = in.u2();
            int descIdx = in.u2();
            roots.add(nameIdx);
            roots.add(descIdx);
            if (method) {
                currentMethodKey = name(nameIdx) + " " + name(descIdx);
                currentMethodCp.clear();
                methodMemberRefs.put(currentMethodKey, new java.util.ArrayList<String>());
            }
            readAttributes(in);
            if (method) {
                flushMethodRefs();
                currentMethodKey = null;
            }
        }
    }

    private void readAttributes(Cursor in) {
        int count = in.u2();
        for (int i = 0; i < count; i++) {
            int nameIdx = in.u2();
            int len = (int) in.u4();
            roots.add(nameIdx);
            byte[] payload = in.take(len);
            walkAttribute(name(nameIdx), payload);
        }
    }

    private void walkAttribute(String attr, byte[] payload) {
        Cursor c = new Cursor(payload);
        switch (attr == null ? "" : attr) {
            case "Code" -> {
                c.u2();
                c.u2();
                int codeLen = (int) c.u4();
                byte[] code = c.take(codeLen);
                scanBytecode(code);
                int handlers = c.u2();
                for (int i = 0; i < handlers; i++) {
                    c.u2();
                    c.u2();
                    c.u2();
                    roots.add(c.u2()); // catch_type
                }
                int attrs = c.u2();
                for (int i = 0; i < attrs; i++) {
                    int n = c.u2();
                    int l = (int) c.u4();
                    roots.add(n);
                    walkAttribute(name(n), c.take(l));
                }
            }
            case "ConstantValue", "Signature", "SourceFile", "NestHost" -> roots.add(c.u2());
            case "Exceptions", "NestMembers" -> {
                int n = c.u2();
                for (int i = 0; i < n; i++) {
                    roots.add(c.u2());
                }
            }
            case "InnerClasses" -> {
                int n = c.u2();
                for (int i = 0; i < n; i++) {
                    roots.add(c.u2());
                    roots.add(c.u2());
                    roots.add(c.u2());
                    c.u2();
                }
            }
            case "EnclosingMethod" -> {
                roots.add(c.u2());
                roots.add(c.u2());
            }
            case "LocalVariableTable", "LocalVariableTypeTable" -> {
                int n = c.u2();
                for (int i = 0; i < n; i++) {
                    c.u2();
                    c.u2();
                    roots.add(c.u2());
                    roots.add(c.u2());
                    c.u2();
                }
            }
            case "StackMapTable" -> walkStackMap(c);
            case "MethodParameters" -> {
                int n = c.u1();
                for (int i = 0; i < n; i++) {
                    roots.add(c.u2());
                    c.u2();
                }
            }
            default -> {
                // LineNumberTable / RuntimeVisibleAnnotations / BootstrapMethods 等：本类不含
                // 影响结论的类引用；不解析即不误判（宁可少收引用，也不会凭空多收）。
            }
        }
    }

    private void walkStackMap(Cursor c) {
        int entries = c.u2();
        for (int i = 0; i < entries; i++) {
            int tag = c.u1();
            if (tag <= 63) {
                continue;
            } else if (tag <= 127) {
                verificationType(c);
            } else if (tag == 247) {
                c.u2();
                verificationType(c);
            } else if (tag <= 250) {
                c.u2();
            } else if (tag == 251) {
                c.u2();
            } else if (tag <= 254) {
                c.u2();
                int k = tag - 251;
                for (int j = 0; j < k; j++) {
                    verificationType(c);
                }
            } else if (tag == 255) {
                c.u2();
                int locals = c.u2();
                for (int j = 0; j < locals; j++) {
                    verificationType(c);
                }
                int stack = c.u2();
                for (int j = 0; j < stack; j++) {
                    verificationType(c);
                }
            } else {
                throw new IllegalStateException("bad stackmap tag " + tag);
            }
        }
    }

    private void verificationType(Cursor c) {
        int tag = c.u1();
        if (tag == 7) {          // Object
            roots.add(c.u2());
        } else if (tag == 8) {   // Uninitialized
            c.u2();
        }
    }

    /** 扫描字节码里所有引用常量池的操作数（单字节索引 ldc 与双字节索引）。 */
    private void scanBytecode(byte[] code) {
        int i = 0;
        while (i < code.length) {
            int op = code[i] & 0xFF;
            switch (op) {
                case 0x12 -> {                       // ldc
                    roots.add(code[i + 1] & 0xFF);
                    i += 2;
                }
                case 0x13, 0x14 -> {                 // ldc_w / ldc2_w
                    roots.add(u2(code, i + 1));
                    i += 3;
                }
                case 0x10 -> i += 2;                 // bipush
                case 0x11 -> i += 3;                 // sipush
                case 0x15, 0x16, 0x17, 0x18, 0x19,   // *load
                        0x36, 0x37, 0x38, 0x39, 0x3A, // *store
                        0xA9, 0xBC -> i += 2;         // ret / newarray
                case 0x84 -> i += 3;                 // iinc
                case 0x99, 0x9A, 0x9B, 0x9C, 0x9D, 0x9E, 0x9F, 0xA0, 0xA1,
                        0xA2, 0xA3, 0xA4, 0xA5, 0xA6, 0xA7, 0xA8 -> i += 3; // if*/goto/jsr
                case 0xB2, 0xB3, 0xB4, 0xB5,         // get/put field/static
                        0xB6, 0xB7, 0xB8,             // invoke*
                        0xBB, 0xBD, 0xC0, 0xC1,       // new/anewarray/checkcast/instanceof
                        0xC6, 0xC7 -> {               // ifnull/ifnonnull
                    int ref = u2(code, i + 1);
                    roots.add(ref);
                    currentMethodCp.add(ref);
                    i += 3;
                }
                case 0xB9, 0xBA -> {                 // invokeinterface / invokedynamic
                    roots.add(u2(code, i + 1));
                    i += 5;
                }
                case 0xC5 -> {                       // multianewarray
                    roots.add(u2(code, i + 1));
                    i += 4;
                }
                case 0xC8, 0xC9 -> i += 5;           // goto_w / jsr_w
                case 0xAA -> {                       // tableswitch
                    int p = (i + 4) & ~3;
                    int lo = s4(code, p + 4);
                    int hi = s4(code, p + 8);
                    i = p + 12 + 4 * (hi - lo + 1);
                }
                case 0xAB -> {                       // lookupswitch
                    int p = (i + 4) & ~3;
                    i = p + 8 + 8 * s4(code, p + 4);
                }
                case 0xC4 -> {                       // wide
                    int sub = code[i + 1] & 0xFF;
                    i += (sub == 0x84) ? 6 : 4;
                }
                default -> i += 1;
            }
        }
    }

    private static int u2(byte[] b, int p) {
        return ((b[p] & 0xFF) << 8) | (b[p + 1] & 0xFF);
    }

    private static int s4(byte[] b, int p) {
        return ((b[p] & 0xFF) << 24) | ((b[p + 1] & 0xFF) << 16)
                | ((b[p + 2] & 0xFF) << 8) | (b[p + 3] & 0xFF);
    }

    /** 常量池引用闭包。 */
    private void expand() {
        java.util.ArrayDeque<Integer> work = new java.util.ArrayDeque<Integer>(roots);
        while (!work.isEmpty()) {
            int idx = work.poll();
            if (idx <= 0 || idx >= cpSize || !live.add(idx)) {
                continue;
            }
            switch (tags[idx]) {
                case CP_CLASS, CP_STRING, CP_METHODTYPE, CP_MODULE, CP_PACKAGE ->
                        work.add(refA[idx]);
                case CP_FIELDREF, CP_METHODREF, CP_IMETHODREF, CP_NAMEANDTYPE,
                        CP_DYNAMIC, CP_INVOKEDYNAMIC -> {
                    work.add(refA[idx]);
                    work.add(refB[idx]);
                }
                case CP_METHODHANDLE -> work.add(refB[idx]);
                default -> {
                }
            }
        }
    }

    public String name(int cpIndex) {
        if (cpIndex <= 0 || cpIndex >= cpSize || tags[cpIndex] != CP_UTF8) {
            return null;
        }
        return utf8[cpIndex];
    }

    /** 内部名（斜杠）形式的类名。 */
    public String className(int cpIndex) {
        if (cpIndex <= 0 || cpIndex >= cpSize || tags[cpIndex] != CP_CLASS) {
            return null;
        }
        return name(refA[cpIndex]);
    }

    public java.util.List<String> interfaceNames() {
        java.util.List<String> out = new java.util.ArrayList<String>();
        for (int idx : interfaces) {
            out.add(className(idx));
        }
        return out;
    }

    /** 活引用里所有以 prefix 开头的 Class 项（去重、保序）。 */
    public java.util.List<String> liveClassRefs(String prefix) {
        java.util.List<String> out = new java.util.ArrayList<String>();
        for (int idx : live) {
            if (tags[idx] == CP_CLASS) {
                String n = className(idx);
                if (n != null && n.startsWith(prefix) && !out.contains(n)) {
                    out.add(n);
                }
            }
        }
        return out;
    }

    /** 常量池里存在、但不在活引用闭包内的 Class 项（打包器拷贝常量池留下的死条目）。 */
    public java.util.List<String> deadClassEntries(String prefix) {
        java.util.List<String> out = new java.util.ArrayList<String>();
        for (int i = 1; i < cpSize; i++) {
            if (tags[i] == CP_CLASS && !live.contains(i)) {
                String n = className(i);
                if (n != null && n.startsWith(prefix) && !out.contains(n)) {
                    out.add(n);
                }
            }
        }
        return out;
    }

    /** 活引用里「owner 为给定类」的字段/方法引用，形如 {@code owner.name:desc}。 */
    public java.util.List<String> liveMemberRefsOwnedBy(String ownerInternalName) {
        java.util.List<String> out = new java.util.ArrayList<String>();
        for (int idx : live) {
            int tag = tags[idx];
            if (tag != CP_FIELDREF && tag != CP_METHODREF && tag != CP_IMETHODREF) {
                continue;
            }
            String owner = className(refA[idx]);
            if (!ownerInternalName.equals(owner)) {
                continue;
            }
            int nat = refB[idx];
            if (nat <= 0 || nat >= cpSize) {
                continue;
            }
            String n = name(refA[nat]);
            String d = name(refB[nat]);
            String s = owner + "." + n + ":" + d;
            if (!out.contains(s)) {
                out.add(s);
            }
        }
        return out;
    }

    private void flushMethodRefs() {
        if (currentMethodKey == null) {
            return;
        }
        java.util.Set<String> refs = new java.util.LinkedHashSet<String>();
        for (int idx : currentMethodCp) {
            int tag = idx > 0 && idx < cpSize ? tags[idx] : 0;
            if (tag != CP_FIELDREF && tag != CP_METHODREF && tag != CP_IMETHODREF) {
                continue;
            }
            String owner = className(refA[idx]);
            int nat = refB[idx];
            if (owner == null || nat <= 0 || nat >= cpSize) {
                continue;
            }
            refs.add(owner + "." + name(refA[nat]) + ":" + name(refB[nat]));
        }
        methodMemberRefs.put(currentMethodKey, new java.util.ArrayList<String>(refs));
        currentMethodCp.clear();
    }

    /** 哪些方法的字节码直接引用了 owner 的成员。 */
    public java.util.List<String> methodsTouching(String ownerInternalName) {
        java.util.List<String> out = new java.util.ArrayList<String>();
        for (java.util.Map.Entry<String, java.util.List<String>> e : methodMemberRefs.entrySet()) {
            for (String ref : e.getValue()) {
                if (ref.startsWith(ownerInternalName + ".")) {
                    out.add(e.getKey());
                    break;
                }
            }
        }
        return out;
    }

    /** 哪些方法直接引用了 owner 的某个成员名。 */
    public java.util.List<String> methodsTouchingMember(String ownerInternalName, String memberName) {
        java.util.List<String> out = new java.util.ArrayList<String>();
        for (java.util.Map.Entry<String, java.util.List<String>> e : methodMemberRefs.entrySet()) {
            for (String ref : e.getValue()) {
                if (ref.startsWith(ownerInternalName + "." + memberName + ":")) {
                    out.add(e.getKey());
                    break;
                }
            }
        }
        return out;
    }

    /** 所有方法（name desc），按类文件顺序。 */
    public java.util.List<String> methodKeys() {
        return new java.util.ArrayList<String>(methodMemberRefs.keySet());
    }

    private static final class Cursor {
        private final byte[] b;
        private int p;

        Cursor(byte[] b) {
            this.b = b;
        }

        int u1() {
            return b[p++] & 0xFF;
        }

        int u2() {
            int v = ClassFileModel.u2(b, p);
            p += 2;
            return v;
        }

        long u4() {
            long v = ((long) (b[p] & 0xFF) << 24) | ((b[p + 1] & 0xFF) << 16)
                    | ((b[p + 2] & 0xFF) << 8) | (b[p + 3] & 0xFF);
            p += 4;
            return v;
        }

        void skip(int n) {
            p += n;
        }

        int pos() {
            return p;
        }

        byte[] take(int n) {
            byte[] out = new byte[n];
            System.arraycopy(b, p, out, 0, n);
            p += n;
            return out;
        }

        String modifiedUtf8() {
            int len = u2();
            String s = new String(b, p, len, java.nio.charset.StandardCharsets.UTF_8);
            p += len;
            return s;
        }
    }
}
