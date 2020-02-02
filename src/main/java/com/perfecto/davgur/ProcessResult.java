package com.perfecto.davgur;

public class ProcessResult {
    private int procent;
    private TestStatusEnum status;
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getProcent() {
        return procent;
    }

    public void setProcent(int procent) {
        this.procent = procent;
    }

    public TestStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TestStatusEnum status) {
        this.status = status;
    }

}
