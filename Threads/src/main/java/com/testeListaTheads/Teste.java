package com.testeListaTheads;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class Teste {
    public static void main(String[] args) {

        List list = new List();

        new Thread(new ThreadToRead(list)).start();

        for(int i=0; i<10; i++){
            new Thread(new Threads(list, i), String.valueOf(i)).start();
        }


    }
}
