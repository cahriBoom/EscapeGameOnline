public class Challenger extends Player {


    private Board tab = new Board();
    private String tabCode = tab.getCombi();
    private String combiPlayer = "";

    //Getter and Setter
    public String getCombiplayer(){
        return (combiPlayer);
    }
    public void setCombiPlayer(String newCombiPlayer){
        this.combiPlayer = newCombiPlayer;
    }

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

    // Repeat each turn until somebody win the game
    private void turnRepeatChallengerMode(){
        int nbTry = 3;
        while(nbTry != 0){
            this.askPlayer();
            this.testAnswer();

            nbTry -=1;
        }

    }
}
