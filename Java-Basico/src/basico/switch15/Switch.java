package basico.switch15;

import java.util.Scanner;

public class Switch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o dia na semana");
		int diaDaSemana = scan.nextInt();
		
		switch(diaDaSemana) {
		case 1: System.out.println("domingo"); break;
		case 2: System.out.println("segunda"); break;
		case 3: System.out.println("terça"); break; 
		// sem break, vai executar todos os comandos apartir do primeiro true
		}
	}	
}
