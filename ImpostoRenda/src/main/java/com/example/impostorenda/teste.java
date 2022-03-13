package com.example.impostorenda;

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Endereco enderecoPF = new Endereco("91216000", "386", "casa");
        PF pf = new PF("Henrique costa de lima", 12, enderecoPF, "02668120071", 6.125*12, 0);

        Endereco enderecoPJ = new Endereco("91216000", "386", "casa");
        PJ pj = new PJ("MagaLu", 19, enderecoPJ, "01281728901321", 900000);

        double impostoPF = pf.calcularImposto();

        double impostoPJ = pj.calcularImposto();

        System.out.println("Imposto para" + pf + "\n ======  " + impostoPF + "======");
        System.out.println("Imposto para" + pj + "\n ======  " + impostoPJ + "======");

    }

}