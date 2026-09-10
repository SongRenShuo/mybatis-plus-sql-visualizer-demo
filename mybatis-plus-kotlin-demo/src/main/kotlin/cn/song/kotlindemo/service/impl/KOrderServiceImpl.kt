package cn.song.kotlindemo.service.impl

import cn.song.kotlindemo.entity.KOrder
import cn.song.kotlindemo.mapper.KOrderMapper
import cn.song.kotlindemo.service.KOrderService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

/**
 * Kotlin 订单服务实现
 *
 * @author SongRenShuo
 */
@Service
open class KOrderServiceImpl : ServiceImpl<KOrderMapper, KOrder>(), KOrderService
