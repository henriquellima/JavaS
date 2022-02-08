package basico.whilefor17;

import java.util.Scanner;


public class CaixaRegistradora {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String maisUm = "s";
		
		while(maisUm.equals("s")) {		
		System.out.println("Lojas Tabajara");
		System.out.println("Digite o valor do primeiro produto: ");
		double preco = scan.nextDouble();
		double total = 0;
		int i = 1;
		
		String output = "Lojas Tabajara \n";
		
		while(preco != 0) {
			output += ("Produto " + i + ": R$ " + preco + "\n");
			total += preco;
			i += 1;
			System.out.println("Digite o valor do proximo produto (0 para sair): ");
			preco = scan.nextDouble();
		}
		
		System.out.println("Total: " + total);
		
		System.out.println("Digite quanto dinheiro o cliente forneceu: ");
		double dinheiroRecebido = scan.nextDouble();
		output += "Total: " + total + "\n";
		output += "Dinheiro recebido: " + dinheiroRecebido + "\n";
		output += "Troco: " + (dinheiroRecebido - total) + "\n";
		output += "Volte Sempre!!";	
		
		System.out.println(output);
		
		System.out.println("Quer registrar mais um produto? (s/n)");
		
		maisUm = scan.next();
		
		output = "";
	}
		System.out.println("====Standby====");
	}
	
}
