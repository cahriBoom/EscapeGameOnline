import java.util.Scanner;

public class Challenger extends Player {

    private Player player = new Player();
    private Player computer = new Player();
    //private Player computer = new Player();

    //Make the game in challenge Mode
    public void ChallengerMode(int nb){
        computer.createBoard(nb);
        computer.printCode();
        System.out.println(" ");
        System.out.println("/////////////////////////////////////");
        this.turnRepeatChallengerMode();
    }

    // Ask the player his response for cracking the code
    public void askPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Proposition : ");
        String choosenNumbers = sc.nextLine();
        player.setCombinaison(choosenNumbers);
    }


    // Check if the answer is the same as the code.
    private void testAnswer() {
        System.out.print("Response : ");

        if(computer.getCombinaison().length()==player.getCombinaison().length()){
            for (int i = 0; i<computer.getCombinaison().length(); i++){
                if(computer.getCombinaison().charAt(i)>player.getCombinaison().charAt(i)){
                    System.out.print('+');
                }else if(computer.getCombinaison().charAt(i)<player.getCombinaison().charAt(i)){
                    System.out.print('-');
                }else{
                    System.out.print('=');
                }
            }
            System.out.println(" ");
        }else{
            System.out.println("Not enough numbers !");
        }
    }

    // Test how many numbers remain before the player win
    private int testNbCharRestant(){
        int longeurString = computer.getCombinaison().length();
        int numberRestant = longeurString;
        for(int i =0; i<longeurString; i++){
            if(computer.getCombinaison().charAt(i)==player.getCombinaison().charAt(i)){
                numberRestant -=1;
            }
        }
        return numberRestant;
    }

    // Repeat each turn until somebody win the game
    private void turnRepeatChallengerMode(){
        int nbTry = 3;
        int numbRestant;
        while(nbTry != 0){
            this.askPlayer();
            this.testAnswer();
            numbRestant = this.testNbCharRestant();
            if (numbRestant==0){
                System.out.println("You win!");
                return;
            }
            nbTry -=1;
        }
        System.out.println("I win !");
        System.out.println("The Code was :" + computer.getCombinaison());
    }
}
