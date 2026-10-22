package cn.song.sqlvis.repro;

/**
 * Repro B 的最小宿主：只打印一行并退出。用于证明「没有第三方加载器时，-javaagent 正常起来」。
 */
public final class MinimalMain {

    public static void main(String[] args) {
        System.out.println("[MinimalMain] started, java=" + System.getProperty("java.version")
                + ", systemClassLoader=" + ClassLoader.getSystemClassLoader().getClass().getName());
        System.out.println("[MinimalMain] exiting normally");
    }
}
