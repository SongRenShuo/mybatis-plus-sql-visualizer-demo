package cn.song.sqlvis.repro.fixture;

/**
 * 一个在机制对照实验里「不可见」的类型。它的方法体不重要，重要的是它会出现在
 * {@link Holder} 的 StackMapTable 帧里。
 */
public class Invisible {

    @Override
    public String toString() {
        return "invisible";
    }
}
