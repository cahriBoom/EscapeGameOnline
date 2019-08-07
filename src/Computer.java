import java.util.Random;

public class Computer extends Player {

    // Create a secret combinaison with X random number.
    public void createSecretCombinaison(int nb) {
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

    // Check if the answer is the same as the code (mode Challenger)
    public String testAnswer(String proposedHumanCode) {
        System.out.print("Response : ");
        String chaineSymbole = "";
        char symbole;
        if(this.getCombinaison().length()==proposedHumanCode.length()){
            for (int i = 0; i<this.getCombinaison().length(); i++){
                if(this.getCombinaison().charAt(i)>proposedHumanCode.charAt(i)){
                    symbole = '+';
                }else if(this.getCombinaison().charAt(i)<proposedHumanCode.charAt(i)){
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

    //Recherche dichotomique pour la valeur cachée (mode Defenser)
    public String BinarySearch(int nbCoup, String symbole, String oldChaine){
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
