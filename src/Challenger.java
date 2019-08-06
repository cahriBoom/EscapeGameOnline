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
    public String testAnswer() {
        System.out.print("Response : ");
        String chaineSymbole = "";
        char symbole;
        if(computer.getCombinaison().length()==player.getCombinaison().length()){
            for (int i = 0; i<computer.getCombinaison().length(); i++){
                if(computer.getCombinaison().charAt(i)>player.getCombinaison().charAt(i)){
                    symbole = '+';
                }else if(computer.getCombinaison().charAt(i)<player.getCombinaison().charAt(i)){
                    symbole = '-';
                }else{
                    symbole = '=';
                }
                chaineSymbole += symbole;
            }
            System.out.println(chaineSymbole);
            return (chaineSymbole);
        }else{
            System.out.println("Not enough numbers !");
            return(chaineSymbole);
        }
    }

    // Test how many numbers remain before the player win
    /*private int testNbCharRestant(){
        int longeurString = computer.getCombinaison().length();
        int numberRestant = longeurString;
        for(int i =0; i<longeurString; i++){
            if(computer.getCombinaison().charAt(i)==player.getCombinaison().charAt(i)){
                numberRestant -=1;
            }
        }
        return numberRestant;
    }*/
    private boolean testnbCharValide(String chaine){
        int compteur = 0;
        for(int i = 0; i<chaine.length();i++){
            if(chaine.charAt(i)=='='){
                compteur += 1;
            }else{
                compteur += 0;
            }
        }
        if(compteur!=computer.getCombinaison().length()){
            return false;
        }else{
            return true;
        }
    }


    // Repeat each turn until somebody win the game
    private void turnRepeatChallengerMode(){
        int nbTry = 3;
        boolean isFinish;
        String repComputer;
        while(nbTry != 0){
            this.askPlayer();
            repComputer = this.testAnswer();
            isFinish = testnbCharValide(repComputer);
            if (isFinish){
                System.out.println("You win!");
                return;
            }
            nbTry -=1;
        }
        System.out.println("I win !");
        System.out.println("The Code was :" + computer.getCombinaison());
    }
}
