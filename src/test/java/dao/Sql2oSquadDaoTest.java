package dao;

import models.Hero;
import models.Squad;
import org.junit.After;
import org.junit.Before;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

class Sql2oSquadDaoTest {
    private Sql2oSquadDao squadDao;
    private Sql2oHeroDao heroDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        squadDao = new Sql2oSquadDao(sql2o);
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingSquadSetsId() throws Exception {
        Squad squad = setupNewSquad();
        int originalSquadId = squad.getId();
        squadDao.add(squad);
        assertNotEquals(originalSquadId, squad.getId());
    }

    @Test
    public void existingSquadCanBeFoundById() throws Exception {
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        Squad foundSquad = squadDao.findById(squad.getId());
        assertEquals(squad, foundSquad);
    }

    @Test
    public void addedSquadAreReturnedFromGetAll() throws Exception {
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        assertEquals(1, squadDao.getAll().size());
    }


    @Test
    public void deleteByIdDeletesCorrectSquad() throws Exception {
        Squad squad = setupNewSquad();
        squadDao.add(squad);
        squadDao.deleteById(squad.getId());
        assertEquals(0, squadDao.getAll().size());
    }

    @Test
    public void clearAllClearsAllSquads() throws Exception {
        Squad squad = setupNewSquad( );
        Squad otherSquad = new Squad("Police", "Fight crime ",6);
       squadDao.add(squad);
       squadDao.add(otherSquad);
        int daoSize = squadDao.getAll().size();
        squadDao.clearAllSquads();
        assertTrue(daoSize > 0 && daoSize > squadDao.getAll().size());
    }

//    @Test
//    public void getAllTasksByCategoryReturnsSquadCorrectly() throws Exception {
//        Squad squad = setupNewSquad();
//       squadDao.add(squad);
//        int squadId = squad.getId();
//        Hero newHero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper", squadId);
//        Hero otherHero = new Hero("Thanos", 20, "Laser eyes", "Running", squadId);
//        Hero thirdHero = new Hero("Mother", 50, "Caring", "None" squadId);
//        heroDao.add(newHero);
//        heroDao.add(otherHero);
//        assertEquals(2, squadDao.getAllHeroesBySquad(squadId).size());
//        assertTrue(squadDao.getAllHeroesBySquad(squadId).contains(newHero));
//        assertTrue(squadDao.getAllHeroesBySquad(squadId).contains(otherHero);
//        assertFalse(squadDao.getAllHeroesBySquad(squadId).contains(thirdHero));
//    }


    public Squad setupNewSquad(){
        return new Squad("Environmentalists", "Conserve environment",10);
    }
}