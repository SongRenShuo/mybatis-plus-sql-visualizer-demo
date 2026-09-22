package com.corp.engine;

/**
 * 自研框架引擎持有者：把 Spring 装配出的内部服务交给静态门面 {@link DataUpdateTool}。
 *
 * <p>真实自研框架常见形态——业务写 {@code DataUpdateTool.findByFilter(...)} 静态调用，
 * 门面背后持有一套由框架自身装配（或 auto-configuration）的引擎服务。
 *
 * @author SongRenShuo
 */
public final class EngineHolder {

    private final LocalDbService localDbService;
    private final MetaDataService metaDataService;
    private final DataAccessFacade facade;

    public EngineHolder(LocalDbService localDbService, MetaDataService metaDataService,
                        DataAccessFacade facade) {
        this.localDbService = localDbService;
        this.metaDataService = metaDataService;
        this.facade = facade;
    }

    public LocalDbService getLocalDbService() {
        return localDbService;
    }

    public MetaDataService getMetaDataService() {
        return metaDataService;
    }

    public DataAccessFacade getFacade() {
        return facade;
    }
}
