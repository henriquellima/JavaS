import java.util.Scanner;

public class TesteCalculadora {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);


        for(Calculadora calc : Calculadora.values()){
            System.out.println("Operacao: " + "'" + calc + "'" + calc.executarOperacao(10, 5));
        }

    }
}
