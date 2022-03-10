package com.Semaforo;

import static java.lang.Thread.sleep;

public class ThreadSemaforo implements Runnable{

    private CorSemafaro cor;
    private Boolean isRunning;
    private Boolean isSuspending;
    public boolean corMudou;

    public ThreadSemaforo() {
        this.cor = CorSemafaro.VERMELHO;

        corMudou = false;
        isRunning = true;
        isSuspending = false;

        new Thread(this).start();
    }

    public CorSemafaro getCor() {
        return cor;
    }

    void suspend() {
        isSuspending = true;
    }

    void stop(){
        isRunning = false;
    }

    void resume(){
        isSuspending = false;
        notify();
    }

    @Override
    public void run() {
        while(isRunning){
            try{
            switch (this.cor) {
                case VERMELHO:
                    sleep(3000);
                    break;
                case AMARELO:
                    sleep(1000);
                    break;
                case VERDE:
                    sleep(4000);
                    break;
            }

            if(isSuspending){
                this.wait();
            }

            this.mudarCor();

        } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private synchronized void mudarCor(){
        switch (this.cor) {
            case AMARELO -> this.cor = CorSemafaro.VERMELHO;
            case VERDE -> this.cor = CorSemafaro.AMARELO;
            case VERMELHO -> this.cor = CorSemafaro.VERDE;
        }
        this.corMudou = true;
        notify();
    }

    public synchronized void corMudouF(){
        while(!this.corMudou) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            this.corMudou = false;

    }

}
