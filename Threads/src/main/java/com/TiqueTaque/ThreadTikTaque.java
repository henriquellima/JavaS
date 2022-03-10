package com.TiqueTaque;

public class ThreadTikTaque implements Runnable {
    TiqueTaque tiquetaque;
    Thread t;

    final int NUM = 5;

    public ThreadTikTaque(String name, TiqueTaque tiquetaque) {
        this.tiquetaque = tiquetaque;
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        if (t.getName().equalsIgnoreCase("Tique")) {
            for (int i = 0; i < NUM; i++) {
                tiquetaque.tique(true);
            }
            tiquetaque.tique(false);
        } else {
            for (int i = 0; i < NUM; i++) {
                tiquetaque.taque(true);
            }
            tiquetaque.taque(false);
        }
    }
}
