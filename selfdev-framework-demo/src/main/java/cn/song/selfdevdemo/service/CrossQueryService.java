package cn.song.selfdevdemo.service;

import java.util.List;
import java.util.Map;

/**
 * 业务横向协作服务：由 {@link SourceCaptureDepthService} 调用的**平级**业务服务，
 * 自身再触达框架门面——用于验证跨类协作时业务帧链的完整性。
 *
 * @author SongRenShuo
 */
public interface CrossQueryService {

    /** 跨服务查询。 */
    List<Map<String, Object>> crossQuery(String owner, int limit);
}
