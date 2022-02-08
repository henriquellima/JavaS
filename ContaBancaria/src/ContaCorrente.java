
public class ContaCorrente extends Conta{
	
	double creditoEspecial;


	public ContaCorrente(Pessoa titular, int numero, double saldo, double creditoEspecial) {
		super(titular, numero, saldo);
		this.creditoEspecial = creditoEspecial;
	}



	public double getCreditoEspecial() {
		return creditoEspecial;
	}




	public void setCreditoEspecial(float creditoEspecial) {
		this.creditoEspecial = creditoEspecial;
	}



	public boolean sacar(int quantia) {
		if(quantia<this.saldo+creditoEspecial) {
			return false;
		}
		else {
			saldo = saldo - quantia;
			return true;
		}
	}
	
	

}
