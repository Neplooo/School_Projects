package Cipher;

/**
 * Class that contains the functions to use the Caesar's Cipher
 * @author Alberto
 */
public class CaesarCipher {

    /**
     * Encrypts a string of text
     * @param shift The amount of times you want the cipher to shift the letter.
     * @param input The input string being passed
     * @return The encrypted String
     */
    public static String encrypt(int shift, String input){

        //Temporary Variables for the alphabet and the final string
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String newString = "";

        //Gets the length of the input
        int stringLength = input.length();

        //Repeat the following code for all letters in the alphabet.
        for(int i = 0; i < stringLength; i++){

            //Get the letter, turn it to lowercase, and figure out where it is in the alphabet.
            String letter = input.substring(i, i+1);
            String lowCaseLetter = letter.toLowerCase();
            int alphPos = alphabet.indexOf(lowCaseLetter);
            String newLetter;

            //If the object is a space, ignore it.
            if(letter.equals(" ")){
                //System.out.println("Space Detected!");
                continue;
            }
            //Main code for sifting.
            else{

               
                int shiftIndex = (alphPos + shift);
                //System.out.println(shiftIndex);
                while(shiftIndex >= 25){
                    //System.out.println(shiftIndex);
                    shiftIndex = 0 + (shiftIndex - 25);
                }
                newLetter = alphabet.substring(shiftIndex, shiftIndex + 1);

            }

            newString += newLetter;

        }

        return newString;

    }

    /**
     * Function that decrypts a string
     * @param shift The shift that the string was originally shifted by.
     * @param input The encrypted string.
     * @return The decrypted string.
     */
    public static String decrypt(int shift, String input){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String newString = "";

        int stringLength = input.length();

        for(int i = 0; i < stringLength; i++){

            String letter = input.substring(i, i+1);
            String lowCaseLetter = letter.toLowerCase();
            int alphPos = alphabet.indexOf(lowCaseLetter);
            String newLetter;
            int shiftIndex = (alphPos - shift);
            while (shiftIndex < 0) {
                shiftIndex = 25 + shiftIndex;
            }
            //System.out.println(shiftIndex);
            newLetter = alphabet.substring(shiftIndex, shiftIndex + 1);
            //System.out.println(alphPos);
            

            newString += newLetter;

        }

        return newString;


    }

    /**
     * Function that encrypts a string using the Vigenere Algorithm
     * @param input The string you want to encrypt.
     * @param keyphrase The keyphrase that the algorithm will iterate through.
     * @return The Encrypted String
     */
    public static String VigenereCipher(String input, String keyphrase){

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String newString = "";

        int inputLength = input.length();
        int keyLenght = keyphrase.length();

        
        for(int i=0; i < inputLength; i++){

            //Create the variables for the input letter and key letter.
            String inputLetter = "";
            String keyLetter = "";

            //If the index being looked for is greater than the length of thhe word, continue.
            if(i >= keyLenght){

                //Create a temporary variable
                int x = i;

                //Enter this loop to loop over the word instead of getting an out bounds error.
                while(x >= keyLenght){
                    //System.out.println("Loop Entered!");
                    x = x - keyLenght;
                    inputLetter = input.substring(i, i+1);
                    keyLetter = keyphrase.substring(x, x + 1);
                }
                
            //If the sting is normal, get a letter from it and the keyphrase string.
            }else{
                inputLetter = input.substring(i, i+1);
                keyLetter = keyphrase.substring(i, i+1);
            }

            
            //System.out.println(keyRelPos);
            //System.out.println(keyLetter);

            //Create variables to keep track of the letters in relation to the alphabet.
            int inputPos = alphabet.indexOf(inputLetter);
            int keyPos = alphabet.indexOf(keyLetter);

            //Get the desired shift position.
            int shiftPos = inputPos + keyPos;

            //Create the string that will hold the new letter.
            String newLetter;

            //If the object is a space, ignore it.
            if(inputLetter.equals(" ")){
                //System.out.println("Space Detected!");
                continue;
            }

            //Zero the Cipher if the index of the letter in relation to the alphabet is larger than the length
            //of the alphabet.
            while(shiftPos >= 25){
                shiftPos = shiftPos - 25;
            }

            //Append the letter to the string
            newLetter = alphabet.substring(shiftPos, shiftPos + 1);
            newString += newLetter;

        }

        //Return the string
        return newString;

        

    }



}
