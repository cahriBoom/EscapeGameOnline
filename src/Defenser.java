public class Defenser extends Player {

    private Player player = new Player();
    private Player computer = new Player();
    private Board tab = new Board();

    //Make the game in Defense mode
    private void Defense(){
        //tab.createBoard();
        this.askPlayer();
        this.testDefense();
    }

    public void testDefense(){
        int triesLeft = 3;
        int combiComputerInt;
        while(triesLeft != 0){
            for (int i = 0; i<computer.getCombinaison().length(); i++){
                if(computer.getCombinaison().charAt(i)<player.getCombinaison().charAt(i)){
                    combiComputerInt = computer.getCombinaison().charAt(i);
                    //combiComputerInt +=1;
                    //combiComputer.charAt(i) = combiComputerInt - 48;
                }
            }
            triesLeft -=1;
        }
        System.out.println("I didn't found your code, You've won");
    }

    // Allow the computer to Attack the code.
    /*private char[] crackTheCode(int cracking[]){
        char code[]={' ',' ',' ',' '};
        for (int i =0; i<this.boardResponseInt.length; i++){
            if(cracking[i]<this.boardResponseInt[i]){
                code[i] = '-';
            }else if(cracking[i]>this.boardResponseInt[i]){
                code[i] = '+';
            }else{
                code[i] = '=';
            }
        }
        return (code);
    }

    // AI try to crack the code by implementing his values by 1 and update the + - = response
    private char[] foundRightNumber(int crack[], char code[]){
        if(code[0]=='-'){
            crack[0] += 1;
        }
        if(code[1]=='-'){
            crack[1] += 1;
        }
        if(code[2]=='-'){
            crack[2] += 1;
        }
        if(code[3]=='-'){
            crack[3] += 1;
        }
        if(code[0]=='+'){
            crack[0] -= 1;
        }
        if(code[1]=='+'){
            crack[1] -= 1;
        }
        if(code[2]=='+'){
            crack[2] -= 1;
        }
        if(code[3]=='+'){
            crack[3] -= 1;
        }
        return (code);
    }*/
}
