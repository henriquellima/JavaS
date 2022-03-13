package DataStructure.ArrayList;

import DataStructure.StaticStructure;

public class ArrayList<T> extends StaticStructure {

    public ArrayList(int capacity) {
        super(capacity);
    }

    public ArrayList() {
    }

    public boolean add(int index, T element) {
        if (index > this.getSize() - 1) {
            throw new IllegalArgumentException("Invaid index");
        } else {
            this.ensureCapacity();
            for (int i = this.getSize() - 1; i >= index; i--) {
                this.elements[i + 1] = this.elements[i];
            }
            ;
            this.elements[index] = element;
            this.size++;
        }
        return true;
    }

    public boolean removeElement(T element) {
        int index = searchElement(element);
        if (index < 0) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    public int searchElement(Object element) {
        for (int i = 0; i < this.getSize(); i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public Object getElement(int index) {
        if (this.size < index) {
            throw new IllegalArgumentException("Invalid index");
        } else {
            return this.elements[index];
        }
    }


}
