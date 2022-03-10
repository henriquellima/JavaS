package core;

public class Agenda {
	private Contato[] agenda = new Contato[5];
	private int cont;
	
	public Agenda() {
		super();
		this.cont = 0;
	}

	public Agenda(Contato[] agenda) {
		super();
		this.agenda = agenda;
		this.cont = 0;
	}
	
	
	public int getCont() {
		return cont;
	}

	public Contato[] getAgenda() {
		return agenda;
	}

	public void setAgenda(Contato[] agenda) {
		this.agenda = agenda;
	}

	public void adicionarContato(Contato newContato) throws Exception {
		this.agenda[cont] = newContato;
		cont++;
	}
	

	public Contato ProcurarContatoPorNome(String nome) throws ContatoNaoExiste {
		for (Contato c : agenda) {
			if (c != null) {
				if (c.getNome().equalsIgnoreCase(nome)) {
					return c;
				}
			}
		}
		throw new ContatoNaoExiste(nome);
	}

	public String toString() {
		String message = "";
		for (Contato c : agenda) {
			if(c!=null) {
			message += (cont + " - " + c.getNome() + "\n" + "    " + c.getTelefone());
			}
		}

		return message;
	}

}
