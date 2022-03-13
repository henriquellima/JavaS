package DataStructure.ArrayList;

public class Teste {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>(15);

        array.add(2);
        array.add(1);

        System.out.println(array);
        System.out.println(array.getSize());

        System.out.println(array.getElement(1));

        array.ensureCapacity();

        System.out.println(array.searchElement(2));

        System.out.println(array.add(1, 10));
        array.remove(0);
        System.out.println(array);

        array.removeElement(10);

        System.out.println(array);


    }
}
