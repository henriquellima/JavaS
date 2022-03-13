public enum DiaDaSemana {
    SEGUNDA("112121"), TERCA("2"), QUARTA("3"), QUINTA("4"), SEXTA("5"), SABADO("6"), DOMINGUEIRA("7");

    private String value;

    private DiaDaSemana(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
