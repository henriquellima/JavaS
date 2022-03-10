package JavaS.Exeptions.src.core;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int option = 0;
		core.Agenda agenda = new core.Agenda();

		
		
		option = obterOpcaoMenu(scan, option);

		while(option != 0) {
		switch (option) {
		case 2:
			try {
				String nome = lerInfoString(scan, "Qual é o nome do novo contato?");
				String telefone = lerInfoString(scan, "Qual é o telefone do" + nome);

				agenda.adicionarContato(new Contato(nome, telefone, agenda.getCont()));
				System.out.println("Contato adicionado com sucesso!");
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
				
				System.out.println("Contatos ja adicionados:");
				System.out.println(agenda);
			}
			break;
		case 1:
			System.out.print("Digite o nome para buscar:");
			String nome = scan.nextLine();
			try {
				Contato contatoAchado = agenda.ProcurarContatoPorNome(nome);
				System.out.println(contatoAchado.getNome() + "\n" + "    " + contatoAchado.getTelefone());
			} catch (ContatoNaoExiste e) {
				System.out.println(e.getMessage());
			}
			break;
		case 3:
			System.out.println(agenda);
			break;
		case 0:
			System.exit(0);
		}
		option = obterOpcaoMenu(scan, option);
	}
		
		System.out.println("Obrigado por usar o melhor app de agenda ihuu!!!");
	}
	
	
	
	public static String lerInfoString(Scanner scan, String message) {
		System.out.println(message);
		String entrada = scan.nextLine();
		return entrada;
	}

	public static int obterOpcaoMenu(Scanner scan, int option) {

		boolean entradaValida = false;


		while (!entradaValida) {
			System.out.println("Digite a opção desejada:");
			System.out.println("1: Consultar contato");
			System.out.println("2: Adicionar contato");
			System.out.println("3: Ver contatos");			
			System.out.println("0: Sair");

			try {
				option = Integer.parseInt(scan.nextLine());

				if (option < 0 || option > 3) {
					throw new Exception("Opção invalida!");
				} else {
					entradaValida = true;
				}
			} catch (Exception e) {
				System.out.println("Entrada Invalida, digite novamente.");
			}
		}
		return option;
	}
}
