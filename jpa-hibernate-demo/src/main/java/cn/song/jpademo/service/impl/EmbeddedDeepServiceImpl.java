package cn.song.jpademo.service.impl;

import cn.song.jpademo.entity.CustomerEntity;
import cn.song.jpademo.repository.CustomerRepository;
import cn.song.jpademo.service.EmbeddedDeepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 嵌套嵌入深水区语料实现（走查口径见 {@link EmbeddedDeepService}）
 *
 * @author SongRenShuo
 */
@Service
public class EmbeddedDeepServiceImpl implements EmbeddedDeepService {

    @Resource
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> derivedNestedZip(String zip) {
        return customerRepository.findByAddressZipcodeZip(zip);
    }

    @Override
    public List<CustomerEntity> derivedPrefixStreet(String street) {
        return customerRepository.findByBizAddressStreet(street);
    }

    @Override
    public List<CustomerEntity> queryNestedArea(String areaCode) {
        return customerRepository.findByAreaCode(areaCode);
    }

    @Override
    public Map<String, List<CustomerEntity>> all(String zip, String street, String areaCode) {
        Map<String, List<CustomerEntity>> result = new HashMap<>(4);
        result.put("derivedNestedZip", customerRepository.findByAddressZipcodeZip(zip));
        result.put("derivedPrefixStreet", customerRepository.findByBizAddressStreet(street));
        result.put("queryNestedArea", customerRepository.findByAreaCode(areaCode));
        return result;
    }
}
