package main.monsters;
import main.Player;

public class Zombie extends Monster {
    public Zombie(int h, int l, int min, int max, String n) {
        // call the parent's constructor (aka super class)
        super(h, l, min, max, n);
    }


    // ATTACK
    public void attack() {
        System.out.println("Zombie attacks you");
        Player.takeDamage(getDamage());
    }


    // TAUNT
    public void taunt()  {
        
    }
}
