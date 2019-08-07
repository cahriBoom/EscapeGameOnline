import java.util.Scanner;

public class Human extends Player {

    // Ask the player his response for cracking the code
    public String askPlayer(int nb) {
        Scanner sc = new Scanner(System.in);
        String choosenNumbers = sc.nextLine();
        return choosenNumbers;
    }
    // Ask the player to type a code
    public String askPlayerNewCode(int nb) {
        System.out.print("Proposition du joueur : ");
        String chaine = this.askPlayer(nb);
        if(chaine.length()!=nb){
            while(chaine.length()!=nb){
                System.out.println("You may choose only " + nb + " Numbers");
                System.out.print("Proposition du joueur : ");
                chaine = this.askPlayer(nb);
            }
        }
        return chaine;
    }
    // Ask the player to type a response to the computer
    public String askPlayerSymbols(int nb) {
        System.out.print("Réponse du joueur : ");
        String chaine =  this.askPlayer(nb);
        if(chaine.length()!=nb){
            while(chaine.length()!=nb){
                System.out.println("You may choose only " + nb + " symbols");
                System.out.print("Reponse du joueur : ");
                chaine = this.askPlayer(nb);
            }
        }
        return chaine;
    }
    // Ask the player to type his/her secret combination
    public void askPlayerSecretCombinaison(int nb) {
        String secretCombinaison;
        System.out.print("Combinaison secrète du joueur : ");
        secretCombinaison = this.askPlayer(nb);
        if(secretCombinaison.length()!=nb){
            while(secretCombinaison.length()!=nb){
                System.out.println("You may choose only " + nb + " Numbers");
                System.out.print("Combinaison secrète du joueur : ");
                secretCombinaison = this.askPlayer(nb);
            }
        }
        this.setCombinaison(secretCombinaison);
    }
}
