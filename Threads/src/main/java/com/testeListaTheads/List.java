package com.testeListaTheads;

public class List {
    private int size;
    private String[] list;
    private boolean canRead = false;

    public List() {
        this.size = 0;
        this.list = new String[1000];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isCanRead() {
        return canRead;
    }

    public void setCanRead(boolean canRead) {
        this.canRead = canRead;
    }

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }

    public String get(int index) {
        return list[index];
    }

    synchronized public void add(String text){
        list[size] = text;
        size++;

        canRead = true;
        notify();
    }

}
