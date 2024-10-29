package main.monsters;
import main.Player;

public class Zombie extends Monster {
    public Zombie(int health, int l, int min, int max) {
        // call the parent's constructor (aka super class)
        super(health, l, min, max, "Zombie", false);
    }


    // ATTACK
    public void attack() {
        System.out.println("Zombie attacks you");
        Player.takeDamage(getDamage());
    }


    // TAUNT
    @Override
    public void taunt()  {
        
    }
}
