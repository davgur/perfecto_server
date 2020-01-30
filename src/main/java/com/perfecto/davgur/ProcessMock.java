package com.perfecto.davgur;

import static java.lang.Thread.sleep;

public class ProcessMock {
    private int interactions = 100;
    private boolean isStop = false;

    public ProcessMock(int interactions){
        this.interactions = interactions;
    }

    public void run() throws InterruptedException {
        int i = 0;
        while ( i < this.interactions && this.isStop){
            i++;
            sleep(100);
            if(i%10 == 0){
                this.callback();
            }
        }
    }

    private void callback() {
    }

    public void stop() {
        this.isStop = true;
    }

    public void start() throws InterruptedException {
        this.isStop = false;
        run();
    }
}
