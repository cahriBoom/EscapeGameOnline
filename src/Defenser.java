public class Defenser extends Player {

    private Player player = new Player();
    private Player computer = new Player();

    //Make the game in Defense mode
    public void Defense(int nb){
        int nbLife = 3;
        String newChaine ="";
        String computerDefaultCode = computer.createDefaultCode(nb);
        player.askPlayer();
        System.out.println("Code Ordi : "  + computerDefaultCode);
        newChaine = computerDefaultCode;
        while(nbLife!=0){
            String chaine = this.testDefense(newChaine);
            newChaine = this.incrementCode(chaine, newChaine);
            System.out.println("New computer combinaison : " + newChaine);
            if(this.isFinish(chaine)){
                System.out.println("I win");
                return;
            }
            nbLife -=1;
        }
        System.out.println("You win");
    }

    private String testDefense(String code){
        String symbole = "";
        String symboleCode = "";
        for (int i = 0; i<code.length(); i++) {
            if (code.charAt(i) < player.getCombinaison().charAt(i)) {
                symbole = "+";
            } else if (code.charAt(i) > player.getCombinaison().charAt(i)) {
                symbole = "-";
            } else {
                symbole = "=";
            }
            symboleCode += symbole;
        }
        return(symboleCode);
    }

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

    // Allow the computer to Attack the code.
    private String incrementCode(String Code, String oldChaine){
        int codeInt=0;
        String newChaine="";
        for(int i = 0; i<Code.length();i++){
            if (Code.charAt(i)=='+'){
                codeInt = Character.getNumericValue(oldChaine.charAt(i));
                codeInt +=1;
            }else if(Code.charAt(i)=='-'){
                codeInt = Character.getNumericValue(oldChaine.charAt(i));
                codeInt -= 1;
            }else{
                codeInt = Character.getNumericValue(oldChaine.charAt(i));
            }
            newChaine += codeInt;
        }
        return (newChaine);
    }
}
