package core;

public class ContatoNaoExiste extends Exception{
	private String nome;

	public ContatoNaoExiste(String nome) {
		this.nome = nome;
	}
	
	public String getMessage() {
		return "Contato " + this.nome + " não existe!";
	}
}
