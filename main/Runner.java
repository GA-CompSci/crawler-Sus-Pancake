
package main;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import main.monsters.Monster;
import main.monsters.Zombie;
import main.monsters.Falsehydra;
import java.lang.Thread;

public class Runner {
    private static int level = 1;

    public static void main(String[] args) throws InterruptedException {
        // game variables
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);

        welcomeMessage();

        // Initial monster should be generated outside of the loop
        Monster m = generateMonster();   

        // game loop
        while(!gameOver){
            
            // Does monster get an early attack? 
            if(m.isFastAttack()) {
                m.attack();
                // did it beat us? if so, taunt then break;
                if(Player.health <= 0) {
                    m.taunt();
                    gameOver = true;
                    break;
                }
            }

            printMenu(m); // functional decomposition
            String choice = input.nextLine();
   

            // QUIT
            if(choice.equalsIgnoreCase("q")) gameOver = true;
            
            // ATTACK
            else if(choice.equalsIgnoreCase("A")){
                Player.attack(m);

                // TODO: check if monster has been defeated
                if(m.isDead()) {
                    level++;

                    System.out.println("You haave defeated the " + m.getName() + "!");

                    m = generateMonster();
                    continue;
                }
            }
            // HEAL
            else if(choice.equalsIgnoreCase("H")){
                // call the HEAL method from the Player class and pass the level param
                Player.heal(level);

                m.taunt();
            }
            // INVALID CHOICE
            else System.out.println("\tINVALID choice. Try again.");

            // TODO: MONSTER's TURN TO ATTACK IF it didn't go before and is still alive
            if(!m.isFastAttack()) {
                m.attack();
                // did it beat us? if so, taunt then break;
                if(Player.health <= 0) {
                    m.taunt();
                    gameOver = true;
                }
            }
        }

        // TODO: goodbye message
        System.out.println("Goodbye! You made it to level " + level + "!");

        // we close the scanner to avoid memory leaks
        input.close(); 

    }

    public static Monster generateMonster() {
        // We are setting the initial stats for the monster based on the player's level
        int minHit = level;            // The minimum damage the monster can deal
        int maxHit = 5 + level;        // The maximum damage the monster can deal
        int health = 10 + level;       // The monster's health, increasing as the player levels up
    
        /* 
        Using a List instead of an array for Suppliers to avoid type safety issues.
        List provides better type safety with generics.
        */
        
        List<Supplier<Monster>> constructors = Arrays.asList(
            // Each lambda here is like a "blueprint" that builds a specific type of Monster when we call .get()
            () -> new Zombie(health, level, minHit, maxHit),
            // Add more monster types here as needed, following the same pattern.
            () -> new Falsehydra(health)
        );
    
        // Create an instance of the Random class, which helps us choose a random monster from our list
        Random random = new Random();
        
        // We randomly pick an index from the list of suppliers
        int index = random.nextInt(constructors.size());
    
        // We call .get() on the chosen Supplier, which finally runs the constructor for the selected monster
        return constructors.get(index).get();  
    
        /* 
        This method will only run the constructor for the monster after we've picked one randomly.
        This avoids unnecessary work and ensures efficiency.
        */
    }

    public static void printMenu(Monster m){
        // pause for 1 second
        pause(1000);
        try {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Error clearing console.");
        }
        // ANSI escape codes for colors
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
    
        // Dungeon-themed menu art
        System.out.println(ANSI_PURPLE + "*************************************************" + ANSI_RESET);
        System.out.println(ANSI_RED + "*                   LEVEL " + level + ": " + m.status() + "                   *" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "*************************************************" + ANSI_RESET);
    
        // Q is for quit
        System.out.println(ANSI_RED + "   [Q] Quit the dungeon and flee while you can!" + ANSI_RESET);
    
        // A is for attack
        System.out.println(ANSI_GREEN + "   [A] Attack! Charge at your enemy with fury!" + ANSI_RESET);
    
        // H is for heal
        System.out.println(ANSI_CYAN + "   [H] Heal. Restore your health." + ANSI_RESET);
    
        System.out.println(ANSI_PURPLE + "*************************************************" + ANSI_RESET);
        
        // Extra dungeon atmosphere
        System.out.println(ANSI_YELLOW + "Your health is " + Player.health + ". You hear distant growls... Choose wisely.\n" + ANSI_RESET);
        System.out.print("\nSELECTION: ");
    }
    
    public static void welcomeMessage() {
        // ANSI escape codes for colors
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_CYAN = "\u001B[36m";

        // Spooky introduction with internal timing control
        System.out.println(ANSI_RED + "*************************************************" + ANSI_RESET);
        pause(500);
        System.out.println(ANSI_GREEN + "*                                               *" + ANSI_RESET);
        pause(500);
        System.out.println(ANSI_GREEN + "*          " + ANSI_CYAN + "Welcome to the Dungeon..." + ANSI_GREEN + "          *" + ANSI_RESET);
        pause(500);
        System.out.println(ANSI_GREEN + "*                                               *" + ANSI_RESET);
        pause(500);
        System.out.println(ANSI_RED + "*************************************************" + ANSI_RESET);
        pause(1000);

        // ASCII art for mood-setting
        System.out.println(ANSI_YELLOW + "\n                  .-._                           " + ANSI_RESET);
        pause(300);
        System.out.println(ANSI_YELLOW + "                 | | | |                         " + ANSI_RESET);
        pause(300);
        System.out.println(ANSI_YELLOW + "           .-._  | | | |   .-._                  " + ANSI_RESET);
        pause(300);
        System.out.println(ANSI_YELLOW + "          | | |  | | | |  | | | |                " + ANSI_RESET);
        pause(300);
        System.out.println(ANSI_CYAN + "   _   _  | | | _|_|_|_|__| | | |  _   _          " + ANSI_RESET);
        pause(300);
        System.out.println(ANSI_CYAN + "  | |_| | |_|_|_|  _____  |_|_|_| | |_| |         " + ANSI_RESET);
        pause(300);
        System.out.println(ANSI_CYAN + "  | ._, |  _____   | | |   _____  | ._, |         " + ANSI_RESET);
        pause(300);
        System.out.println(ANSI_CYAN + "  | |_|_|_|  | | | | | | | | |  |_|_|_|_|         " + ANSI_RESET);
        pause(300);
        System.out.println(ANSI_YELLOW + "  |_,-,_,-,_|_|_|_|_|_|_|_|_|_|_|_|_,-,_,-,_      " + ANSI_RESET);
        pause(1000);
        System.out.println(ANSI_GREEN + "\nPrepare yourself...\n" + ANSI_RESET);
        pause(1500);
    }

    // Helper method to pause without forcing InterruptedException
    private static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle the interruption silently
            Thread.currentThread().interrupt(); // Reset the interrupt flag in case it's needed elsewhere
        }
    }
    
}