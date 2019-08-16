import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;



public class Affichage {

    private int nb_numbers=4;
    private boolean dev_mode=false;

    //Getters and Setters
    private void setNb_numbers(int newNb_Numbers){this.nb_numbers=newNb_Numbers;}
    private int getNb_numbers(){return this.nb_numbers;}
    private void setDev_mode(boolean newDev_mode){this.dev_mode=newDev_mode;}
    private boolean getDev_mode(){return this.dev_mode;}

    // Properties File
    private static String propertiesFile = System.getProperty("user.dir") + File.separator + "config.properties";
    private static Logger logger = Logger.getLogger(Affichage.class);
    private static String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.properties";

    //Print and navigate in the main menu
    public void printMainMenu(){
        GameMode gameMode = new GameMode();
        Scanner sc = new Scanner(System.in);
        PropertyConfigurator.configure(log4jConfigFile);

        //Read the parameter file.
        try (InputStream input = new FileInputStream(propertiesFile)) {
            Properties prop = new Properties();
            prop.load(input);
            String nbString = prop.getProperty("Numbers_Asked");
            String dev_modeString = prop.getProperty("Dev_Mode");

            // Numbers of number to decode.
            int nb = Integer.parseInt(nbString);
            this.setNb_numbers(nb);

            // Activate or not the mode developer
            boolean dev = Boolean.parseBoolean(dev_modeString);
            this.setDev_mode(dev);

        } catch (IOException io) {
            io.printStackTrace();
        }

        boolean replay = true;
        try {
            System.out.println("1- Challenger");
            System.out.println("2- Defense");
            System.out.println("3- Duel ");
            System.out.println("4- Quit");
            System.out.println("Choose a number : ");
            int entryMenu = sc.nextInt();
            int nb = this.getNb_numbers();
            boolean dev_mode = this.getDev_mode();
            switch (entryMenu) {
                case 1:
                    while (replay) {
                        gameMode.Challenger(nb, dev_mode);
                        replay = this.askToReplay();
                        this.clearScreen();
                    }
                    this.printMainMenu();
                    break;
                case 2:
                    while (replay) {
                        gameMode.Defense(nb);
                        replay = this.askToReplay();
                        this.clearScreen();
                    }
                    this.printMainMenu();
                    break;
                case 3:   // mode Duel
                    while (replay) {
                        gameMode.Duel(nb, dev_mode);
                        replay = this.askToReplay();
                        this.clearScreen();
                    }
                    this.printMainMenu();
                    break;
                case 4:
                    System.out.println("Bye");
                    return;
                default:
                    System.out.println("Choose a number between 1 and 4");
                    logger.error("ERROR USER TYPE : " + entryMenu);
                    this.clearScreen();
                    this.printMainMenu();
            }
        }catch (InputMismatchException e){
            System.out.println("Please type only integer");
            logger.error("ERROR: NOT INTEGER");
            this.printMainMenu();
        }
    }

    // Clear the console
    private void clearScreen() {
        for(int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    // Ask if the player want to replay another game or not
    private boolean askToReplay(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to replay this game : ?(Yes/No)");
        String replay = sc.nextLine();
        if(replay.equals("Yes")){
            return true;
        }else{
            return false;
        }
    }
}
