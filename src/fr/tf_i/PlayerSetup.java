package fr.tf_i;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

/**
 * Class used to setup players (choose class, level, stats, etc ...)
 */
class PlayerSetup {
    Scanner sc = new Scanner(System.in);

    //Players Stats
    private int classe = -1;
    private int level = -1;
    private int maxLife = -1;
    private int currentLife = -1;
    private int strength = -1;
    private int agility = -1;
    private int intelligence = -1;

    //Setup necessaries
    private int availablePoints = 1;
    private String playerSetup = "";
    private String intro = "";


    // ----- METHODS -----

    // MAIN

    /**
     * Main method used to dispatch between player 1 and 2
     * @param playerNb which player to setup.
     */
    void SetupPlayers(int playerNb) {

        if (playerNb == 1) {

            System.out.println(" ");
            System.out.println("----------------------------------");
            System.out.println("Creation du personnage du Joueur 1");
            System.out.println("----------------------------------");

            classe = setClasse();
            level = setLevel();
            maxLife = setLife(level);
            currentLife = setCurrentLife(maxLife);
            strength = setStrength();
            agility = setAgility();
            intelligence = setIntelligence();

            //MAKE PLAYER 1 THEN WRITE IN CSV
            playerSetup = playerSetupToPrint(1);

            Path playerSetupPath = Paths.get("Player1.csv");

            try {
                Files.write(playerSetupPath, String.format(playerSetup).getBytes(), APPEND);
            } catch (IOException e) {
                System.out.println("Une erreur est survenue lors de la generation du Player1.csv. Merci de reessayer.");
                return;
            }

            //MAKE INTRO THEN PRINT IT
            intro = setIntro(1);
            System.out.println(intro);


            SetupPlayers(2); // Then setup Player 2



        }
        else if (playerNb == 2) {


            System.out.println(" ");
            System.out.println("----------------------------------");
            System.out.println("Creation du personnage du Joueur 2");
            System.out.println("----------------------------------");

            classe = setClasse();
            level = setLevel();
            maxLife = setLife(level);
            currentLife = setCurrentLife(maxLife);
            strength = setStrength();
            agility = setAgility();
            intelligence = setIntelligence();

            //MAKE PLAYER 2 THEN WRITE IN CSV
            playerSetup = playerSetupToPrint(2);

            Path playerSetupPath = Paths.get("Player2.csv");

            try {
                Files.write(playerSetupPath, String.format(playerSetup).getBytes(), APPEND);
            } catch (IOException e) {
                System.out.println("Une erreur est survenue lors de la generation du Player2.csv. Merci de reessayer.");
                return;
            }

            // MAKE INTRO THEN PRINT IT
            intro = setIntro(2);
            System.out.println(intro);

            //START GAME HERE
            Game game = new Game();
            game.Launch(true);

        }
        else {
            System.out.println("Erreur (PlayerSetup Class setupPlayers method. Wrong playerNb)");
        }
    }




    // SETUP BASE

    private String playerSetupToPrint(int playerNb) {
        String setupToPrint;

        setupToPrint = playerNb + "," + classe + "," + level + "," + maxLife + "," + currentLife + "," + strength + "," + agility + "," + intelligence + "%n";

        return setupToPrint;
    }

    private String setIntro(int playerNb) {

        switch (classe) {
            case 1:
                intro = "Woarg je suis le Guerrier Joueur " + playerNb + " niveau " + level + ", je possede " + maxLife + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
                break;
            case 2:
                intro = "Hmmm je suis le Rodeur Joueur " + playerNb + " niveau " + level + ", je possede " + maxLife + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
                break;
            case 3:
                intro = "Abracadabra je suis le Mage Joueur " + playerNb + " niveau " + level + ", je possede " + maxLife + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
                break;

            default:
                intro = "Erreur lors du choix de la classe, je suis donc le simple Humain Joueur " + playerNb + " niveau " + level + ", je possede " + maxLife + " de vitalite, " + strength + " de force, " + agility + " d'agilite et " + intelligence + " d'intelligence !";
        }

        return intro;
    }




    //SETUP MODULES (SET PLAYERS STATS)


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

        availablePoints = level;

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
        } while (intelligence < 0 || intelligence > availablePoints);
        availablePoints = (availablePoints - intelligence);

        return intelligence;
    }


}
