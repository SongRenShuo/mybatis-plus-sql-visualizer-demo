package cn.song.custcenter.config;

/**
 * 租户隔离配置。
 */
public class TenantConfig {

    /** 默认租户。 */
    public Long defaultTenantId() {
        return Long.valueOf(1L);
    }
}
