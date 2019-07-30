import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Board {
    private int combinaison[] = {0, 0, 0, 0};       // AI combinaison
    private char boardResponse[] = {};              // Place char. To help AI cracking the code
    private int boardResponseInt[] = {0, 0, 0, 0};  // Combinaison input by the player
    private int remainNumbers = 4;                  // Number remaining to found
    private boolean isFinish = false;               // If the game is finish or not


    //Getter and Setter
    private int getCombiLength() {
        return (this.combinaison.length);
    }

    //Print and navigate in the main menu
    public void printMainMenu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1- Challenger");
        System.out.println("2- Defense");
        System.out.println("3- Duel ");
        System.out.println("4- Quit");
        System.out.println("Choose a number : ");
        int entryMenu = sc.nextInt();
        switch(entryMenu) {
            case 1:
                this.Challenger();
                break;
            case 2:
                this.Defense();
                break;
            case 3:
                this.Duel();
                break;
            case 4:
                System.out.println("Bye");
                return;
            default:
                System.out.println("Choose a number between 1 and 4");
        }
    }

    //Make the game in challenge Mode
    private void Challenger(){
        this.createBoard(1);
        this.printBoard();
        System.out.println(" ");
        System.out.println("/////////////////////////////////////");
        this.turnRepeatChallenger();
    }

    //Make the game in Defense mode
    private void Defense(){
        this.createBoard(2);
        this.testDefense();
    }

    // Make the game in Duel mode
    private void Duel(){

    }

    // Create a board with X random number.
    // Or Ask the player to choose a String of numbers for Defense mode
    private void createBoard(int menu) {
        if(menu == 1){
            Random randomGenerator = new Random();
            int tabLength = this.getCombiLength();
            for (int i = 0; i < tabLength; i++) {
                int randomInt = randomGenerator.nextInt(9);
                this.combinaison[i] = randomInt;
            }
        }else if(menu == 2){
            askPlayer();
        }
    }

    // Ask the player his response for cracking the code
    private void askPlayer() {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.print("Proposition : ");
        String choosenNumbers = sc.nextLine();
        this.boardResponse = choosenNumbers.toCharArray();
        for (char num : this.boardResponse) {
            this.boardResponseInt[i] = (num-48);
            i++;
        }
    }

    // Test each values of the board.
    private void printBoard() {
        int tabLength = this.getCombiLength();
        for (int i = 0; i < tabLength; i++) {
            System.out.print(this.combinaison[i]);
        }
    }

    // Check if the answer is the same as the code.
    private void testAnswer() {
        System.out.print("Response : ");
        int tabLength = this.getCombiLength();
        for (int i = 0; i < tabLength; i++) {
            if (this.combinaison[i] < this.boardResponseInt[i]) {
                System.out.print("-");
            } else if (this.combinaison[i] > this.boardResponseInt[i]) {
                System.out.print("+");
            } else if (this.combinaison[i] == this.boardResponseInt[i]) {
                System.out.print("=");
                this.remainNumbers -=1;
                if(this.remainNumbers==0){
                    this.isFinish = true;
                    return;
                }
            }
        }
    }
    // Repeat the action asking/responding until player crack the code
    private void turnRepeatChallenger(){
        while(this.remainNumbers !=0){
            this.askPlayer();
            this.testAnswer();
            System.out.println(" ");
            this.remainNumbers = 4;
            if(this.isFinish){
                System.out.println("Congratulation you won !");
                return;
            }
        }
    }
    // Allow the computer to Attack the code.
    private char[] crackTheCode(int cracking[]){
        char code[]={' ',' ',' ',' '};
        for (int i =0; i<this.boardResponseInt.length; i++){
            if(cracking[i]<this.boardResponseInt[i]){
                code[i] = '-';
            }else if(cracking[i]>this.boardResponseInt[i]){
                code[i] = '+';
            }else{
                code[i] = '=';
            }
        }
        return (code);
    }

    private void testDefense(){
        int cracking[] = {5, 5, 5, 5};
        char code [] ={' ',' ',' ',' '};
        int triesLeft = 3;
        while(triesLeft != 0){
            code = this.crackTheCode(cracking);
            if(code[0]=='='&& code[1]=='='&& code[2]=='=' && code[3]=='='){
                System.out.println("I found your code, I've won ");
                return;
            }
            code = this.foundRightNumber(cracking, code);
            System.out.println(code);
            triesLeft -=1;
        }
        System.out.println("I didn't found your code, You've won");



    }
    // AI try to crack the code by implementing his values by 1 and update the + - = response
    private char[] foundRightNumber(int crack[], char code[]){
        if(code[0]=='-'){
            crack[0] += 1;
        }
        if(code[1]=='-'){
            crack[1] += 1;
        }
        if(code[2]=='-'){
            crack[2] += 1;
        }
        if(code[3]=='-'){
            crack[3] += 1;
        }
        if(code[0]=='+'){
            crack[0] -= 1;
        }
        if(code[1]=='+'){
            crack[1] -= 1;
        }
        if(code[2]=='+'){
            crack[2] -= 1;
        }
        if(code[3]=='+'){
            crack[3] -= 1;
        }
        return (code);
    }
}
