import java.util.Scanner;

public class Human extends Player {

    // Ask the player his response for cracking the code
    public String askPlayer(String question, boolean modeIntegers) {
        //Scanner sc = new Scanner(System.in);

        Scanner sc = new Scanner(System.in);
        if (modeIntegers) {
            Integer enteredIntegers;
            while (true) {
                System.out.print(question);
                try {
                    enteredIntegers = sc.nextInt();
                    return enteredIntegers.toString();
                } catch (java.util.NoSuchElementException e) {
                    sc.nextLine();
                    System.out.println("The input is not an integer");
                }
            }
        } else {
            String enteredComparators;
            while (true) {
                System.out.print(question);
                enteredComparators = sc.nextLine();
                boolean ok = true;
                for (int i=0; i<enteredComparators.length();i++){
                    if ((enteredComparators.charAt(i)!='=') && (enteredComparators.charAt(i)!='-') && (enteredComparators.charAt(i)!='+')){
                        ok = false;
                    }
                }
                if (ok) {
                    return enteredComparators;
                } else {
//                    sc.nextLine();
                    System.out.println("The string is not correct");
                }
            }
        }
    }

    // Ask the player to type a code
    public String askPlayerNewCode(int nb) {
        String chaine = this.askPlayer("Proposition du joueur : ", true);
        if(chaine.length()!=nb){
            while(chaine.length()!=nb){
                System.out.println("You may choose only " + nb + " Numbers");
                chaine = this.askPlayer("Proposition du joueur : ", true);
            }
        }
        return chaine;
    }
    // Ask the player to type a response to the computer
    public String askPlayerSymbols(int nb) {
        String chaine =  this.askPlayer("Réponse du joueur : ", false);
        if(chaine.length()!=nb){
            while(chaine.length()!=nb){
                System.out.println("You may choose only " + nb + " symbols");
                chaine = this.askPlayer("Réponse du joueur : ", false);
            }
        }
        return chaine;
    }
    // Ask the player to type his/her secret combination
    public void askPlayerSecretCombinaison(int nb) {
        String secretCombinaison;
        secretCombinaison = this.askPlayer("Combinaison secrète du joueur : ", true);
        if(secretCombinaison.length()!=nb){
            while(secretCombinaison.length()!=nb){
                System.out.println("You may choose only " + nb + " Numbers");
                secretCombinaison = this.askPlayer("Combinaison secrète du joueur : ", true);
            }
        }
        this.setCombinaison(secretCombinaison);
    }
}

