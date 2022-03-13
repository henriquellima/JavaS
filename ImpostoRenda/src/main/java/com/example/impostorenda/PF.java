package com.example.impostorenda;

public class PF extends Contribuinte{
    private String cpf;
    private double rendimentoAnual;
    int dependentes;

    public PF(String nome, int id, Endereco endereco, String cpf, double rendimentoAnual, int dependentes) {
        super(nome, id, endereco);
        this.cpf = cpf;
        this.rendimentoAnual = rendimentoAnual;
        this.dependentes = dependentes;
    }

    public double calcularImposto(){
        double rendimentoSemDependentes = rendimentoAnual - (1770*dependentes);
        if(rendimentoSemDependentes<25000) {
            return 0;
        } else if(rendimentoSemDependentes<50000){
            return rendimentoSemDependentes*0.15;
        }else if(rendimentoSemDependentes<100000){
            return rendimentoSemDependentes*0.15;
        }else{
            return rendimentoSemDependentes*0.275;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", endereco=" + endereco +
                ", cpf='" + cpf + '\'' +
                ", rendimentoAnual=" + rendimentoAnual +
                ", dependentes=" + dependentes +
                '}';
    }
}
