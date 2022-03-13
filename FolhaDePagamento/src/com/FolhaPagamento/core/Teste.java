package com.FolhaPagamento.core;

public class Teste {
    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[4];

        funcionarios[0] = new Chefe("Henrique Lima", 1203, 10000, 25, 1000);
        funcionarios[1] = new Comissionado("Gisele Lima", 10234, 6000,10);
        funcionarios[2] = new Empreiteiro("Luciano Lima", 12323, 100000);
        funcionarios[3] = new Horista("Daiane Souza",1213, 60, 150);


        for(Funcionario funcionario: funcionarios){
            Recibo recibo = funcionario.CalcularSalario("17/02/2022");
            System.out.println(recibo);
        }
    }
}
