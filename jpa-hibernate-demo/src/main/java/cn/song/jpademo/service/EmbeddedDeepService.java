package cn.song.jpademo.service;

import cn.song.jpademo.entity.CustomerEntity;

import java.util.List;
import java.util.Map;

/**
 * 嵌套嵌入深水区语料服务（T-Embedded G1/G2 回归用）
 *
 * <p>走查口径：派生查询与 @Query 的列面都应为覆写/前缀后的真实列
 * （cust_zip / biz_street / cust_street / area_code），不得出现伪列拼接。
 *
 * @author SongRenShuo
 */
public interface EmbeddedDeepService {

    /** 嵌套段派生查询：findByAddressZipcodeZip → WHERE cust_zip = ? */
    List<CustomerEntity> derivedNestedZip(String zip);

    /** prefix 双嵌入派生查询：findByBizAddressStreet → WHERE biz_street = ? */
    List<CustomerEntity> derivedPrefixStreet(String street);

    /** @Query JPQL 嵌套段（投影/排序对照） */
    List<CustomerEntity> queryNestedArea(String areaCode);

    /** 汇总调用（一次走查多条） */
    Map<String, List<CustomerEntity>> all(String zip, String street, String areaCode);
}
