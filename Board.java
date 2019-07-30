import java.util.Random;

public class Board {
    private String combinaison = "";        // AI combinaison

    //Getter and Setter
    public String getCombi() {
        return (this.combinaison);
    }
    public void setCombinaison(String newCombinaison){
        this.combinaison = newCombinaison;
    }

    // Make the game in Duel mode
    private void Duel(){

    }

    // Create a board with X random number.
    public void createBoard() {
            Random randomGenerator = new Random();
            String tabLength = this.getCombi();
            for (int i = 0; i < tabLength.length(); i++) {
                int randomInt = randomGenerator.nextInt(9);
                this.combinaison = Integer.toString(randomInt);
        }
    }

    // Test each values of the board.
    public void printCode() {
        String tabLength = this.getCombi();
        for (int i = 0; i < tabLength.length(); i++) {
            System.out.print(this.combinaison);
        }
    }
}
