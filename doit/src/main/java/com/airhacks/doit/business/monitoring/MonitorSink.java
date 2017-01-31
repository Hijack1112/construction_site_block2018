package com.airhacks.doit.business.monitoring;

import com.airhacks.doit.business.logging.boundary.CallEvent;
import com.airhacks.doit.business.logging.boundary.LogSink;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 *
 * @author Hijack
 */
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@Singleton
public class MonitorSink {

    @Inject
    LogSink LOG;

    CopyOnWriteArrayList<CallEvent> recentEvent;

    @PostConstruct
    public void init() {
        //due to ConcurrencyManagementType
        this.recentEvent = new CopyOnWriteArrayList<>();
    }

    public void onCallEvent(@Observes CallEvent event) {
        LOG.log(event.toString());
        this.recentEvent.add(event);
    }

    public List<CallEvent> getRecentEvent() {
        return this.recentEvent;
    }

    public LongSummaryStatistics getStatistics() {
        return this.recentEvent.stream().collect(Collectors.summarizingLong(CallEvent::getDuration));
    }
}
