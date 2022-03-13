package com.example.impostorenda;

public class PJ extends Contribuinte{
    private String cnpj;
    private double faturamento;

    public PJ(String nome, int id, Endereco endereco, String cnpj, double faturamento) {
        super(nome, id, endereco);
        this.cnpj = cnpj;
        this.faturamento = faturamento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(double faturamento) {
        this.faturamento = faturamento;
    }

    public double calcularImposto() {
        if (faturamento < 100000) {
            return 0;
        } else if (faturamento < 250000) {
            return faturamento * 0.06;
        } else if (faturamento < 450000) {
            return faturamento * 0.15;
        } else {
            return faturamento * 0.25;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", endereco=" + endereco +
                ", cnpj='" + cnpj + '\'' +
                ", faturamento=" + faturamento +
                '}';
    }
}
