package com.Calculadora;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class TelaTeste {
    public static void main(String[] args) {


                JFrame janela = new JFrame("Multiplicação Demorada");

                JTextField primeiro = new JTextField(10);
                JTextField segundo = new JTextField(10);
                JButton botao = new JButton(" = ");
                JLabel resultado = new JLabel("           ?          ");

                //quando clica no botão será executado a classe Multiplicador
                // lambda abaixo substituiu toda a classe AcaoBotao

                botao.addActionListener(e -> {
                        new ThreadMulti(primeiro, segundo, resultado);
                    });

                JPanel painel = new JPanel();
                painel.add(primeiro);
                painel.add(new JLabel("x"));
                painel.add(segundo);
                painel.add(botao);
                painel.add(resultado);

                janela.add(painel);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                janela.pack();
                janela.setVisible(true);
            }
        }
