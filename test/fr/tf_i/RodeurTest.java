package fr.tf_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RodeurTest {

    @Test
    void Given_Rodeur_level100_When_UseBasicAttack_Then_ApplyGoodDamages() {
        Rodeur rodeur = new Rodeur(1, 1, 100, 500, 500, 0, 100, 0);
        Rodeur ennemy = new Rodeur(1, 1, 100, 500, 500, 0, 100, 0);

        rodeur.basicAttack(ennemy);
        assertEquals(500 - 100, ennemy.getCurrentLife());
    }

    @Test
    void Given_Rodeur_level100_When_UseSpecialAttack_Then_ApplyGoodAgilityBoost() {
        Rodeur rodeur = new Rodeur(1, 1, 100, 500, 500, 0, 100, 0);
        Rodeur ennemy = new Rodeur(1, 1, 100, 500, 500, 0, 100, 0);

        rodeur.specialAttack(ennemy);
        assertEquals(100 + 50, rodeur.agility);
    }
}