package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;



public class HeroTest {
    @Test
    public void NewHeroObjectGetsCorrectlyCreated() {
        Hero hero = new Hero ("Thanos", 20, "Laser eyes","Running");
        assertTrue (hero instanceof Hero);
    }

    @Test
    public void all_returnsAllInstancesOfHero_true() {
        Hero firstHero = new Hero("Thanos", 20, "Laser eyes", "Running");
        Hero secondHero = new Hero("Mathai", 40, "Environment conservation", "Poor time keeper");
        assertTrue(Hero.getAllInstances().contains(firstHero));
        assertTrue(Hero.getAllInstances().contains(secondHero));;
    }
}
