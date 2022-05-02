package dao;

import org.junit.After;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.Hero;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class Sql2oHeroDaoTest {

    private static Sql2oHeroDao heroDao;
    private static Sql2oSquadDao squadDao;

    private static Connection conn;



    @Test
    public void addingHeroesById() throws Exception {
        Hero hero = setupNewHero();
        int originalHeroId = hero.getId();
        heroDao.add(hero);
        assertNotEquals(originalHeroId, hero.getId());
    }

    @Test
    public void existingHeroesCanBeFoundById() throws Exception {
        Hero hero = setupNewHero();
        heroDao.add(hero);
        Hero foundHero = heroDao.findById(hero.getId());
        assertEquals(hero, foundHero);
    }

//    @Test
//    public void addedHeroesAreReturnedFromgetAll() throws Exception {
//        Hero hero = setupNewHero();
//        heroDao.add(hero);
//        assertEquals(1, heroDao.getAll().size());
//    }
//
//
//
    @Test
    public void deleteByIdDeletesCorrectHero() throws Exception {
        Hero hero = setupNewHero();
        heroDao.add(hero);
        heroDao.deleteById(hero.getId());
        assertFalse(heroDao.getAll().contains(hero));
    }

    @Test
    public void clearAll() throws Exception {
        Hero hero = setupNewHero();
        Hero otherHero = setupNewHero();
        heroDao.add(hero);
        heroDao.add(otherHero);
        heroDao.clearAllHeroes();
        assertFalse(heroDao.getAll().contains(hero));
        assertFalse(heroDao.getAll().contains(otherHero));
        assertEquals(0,heroDao.getAll().size());
    }

    @Before
    public static void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        heroDao = new Sql2oHeroDao(sql2o);
        squadDao = new Sql2oSquadDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }
        public Hero setupNewHero(){
            return new Hero("Mathai", 40, "Environment conservation", "Poor time keeper");
        }




}
