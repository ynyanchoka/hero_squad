package models;

import java.util.ArrayList;
import java.util.Objects;



public class Hero {

    private  String name;
    private  int age;
    private  String power;
    private  String weakness;
    private static int id;
    private int squadId;
    private boolean squadMember;



    private static ArrayList<Hero> instances = new ArrayList<>();


//    constructor
    public Hero (String name, int age, String power, String weakness){
        this.name=name;
        this.age=age;
        this.power=power;
        this.weakness = weakness;
        instances.add(this);
        this.id =instances.size();
        this.squadId = squadId;


    }
    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }


    public static ArrayList<Hero> getAllInstances() {
        return instances;
    }

    public static void clearAllHeroes() {
        instances.clear();
    }


    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getPower() {
        return this.power;
    }

    public String getWeakness() {
        return this.weakness;
    }
    public static int setId( int id) {
        return id;
    }
    public int getId() {
        return id;
    }

    public static Hero findById(int id) {
        try {
            return instances.get(id-1);
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public static void deleteHero() {
        instances.remove(id-1);
    }

    public void updateHeroStatus(boolean squadMember){
        this.squadMember=squadMember;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return getAge() == hero.getAge() &&
                getName().equals(hero.getName()) &&
                getPower().equals(hero.getPower()) &&
                getWeakness().equals(hero.getWeakness());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getPower(), getWeakness());
    }

    public boolean isSquadMember() {
        return squadMember;
    }

//    public int getSquadId() {
//        return squadId;
//    }
//
//    public void setSquadId(int squadId) {
//        this.squadId = squadId;
//    }


}
