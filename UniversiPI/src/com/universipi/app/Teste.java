package com.universipi.app;

import com.universipi.core.QuestaoComDica;
import com.universipi.core.QuestaoMultiplaEscolha;
import com.universipi.core.QuestaoSimples;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        QuestaoSimples[] questoes = new QuestaoSimples[3];

        questoes[0] = new QuestaoComDica("Qual o simbolo da agua?", "h2o",
                "Tem hidrogenio e oxigênio!!");
        questoes[1] = new QuestaoMultiplaEscolha("Qual é a primeira letra do alfabeto?", "c",
                "z", "x", "a", "p");
        questoes[2] = new QuestaoSimples("Quem descobriu o Braza? (primeiro nome no diminutivo).",
                "pedrin");


        for (QuestaoSimples questao : questoes){
            System.out.println(questao.aplicarQuestao());
            System.out.print("R: ");
            try {
                if (questao.corrigir(scan.next())) {
                    System.out.println("Acerto!");
                } else{
                    System.out.println("Errrouuuu!!");
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
