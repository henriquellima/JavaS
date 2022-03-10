package com.testeListaTheads;

public class ThreadToRead implements Runnable{
    private final List list;

    public ThreadToRead(List list) {
        this.list = list;
    }

    public List getList() {
        return list;
    }


    public void run(){

        synchronized (list) {
            for (int i = 0; i < 1000; i++) {
                    try{
                        while(!list.isCanRead()) {
                            list.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                System.out.println(list.get(i));
                    list.setCanRead(false);
                    list.notify();
            }
        }
    }

}
