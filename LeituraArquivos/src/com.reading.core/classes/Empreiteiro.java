package com.reading.core.classes;

public class Empreiteiro extends Funcionario{
    private double valorEmpreitada;

    public Empreiteiro(String nome, int numeroRegistro, double valorEmpreitada) {
        super(nome, numeroRegistro);
        this.valorEmpreitada = valorEmpreitada;
    }

    public double getValorEmpreitada() {
        return valorEmpreitada;
    }

    public void setValorEmpreitada(double valorEmpreitada) {
        this.valorEmpreitada = valorEmpreitada;
    }


    public Recibo CalcularSalario(String hoje) {
        double salario;
        salario = valorEmpreitada;
        Recibo recido = new Recibo(super.nome, super.numeroRegistro, salario, hoje );
        return recido;
    }
}
