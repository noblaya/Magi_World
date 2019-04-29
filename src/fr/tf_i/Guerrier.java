package fr.tf_i;

public class Guerrier extends Player {

    public Guerrier(int playerNb, int classe, int level, int maxLife, int currentLife, int strength, int agility, int intelligence) {
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
        int damage = -1;
        int self = -1;

        //Calculate damages to apply
        damage = strength*2;
        self = strength/2;

        //Show damages and apply them
        System.out.println("Joueur " + playerNb + " utilise Coup de Rage et inflige " + damage + " dommages. Mais il s'inflige " + self + " dommages dans sa folie.");
        enemy.applyDamages(damage);
        this.applyDamages(self);

    }
}
