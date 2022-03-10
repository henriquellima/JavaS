package JavaS.CartaoPrePago.src;

public class ReciboCompra {
    Pessoa titular;
    double preco;
    double CashBack;


    public ReciboCompra(Pessoa titular, double preco, double cashBack) {
        this.titular = titular;
        this.preco = preco;
        CashBack = cashBack;
    }

    @Override
    public String toString() {
        return "ReciboCompra{" +
                "titular=" + titular +
                ", preco=" + preco +
                ", CashBack=" + CashBack +
                '}';
    }
}
