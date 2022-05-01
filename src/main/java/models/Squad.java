package models;

import java.util.ArrayList;

import java.util.Objects;


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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return getSize() == squad.getSize() &&
                getSquadName().equals(squad.getSquadName()) &&
                getCause().equals(squad.getCause());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSquadName(), getCause(), getSize());
    }





}
