package cn.song.custmetadata.mapper;

import cn.song.custmetadata.entity.CustBankAcct;
import cn.song.custmetadata.example.CustBankAcctExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * CUST_BANK_ACCT 表 Mapper（MyBatis Generator 生成风格）。
 *
 * <p>客户银行账户。Example 查询入口是全仓调用点最密集的方法。
 */
public interface CustBankAcctMapper {

    int countByExample(CustBankAcctExample example);

    int deleteByExample(CustBankAcctExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CustBankAcct record);

    int insertSelective(CustBankAcct record);

    List<CustBankAcct> selectByExample(CustBankAcctExample example);

    CustBankAcct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CustBankAcct record, @Param("example") CustBankAcctExample example);

    int updateByExample(@Param("record") CustBankAcct record, @Param("example") CustBankAcctExample example);

    int updateByPrimaryKeySelective(CustBankAcct record);

    int updateByPrimaryKey(CustBankAcct record);

}
