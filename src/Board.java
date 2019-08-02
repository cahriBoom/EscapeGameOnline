import java.util.Random;

public class Board {

    private Defenser computer;
    private Challenger player;

    // Set the game in Duel Mode
    public void Duel(int nb){
        computer.createBoard(nb);
        player.askPlayer();
        String codeComputer = computer.getCombinaison();
        String codePlayer = player.getCombinaison();

    }

    private void Turn(){

    }
}
