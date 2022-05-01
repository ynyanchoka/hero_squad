package dao;

import models.Hero;
import models.Squad;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Sql2oSquadDaoTest {
    private static Sql2oSquadDao squadDao;
    private static Sql2oHeroDao heroDao;
    private static Connection conn;



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
        squadDao.clearAllSquads();
        assertFalse(squadDao.getAll().contains(squad));
        assertFalse(squadDao.getAll().contains(otherSquad));
        assertEquals(0,squadDao.getAll().size());
    }

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        squadDao = new Sql2oSquadDao(sql2o);
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }


    @AfterClass
    public void tearDown() throws Exception {
        conn.close();
    }




    public Squad setupNewSquad(){
        return new Squad("Environmentalists", "Conserve environment",10);
    }
}