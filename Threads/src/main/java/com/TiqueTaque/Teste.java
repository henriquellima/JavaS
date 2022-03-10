package com.TiqueTaque;

public class Teste {
    public static void main(String[] args) {

        TiqueTaque tt = new TiqueTaque();

            ThreadTikTaque tique = new ThreadTikTaque("Tique", tt);
            ThreadTikTaque taque = new ThreadTikTaque("Taque", tt);


            try{
                taque.t.join();
                tique.t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        System.out.println("Termnei hehe");

    }
}
