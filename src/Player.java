import java.util.Scanner;

public class Player {

    public Board tab = new Board();
    public String tabCode = tab.getCombi();
    public String combiPlayer = "";

    //Getter and Setter
    public String getCombiplayer(){
        return (combiPlayer);
    }
    public void setCombiPlayer(String newCombiPlayer){
        this.combiPlayer = newCombiPlayer;
    }

    // Ask the player his response for cracking the code
    public void askPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Proposition : ");
        String choosenNumbers = sc.nextLine();
        tab.setCombinaison(choosenNumbers);
    }
}
