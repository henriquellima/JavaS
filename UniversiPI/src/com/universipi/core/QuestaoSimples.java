package com.universipi.core;

public class QuestaoSimples {
    protected String enunciado;
    protected String resposta;

    public QuestaoSimples(String enunciado, String resposta) {
        this.enunciado = enunciado;
        this.resposta = resposta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public String aplicarQuestao() {
        return enunciado;
    }

    public boolean corrigir(String resposta) throws Exception {
        if (this.resposta.equalsIgnoreCase(resposta)) {
            return true;
        } else {
            return false;
        }
    }
}
