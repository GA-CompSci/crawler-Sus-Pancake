import java.util.Scanner;
import monsters.Monster;

public class Runner {

    public static void main(String[] args) {
        // set up key variables
        int level = 1;
        boolean gameOver = false;
        Scanner input = new Scanner(System.in);

        // print a welcome message to user
        System.out.println("Welcome to Monster Fighter!");

        // game loop
        while(!gameOver){
            printMenu();
            String choice = input.nextLine();

            Monster m = generateMonster(level);

            // QUIT
            if(choice.equalsIgnoreCase("q")) {
                gameOver = true;
            }
            // ATTACK
            else if(choice.equalsIgnoreCase("a")) {
                //a
            }
            // HEAL
            else if(choice.equalsIgnoreCase("h")) {

            }
            // INVALID CHOICE
            else {
                System.out.println("Invalid choice.  Try again.");
            }
        }

        //goodbye message

        // we close the scanner to avoid memory leaks
        input.close();
    }

    public static Monster generateMonster(int level){
        return null;
    }

    public static void printMenu(){
        // ANSI escape codes for colors
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
    
        // Dungeon-themed menu art
        System.out.println(ANSI_PURPLE + "*************************************************" + ANSI_RESET);
        System.out.println(ANSI_RED + "*                Choose your path:              *" + ANSI_RESET);
        System.out.println(ANSI_PURPLE + "*************************************************" + ANSI_RESET);
    
        // Q is for quit
        System.out.println(ANSI_RED + "   [Q] Quit the dungeon and flee while you can!" + ANSI_RESET);
    
        // A is for attack
        System.out.println(ANSI_GREEN + "   [A] Attack! Charge at your enemy with fury!" + ANSI_RESET);
    
        // H is for heal
        System.out.println(ANSI_CYAN + "   [H] Heal. Restore your strength before battle!" + ANSI_RESET);
    
        System.out.println(ANSI_PURPLE + "*************************************************" + ANSI_RESET);
        
        // Extra dungeon atmosphere
        System.out.println(ANSI_YELLOW + "You hear distant growls... Choose wisely.\n" + ANSI_RESET);
        System.out.print("\nSELECTION: ");
    }
    

}
