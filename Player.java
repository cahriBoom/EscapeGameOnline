import java.util.Scanner;

public class Player {

    private Board tab = new Board();

    // Ask the player his response for cracking the code
    public void askPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Proposition : ");
        String choosenNumbers = sc.nextLine();
        tab.setCombinaison(choosenNumbers);
    }
}
