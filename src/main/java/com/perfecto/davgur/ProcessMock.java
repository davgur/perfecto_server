package com.perfecto.davgur;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class ProcessMock {
    private int interactions = 100;
    private boolean isStop = false;
    private ArrayList<IProcessListener> listeners = new ArrayList<>();


    public void addListener(IProcessListener listener) {
        listeners.add(listener);
    }

    public void run() {
        int i = 0;
        ProcessResult result = new ProcessResult();

        try {
            while (i < this.interactions && this.isStop) {
                i++;
                sleep(100);
                if (i % 10 == 0) {
                    result.setProcent(i * 100 % this.interactions);
                    result.setStatus(TestStatusEnum.RUNNING);
                    this.runCallbacks(result);
                }
            }
            result.setProcent(i * 100 % this.interactions);
            result.setStatus(this.isStop ? TestStatusEnum.STOPED : TestStatusEnum.ENDED);
        } catch (Exception e) {
            result.setProcent(i * 100 % this.interactions);
            result.setStatus(TestStatusEnum.ERROR);
            result.setMessage(e.getMessage());
        }
        this.runCallbacks(result);
    }

    private void runCallbacks(ProcessResult result) {
        this.listeners.forEach(l -> l.processCallback(result));
    }

    public void stop() {
        this.isStop = true;
    }

    public void start() {
        this.isStop = false;
        run();
    }
}
