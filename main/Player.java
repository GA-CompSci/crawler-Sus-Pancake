package main;
import main.monsters.Monster;
public class Player {
    //static variables
    public static int health = 100;
    public static void attack(Monster m) {
        // draw a random number 0 - 20
        //make this actually random
        int random = 20;
        m.setHealth(m.getHealth() - random);
        // If roll zero hurt self
        if(random == 0) {
            System.out.println("critical fail! you hurt youself");
            takeDamage(5);
        } else {
            System.out.println("You hurt " + m.getName() + " for " + random + " damage");
        }
    }

    public static void takeDamage(int damage) {
        health -= damage;

        System.out.println("You took " + damage + " points of damage.");
    }


    public static void heal(int currentLevel) {

        int heal = (int)(Math.random() * 5) + 1;

        heal -= (int)(currentLevel * .5);

        if(heal > 0) health += heal;
        else heal = 0;

        System.out.println("You healed for " + heal + " points");
    }
}
