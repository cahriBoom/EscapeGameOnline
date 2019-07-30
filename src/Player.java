import java.util.Scanner;

public class Player {

    private String combinaison = " ";

    //Getter and Setter
    public String getCombinaison(){
        return (this.combinaison);
    }
    public void setCombinaison(String newCombinaison){
        this.combinaison = newCombinaison;
    }

    // Ask the player his response for cracking the code
    public void askPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Proposition : ");
        String choosenNumbers = sc.nextLine();
        this.setCombinaison(choosenNumbers);
    }
}
