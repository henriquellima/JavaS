package DataStructure;

public class StaticStructure<T> {
    protected T[] elements;
    protected int size;

    public StaticStructure(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.size = 0;
    }

    public StaticStructure() {
        this.elements = (T[]) new Object[10];
        this.size = 0;
    }

    public boolean add(T element) {
        this.ensureCapacity();
        this.elements[this.size] = element;
        this.size++;
        return true;
    }


    public boolean remove(int index) {
        if (index > this.getSize() - 1) {
            throw new IllegalArgumentException("Invaid index");
        } else {
            for (int i = index; i < this.getSize(); i++) {
                this.elements[i] = this.elements[i + 1];
            }
        }
        this.size--;
        return true;
    }


    public int getSize() {
        return this.size;
    }



    public void ensureCapacity() {
        if (this.size == this.elements.length) {
            T[] newElements = (T[]) new Object[this.elements.length * 2];
            for (int i = 0; i < this.elements.length; i++) {
                newElements[i] = this.elements[i];
            }
            this.elements = newElements;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");

        for (int i = 0; i < this.getSize() - 1; i++) {
            string.append(this.elements[i]);
            string.append(", ");

        }

        if (this.getSize() > 0) {
            string.append(this.elements[this.getSize() - 1]);
        }

        string.append("]");

        return string.toString();
    }
}
