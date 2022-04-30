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
        assertEquals("Environmentalists", squad.getName());

    }
}