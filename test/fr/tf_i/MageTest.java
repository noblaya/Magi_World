package fr.tf_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    @Test
    void Given_Mage_level100_When_UseBasicAttack_Then_ApplyGoodDamages() {
        Mage mage = new Mage(1, 1, 100, 500, 500, 0, 0, 100);
        Mage ennemy = new Mage(1, 1, 100, 500, 500, 0, 0, 100);

        mage.basicAttack(ennemy);
        assertEquals(500 - 100, ennemy.getCurrentLife());
    }

    @Test
    void Given_Mage_level100_And_50CurrentLife_When_UseSpecialAttack_Then_ApplyGoodHealingRate() {
        Mage mage = new Mage(1, 1, 100, 500, 50, 0, 0, 100);
        Mage ennemy = new Mage(1, 1, 100, 500, 500, 0, 0, 100);

        mage.specialAttack(ennemy);
        assertEquals(50 + 200, mage.currentLife);
    }

    @Test
    void Given_Mage_level100_And_400CurrentLife_When_UseSpecialAttack_Then_ApplyGoodHealingRate() {
        Mage mage = new Mage(1, 1, 100, 500, 400, 0, 0, 100);
        Mage ennemy = new Mage(1, 1, 100, 500, 500, 0, 0, 100);

        mage.specialAttack(ennemy);
        assertEquals(500, mage.currentLife);
    }
}