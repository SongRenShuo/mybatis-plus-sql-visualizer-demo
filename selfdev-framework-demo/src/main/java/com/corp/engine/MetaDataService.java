package com.corp.engine;

import com.corp.meta.MetaRegistry;
import com.corp.meta.TableMeta;

/**
 * 自研框架元数据服务：schemaCode → {@link TableMeta}（未登记即抛框架异常）。
 *
 * @author SongRenShuo
 */
public class MetaDataService {

    public TableMeta resolve(String schemaCode) {
        TableMeta meta = MetaRegistry.resolve(schemaCode);
        if (meta == null) {
            throw new EngineException("未登记的 schemaCode: " + schemaCode);
        }
        return meta;
    }
}
