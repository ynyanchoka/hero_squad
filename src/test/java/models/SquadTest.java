package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void name() {
    }
    @Test
    public void NewSquadObjectGetsCorrectlyCreated() throws Exception {
       Squad squad = new Squad ("Environmentalists", "Conserve environment",10);
        assertTrue (squad instanceof Squad);
    }
//    squad name
    @Test
    public void SquadInstantiatesWithName_true() throws Exception {
        Squad squad = new Squad ("Environmentalists", "Conserve environment",10);
        assertEquals("Environmentalists", squad.getSquadName());

    }
//    cause
    @Test
    public void SquadInstantiatesWithCause_true() throws Exception {
        Squad squad = new Squad ("Environmentalists", "Conserve environment",10);
        assertEquals("Conserve environment", squad.getCause());

    }

    @Test
    public void SquadInstantiatesWithSize_true() throws Exception {
        Squad squad = new Squad ("Environmentalists", "Conserve environment",10);
        assertEquals(10, squad.getSize());

    }

    @Test
    public void all_returnsAllInstancesOfSquad_true() throws Exception {
        Squad firstSquad = new Squad ("Environmentalists", "Conserve environment",10);
        Squad secondSquad = new Squad ("Police", "Crime",7);
        assertTrue(Squad.getAllInstances().contains(firstSquad));
        assertTrue(Squad.getAllInstances().contains(secondSquad));;
    }
}