import java.util.Scanner;

public class TesteMemoria {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String oi = new String("oi");
		String xau = new String("oi");
		
		String oi2 = scan.next();
		
		System.out.println(oi.equals(xau));
	}
}
