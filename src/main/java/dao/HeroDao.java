package dao;

import models.Hero;

import java.util.List;

public interface HeroDao {

    // LIST
    List<Hero> getAll();

    // CREATE
    void add(Hero hero);

    // READ
    Hero findById(int id);


    void update(String name,int age,String power,String weakness);

    //DELETE
    void deleteById(int id);
    void clearAllTasks();
}
