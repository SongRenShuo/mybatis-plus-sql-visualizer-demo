package cn.song.sqlvis.repro;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

/**
 * 物理删接口实验：把 agent jar 里某个类的 {@code interfaces} 表清零，其余字节原样保留。
 *
 * <p>用途是**实测证伪**主控的假设「删掉 {@code implements Opcodes} 能把失败点后移到真正需要
 * ASM 的 {@code weave()}」。不碰主仓源码，只在复现目录里生成一份改过的 jar 副本。
 *
 * <p>zeroless 前提：删接口只改 {@code interfaces_count} 与其后紧跟的接口表，常量池索引不变，
 * 因此不需要重算偏移。
 */
public final class InterfaceStripper {

    /** 返回改过的 jar 路径；若无该类或无接口可删则返回 null。 */
    public static File strip(File srcJar, String entryName, File outJar) throws Exception {
        Map<String, byte[]> entries = new LinkedHashMap<String, byte[]>();
        byte[] manifest = null;
        try (JarFile jf = new JarFile(srcJar)) {
            List<String> names = new ArrayList<String>();
            for (JarEntry e : Collections.list(jf.entries())) {
                if (!e.isDirectory()) {
                    names.add(e.getName());
                }
            }
            Collections.sort(names);
            for (String n : names) {
                try (InputStream in = jf.getInputStream(jf.getEntry(n))) {
                    byte[] b = readAll(in);
                    if ("META-INF/MANIFEST.MF".equalsIgnoreCase(n)) {
                        manifest = b;
                    } else {
                        entries.put(n, b);
                    }
                }
            }
        }
        byte[] target = entries.get(entryName);
        if (target == null) {
            return null;
        }
        ClassFileModel model = ClassFileModel.parse(target);
        if (model.interfaces.length == 0) {
            return null;
        }
        byte[] patched = removeInterfaces(target, model);
        entries.put(entryName, patched);

        File parent = outJar.getParentFile();
        if (parent != null) {
            parent.mkdirs();
        }
        try (JarOutputStream out = new JarOutputStream(new FileOutputStream(outJar))) {
            if (manifest != null) {
                out.putNextEntry(new JarEntry("META-INF/MANIFEST.MF"));
                out.write(manifest);
                out.closeEntry();
            }
            for (Map.Entry<String, byte[]> e : entries.entrySet()) {
                out.putNextEntry(new JarEntry(e.getKey()));
                out.write(e.getValue());
                out.closeEntry();
            }
        }
        return outJar;
    }

    private static byte[] removeInterfaces(byte[] cls, ClassFileModel m) {
        int countOff = m.interfacesCountOffset;
        int endOff = m.interfacesEndOffset;
        int removeLen = endOff - (countOff + 2);
        byte[] out = new byte[cls.length - removeLen];
        System.arraycopy(cls, 0, out, 0, countOff);
        // interfaces_count = 0
        out[countOff] = 0;
        out[countOff + 1] = 0;
        System.arraycopy(cls, endOff, out, countOff + 2, cls.length - endOff);
        return out;
    }

    private static byte[] readAll(InputStream in) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[8192];
        int n;
        while ((n = in.read(buf)) > 0) {
            bos.write(buf, 0, n);
        }
        return bos.toByteArray();
    }

    private InterfaceStripper() {
    }
}
