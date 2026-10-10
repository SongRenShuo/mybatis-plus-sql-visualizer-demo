package cn.song.jpademo.repository;

import cn.song.jpademo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 嵌套嵌入深水区语料 Repository（T-Embedded G1/G2 回归用）
 *
 * @author SongRenShuo
 */
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    /**
     * 嵌套嵌入段派生查询：属性路径 address.zipcode.zip 穿透两级 @Embedded——
     * 派生查询 WHERE 须映射到点路径覆写列 cust_zip（而非伪列 address_zipcode_zip）
     */
    List<CustomerEntity> findByAddressZipcodeZip(String zip);

    /**
     * 嵌入段前缀双嵌入派生查询：bizAddress.street 应映射 biz_street（SD prefix 语料）
     */
    List<CustomerEntity> findByBizAddressStreet(String street);

    /**
     * @Query JPQL 嵌套段路径对照：SELECT 投影 + WHERE + ORDER BY 三处嵌套属性
     */
    @Query("select c from CustomerEntity c where c.address.zipcode.areaCode = :areaCode "
            + "order by c.address.zipcode.zip desc")
    List<CustomerEntity> findByAreaCode(@Param("areaCode") String areaCode);
}
