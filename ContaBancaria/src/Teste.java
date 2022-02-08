import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Pessoa pessoa;
		ContaInvestimento contaI;
		ContaCorrente contaC;
		boolean opering;

		pessoa = new Pessoa("Henrique Lima", "02668120071", 21);

		contaI = new ContaInvestimento(pessoa, 20203, 30120.00, "investimento", 10.80);

		contaC = new ContaCorrente(pessoa, 20204, 10000, 5000);

		opering = true;

		System.out.println("Bem vindo " + contaI.getTitular().getNome() + "!!!");

		while (opering) {
			int opcaoConta;

			System.out.println("Escolha qual conta voce quer operar: \n 1: Corrente \n 2: Investimento \n 3: Sair");

			opcaoConta = scan.nextInt();

			System.out.print(opcaoConta == 2
					? "Escolha qual operacao voce quer fazer: \n 1: Sacar \n 2: Depositar \n 3: VerificarSaldo \n 4: Verificar Rendimento\n 0: Sair"
					: "Escolha qual operacao voce quer fazer: \n 1: Sacar \n 2: Depositar \n 3: VerificarSaldo \n 4: Consultar Credito-Especial\n0: Sair ");

			int opcaoOperacao = scan.nextInt();

			switch (opcaoOperacao) {
			case 1:
				System.out.println("Quanto você deseja sacar?");
				double valor = scan.nextDouble();

				if (opcaoConta == 1) {
					if (contaC.sacar(valor)) {
						contaC.sacar(valor);
						System.out.println("Saque efetuado com secesso!!");
					} else {
						System.out.println("Saldo insuficiente!");
					}
				} else {
					if (contaI.sacar(valor)) {
						contaI.sacar(valor);
						System.out.println("Saque efetuado com secesso!!");
					} else {
						System.out.println("Saldo insuficiente!");
					}
				}
				break;

			case 2:
				System.out.println("Quanto você deseja depositar?");
				double valorDeposito = scan.nextDouble();

				if (opcaoConta == 1) {
					contaC.sacar(valorDeposito);
					System.out.println("Deposito efetuado com secesso!!");
				} else {
					contaI.depositar(valorDeposito);
					System.out.println("Deposito efetuado com secesso!!");
				}

				break;
			case 3:
				if (opcaoConta == 1) {

					System.out.println(contaC.getSaldo());
				} else {
					System.out.println(contaI.getSaldo());
				}

				break;

			case 4:

				if (opcaoConta == 1) {

					System.out.println(contaC.getCreditoEspecial());
				} else {
					System.out.println(contaI.getRendimento());
				}
			case 0:
				opering = false;

			default:
				System.out.println("Comando invalido!");
			}

			System.out.println("Deseja realizar outra operação? (s/n)");
			if (scan.next().equals("n")) {
				opering = false;
			}

		}

		scan.close();
	}

}
