package cn.song.kotlindemo.service.impl

import cn.song.kotlindemo.entity.KUser
import cn.song.kotlindemo.mapper.KUserMapper
import cn.song.kotlindemo.service.KUserService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

/**
 * Kotlin 用户服务实现
 *
 * @author SongRenShuo
 */
@Service
class KUserServiceImpl : ServiceImpl<KUserMapper, KUser>(), KUserService
