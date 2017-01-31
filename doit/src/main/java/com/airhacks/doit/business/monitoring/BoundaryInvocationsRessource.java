package com.airhacks.doit.business.monitoring;



import com.airhacks.doit.business.logging.boundary.CallEvent;
import com.airhacks.doit.business.monitoring.MonitorSink;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author Hijack
 */
@Stateless
@Path("boundary-invocations")
public class BoundaryInvocationsRessource {

    @Inject
    MonitorSink ms;
    
    @GET
    public List<CallEvent> expose() {
        return this.ms.getRecentEvent();
    }
}
