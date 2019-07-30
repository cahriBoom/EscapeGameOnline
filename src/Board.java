import java.util.Random;

public class Board {

    Player player = new Player();
    // Make the game in Duel mode
    private void Duel(){

    }

    // Create a board with X random number.
    public void createBoard() {
            Random randomGenerator = new Random();
            String combiPlayer = player.getCombinaison();
            for (int i = 0; i < combiPlayer.length(); i++) {
                int randomInt = randomGenerator.nextInt(9);
                combiPlayer += Integer.toString(randomInt);
        }
    }

    // Test each values of the board.
    public void printCode() {
        String combiPlayer = player.getCombinaison();
        for (int i = 0; i < combiPlayer.length(); i++) {
            System.out.print(combiPlayer);
        }
    }
}
