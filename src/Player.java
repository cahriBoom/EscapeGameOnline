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

