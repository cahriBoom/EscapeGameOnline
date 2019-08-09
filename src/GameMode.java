import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class GameMode {

    //
    private Human human = new Human();
    private Computer computer = new Computer();
    private static Logger logger = Logger.getLogger(GameMode.class);
    private static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.properties";
    //

    // Set the game in challenger mode
    public void Challenger(int nb, boolean dev){
        computer.createSecretCombinaison(nb);
        String computerAnswerSymbols;
        // Configuration Log4j
        PropertyConfigurator.configure(log4jConfigFile);

        // If mode develop is activated
        if(dev){
            System.out.println("---------DEV MODE---------");
            System.out.println("Computer combination : " + computer.getCombinaison());
            System.out.println("--------------------------");
        }
        int nbTry = 1;
        while(nbTry<=3){
            System.out.println("\nTour numéro : " + nbTry);
            System.out.println("C'est à vous de jouer");
            System.out.println("---------------------");
            String humanProposedCode = human.askPlayerNewCode(nb);
            logger.info("Player proposed : " + humanProposedCode);
            computerAnswerSymbols = computer.testAnswer(humanProposedCode);
            logger.info("Computer responds : " + computerAnswerSymbols);

            if(human.isFinished(computerAnswerSymbols)){
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
        human.askPlayerSecretCombinaison(nb);
        String computerProposedCombinaison = computer.createDefaultCode(nb);
        // Configuration Log4j
        PropertyConfigurator.configure(log4jConfigFile);

        int nbTry =1;
        while (nbTry<=3){
            System.out.println("\nC'est à l'ordinateur de jouer");
            System.out.println("-----------------------------");
            System.out.println("Proposition de l'ordinateur : " + computerProposedCombinaison);
            logger.info("computer proposed : " + computerProposedCombinaison);
            String chaine = human.askPlayerSymbols(nb);
            logger.info("Player respond : " + chaine);
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
    public void Duel(int nb, boolean dev){
        computer.createSecretCombinaison(nb);
        String computerProposedCombinaison = computer.createDefaultCode(nb);
        human.askPlayerSecretCombinaison(nb);

        // Configuration Log4j
        PropertyConfigurator.configure(log4jConfigFile);

        // If mode develop is activated
        if(dev){
            System.out.println("---------DEV MODE---------");
            System.out.println("Computer combination : " + computer.getCombinaison());
            System.out.println("--------------------------");
        }

        // loop until a player wins
        int numTry = 1;
        while(numTry <= 3){
            // first : the human plays and tries to found computer secret combinaison
            System.out.println("Tour numéro : " + numTry);
            System.out.println("C'est à vous de jouer");
            System.out.println("---------------------");
            String humanProposedCode;
            humanProposedCode = human.askPlayerNewCode(nb);
            logger.info("Player proposed : " + humanProposedCode);
            String computerAnswerSymbols;
            computerAnswerSymbols = computer.testAnswer(humanProposedCode);
            logger.info("Computer responds : " + computerAnswerSymbols);
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
            logger.info("Computer proposed " + computerProposedCombinaison);
            String chaine = human.askPlayerSymbols(nb);
            logger.info("Player responds " + chaine);
            computerProposedCombinaison = computer.BinarySearch(numTry, chaine, computerProposedCombinaison);
            if(computer.isFinished(chaine)){
                System.out.println("\n++++++++++++++++++++++++");
                System.out.println("L'ordinateur a gagné !!!");
                System.out.println("++++++++++++++++++++++++");
                return;
            }
            numTry +=1;
        }
        System.out.println("The Code was :" + computer.getCombinaison());

    }
}
