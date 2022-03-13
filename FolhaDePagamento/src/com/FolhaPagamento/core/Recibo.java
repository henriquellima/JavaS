package com.FolhaPagamento.core;

public class Recibo {
    private String nome;
    private int numFuncionario;
    private double pagamento;
    private String data;

    public Recibo(String nome, int numFuncionario, double pagamento, String data) {
        this.nome = nome;
        this.numFuncionario = numFuncionario;
        this.pagamento = pagamento;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Recibo{" +
                "nome='" + nome + '\'' +
                ", numFuncionario='" + numFuncionario + '\'' +
                ", pagamento=" + pagamento +
                ", data='" + data + '\'' +
                '}';
    }
}
