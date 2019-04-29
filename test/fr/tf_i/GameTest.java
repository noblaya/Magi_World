package fr.tf_i;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void FullGameTest() {
        String toTypeSetup = "1%n20%n20%n0%n0%n3%n5%n0%n0%n5%n"; //Players Setup (Player 1 Guerrier lvl 20, 20 strength)(Player 2 Mage lvl 5, 5 Intelligence)
        String toTypeAction = "1%n1%n1%n1%n"; // Players action (Basic attack 4 times)

        System.setIn(new ByteArrayInputStream(String.format(toTypeSetup,toTypeAction).getBytes()));
        Game game = new Game();
        game.Launch(false); // Launch the complete game phase

        //Result expected
        assertEquals(100 - 5, game.player1.getCurrentLife()); // Player 1
        assertEquals(25 - 20 - 20, game.player2.getCurrentLife()); // Player 2
    }

}