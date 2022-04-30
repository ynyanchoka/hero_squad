package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



public class HeroTest {
    @Test
    public void NewHeroObjectGetsCorrectlyCreated_true() {
        Hero hero = new Hero ("Thanos", 20, "Laser eyes","Running");
        assertEquals (true,hero instanceof Hero);
    }
}
