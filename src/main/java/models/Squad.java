package models;

import java.util.ArrayList;

import java.util.Objects;


public class Squad {
    private static ArrayList<Squad> squadInstances= new ArrayList<>();
    private String squadName;
    private ArrayList<Hero> heroes;
    private String cause;
    private int size;

    private int id;
    private static ArrayList<Squad> instances = new ArrayList<>() ;


    public  Squad( String squadName, String cause,int size,ArrayList<Hero> heroes){
        this.squadName = squadName;
        this.cause = cause;
        this.size= size;
        this.heroes=heroes;
        squadInstances.add(this);
        this.id = squadInstances.size();
//        instances.add(this);

    }

    public static ArrayList<Squad> getAllInstances() {
        return instances;
    }

    public static ArrayList<Squad> getSquadInstances() {
        return squadInstances;
    }

    public static void clearAllSquads() {
        squadInstances.clear();
    }

    public static Squad findById(int id) {
        try {
            return squadInstances.get(id-1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
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


    public ArrayList<Hero> getHeroes() {
        return this.heroes;
    }
}
