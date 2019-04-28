package fr.tf_i;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Game {

    private Scanner sc = new Scanner(System.in);

    String player1CSVBrut = "";
    String player2CSVBrut = "";

    Player player1;
    Player player2;



    public void Launch(boolean isGameSetup){
        PlayerSetup ps = new PlayerSetup();

        if (!isGameSetup){
            ps.SetupPlayers(1);
        }
        else {
            StartGame();
        }
    }

    public void StartGame() {

        // ===================TESTS========================
        System.out.println("SUCCES");
        //READ PLAYER 1 CSV
        try {
            player1CSVBrut = ReadLastLine.Player1CSV();
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du Player1.csv");
        }

        //READ PLAYER 2 CSV
        try {
            player2CSVBrut = ReadLastLine.Player2CSV();
        } catch (Exception e) {
            System.out.println("Erreur lors de la lecture du Player2.csv");
        }

        System.out.println(player1CSVBrut);
        System.out.println(player2CSVBrut);

        // --- Clear CSV Files ---
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
        // --- Clear CSV Files ---

        // ===================TESTS=========================
    }



}
