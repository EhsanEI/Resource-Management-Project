package main.networktest;

import main.networktest.Banana;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by qizilbash on 7/1/2016.
 */
public class Bapple implements Serializable {
    private int id;
    private ArrayList<Banana> bananas =new ArrayList<>();

    public Bapple(int id) {
        this.id = id;
    }

    public void addBanana(Banana banana){
        bananas.add(banana);
    }

    public int getId(){
        return id;
    }
}
