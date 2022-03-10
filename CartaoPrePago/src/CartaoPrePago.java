package JavaS.CartaoPrePago.src;

public class CartaoPrePago {

    protected String numeroCartao;
    protected Pessoa titular;
    protected int anoValidade;
    protected int mesValidade;
    protected double saldo;

    public CartaoPrePago(String numeroCartao, Pessoa titular, int anoValidade, int mesValidade, double saldo) {
        this.numeroCartao = numeroCartao;
        this.titular = titular;
        this.anoValidade = anoValidade;
        this.mesValidade = mesValidade;
        this.saldo = saldo;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public int getAnoValidade() {
        return anoValidade;
    }

    public void setAnoValidade(int anoValidade) {
        this.anoValidade = anoValidade;
    }

    public int getMesValidade() {
        return mesValidade;
    }

    public void setMesValidade(int mesValidade) {
        this.mesValidade = mesValidade;
    }

    public double getSaldo() {
        return saldo;
    }


    public double adicionarCredito(double quantia){
        this.saldo = this.saldo + quantia;
        return this.saldo;
    }

    public ReciboCompra comprar(double preco) throws Exception{
        if(saldo<preco){
            throw new RuntimeException("Saldo insuficiente!");
        }else{
            saldo -= preco;

            ReciboCompra recibo = new ReciboCompra(titular, preco, 0);
            return recibo;
        }
    }

}
