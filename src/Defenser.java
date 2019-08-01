public class Defenser extends Player {

    private Player player = new Player();
    private Player computer = new Player();

    //Make the game in Defense mode
    public void Defense(int nb){
        int nbLife = 3;
        computer.createBoard(nb);
        player.askPlayer();
        System.out.println("Code Ordi : "  + computer.getCombinaison());
        while(nbLife!=0){
            String chaine = this.testDefense();
            this.incrementCode(chaine);
            System.out.println("New computer combinaison : " + computer.getCombinaison());
            System.out.println("New computer combinaison longeur : " + computer.getCombinaison().length());
            nbLife -=1;
        }
    }

    private String testDefense(){
        String symbole = "";
        String symboleCode = "";
        for (int i = 0; i<computer.getCombinaison().length(); i++) {
            if (computer.getCombinaison().charAt(i) < player.getCombinaison().charAt(i)) {
                symbole = "+";
            } else if (computer.getCombinaison().charAt(i) > player.getCombinaison().charAt(i)) {
                symbole = "-";
            } else {
                symbole = "=";
            }
            symboleCode += symbole;
        }
        return(symboleCode);
    }

    // Allow the computer to Attack the code.
    private void incrementCode(String Code){
        int codeInt=0;
        String newChaine="";
        for(int i = 0; i<Code.length();i++){
            if (Code.charAt(i)=='+'){
                codeInt = Character.getNumericValue(computer.getCombinaison().charAt(i));
                codeInt +=1;
            }else if(Code.charAt(i)=='-'){
                codeInt = Character.getNumericValue(computer.getCombinaison().charAt(i));
                codeInt -= 1;
            }else{
                codeInt = Character.getNumericValue(computer.getCombinaison().charAt(i));
            }
            System.out.println("code Int : " + codeInt);
            newChaine += codeInt;
        }
        //System.out.println("new Chaine : "+ newChaine);
        computer.setCombinaison(newChaine);
    }
}
