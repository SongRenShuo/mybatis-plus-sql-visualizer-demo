package cn.song.previewfixtures;

import cn.song.mpjarlib.LegacyBooking;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/** 单独导入宿主 pom，让实体保持依赖 JAR 形态；这些方法不可运行。 */
public final class LegacyBookingCases {
    private LegacyBookingCases() { }

    public interface LegacyBookingMapper extends BaseMapper<LegacyBooking> { }

    public static void select(LegacyBookingMapper mapper) {
        mapper.selectList(new LambdaQueryWrapper<LegacyBooking>()
                .eq(LegacyBooking::getReferenceCode, "BOOK,100")
                .eq(LegacyBooking::getStateCode, 1));
    }

    public static void update(LegacyBookingMapper mapper) {
        mapper.update(null, new LambdaUpdateWrapper<LegacyBooking>()
                .set(LegacyBooking::getStateCode, 2)
                .eq(LegacyBooking::getReferenceCode, "BOOK,100"));
    }

    public static void insert(LegacyBookingMapper mapper, LegacyBooking entity) {
        mapper.insert(entity);
    }
}
