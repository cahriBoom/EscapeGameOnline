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
        String codePlayer = player.getCombinaison();

    }

    private void Turn(String CodeComp, String codePlay){
        int nbTurn = 0;
        if (nbTurn==0){
            // Joueur propose       ("1234")
            // Ordi réponds         ("++-=")
            // Ordi propose RANDOM  ("8651")
            // Joueur réponds       ("++--")
        }
    }
}
