import java.util.Scanner;

public class Human extends Player {

    // Ask the player his response for cracking the code
    public String askPlayer() {
        Scanner sc = new Scanner(System.in);
        String choosenNumbers = sc.nextLine();
        return choosenNumbers;
    }

    public String askPlayerNewCode() {
        System.out.print("Proposition du joueur : ");
        return this.askPlayer();
    }

    public String askPlayerSymbols() {
        System.out.print("Réponse du joueur : ");
        return this.askPlayer();
    }

    public void askPlayerSecretCombinaison() {
        String secretCombinaison;
        System.out.print("Combinaison secrète du joueur : ");
        secretCombinaison = this.askPlayer();
        this.setCombinaison(secretCombinaison);
    }



}
