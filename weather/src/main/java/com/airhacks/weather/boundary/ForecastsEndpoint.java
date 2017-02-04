package com.airhacks.weather.boundary;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Hijack
 */
@Startup
@Singleton
@ServerEndpoint("/forecasts")
public class ForecastsEndpoint {

    private Session session;

    @OnOpen
    public void open(Session session) {
        this.session = session;
    }

    public void sendWeatherForecast(String message) {
        try {
            if (this.session != null && this.session.isOpen()) {
                this.session.getBasicRemote().sendText(message);
            }
        } catch (IOException ex) {
            Logger.getLogger(ForecastsEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Schedule(hour = "*", minute = "*", second = "*/2", persistent = false)
    public void ticker() {
        System.out.println(".");
        this.sendWeatherForecast("micro clouds: " + System.currentTimeMillis());
    }

}
