package com.corp.engine;

/**
 * 自研框架异常。
 *
 * @author SongRenShuo
 */
public class EngineException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EngineException(String message) {
        super(message);
    }

    public EngineException(String message, Throwable cause) {
        super(message, cause);
    }
}
