package com.reading.core.classes;

public class Comissionado extends Funcionario{
    private double salarioBase;
    private double comissao;

    public Comissionado(String nome, int numeroRegistro, double salarioBase, double comissao) {
        super(nome, numeroRegistro);
        this.salarioBase = salarioBase;
        this.comissao = comissao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }


    public Recibo CalcularSalario(String hoje) {
        double salario;
        salario = (this.salarioBase+(this.salarioBase*this.comissao/100));
        Recibo recido = new Recibo(super.nome, super.numeroRegistro, salario, hoje);
        return recido;
    }
}
