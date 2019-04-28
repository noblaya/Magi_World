package fr.tf_i;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerSetup {
    Scanner sc = new Scanner(System.in);

    public void setupPlayers (int playerNb) {
        if (playerNb == 1) {

        }
        else {

        }
    }

    /**
     * Set Player's Class method
     * @return
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
     * @return
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

}
