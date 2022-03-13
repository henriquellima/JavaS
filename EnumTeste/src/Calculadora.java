public enum Calculadora {
    SOMAR("+"){
        @Override
        public double executarOperacao(double x, double y) {
            return (x+y);
        }
    }, SUBTRAIR("-"){
        public double executarOperacao(double x, double y) {
            return (x - y);
        }
    }, MULTIPLICAR("*"){
            public double executarOperacao(double x, double y) {
                return (x*y);
            }
    }, DIVIDIR("/") {
        public double executarOperacao(double x, double y) {
            return (x/y);
    }
    };


    private String operation;

    private Calculadora( String operation){
        this.operation = operation;
    }

    public String getValue(){
        return operation;
    }

    @Override
    public String toString() {
        return this.operation;
    }

    public abstract double executarOperacao(double x, double y);
}
