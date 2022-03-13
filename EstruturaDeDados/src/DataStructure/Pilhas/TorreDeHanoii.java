package DataStructure.Pilhas;

import java.util.Stack;

public class TorreDeHanoii {

    public static void main(String[] args) {
        Stack<Integer> original = new Stack<Integer>();
        Stack<Integer> destino = new Stack<Integer>();
        Stack<Integer> auxiliar = new Stack<Integer>();

        original.push(1);
        original.push(2);
        original.push(3);

        jogar(original.size(), original, destino, auxiliar);
    }

    private static void jogar(int n, Stack<Integer> original, Stack<Integer> destino, Stack<Integer> auxiliar) {
        if (n > 0) {
            jogar(n - 1, original, auxiliar, destino);
            destino.push(original.pop());
            System.out.println("-----");
            System.out.println("Original = " + original);
            System.out.println("Destino = " + destino);
            System.out.println("Auxiliar = " + auxiliar);
            System.out.println("-----");
            jogar(n - 1, auxiliar, destino, original);
        }
    }
}

