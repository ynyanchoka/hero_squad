package dao;

import models.Hero;
import models.Squad;

import java.util.List;

public interface HeroDao {


    List<Hero> getAllInstances();

    // CREATE
    void add(Hero hero);

    // READ
    Hero findById(int id);


    //DELETE
    void deleteById(int id);
    void clearAllHeroes();


}
