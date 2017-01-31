package com.airhacks.doit.business.logging.boundary;

import java.util.logging.Logger;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;


/**
 *
 * @author Hijack
 */
public class LogSinkProducer  {
    
    @Produces
    LogSink produce(InjectionPoint ip) {    
        Class<?> injectionTarget = ip.getMember().getDeclaringClass();
        return Logger.getLogger(injectionTarget.getName())::info;
    }
}
