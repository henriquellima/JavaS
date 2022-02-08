
public class ContaInvestimento extends Conta{
	
	private String tipo;
	private double rendimento;
	

	public ContaInvestimento(Pessoa titular, int numero, double saldo, String tipo, double rendimento) {
		super(titular, numero, saldo);
		this.tipo = tipo;
		this.rendimento = rendimento;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public double getRendimento() {
		return rendimento;
	}


	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	
	

}
