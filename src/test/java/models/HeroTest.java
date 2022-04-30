package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class HeroTest {

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }
    @Test
    public void NewHeroObjectGetsCorrectlyCreated() throws Exception {
        Hero hero = new Hero ("Thanos", 20, "Laser eyes","Running");
        assertTrue (hero instanceof Hero);
    }

    @Test
    public void all_returnsAllInstancesOfHero_true() throws Exception {
        Hero firstHero = new Hero("Thanos", 20, "Laser eyes", "Running");
        Hero secondHero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper");
        assertTrue(Hero.getAllInstances().contains(firstHero));
        assertTrue(Hero.getAllInstances().contains(secondHero));;
    }
//    name
    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero hero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper");
        assertEquals("Mathai", hero.getName());

    }
    //    age
    @Test
    public void HeroInstantiatesWithAge_true()  {
        Hero hero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper");
        assertEquals(40, hero.getAge());

    }
    //    power
    @Test
    public void HeroInstantiatesWithPower_true() throws Exception{
        Hero hero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper");
        assertEquals("Environment conservation", hero.getPower());

    }
    //   weakness
    @Test
    public void HeroInstantiatesWithWeakness_true() throws Exception{
        Hero hero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper");
        assertEquals("Poor time keeper", hero.getWeakness());

    }
}
