package core;

public class Contato {
	private String nome;
	private String telefone;
	private int id;
	
	
	public Contato(String nome, String telefone, int id) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.id = id;
	}

	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getId() {
		return id;
	}

	
}
