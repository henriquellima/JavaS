package DataStructure.Pilhas;

import java.util.Scanner;
import java.util.Stack;

public class Exercise {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();

        int num = scan.nextInt();
        StringBuilder binary = new StringBuilder();
        int resto;

        while(num > 0){
            resto = num % 2;
            stack.push(resto);
            num /= 2;
        }
        while(!stack.empty()){
            binary.append(stack.pop());
        }

        System.out.println(binary);
    }
}
