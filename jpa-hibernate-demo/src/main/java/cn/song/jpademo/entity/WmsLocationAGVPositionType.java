package cn.song.jpademo.entity;

/**
 * 库位 AGV 位置类型枚举（O-111 复现用例配套）。
 *
 * 字段形态对齐用户反馈截图中的 WmsLocationAGVPositionType：TC（拣货位）等。
 *
 * @author SongRenShuo
 */
public enum WmsLocationAGVPositionType {

    /** 拣货位（对齐截图 setParameter("positionType", WmsLocationAGVPositionType.TC)） */
    TC,

    /** 空闲位 */
    EMPTY,

    /** 占用位 */
    OCCUPIED
}
