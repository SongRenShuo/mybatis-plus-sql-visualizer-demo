package cn.song.custcenter.service.impl;

import cn.song.custcenter.entity.CustInfo;
import cn.song.custcenter.mapper.CustInfoMapper;
import cn.song.custcenter.service.CustInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.Date;
import java.util.List;

/**
 * CustInfo 服务实现（Wrapper / Page 压力档）。
 */
public class CustInfoServiceImpl implements CustInfoService {

    private final CustInfoMapper custInfoMapper;

    public CustInfoServiceImpl(CustInfoMapper custInfoMapper) {
        this.custInfoMapper = custInfoMapper;
    }

    public List<CustInfo> listByTenant(Long tenantId) {
        LambdaQueryWrapper<CustInfo> wrapper = new LambdaQueryWrapper<CustInfo>();
        wrapper.eq(CustInfo::getTenantId, tenantId)
                .eq(CustInfo::getDelFlag, "0")
                .orderByDesc(CustInfo::getCreateTime);
        return custInfoMapper.selectList(wrapper);
    }

    public IPage<CustInfo> pageByCondition(Page<CustInfo> page, Long tenantId, String keyword) {
        QueryWrapper<CustInfo> wrapper = new QueryWrapper<CustInfo>();
        wrapper.eq("tenant_id", tenantId)
                .eq("del_flag", "0")
                .like("cust_name", keyword)
                .orderByDesc("create_time");
        return custInfoMapper.selectPage(page, wrapper);
    }

    public int updateStatus(Long id, String status) {
        CustInfo entity = new CustInfo();
        entity.setStatus(status);
        entity.setUpdateTime(new Date());
        LambdaQueryWrapper<CustInfo> wrapper = new LambdaQueryWrapper<CustInfo>();
        wrapper.eq(CustInfo::getId, id);
        return custInfoMapper.update(entity, wrapper);
    }

    public long countByKeyword(Long tenantId, String keyword) {
        QueryWrapper<CustInfo> wrapper = new QueryWrapper<CustInfo>();
        wrapper.eq("tenant_id", tenantId)
                .like("cust_name", keyword);
        Long total = custInfoMapper.selectCount(wrapper);
        return total == null ? 0L : total.longValue();
    }

    public CustInfo getOneByCode(Long tenantId, String code) {
        QueryWrapper<CustInfo> wrapper = new QueryWrapper<CustInfo>();
        wrapper.eq("tenant_id", tenantId)
                .eq("cust_no", code)
                .last("limit 1");
        return custInfoMapper.selectOne(wrapper);
    }

}
