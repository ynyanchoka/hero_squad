package models;

import java.util.ArrayList;
import java.util.Objects;



public class Hero {

    private final String squadName;
    private  String name;
    private  int age;
    private  String power;
    private  String weakness;
    private static int id;
    private int squadId;
    private boolean squadMember;



    private static ArrayList<Hero> instances = new ArrayList<>();
    private Squad squad;


    //    constructor
    public Hero (String name, int age, String power, String weakness,String squadName){
        this.name=name;
        this.age=age;
        this.power=power;
        this.weakness = weakness;
        this.squadName = squadName;
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

    public String getSquadName() {
        return this.squadName;
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
    public String toString() {
        return "Hero " + id + ": " + name + " " + age + " " + power + " " + weakness + " " + squadName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return age == hero.age && Objects.equals(squadName, hero.squadName) && Objects.equals(name, hero.name) && Objects.equals(power, hero.power) && Objects.equals(weakness, hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(squadName, name, age, power, weakness);
    }

    public static int setId(int id) {
        return id;
    }


    public void setSquad(Squad squad) {
        this.squad = squad;
    }
}
