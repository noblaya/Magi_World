package fr.tf_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuerrierTest {

    @Test
    void Given_Guerrier_level100_When_UseBasicAttack_Then_ApplyGoodDamages() {
        Guerrier guerrier = new Guerrier(1, 1, 100, 500, 500, 100, 0, 0);
        Guerrier ennemy = new Guerrier(1, 1, 100, 500, 500, 100, 0, 0);

        guerrier.basicAttack(ennemy);
        assertEquals(500 - 100, ennemy.getCurrentLife());
    }

    @Test
    void Given_Guerrier_level100_When_UseSpecialAttack_Then_ApplyGoodDamages() {
        Guerrier guerrier = new Guerrier(1, 1, 100, 500, 500, 100, 0, 0);
        Guerrier ennemy = new Guerrier(1, 1, 100, 500, 500, 100, 0, 0);

        guerrier.specialAttack(ennemy);
        assertEquals(500 - 200, ennemy.getCurrentLife());
    }

    @Test
    void Given_Guerrier_level100_When_UseSpecialAttack_Then_ApplyGoodDamagesToSelf() {
        Guerrier guerrier = new Guerrier(1, 1, 100, 500, 500, 100, 0, 0);
        Guerrier ennemy = new Guerrier(1, 1, 100, 500, 500, 100, 0, 0);

        guerrier.specialAttack(ennemy);
        assertEquals(500 - 50, guerrier.getCurrentLife());
    }
}