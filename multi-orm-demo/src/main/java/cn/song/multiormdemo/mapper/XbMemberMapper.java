package cn.song.multiormdemo.mapper;

import cn.song.multiormdemo.entity.XbMember;
import cn.xbatis.core.mybatis.mapper.MybatisMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * xbatis 成员 Mapper（@Mapper 触发 starter 自动扫描）
 *
 * @author SongRenShuo
 */
@Mapper
public interface XbMemberMapper extends MybatisMapper<XbMember> {
}
