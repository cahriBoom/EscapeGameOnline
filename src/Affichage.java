import java.io.IOException;
import java.util.Scanner;

public class Affichage {


    //Print and navigate in the main menu
    public void printMainMenu(int nb){
        Challenger challenger = new Challenger();
        Defenser defenser = new Defenser();
        Board gameMode = new Board();
        Scanner sc = new Scanner(System.in);
        boolean replay = true;
        System.out.println("1- Challenger");
        System.out.println("2- Defense");
        System.out.println("3- Duel ");
        System.out.println("4- Quit");
        System.out.println("Choose a number : ");
        int entryMenu = sc.nextInt();
        switch(entryMenu) {
            case 1:
                while(replay){
                    challenger.ChallengerMode(nb);
                    replay=this.askToReplay();
                    this.clearScreen();
                }
                this.printMainMenu(nb);
                break;
            case 2:
                while(replay){
                    defenser.Defense(nb);
                    replay=this.askToReplay();
                    this.clearScreen();
                }
                this.printMainMenu(nb);
                break;
            case 3:
                while(replay){
                    gameMode.Duel(nb);
                    replay = this.askToReplay();
                    this.clearScreen();
                }
                this.printMainMenu(nb);
                break;
            case 4:
                System.out.println("Bye");
                return;
            default:
                System.out.println("Choose a number between 1 and 4");
                this.clearScreen();
                this.printMainMenu(nb);
        }
    }

    // Clear the console
    private void clearScreen() {
        for(int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    // Ask if the player want to replay another game or not
    private boolean askToReplay(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to replay this game : ?(Yes/No)");
        String replay = sc.nextLine();
        if(replay.equals("Yes")){
            return true;
        }else{
            return false;
        }
    }
}
