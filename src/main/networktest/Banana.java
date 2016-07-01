package main.networktest;

import org.omg.CORBA.BAD_CONTEXT;

import java.io.Serializable;

/**
 * Created by qizilbash on 7/1/2016.
 */
public class Banana implements Serializable {
    public int getId() {
        return id;
    }

    private int id ;

    public Banana(int id) {
        this.id = id;
    }
}
