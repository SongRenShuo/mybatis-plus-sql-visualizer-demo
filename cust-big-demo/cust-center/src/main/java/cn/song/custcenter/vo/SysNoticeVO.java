package cn.song.custcenter.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 通知公告 视图对象。
 */
public class SysNoticeVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 关键字 */
    private String noticeTitle;

    /** 状态 */
    private String status;

    /** 创建时间 */
    private Date createTime;

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SysNoticeVO{");
        sb.append("noticeTitle=").append(noticeTitle).append(", ");
        sb.append("status=").append(status).append(", ");
        sb.append("createTime=").append(createTime).append(", ");
        sb.append('}');
        return sb.toString();
    }
}
