import java.util.Random;
import java.util.Scanner;

public class Player {

    private String combinaison = "";

    //Getter and Setter
    public String getCombinaison(){
        return (this.combinaison);
    }
    public void setCombinaison(String newCombinaison){
        this.combinaison = newCombinaison;
    }

    // Create a board with X random number.
    public void createBoard(int nb) {
        Random randomGenerator = new Random();
        String combiRandom = "";
        for (int i = 0; i < nb; i++) {
            int randomInt = randomGenerator.nextInt(9);
            combiRandom += Integer.toString(randomInt);
            this.setCombinaison(combiRandom);
        }
    }

    public String createDefaultCode(int nb){
        String code="";
        while(nb !=0){
            code +=5;
            nb-=1;
        }
        return code;
    }

    // Test each values of the board.
    public void printCode() {
        String combiPlayer = this.getCombinaison();
        System.out.print(combiPlayer);

    }


    // True if there are = on all characters
    public boolean isFinished(String Code){
        int longueurChaine = Code.length();
        int compteur = 0;
        for (int i=0; i<longueurChaine;i++){
            if (Code.charAt(i)=='='){
                compteur +=1;
            }else{
                compteur =0;
            }
        }
        if(compteur==longueurChaine){
            return true;
        }
        return false;
    }


}

