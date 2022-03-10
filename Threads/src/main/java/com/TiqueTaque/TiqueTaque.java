package com.TiqueTaque;

public class TiqueTaque {
    boolean tique;

    synchronized void tique(boolean isRunning) {
        if (!isRunning) {
            tique = true;
            notify();
            return;
        }

        System.out.print("Tique ");
        tique = true;

        notify();

        try {
            while (tique) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void taque(boolean isRunning) {

        if (!isRunning) {
            return;
        }

        System.out.println("Taque ");
        tique = false;

        notify();

        try {
            while (!tique) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
