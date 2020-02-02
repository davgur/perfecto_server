package com.perfecto.davgur;

import java.lang.String;

import java.util.ArrayList;
import java.util.Stack;

public class TestItem {
    private String name;
    private String owner;
    private Stack<Step> steps = new Stack<>();
    private TestStatusEnum status = TestStatusEnum.NOT_STARTED;
    private Long id;
    private ProcessMock process;
    private ProcessListener listener = new ProcessListener();


    public TestItem(String name) {
        this.setName(name);
        this.process.addListener(this.listener);
    }

    public void add(Step step) {
        this.steps.add(step);
    }

    public void stop() {
        this.process.stop();
    }

    public void start() {
        this.process.start();
    }


    public ArrayList<Step> getSteps() {
        return new ArrayList<>(steps);
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setStatus(TestStatusEnum status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("{name: %s,status: %s,id: %d,error: %s}", this.name, this.status.toString(), this.id);
    }
}
