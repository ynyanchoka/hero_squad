package dao;

import org.junit.After;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import models.Hero;
import org.junit.jupiter.api.Test;



import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Sql2oHeroDaoTest {

    public Sql2oHeroDao heroDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingHeroesById() throws Exception {
        Hero hero = setupNewHero();
        int originalHeroId = hero.getId();
        heroDao.add(hero);
        assertNotEquals(originalHeroId, hero.getId());
    }

    @Test
    public void existingTasksCanBeFoundById() throws Exception {
        Hero hero = new Hero("Thanos", 20, "Laser eyes", "Running");
        Hero secondHero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper");
        Hero foundHero = Hero.findById(1);
        Hero foundSecondHero = Hero.findById(2);
        assertEquals(hero, foundHero);
        assertEquals(secondHero, foundSecondHero);
    }

    @Test
    public void addedTasksAreReturnedFromgetAll() throws Exception {
        Hero hero = setupNewHero();
        heroDao.add(hero);
        assertEquals(1, heroDao.getAllInstances().size());
    }
//
//
//
    @Test
    public void deleteByIdDeletesCorrectTask() throws Exception {
        Hero hero = setupNewHero();
        heroDao.add(hero);
        heroDao.deleteById(hero.getId());
        assertEquals(1, heroDao.getAllInstances().size());
    }

    @Test
    public void clearAll() throws Exception {
        Hero hero = setupNewHero();
        Hero otherHero = new Hero("Thanos", 20, "Laser eyes", "Running");
        heroDao.add(hero);
        heroDao.add(otherHero);
        int daoSize = heroDao.getAllInstances().size();
        heroDao.clearAllHeroes();
        assertTrue(daoSize > 0 && daoSize > heroDao.getAllInstances().size()); //this is a little overcomplicated, but illustrates well how we might use `assertTrue` in a different way.
    }
        public Hero setupNewHero(){
            return new Hero("Mathai", 40, "Environment conservation", "Poor time keeper");
        }




}
