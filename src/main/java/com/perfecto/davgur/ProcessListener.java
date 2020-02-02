package com.perfecto.davgur;

import com.google.gson.Gson;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

public class ProcessListener implements IProcessListener {


    private WebSocketClient client = new StandardWebSocketClient();
    private String url = "ws://localhost:8080/socket";
    private ListenableFuture<StompSession> listener;

    public ProcessListener() {
        this.listener = initWS();
    }

    @Override
    public void processCallback(ProcessResult result) {
        try {
            this.listener.get().send("sadas", result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ListenableFuture<StompSession> initWS() {

        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new SimpleMessageConverter());

        StompSessionHandler sessionHandler = new MyStompSessionHandler();
        return stompClient.connect(url, sessionHandler);
    }

}
