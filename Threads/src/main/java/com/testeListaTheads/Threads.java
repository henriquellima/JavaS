package com.testeListaTheads;

import java.util.Collections;

public class Threads implements Runnable {

    final List list;
    int numString;

    public Threads(List list, int num) {
        this.list = list;
        this.numString = num;
    }

    @Override
    public void run() {


        synchronized (list) {
            for (int i = 0; i < 100; i++) {
                list.add("Tamanho" + list.getSize() + "Thread " + numString);

                while(list.isCanRead()){
                    try {
                       list.wait();
                   } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(25);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

    }
}
