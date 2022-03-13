package DataStructure.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Exercicio {
    public static void main(String[] args) {

        String text = "o livro, com 11 milhões de exemplares vendidos no mundo, constrói um mundo ideal onde não existem dor, desigualdade, guerra nem qualquer tipo de conflito e cujos habitantes conhecem apenas o presente. Com isso, um único indivíduo é encarregado de ser o guardião das memórias desse povo. E, aos 12 anos, Jonas recebe a honra de se tornar o próximo guardião. Ele é avisado de que precisará passar por um treinamento difícil, que exigirá coragem, disciplina e força, mas não faz ideia de que seu mundo nunca mais será o mesmo";

        Map<String, Integer> hashmap = new HashMap<>();

        text = text.replaceAll(",", "");

        String[] textArray = text.split(" ");

        for (int i = 0; i < textArray.length; i++) {
            if (hashmap.get(textArray[i]) == null) {
                hashmap.put(textArray[i], 1);
            } else {
                hashmap.replace(textArray[i], hashmap.get(textArray[i])+1);
            }
        }

        System.out.println(hashmap);

    }
}
