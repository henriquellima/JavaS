package basico.operadores13;

import java.util.Scanner;

public class Salario {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o seu salario bruto:");
		int salario = scan.nextInt();
		double inss = salario*0.11;
		double sindicato = salario*0.08;
		double liquido = salario - sindicato - inss;
		System.out.println("Seu salario liquido é: " + liquido +
				"O desconto do inss vai ser:" + inss +
				"O sindicato vai ficar com: " + sindicato );
	}

}
