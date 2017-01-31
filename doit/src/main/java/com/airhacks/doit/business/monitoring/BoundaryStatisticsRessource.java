package com.airhacks.doit.business.monitoring;

import java.util.LongSummaryStatistics;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;



/**
 *
 * @author Hijack
 */
@Stateless
@Path("boundary-statistics")
public class BoundaryStatisticsRessource {
    
    @Inject
    MonitorSink ms;
    
    @GET
    public JsonObject get() {
        LongSummaryStatistics statistics = ms.getStatistics();
        JsonObject jsonObject = Json.createObjectBuilder().add("average", statistics.getAverage()).add("invocation-count", statistics.getCount()).add("min-duration", statistics.getMin()).add("max-duration", statistics.getMax()).build();
        return jsonObject;
    }
    
}
