package Cipher;

import java.util.Scanner;

class Main{

    public static void main(String[] args) {

        //Create a scanner becasue funny
        Scanner prompt = new Scanner(System.in);
        
        //Loop over again and again so that people can use the tool more than once
        while(true){

            //Prompt the user with the main menu
            System.out.println("Welcome to the Ceasar's Cypher");
            System.out.println("Would you like encrypt (e), decrypt (d), vigenere encrypt (ve), or quit (q)?");

            //Prompt to choose the task.
            String cypherChoice = prompt.nextLine();

            //Cool switch case that abstracts stuff out.
            switch (cypherChoice) {
                case "e":
                    System.out.println("Enter the string you would like to encrypt");
                    String inputString = prompt.nextLine();
                    System.out.println("Next, input a shit number");
                    int inputNum = prompt.nextInt();
                    String output = CaesarCipher.encrypt(inputNum, inputString);
                    System.out.println("Your encrypted string is: " + output);
                    break;
                case "d":
                    System.out.println("Enter the string you would like to decrypt.");
                    inputString = prompt.nextLine();
                    System.out.println("Now, enter the number that it was shifted by.");
                    inputNum = prompt.nextInt();
                    output = CaesarCipher.decrypt(inputNum, inputString);
                    System.out.println("Your string is: " + output);
                    break;
                case "q":
                    prompt.close();
                    System.exit(0);
                case "ve":
                    System.out.println("Enter the string you would like to encrypt");
                    inputString = prompt.nextLine();
                    System.out.println("Next, enter the keyphrase");
                    String keyphrase = prompt.nextLine();
                    output = CaesarCipher.VigenereCipher(inputString, keyphrase);
                    System.out.println("Your encrypted string is: " + output);
                    break;
                default:
                    System.out.println("Invalid input; try again.");
                    break;
            }

        }


    }


}
