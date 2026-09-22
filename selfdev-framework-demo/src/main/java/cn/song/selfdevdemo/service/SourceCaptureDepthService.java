package cn.song.selfdevdemo.service;

import java.util.List;
import java.util.Map;

/**
 * B 组语料：**委托深度**矩阵（业务帧在调用栈中的层数与形态）。
 *
 * <p>登记前缀后主位置应稳定落在**最深的业务帧**，本组用于验证：
 * 无论业务委托一层、三层还是跨服务，落点都不会漂到外层调用者或框架帧。
 *
 * @author SongRenShuo
 */
public interface SourceCaptureDepthService {

    /** 13. 浅层：本服务直接触达门面。 */
    List<Map<String, Object>> shallow(int status);

    /** 14. 三层委托：本服务 → 中间层 → 内层 → 门面。 */
    List<Map<String, Object>> deepThree(String planId);

    /** 15. 跨服务：本服务 → 平级协作服务 → 门面。 */
    List<Map<String, Object>> crossService(String owner, int limit);

    /** 16. 业务包内委托壳（**负例**：该包不应登记为前缀）。 */
    List<Map<String, Object>> viaBusinessDelegate(String owner);
}
