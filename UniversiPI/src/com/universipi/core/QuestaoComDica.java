package com.universipi.core;

public class QuestaoComDica extends QuestaoSimples{
    String dica;

    public QuestaoComDica(String enunciado, String resposta, String dica) {
        super(enunciado, resposta);
        this.dica = dica;
    }

    @Override
    public String aplicarQuestao() {
        return super.enunciado + "\n -DICA- \n======" + dica + "======" ;
    }
}
