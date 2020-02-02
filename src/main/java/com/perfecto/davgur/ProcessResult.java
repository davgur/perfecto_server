package com.perfecto.davgur;

import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ProcessResult extends TextWebSocketHandler {
    private int percent;
    private TestStatusEnum status;
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public TestStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TestStatusEnum status) {
        this.status = status;
    }

}
