package fr.tf_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void Given_OneBasicCharacter_Then_Apply100DamagesToHim() {
            Player player = new Player(1,1,100,500,500,34,33,33) {

            };
            player.applyDamages(100);
            assertEquals(500 - 100, player.getCurrentLife());

            }
}