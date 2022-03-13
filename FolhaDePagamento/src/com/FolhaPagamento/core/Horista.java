package com.FolhaPagamento.core;

public class Horista extends Funcionario{
    private float valorHora;
    private int numeroHoras;

    public Horista(String nome, int numeroRegistro, float valorHora, int numeroHoras) {
        super(nome, numeroRegistro);
        this.valorHora = valorHora;
        this.numeroHoras = numeroHoras;
    }

    public float getValorHora() {
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
