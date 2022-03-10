package core;

public class Bomba {
	private Combustivel[] combustivel = new Combustivel[2];
	
	



	public Bomba(Combustivel[] combustivel) {
		super();
		this.combustivel = combustivel;
	}


	public void abastecer(int combustivel, float litros) {
		System.out.println("Carro abastecido!! \n"
				+ "Valor total: " + String.format("%.2f", (litros*this.combustivel[combustivel].getPreco())));
	}
	
	
}
