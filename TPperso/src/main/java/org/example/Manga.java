package org.example;

public class Manga {

    private String name;
    private int tome;
    private boolean acquis;

    public Manga(java.lang.String name, int tome,boolean acquis) {
        this.name = name;
        this.tome = tome;
        this.acquis = acquis;
    }
    public boolean getAcquis(){
        return acquis;
    }
    public String getName(){
        return name;
    }
    public int getTome(){
        return tome;
    }



    @Override
    public String toString() {
        return this.name+ " " + this.tome + " " + this.acquis;
    }


}
