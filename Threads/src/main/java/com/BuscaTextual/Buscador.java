package com.BuscaTextual;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Buscador {


    public void buscar(String arquivo, String nome) {
        System.out.println("Iniciando busca -- " + arquivo);

        synchronized (this) {
            Scanner text = null;
            try {
                text = new Scanner(new File(arquivo));
            } catch (
                    FileNotFoundException e) {
                e.printStackTrace();
            }
            int contador = 0;
            while (text.hasNext()) {
                System.out.println(nome + "|| " + contador + " || " + text.nextLine());
                contador++;
            }
        }
    }

}
