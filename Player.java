public class Player {
    //static variables
    public static int health = 100;


    public static void heal(int currentLevel) {

        int heal = (int)(Math.random() * 5) + 1;

        heal -= (int)(currentLevel * .5);

        if(heal > 0) health += heal;
        else heal = 0;

        System.out.println("You healed for " + heal + " points");
    }
}
