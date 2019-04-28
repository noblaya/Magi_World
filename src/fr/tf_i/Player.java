package fr.tf_i;

import java.util.Scanner;

public class Player {

    public int playerNb = -1;
    public int classe = -1;
    public int level = -1;
    public int maxLife = -1;
    public int currentLife = -1;
    public int strength = -1;
    public int agility = -1;
    public int intelligence = -1;

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




}
