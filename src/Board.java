import java.util.Random;

public class Board {

    private Defenser computer = new Defenser();
    private Challenger player = new Challenger();
    private Affichage a = new Affichage();

    // Set the game in Duel Mode
    public void Duel(int nb){
        computer.createBoard(nb);
        player.askPlayer();
        String codeComputer = computer.getCombinaison();

    }

    private void Turn(String CodeComp){
        String repComputer = player.testAnswer();
        String repPlayer;
        System.out.println("Computer response : " + repComputer);
        System.out.println("Computer proposition : " + CodeComp);
        repPlayer = computer.askPlayer();
        //joueur Propose
    }
}
