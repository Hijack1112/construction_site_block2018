package com.airhacks.doit.business.logging.boundary;

/**
 *
 * @author Hijack
 */
@FunctionalInterface
public interface LogSink {
    
    void log(String msg);
}
