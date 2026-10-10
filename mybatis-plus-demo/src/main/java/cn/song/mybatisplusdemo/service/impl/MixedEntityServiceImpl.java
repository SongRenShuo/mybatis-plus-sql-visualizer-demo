package cn.song.mybatisplusdemo.service.impl;

import cn.song.mybatisplusdemo.entity.MixedProfile;
import cn.song.mybatisplusdemo.entity.ProfileSetting;
import cn.song.mybatisplusdemo.mapper.MixedProfileMapper;
import cn.song.mybatisplusdemo.service.MixedEntityService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * MP 混合注解实体语料实现（T-Embedded G3 回归用；走查口径见 {@link MixedEntityService}）
 *
 * @author SongRenShuo
 */
@Service
public class MixedEntityServiceImpl implements MixedEntityService {

    @Resource
    private MixedProfileMapper mixedProfileMapper;

    @Override
    public Object listByFlattenedColumn(String theme) {
        QueryWrapper<MixedProfile> wrapper = new QueryWrapper<MixedProfile>()
                .eq("theme", theme)
                .gt("max_retry", 0)
                .orderByDesc("notify_email");
        return mixedProfileMapper.selectList(wrapper);
    }

    @Override
    public Object lambdaChainWithFlattenedSelect() {
        LambdaQueryWrapper<MixedProfile> wrapper = new LambdaQueryWrapper<MixedProfile>()
                .select(MixedProfile::getId, MixedProfile::getName, MixedProfile::getRemark)
                .eq(MixedProfile::getName, "demo")
                .orderByAsc(MixedProfile::getId);
        return mixedProfileMapper.selectList(wrapper);
    }

    @Override
    public Object getByIdFlattened(Long id) {
        return mixedProfileMapper.selectById(id);
    }

    @Override
    public Object insertFlattened() {
        MixedProfile profile = new MixedProfile();
        profile.setName("mixed-demo");
        ProfileSetting setting = new ProfileSetting();
        setting.setTheme("dark");
        setting.setNotifyEmail("demo@example.com");
        setting.setMaxRetry(3);
        profile.setSetting(setting);
        return mixedProfileMapper.insert(profile);
    }

    @Override
    public Object updateByIdFlattened() {
        MixedProfile profile = new MixedProfile();
        profile.setId(1L);
        profile.setRemark("updated");
        ProfileSetting setting = new ProfileSetting();
        setting.setTheme("light");
        profile.setSetting(setting);
        return mixedProfileMapper.updateById(profile);
    }
}
