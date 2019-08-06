public class GameMode {

    //
    private Human human = new Human();
    private Computer computer = new Computer();
    //

    // Set the game in challenger mode
    public void Challenger(int nb){
        computer.createSecretCombinaison(nb);
        String computerAswerSymbols;
        int nbTry = 1;
        while(nbTry<=3){
            System.out.println("\nTour numéro : " + nbTry);
            System.out.println("C'est à vous de jouer");
            System.out.println("---------------------");
            String humanProposedCode = human.askPlayerNewCode();
            computerAswerSymbols = computer.testAnswer(humanProposedCode);

            if(human.isFinished(computerAswerSymbols)){
                System.out.println("\n+++++++++++++++++++");
                System.out.println("Vous avez gagné !!!");
                System.out.println("+++++++++++++++++++");
                return;
            }
            nbTry+=1;
        }
        System.out.println("\n++++++++++++++++++++++++");
        System.out.println("L'ordinateur a gagné !!!");
        System.out.println("++++++++++++++++++++++++");
        System.out.println("La combinaison était : " + computer.getCombinaison());
    }

    // set the game in Defense mode
    public void Defense(int nb){
        human.askPlayerSecretCombinaison();
        String computerProposedCombinaison = computer.createDefaultCode(nb);
        int nbTry =1;
        while (nbTry<=3){
            System.out.println("\nC'est à l'ordinateur de jouer");
            System.out.println("-----------------------------");
            System.out.println("Proposition de l'ordinateur : " + computerProposedCombinaison);
            String chaine = human.askPlayerSymbols();
            computerProposedCombinaison = computer.BinarySearch(nbTry, chaine, computerProposedCombinaison);
            nbTry+=1;
            if(computer.isFinished(chaine)){
                System.out.println("\n++++++++++++++++++++++++");
                System.out.println("L'ordinateur a gagné !!!");
                System.out.println("++++++++++++++++++++++++");
                return;
            }
        }
        System.out.println("\n+++++++++++++++++++");
        System.out.println("Vous avez gagné !!!");
        System.out.println("+++++++++++++++++++");
    }

    // Set the game in Duel Mode
    public void Duel(int nb){
        computer.createSecretCombinaison(nb);
        String computerProposedCombinaison = computer.createDefaultCode(nb);
        human.askPlayerSecretCombinaison();

        // loop until a player wins
        int numTry = 1;
        while(numTry <= 3){
            // first : the human plays and tries to found computer secret combinaison
            System.out.println("Tour numéro : " + numTry);
            System.out.println("C'est à vous de jouer");
            System.out.println("---------------------");
            String humanProposedCode;
            humanProposedCode = human.askPlayerNewCode();
            String computerAnswerSymbols;
            computerAnswerSymbols = computer.testAnswer(humanProposedCode);
            if(human.isFinished(computerAnswerSymbols)){
                System.out.println("\n+++++++++++++++++++");
                System.out.println("Vous avez gagné !!!");
                System.out.println("+++++++++++++++++++");
                return;
            }

            // second : the computer plays and tries to found human secret combinaison
            System.out.println("C'est à l'ordinateur de jouer");
            System.out.println("-----------------------------");
            System.out.println("   Proposition de l'ordinateur : " + computerProposedCombinaison);
            String chaine = human.askPlayerSymbols();
            computerProposedCombinaison = computer.BinarySearch(numTry, chaine, computerProposedCombinaison);
            if(computer.isFinished(chaine)){
                System.out.println("\n++++++++++++++++++++++++");
                System.out.println("L'ordinateur a gagné !!!");
                System.out.println("++++++++++++++++++++++++");
                return;
            }
            //System.out.println("New computer combinaison : " + computerProposedCombinaison);
            numTry +=1;
        }
        System.out.println("The Code was :" + computer.getCombinaison());

    }
}
