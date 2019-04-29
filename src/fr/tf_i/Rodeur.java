package fr.tf_i;

public class Rodeur extends Player {

    public Rodeur(int playerNb, int classe, int level, int maxLife, int currentLife, int strength, int agility, int intelligence) {
        super(playerNb, classe, level, maxLife, currentLife, strength, agility, intelligence);
    }

    @Override
    public void basicAttack(Player enemy) {
        int damage = -1;

        //Calculate damages to apply
        damage = agility;

        //Show damages and apply it
        System.out.println("Joueur " + playerNb + " utilise Tir à l'Arc et inflige " + damage + " dommages.");
        enemy.applyDamages(damage);
    }

    @Override
    public void specialAttack(Player enemy) {
        int boost = -1;

        //Calculate
        boost = (this.level/2);

        //Print the number to apply
        System.out.println("Joueur " + playerNb + " utilise Concentration et gagne " + boost + " en agilite.");

        //Apply it
        this.agility = (this.agility + boost);
    }
}
