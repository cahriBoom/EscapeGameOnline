public class Challenger extends Player {


    //Make the game in challenge Mode
    private void ChallengerMode(){
        tab.createBoard();
        tab.printCode();
        System.out.println(" ");
        System.out.println("/////////////////////////////////////");
        this.turnRepeatChallengerMode();
    }

    // Check if the answer is the same as the code.
    private void testAnswer() {
        System.out.print("Response : ");
        if(tabCode.length()==combiPlayer.length()){
            for (int i = 0; i<tabCode.length(); i++){
                if(tabCode.charAt(i)>combiPlayer.charAt(i)){
                    System.out.print('+');
                }else if(tabCode.charAt(i)<combiPlayer.charAt(i)){
                    System.out.print('-');
                }else{
                    System.out.print('=');
                }
            }
        }else{
            System.out.println("Not enough numbers !");
        }
    }

    // Test how many numbers remain before the player win
    private int testNbCharRestant(){
        int longeurString = tabCode.length();
        int numberRestant = longeurString;
        for(int i =0; i<longeurString; i++){
            if(combiPlayer.charAt(i)=='='){
                numberRestant +=1;
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

    }
}
