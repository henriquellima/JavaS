package DataStructure.Pilhas;

import DataStructure.StaticStructure;

public class Stack<T>  extends StaticStructure {

    public Stack(int capacity) {
        super(capacity);
    }

    public Stack() {
        super();
    }

    public void stack( T element){
        this.ensureCapacity();
        this.elements[this.size] = element;
    }

    public void unstack(){

    }

    public void top(){

    }

    @Override
    public String toString(){
        return "";
    }
}
