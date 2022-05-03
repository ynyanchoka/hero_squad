package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class HeroTest {

    @BeforeEach
    public void setUp()  throws Exception{
    }

    @AfterEach
    public void tearDown() throws Exception {
    }
    @Test
    public void NewHeroObjectGetsCorrectlyCreated() throws Exception {
        Hero hero = new Hero ("Thanos", 20, "Laser eyes","Running", "Villain");
        assertTrue (hero instanceof Hero);
    }


//    name
    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero hero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper","Champions");
        assertEquals("Mathai", hero.getName());

    }
    //    age
    @Test
    public void HeroInstantiatesWithAge_true()  {
        Hero hero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper","Champions");
        assertEquals(40, hero.getAge());

    }
    //    power
    @Test
    public void HeroInstantiatesWithPower_true() throws Exception{
        Hero hero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper","Champions");
        assertEquals("Environment conservation", hero.getPower());

    }
    //   weakness
    @Test
    public void HeroInstantiatesWithWeakness_true() throws Exception{
        Hero hero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper","Champions");
        assertEquals("Poor time keeper", hero.getWeakness());

    }
}
