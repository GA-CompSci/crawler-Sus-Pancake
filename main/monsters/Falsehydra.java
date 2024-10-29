package main.monsters;

import main.Player;

public class Falsehydra extends Monster {
    public Falsehydra(int level) {
        super(50, level, 10, 20, "False Hydra", false);
    }
    
    @Override
    public void attack() {
        System.out.println("The False Hydra attacks you!");
        if(Math.random() > 0.5) {
            System.out.println("It does double damage");
            Player.takeDamage(super.getDamage() * 2);
        }
        //else 
    }
}
