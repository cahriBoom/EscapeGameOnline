import java.util.Scanner;

public class Affichage {


    //Print and navigate in the main menu
    public void printMainMenu(int nb){
        Challenger challenger = new Challenger();
        Defenser defenser = new Defenser();
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Challenger");
        System.out.println("2- Defense");
        System.out.println("3- Duel ");
        System.out.println("4- Quit");
        System.out.println("Choose a number : ");
        int entryMenu = sc.nextInt();
        switch(entryMenu) {
            case 1:
                challenger.ChallengerMode(nb);
                break;
            case 2:
                defenser.Defense(nb);
                break;
            case 3:
                //this.Duel();
                break;
            case 4:
                System.out.println("Bye");
                return;
            default:
                System.out.println("Choose a number between 1 and 4");
        }
    }
}
