package fr.tf_i;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Scanner sc = new Scanner(System.in);

    String player1CSVBrut = "";
    String player2CSVBrut = "";

    String[] splitedPl1;
    String[] splitedPl2;

    Player player1 = null;
    Player player2 = null;




    /**
     * Launch the game and check if the game is Setup if not, set it up, if yes, Start game.
     * @param isGameSetup Game is setup (players stats) ?
     */
    public void Launch(boolean isGameSetup){
        PlayerSetup ps = new PlayerSetup();
            if (!isGameSetup) {
                ps.SetupPlayers(1, false);
            } else {
                startGame(false);
            }

    }

    /**
     * Launch the game when players objects are created.
     * @param isPlayerSetItUp Players objects are created ?
     */
    public void startGame(boolean isPlayerSetItUp) {


            if (!isPlayerSetItUp) {

                this.setPlayersSplits(1);

            } else {

                game(1);
            }
    }

    /**
     * Game action loop
     * @param playerNb Player's turn to play
     */
    public void game(int playerNb) {
        if (playerNb == 1){
            playerAction(1);
        }
        else if (playerNb == 2) {
            playerAction(2);
        }
    }

    /**
     * Make players an usable board about theirs stats using CSV.
     * @param playerNb
     */
    public void setPlayersSplits (int playerNb) {

        //READ PLAYER 1 CSV
        if (playerNb == 1) {
            try {
                 player1CSVBrut = ReadLastLine.Player1CSV();
            } catch (Exception e) {
                 System.out.println("Erreur lors de la lecture du Player1.csv");
            }
            //Make an usable board
            splitedPl1 = player1CSVBrut.split(",");

            setPlayersSplits(2);
        }

        else {

            //READ PLAYER 2 CSV
            try {
                player2CSVBrut = ReadLastLine.Player2CSV();
            } catch (Exception e) {
                System.out.println("Erreur lors de la lecture du Player2.csv");
            }
            //Make an usable board
            splitedPl2 = player2CSVBrut.split(",");

            createPlayers(1);
        }

    }

    /**
     * Create player object
     * @param playerNb which player to create
     */
    public void createPlayers(int playerNb) {
        int classe = -1;
        int level = -1;
        int maxLife = -1;
        int currentLife = -1;
        int strength = -1;
        int agility = -1;
        int intelligence = -1;

        //PLAYER 1
        if (playerNb == 1) {

            classe = Integer.valueOf(splitedPl1[1]);
            level = Integer.valueOf(splitedPl1[2]);
            maxLife = Integer.valueOf(splitedPl1[3]);
            currentLife = Integer.valueOf(splitedPl1[4]);
            strength = Integer.valueOf(splitedPl1[5]);
            agility = Integer.valueOf(splitedPl1[6]);
            intelligence = Integer.valueOf(splitedPl1[7]);

            switch (classe) {
                case 1:
                    player1 = new Guerrier(1, classe, level, maxLife, currentLife, strength, agility, intelligence);
                    createPlayers(2);
                    break;
                case 2:
                    player1 = new Rodeur(1, classe, level, maxLife, currentLife, strength, agility, intelligence);
                    createPlayers(2);
                    break;
                case 3:
                    player1 = new Mage(1, classe, level, maxLife, currentLife, strength, agility, intelligence);
                    createPlayers(2);
                    break;
            }

            //PLAYER 2
        } else if (playerNb == 2) {
            classe = Integer.valueOf(splitedPl2[1]);
            level = Integer.valueOf(splitedPl2[2]);
            maxLife = Integer.valueOf(splitedPl2[3]);
            currentLife = Integer.valueOf(splitedPl2[4]);
            strength = Integer.valueOf(splitedPl2[5]);
            agility = Integer.valueOf(splitedPl2[6]);
            intelligence = Integer.valueOf(splitedPl2[7]);

            switch (classe) {
                case 1:
                    player2 = new Guerrier(2, classe, level, maxLife, currentLife, strength, agility, intelligence);
                    startGame(true);
                    break;
                case 2:
                    player2 = new Rodeur(2, classe, level, maxLife, currentLife, strength, agility, intelligence);
                    startGame(true);
                    break;
                case 3:
                    player2 = new Mage(2, classe, level, maxLife, currentLife, strength, agility, intelligence);
                    startGame(true);
                    break;
            }

        }


    }

    /**
     * Players Actions (Attack Boost, etc)
     * @param playerNb Which player turn
     */
    public void playerAction(int playerNb) {
        boolean responseIsGood = false;
        int currentAction = -1;

        // PLAYER 1 ACTION
        if (playerNb == 1) {


            do {
                do {
                    System.out.println("");
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Joueur 1 (" + player1.currentLife + " de vitalite) veuillez choisir votre action (1: Attaque Basique, 2: Attaque Speciale)");
                    try {
                        currentAction = sc.nextInt();
                        responseIsGood = true;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Merci de tapper 1 pour Attaque Basique ou 2 pour Attaque Speciale");
                        responseIsGood = false;
                    }

                } while (!responseIsGood);

                switch (currentAction) {
                    case 1 :
                        player1.basicAttack(player2);
                        currentAction = -1; //Reset current action int.
                        playerAction(2);
                        break;

                    case 2 :
                        player1.specialAttack(player2);
                        currentAction = -1;
                        playerAction(2);
                        break;
                }

            } while (currentAction < 1 || currentAction > 2);

        }

        // PLAYER 2 ACTIONS
        else if (playerNb == 2) {

            do {
                do {
                    System.out.println("");
                    System.out.println("------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Joueur 2 (" + player2.currentLife + " de vitalite) veuillez choisir votre action (1: Attaque Basique, 2: Attaque Speciale)");
                    try {
                        currentAction = sc.nextInt();
                        responseIsGood = true;
                    } catch (InputMismatchException e) {
                        sc.next();
                        System.out.println("Merci de tapper 1 pour Attaque Basique ou 2 pour Attaque Speciale");
                        responseIsGood = false;
                    }

                } while (!responseIsGood);

                switch (currentAction) {
                    case 1 :
                        player2.basicAttack(player1);
                        currentAction = -1; //Reset current action int.
                        playerAction(1);
                        break;

                    case 2 :
                        player2.specialAttack(player1);
                        currentAction = -1;
                        playerAction(1);
                        break;
                }

            } while (currentAction < 1 || currentAction > 2);

        }
        else {
            System.out.println("ERREUR : Game / playerAction / Mauvais playerNb");
            System.exit(101);
        }
    }


}
