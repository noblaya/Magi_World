package fr.tf_i;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Basic Players characters Class
 */
public abstract class Player {

    int playerNb;
    private int classe;
    int level;
    int maxLife;
    int currentLife;
    int strength;
    int agility;
    int intelligence;

    //CONSTRUCTOR
    Player(int playerNb, int classe, int level, int maxLife, int currentLife, int strength, int agility, int intelligence) {
        this.playerNb = playerNb;
        this.classe = classe;
        this.level = level;
        this.maxLife = maxLife;
        this.currentLife = currentLife;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    // GETTERS

    int getCurrentLife() {
        return currentLife;
    }

    //ATTACKS

    /**
     * Basic Player's attack
     * @param enemy the enemy to hit with
     */
    public void basicAttack(Player enemy) {

    }

    /**
     * Special Player's attack
     * @param enemy the enemy to hit with
     */
    public void specialAttack (Player enemy) {

    }



    //MODULES
    /**
     * Apply damage to the player
     * @param damage the amount of damage to apply
     */
    void applyDamages(int damage) {
        this.currentLife = (this.currentLife - damage);

        if (this.currentLife <= 0) {
            System.out.println("");
            System.out.println("Joueur " + this.playerNb + " est mort");
            System.out.println("Joueur " + this.playerNb + " à perdu !");
            Game game = new Game();
            clearCSVs();
            System.exit(0);
        }
    }

    /**
     * Clear the CSV file at the end of the game.
     */
    private void clearCSVs() {

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("Player1.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
        try {
            PrintWriter writer2 = new PrintWriter("Player2.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();
    }

}
