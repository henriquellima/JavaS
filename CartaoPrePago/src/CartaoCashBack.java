package JavaS.CartaoPrePago.src;

public class CartaoCashBack extends CartaoPrePago{
    private int tipo;


    public CartaoCashBack(String numeroCartao, Pessoa titular, int anoValidade, int mesValidade, double saldo, int tipo) {
        super(numeroCartao, titular, anoValidade, mesValidade, saldo);
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public ReciboCompra comprar(double preco) throws Exception {
        if(saldo<preco){
            throw new RuntimeException("Saldo insuficiente!");
        }else{
            int cashBack = 0;
            switch (this.tipo){
                case 1:
                    cashBack = 5;
                case 2:
                    cashBack = 8;
                case 3:
                    cashBack = 10;
            }

            saldo -= (preco+(preco*(cashBack/100)));
            ReciboCompra recibo = new ReciboCompra(super.titular, preco, cashBack);

            return recibo;
        }
    }
}
