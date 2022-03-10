package com.BuscaTextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreadBuscaTexto implements Runnable{
    String arquivo;
    String nome;
    Buscador buscador;

    public ThreadBuscaTexto(String arquivo, String nome, Buscador buscador) {
        this.arquivo = arquivo;
        this.nome = nome;
        this.buscador = buscador;

        new Thread(this, nome).start();
    }

    @Override
    public void run() {

        buscador.buscar(arquivo, nome);
    }

}
