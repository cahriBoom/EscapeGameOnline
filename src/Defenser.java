import java.util.Scanner;

public class Defenser extends Player {

    private Challenger player = new Challenger();
    private Player computer = new Player();

    //Make the game in Defense mode
    public void Defense(int nb){
        int nbTry = 1;
        String newChaine ="";
        String computerDefaultCode = computer.createDefaultCode(nb);
        player.askPlayer();
        System.out.println("Code Ordi : "  + computerDefaultCode);
        newChaine = computerDefaultCode;
        while(nbTry!=4){
            String chaine = this.askPlayer();
            newChaine = this.BinarySearch(nbTry, chaine, newChaine);
            if(this.isFinish(chaine)){
                System.out.println("I win");
                return;
            }
            System.out.println("New computer combinaison : " + newChaine);
            nbTry +=1;
        }
        System.out.println("You win");
    }

    // Ask the player for a response in symbole
    public String askPlayer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Respond to the computer : ");
        String response = sc.nextLine();
        return response;
    }

    // True if there are = on all characters
    private boolean isFinish(String Code){
        int longeurChaine = Code.length();
        int compteur = 0;
        for (int i=0; i<longeurChaine;i++){
            if (Code.charAt(i)=='='){
                compteur +=1;
            }else{
                compteur =0;
            }
        }
        if(compteur==longeurChaine){
            return true;
        }
        return false;
    }

    //Recherche dichotomique pour la valeur cachée
    private String BinarySearch(int nbCoup, String symbole, String oldChaine){
        int val = 0;
        String newChaine ="";
        for(int i=0; i<symbole.length();i++){
            val = Character.getNumericValue(oldChaine.charAt(i));
            switch(nbCoup) {
                case 1:
                    if(symbole.charAt(i)=='+'){
                        val +=2;
                    }else if(symbole.charAt(i)=='-'){
                        val-=2;
                    }
                    break;
                case 2:
                case 3:
                    if(symbole.charAt(i)=='+'){
                        val +=1;
                    }else if(symbole.charAt(i)=='-'){
                        val-=1;
                    }
            }
            newChaine += val;
        }
        return(newChaine);
    }
}
