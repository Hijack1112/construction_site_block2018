package com.airhacks.ticker.boundary;

import com.airhacks.ticker.control.TickerEndpoint;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.websocket.ClientEndpointConfig;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Hijack
 */
//to be eagerly initialized
@Startup
@Singleton
public class Ticker {

    private WebSocketContainer container;
    private TickerEndpoint ticker;

    @PostConstruct
    public void connect() {

        ClientEndpointConfig cec = ClientEndpointConfig.Builder.create().build();
        //now we can communicate with the other side
        this.container = ContainerProvider.getWebSocketContainer();
        this.ticker = new TickerEndpoint();
        try {
            this.container.connectToServer(ticker, cec, new URI("ws://localhost:8080/weather/forecasts"));
        } catch (DeploymentException | URISyntaxException | IOException ex) {
            Logger.getLogger(Ticker.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

}
