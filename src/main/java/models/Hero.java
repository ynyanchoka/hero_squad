package models;

import java.util.ArrayList;


public class Hero {

   private  String name;
    private  int age;
    private  String power;
    private  String weakness;
    private static int id;

    private static ArrayList<Hero> instances = new ArrayList<>();


//    constructor
    public Hero (String name,int age,String power,String weakness){
        this.name=name;
        this.age=age;
        this.power=power;
        this.weakness = weakness;
//        instances.add(this);
        this.id =instances.size();


    }

//    public static ArrayList<Hero> getAllInstances() {
//        return instances;
//    }


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
    public static int getId() {
        return id;
    }
}
