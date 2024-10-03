import java.util.Scanner;
import monsters.Monster;

public class Runner {
    
    public static void main(String[] args) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_PURPLE = "\u001B[35m";
        String ANSI_CYAN = "\u001B[36m";
    
        // set up key variables
        int level = 1;
        boolean gameOver = false;
        boolean gameStarted = false;
        int setUpPhase = 0;
        String playerName = "player";
        String difficultyLevel = "";
        Scanner input = new Scanner(System.in);

        // print a welcome message to user
        System.out.println("Hello " + ANSI_YELLOW + "player" + ANSI_RESET + " welcome to " + ANSI_PURPLE + "Monster Fighter!" + ANSI_RESET);
        System.out.println("Press [ENTER] to begin");

        while (!gameStarted) {
            String choice = input.nextLine();
            if(setUpPhase == 0) {
                if(choice.equalsIgnoreCase("")) {
                    setUpPhase =+ 1;
                }
                else {
                    invalidChoice();
                }
            }
            else if(setUpPhase == 1) {
                System.out.println("Please input " + ANSI_YELLOW + "your" + ANSI_RESET + " name.");
                if(!choice.equalsIgnoreCase("")) {
                    playerName = choice;
                    setUpPhase += 1;
                }
                else {
                    invalidChoice();
                }
            }
            else if(setUpPhase == 2) {
                System.out.println("Please select difficulty:");
                System.out.println(ANSI_GREEN + "[1] Easy." + ANSI_RESET);
                System.out.println(ANSI_YELLOW + "[2] Medium." + ANSI_RESET);
                System.out.println(ANSI_RED + "[3] Hard." + ANSI_RESET);
                if(choice.equalsIgnoreCase("1")) {
                    difficultyLevel = (ANSI_GREEN + "Easy" + ANSI_RESET);
                    setUpPhase += 1;
                }
                else if(choice.equalsIgnoreCase("2")) {
                    difficultyLevel = (ANSI_YELLOW + "Medium" + ANSI_RESET);
                    setUpPhase += 1;
                }
                else if(choice.equalsIgnoreCase("3")) {
                    difficultyLevel = (ANSI_RED + "Hard" + ANSI_RESET);
                    setUpPhase += 1;
                }
                else {
                    invalidChoice();
                }
            }
            else if(setUpPhase == 3) {
                System.out.println("Name: " + ANSI_YELLOW + playerName + ANSI_RESET + "\t Difficulty: " + difficultyLevel + "\t Is this right?");
                System.out.println(ANSI_GREEN + "[Y] Yes." + ANSI_RESET);
                System.out.println(ANSI_RED + "[N] No." + ANSI_RESET);
                if(choice.equalsIgnoreCase("y")) {
                    System.out.println("Excellent!  Then let us begin");
                    gameStarted = true;
                }
                else if(choice.equalsIgnoreCase("n")) {
                    setUpPhase = 1;
                }
                else {
                    invalidChoice();
                }
            }
        }
        // game loop
        while(!gameOver && gameStarted){
            printMenu();
            String choice = input.nextLine();

            Monster m = generateMonster(level);
            // QUIT
            if(choice.equalsIgnoreCase("q")) {
                System.out.println(ANSI_RED + "BYE" + ANSI_RESET);
                gameOver = true;
            }
            // ATTACK
            else if(choice.equalsIgnoreCase("a")) {
                System.out.println(ANSI_YELLOW + playerName + ANSI_RESET + " " + ANSI_CYAN + "attacks" + ANSI_RESET + " " + ANSI_YELLOW + "Enemy" + ANSI_RESET + ".");
            }
            // HEAL
            else if(choice.equalsIgnoreCase("h")) {
                System.out.println(ANSI_YELLOW + playerName + ANSI_RESET + " " + ANSI_GREEN + "heals" + ANSI_RESET + ".");
            }
            // INVALID CHOICE
            else {
                invalidChoice();
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
        System.out.println("*                Choose " + ANSI_YELLOW + "your" + ANSI_RESET + " path:              *");
        System.out.println(ANSI_PURPLE + "*************************************************" + ANSI_RESET);
    
        // Q is for quit
        System.out.println("   [" + ANSI_RED +"Q" + ANSI_RESET + "] " + ANSI_RED + "Quit" + ANSI_RESET + " the dungeon and flee while " + ANSI_YELLOW + "you" + ANSI_RESET + " can!");
    
        // A is for attack
        System.out.println("   [" + ANSI_CYAN + "A" + ANSI_RESET + "] " + ANSI_CYAN + "Attack!" + ANSI_RESET + " Charge at " + ANSI_YELLOW + "your enemy" + ANSI_RESET + " with fury!");
    
        // H is for heal
        System.out.println("   [" + ANSI_GREEN + "H" + ANSI_RESET + "] " + ANSI_GREEN + "Heal." + ANSI_RESET + " Restore " + ANSI_YELLOW + "your" + ANSI_RESET + " strength before battle!");
    
        System.out.println(ANSI_PURPLE + "*************************************************" + ANSI_RESET);
        
        // Extra dungeon atmosphere
        System.out.println(ANSI_YELLOW + "You" + ANSI_RESET + " hear distant growls... Choose wisely.\n");
        System.out.print("\nSELECTION: ");
    }
    
    public static void invalidChoice(){
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + "Invalid choice! Please try again." + ANSI_RESET);
    }

}
