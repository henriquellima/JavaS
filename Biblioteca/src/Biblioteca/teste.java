package Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class teste {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Livro book0 = new Livro();
		Livro book1 = new Livro();
		Livro book2 = new Livro();
		Livro book3 = new Livro();

		book0.setTitulo("Sapiens1");
		book0.setAutor("Yuval Harari");
		book0.setCategoria("Historia");
		book0.setArmario(1);
		book0.setPratileira(1);
		book0.setDataPublicacao("10-01-2000");

		book1.setTitulo("Sapiens2");
		book1.setAutor("Yuval Harari");
		book1.setCategoria("Historia");
		book1.setArmario(1);
		book1.setPratileira(1);
		book1.setDataPublicacao("10-01-2000");

		book2.setTitulo("Sapiens3");
		book2.setAutor("Yuval Harari");
		book2.setCategoria("Historia");
		book2.setArmario(1);
		book2.setPratileira(1);
		book2.setDataPublicacao("10-01-2000");

		book3.setTitulo("Sapiens4");
		book3.setAutor("Yuval Harari");
		book3.setCategoria("Historia");
		book3.setArmario(1);
		book3.setPratileira(1);
		book3.setDataPublicacao("10-01-2000");

		Livro[] livros = { book0, book1, book2, book3 };
		boolean running = true;

		while (running) {
			System.out.println("Escolha o Livro:");

			int count = 0;

			for (Livro livro : livros) {
				System.out.println(count + ": " + livro.getTitulo());
				count++;
			}

			int selectedBook = scan.nextInt();

			System.out.print("Oque você quer fazer?\n" + "1: Pegar Emprestado\n" + "2: Devolver");

			int selectedOption = scan.nextInt();

			switch (selectedOption) {
			case 1:
				if (livros[selectedBook].socilitarEmprestimo()) {
					livros[selectedBook].socilitarEmprestimo();
				} else {
					System.out.println("Livro não disponivel!");
				}
				break;
			case 2:
				if (livros[selectedBook].devolver()) {
					livros[selectedBook].devolver();
				} else {
					System.out.println("Livro já esta conosco!");
				}
			default:
				System.out.println("Opçao invalida!");
			}

			System.out.println("Quer continuar?(s/n)");

			if (scan.next().equals("n")) {
				running = false;
			}
			;
		}
	}
}
