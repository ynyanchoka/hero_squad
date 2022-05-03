package dao;

import models.Hero;
import models.Squad;


import java.util.List;

public interface SquadDao {


    List<Squad> getAll();


    void add (Squad squad);


    Squad findById(int id);

    void deleteById(int id);
    void clearAllSquads();
    List<Hero> getAllHeroesBySquad(int squadId);

    void deleteAllHeroesInSquad(int squadId);

}

