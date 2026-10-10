package cn.song.mybatisplusdemo.service;

import cn.song.mybatisplusdemo.entity.User;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 * 分页拦截器模拟语料（插件 R12 T-PaginationSim / T-CountSimToggle 回归用）
 *
 * <p>预期插件行为（对照走查口径）：
 * <ul>
 *   <li>mapper 方法（XML/注解）带 {@code IPage} 形参 → SELECT 尾追 LIMIT + 并列 COUNT 包裹语句；</li>
 *   <li>语句已手写 LIMIT → 不重复追加（只产 COUNT）；</li>
 *   <li>{@code new Page<>(current, size, searchCount)} 布尔第三参 → searchCount=false 时不产 COUNT；</li>
 *   <li>Wrapper 链消费（selectPage/selectList/selectMapsPage）同步识别 Page 构造器 searchCount。</li>
 * </ul>
 *
 * @author SongRenShuo
 */
public interface PageSimService {

    /** 注解 SQL + IPage 形参：@Select 路径分页模拟（预期 LIMIT + COUNT 两条） */
    IPage<User> annotationPage(int current, int size, Integer status);

    /** XML 分页（既有语料，无手写 LIMIT）：预期 LIMIT + COUNT 两条 */
    IPage<User> xmlPage(int current, int size, Integer status, String keyword);

    /** XML 手写 LIMIT + IPage 首位：预期只产 COUNT，不重复追加 LIMIT */
    IPage<User> xmlLimitPage(int current, int size, Integer status);

    /** searchCount=false 三参构造：预期只有 LIMIT、无 COUNT */
    IPage<User> noCountPage();

    /** searchCount 缺省（true）对照：预期 LIMIT + COUNT 两条 */
    IPage<User> countOnPage();

    /** 四参构造 Page(current, size, total, searchCount=false)：预期带 total 且无 COUNT */
    IPage<User> fourArgPage();

    /** BaseMapper.selectList(page, wrapper) 消费形态：Page 构造器布尔识别 */
    List<User> selectListPage(boolean searchCount);

    /** BaseMapper.selectMaps(page, wrapper) 消费形态：Map 族分页 */
    List<Map<String, Object>> selectMapsPage(boolean searchCount);
}
