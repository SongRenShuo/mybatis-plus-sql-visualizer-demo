package cn.song.mybatisplusdemo.service;

import cn.song.mybatisplusdemo.entity.MixedProfile;

import java.util.Map;

/**
 * MP 混合注解实体语料（T-Embedded G3 回归用）
 *
 * <p>预期插件行为：所有语句的列面都是展平列（theme / notify_email / max_retry 与宿主列
 * name / remark 并列），不出现 {@code setting} 伪列；INSERT 批量模板同样按展平列出全列。
 *
 * <p><b>仅静态预览语料</b>：MP 3.5.7 运行期不解析 jakarta 注解，涉及 t_mixed_profile
 * 的真实调用会因伪列报错——本类不提供 HTTP 端点，走查只在 IDEA 预览层进行。
 *
 * @author SongRenShuo
 */
public interface MixedEntityService {

    /** 字符串列 QueryWrapper 命中展平列（eq("theme", ...)） */
    Object listByFlattenedColumn(String theme);

    /** Lambda 链（宿主字段）+ select 投影含展平列 */
    Object lambdaChainWithFlattenedSelect();

    /** getById 批量模板：SELECT 全列应为展平列集合 */
    Object getByIdFlattened(Long id);

    /** insert 批量模板：INSERT 列面应为展平列全列 */
    Object insertFlattened();

    /** updateById 批量模板：UPDATE SET 列面应为展平列 */
    Object updateByIdFlattened();
}
