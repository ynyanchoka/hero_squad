package models;

import java.util.ArrayList;
import java.util.Collection;

public class Squad {
    private String squadName;
    private String cause;
    private int size;

    private int id;
    private static ArrayList<Squad> instances = new ArrayList<>() ;


    public  Squad( String squadName, String cause,int size){
        this.squadName = squadName;
        this.cause = cause;
        this.size= size;
        instances.add(this);

    }

    public static ArrayList<Squad> getAllInstances() {
        return instances;
    }

    public String getSquadName() {
        return this.squadName;
    }

    public String getCause() {
        return this.cause;
    }

    public int getSize() {
        return this.size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
