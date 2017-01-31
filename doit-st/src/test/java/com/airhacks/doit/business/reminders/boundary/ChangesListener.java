package com.airhacks.doit.business.reminders.boundary;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.json.JsonObject;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

/**
 *
 * @author Hijack
 */
public class ChangesListener extends Endpoint {

    JsonObject message;
    CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler((MessageHandler.Whole<JsonObject>) new MessageHandler.Whole<JsonObject>() {
            @Override
            public void onMessage(JsonObject msg) {
                ChangesListener.this.message = msg;
                latch.countDown();
                System.out.println("message = " + msg);
            }
        });
    }

    public JsonObject getMessage() throws InterruptedException {
        latch.await(1, TimeUnit.MINUTES);
        return message;
    }

}
