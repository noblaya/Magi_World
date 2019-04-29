package fr.tf_i;

public class Mage extends Player{
    public Mage(int playerNb, int classe, int level, int maxLife, int currentLife, int strength, int agility, int intelligence) {
        super(playerNb, classe, level, maxLife, currentLife, strength, agility, intelligence);
    }

    @Override
    public void basicAttack(Player enemy) {
        int damage = -1;

        //Calculate damages to apply
        damage = strength;

        //Show damages and apply it
        System.out.println("Joueur " + playerNb + " utilise Coup d'Epée et inflige " + damage + " dommages.");
        enemy.applyDamages(damage);
    }

    @Override
    public void specialAttack(Player enemy) {
        int boost = -1;
        int deltaLife = -1;
        int currentBoost = -1;

        //Calculate
        deltaLife = (this.maxLife - this.currentLife);
        currentBoost = (this.intelligence * 2);

        //If the number of points to heal is higher than the max life, just set max life to the current player's life.
        if (currentBoost <= deltaLife) {
            boost = (intelligence*2);
        } else {
            boost = deltaLife;
        }
        //Print the number of points healed
        System.out.println("Joueur " + playerNb + " utilise Soin et gagne " + boost + " en vitalite.");

        //Apply them
        this.agility = (this.agility + boost);
    }
}
