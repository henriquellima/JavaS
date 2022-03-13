package com.reading.core.classes;

public class Horista extends Funcionario{
    private double valorHora;
    private int numeroHoras;

    public Horista(String nome, int numeroRegistro, double valorHora, int numeroHoras) {
        super(nome, numeroRegistro);
        this.valorHora = valorHora;
        this.numeroHoras = numeroHoras;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public Recibo CalcularSalario(String hoje) {
        double salario;
        salario = valorHora*numeroHoras;
        Recibo recido = new Recibo(super.nome, super.numeroRegistro, salario, hoje);
        return recido;
    }
}
