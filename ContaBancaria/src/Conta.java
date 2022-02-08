
abstract public class Conta {

	Pessoa titular;
	int numero;
	double saldo;
	
	
	
	public Conta(Pessoa titular, int numero, double saldo) {
		super();
		this.titular = titular;
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public Pessoa getTitular() {
		return titular;
	}
	public void setTitular(Pessoa titular) {
		this.titular = titular;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean sacar(double quantia) {
		if(saldo < quantia) {
			return false;
		}
		else {
			this.setSaldo(saldo-quantia);
			return true;
		}
	}
	
	public void depositar(double quantia) {
		this.setSaldo(quantia+saldo);
	}

}
