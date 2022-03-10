package core;

import java.util.Scanner;

public class Teste {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Combustivel gasolina = new Combustivel("gasolina", 6.50);
		Combustivel diesel = new Combustivel("diesel", 4.50);
		Combustivel[] combustiveis = {gasolina, diesel};
		
		Bomba bomba = new Bomba(combustiveis);
		
		System.out.println("Que vai ser patroa? \n"
				+ "1 - gasolina; \n"
				+ "2 - diesel;");
		
		int option = scan.nextInt();
		
		System.out.print("Quantos litro aê patroa?");
		float litros = scan.nextFloat();
		
		bomba.abastecer(option-1, litros);
	}
}
