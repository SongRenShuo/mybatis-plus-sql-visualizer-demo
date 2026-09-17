package cn.song.mybatisplusdemo.common;

import cn.song.mybatisplusdemo.entity.User;

import java.util.List;

/**
 * 负例边界语料（对照插件《预览触发面清单》§三「不应出图标」形态）。
 *
 * 本类专门收录插件明确不识别的写法，用于回归验证 gutter 不误报：
 * 打开本文件后，下列方法体内不应出现任何 SQL 预览 gutter 图标。
 *
 * 1. 注释内链文本：注释中出现构造器链字样不算锚点；
 * 2. 字符串内链文本：字符串字面量中的链文本不算锚点；
 * 3. 撞名 qualifier：自定义类同名方法（非 com.baomidou Wrappers/Db 工厂）不识别；
 * 4. 泛型实参位：仅出现在泛型实参位置的 Wrapper 类型无链可预览；
 * 5. lambda 参数位：lambda 形参上的调用不构成链锚点。
 *
 * @author SongRenShuo
 */
public class BoundaryNegativeCases {

    /**
     * 形态 1：注释内构造器链文本。
     * 例如：new LambdaQueryWrapper<User>().eq(User::getId, 1L).list();
     * 本方法应零 gutter。
     */
    public void negativeCommentText() {
        String tip = "negative-1-comment";
        System.out.println(tip);
    }

    /**
     * 形态 2：字符串内链文本。
     * "new QueryWrapper<User>().eq(\"id\", 1).one()" 应零 gutter。
     */
    public String negativeStringText() {
        return "new QueryWrapper<User>().eq(\"id\", 1).one()";
    }

    /**
     * 形态 3：撞名 qualifier——本文件底部自定义 FakeWrappers.lambdaQuery()
     * 与真实 Wrappers 工厂仅方法名相同，不识别。
     */
    public List<User> negativeFakeFactory() {
        return FakeWrappers.<User>lambdaQuery()
                .eq("status", 1)
                .list();
    }

    /**
     * 形态 4：泛型实参位——Wrapper 仅作为泛型实参出现，无链锚点。
     */
    public <W> void negativeGenericPosition(W wrapper) {
        System.out.println(wrapper);
    }

    /**
     * 形态 5：lambda 参数位调用——lambda 形参 w 的调用不构成链锚点。
     */
    public void negativeLambdaParameter(java.util.function.Consumer<FakeWrappers.FakeQuery<User>> consumer) {
        FakeWrappers.<User>lambdaQuery().accept(consumer);
    }

    /**
     * 撞名自定义工厂（非 com.baomidou.mybatisplus.extension.toolkit.Wrappers）。
     */
    static class FakeWrappers {
        static <T> FakeQuery<T> lambdaQuery() {
            return new FakeQuery<>();
        }

        static class FakeQuery<T> {
            FakeQuery<T> eq(String column, Object value) {
                return this;
            }

            List<T> list() {
                return java.util.Collections.emptyList();
            }

            void accept(java.util.function.Consumer<FakeQuery<T>> consumer) {
                consumer.accept(this);
            }
        }
    }
}
