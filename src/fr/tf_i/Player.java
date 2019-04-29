package fr.tf_i;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Basic Players characters Class
 */
public abstract class Player {

    public int playerNb = -1;
    public int classe = -1;
    public int level = -1;
    public int maxLife = -1;
    public int currentLife = -1;
    public int strength = -1;
    public int agility = -1;
    public int intelligence = -1;

    //CONSTRUCTOR
    public Player(int playerNb, int classe, int level, int maxLife, int currentLife, int strength, int agility, int intelligence) {
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
    public int getPlayerNb() {
        return playerNb;
    }

    public int getClasse() {
        return classe;
    }

    public int getLevel() {
        return level;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
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
    public void applyDamages(int damage) {
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
    public void clearCSVs () {

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
