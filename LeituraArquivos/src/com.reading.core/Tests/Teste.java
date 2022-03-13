package com.reading.core.Tests;

import com.reading.core.Exeptions.CSVFormatException;
import com.reading.core.Util.GeradorEmpregado;
import com.reading.core.classes.Chefe;
import com.reading.core.classes.Comissionado;
import com.reading.core.classes.Empreiteiro;
import com.reading.core.classes.Funcionario;
import com.reading.core.classes.Horista;
import com.reading.core.classes.Recibo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        StringBuilder boletos = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/folha.txt"));

            String line;

            do {
                line = br.readLine();

                if (line != null) {

                    try {
                        funcionarios.add(GeradorEmpregado.gerarFuncionario(line));
                    } catch (Exception c) {
                        System.out.println("Algo deu errado!");
                        c.printStackTrace();
                    }
                }

            } while (line != null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ;
        }

        try {
            Scanner scan = new Scanner(System.in);
            PrintWriter writer = new PrintWriter("recibos.txt", StandardCharsets.UTF_8);

            System.out.print("Voce quer ordenar os funcionarios pelo oque? \n  1- Nome \n 2- id \n 3- Não ordenar");

            int optionToSort = scan.nextInt();
            switch (optionToSort) {
                case 3 -> funcionarios.forEach((e) -> {
                    writer.println(e.CalcularSalario("24/02/2022"));
                });
                case 1 -> funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach((e) -> {
                    writer.println(e.CalcularSalario("24/02/2022"));
                });
                case 2 -> funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNumeroRegistro)).forEach((e) -> {
                    writer.println(e.CalcularSalario("24/02/2022"));

                });


            }

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
