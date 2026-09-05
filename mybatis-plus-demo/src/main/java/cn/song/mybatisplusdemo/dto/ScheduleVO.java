package cn.song.mybatisplusdemo.dto;

/**
 * 工作流任务统计 VO（对齐用户真实项目 ScheduleVO 形态）
 *
 * @author SongRenShuo
 */
public class ScheduleVO {

    /** 任务名 */
    private String taskName;

    /** 任务数 */
    private Integer taskNumber;

    /** 流程标识 */
    private String flowKey;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getFlowKey() {
        return flowKey;
    }

    public void setFlowKey(String flowKey) {
        this.flowKey = flowKey;
    }
}
