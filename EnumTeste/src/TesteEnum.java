public class TesteEnum {

    public static void main(String[] args) {
        DiaDaSemana diaSemana;

        for(DiaDaSemana dia : DiaDaSemana.values()){
            System.out.print(dia + "é" + dia.getValue() + "\n");
        }
    }
}
