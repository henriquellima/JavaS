package com.BuscaTextual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        Buscador buscador ;

        buscador = new Buscador();

        ThreadBuscaTexto ass1 = new ThreadBuscaTexto("src/main/java/com/BuscaTextual/assinaturas1.txt", "ass1", buscador);
        ThreadBuscaTexto ass2 = new ThreadBuscaTexto("src/main/java/com/BuscaTextual/assinaturas2.txt", "ass2", buscador);
        ThreadBuscaTexto autores = new ThreadBuscaTexto("src/main/java/com/BuscaTextual/autores.txt", "autores", buscador);


    }
}
