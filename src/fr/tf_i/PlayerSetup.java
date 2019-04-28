package fr.tf_i;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerSetup {
    Scanner sc = new Scanner(System.in);
    private int availablePoints = 1;

    public void setupPlayers (int playerNb) {
        if (playerNb == 1) {

        }
        else {

        }
    }

    /**
     * Set Player's Class method
     * @return Class set
     */
    private int setClasse() {
        int classe = -1;
        boolean responseIsGood = false;

        do {
            do {
                System.out.println("Veuillez choisir la classe du personnage (1 : Guerrier, 2 : Rodeur, 3 : Mage)");
                try {
                    classe = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 1 et 3 correspondant à la Classe souhaitée");
                    responseIsGood = false;
                }
            } while (!responseIsGood);
        }while (classe < 1 || classe > 3);



        return classe;
    }

    /**
     * Set Player's Level method
     * @return Level set
     */
    private int setLevel() {
        int level = -1;
        boolean responseIsGood = false;

        do {
            do {
                System.out.println("Niveau du personnage ? (Entre 1 et 100)");
                try {
                    level = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 1 et 100 correspondant au Niveau souhaité");
                    responseIsGood = false;
                }
            } while (!responseIsGood);
        } while (level < 1 || level > 100);


        return level;
    }

    /**
     * Set the player's life (Level of the player x5)
     * @param level Level of the Player
     * @return Return the max Life.
     */
    private int setLife(int level) {
        int maxLife = level*5;

        return maxLife;
    }

    /**
     * Initialise the player's current life ( = max life at the beginning)
     * @param maxLife Max life of the Player
     * @return Return the current Life to initialise.
     */
    private int setCurrentLife(int maxLife) {
        int currentLife = maxLife;

        return currentLife;
    }

    /**
     * Set available points to spend
     * @param level Player's Level set
     */
    private void setAvailablePoints(int level) {
        availablePoints = level;
    }

    /**
     * Set player's Stregth
     * @return Stregth set
     */
    private int setStrength() {
        int strength = -1;
        boolean responseIsGood = false;

        do {
            do {
                System.out.println("Force du personnage ? (Entre 0 et " + availablePoints + ")");
                try {
                    strength = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 0 et " + availablePoints + "correspondant à la Force du personnage souhaitee");
                    responseIsGood = false;
                }
            } while (!responseIsGood);
        } while (strength < 0 || strength > availablePoints);
        availablePoints = (availablePoints - strength);

        return strength;
    }

    /**
     * Set player's Agility
     * @return Agility set
     */
    private int setAgility() {
        int agility = -1;
        boolean responseIsGood = false;

        do {
            do {
                System.out.println("Agilite du personnage ? (Entre 0 et " + availablePoints + ")");
                try {
                    agility = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e) {
                    sc.next();
                    System.out.println("Merci de saisir un nombre entre 0 et " + availablePoints + " correspondant à l'Agilité du personnage souhaitee");
                    responseIsGood = false;
                }
            }while (!responseIsGood);
        } while (agility < 0 || agility > availablePoints);
        availablePoints = (availablePoints - agility);

        return agility;
    }

    /**
     * Set player's Intelligence
     * @return Intelligence set
     */
    private int setIntelligence() {
        int intelligence = -1;
        boolean responseIsGood = false;

        do {
            do {
                System.out.println("Intelligence du personnage ? (Entre 0 et " + availablePoints +")");
                try {
                    intelligence = sc.nextInt();
                    responseIsGood = true;
                } catch (InputMismatchException e){
                    System.out.println("Merci de saisir un nombre entre 0 et " + availablePoints +" correspondant à l'Intelligence du personnage souahaitee");
                    responseIsGood = false;
                }

            } while (!responseIsGood);
        } while (intelligence < 0 || intelligence > 100);
        availablePoints = (availablePoints - intelligence);

        return intelligence;
    }


}
