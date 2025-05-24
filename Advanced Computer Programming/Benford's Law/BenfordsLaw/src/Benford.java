import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Benford Class: Does all kinds of things to numbers to detect patterns.
 * @author Albert Mathisz
 */
public class Benford {

    private String pathToFile; //The data's file path
    private int[] dataArray = new int[100]; //the array containing the numbers to be analyzed
    private int dataArrayLength = 0; // Dynamic length of data array
    private int[] tally = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //Count of the numbers in certain locations

    /**
     * This constructor makes intializes the dataset.
     * @param path Path to the dataset
     * @throws IOException Not sure what this means
     */
    public Benford(String path) throws IOException{
        pathToFile = path;

        Scanner file = new Scanner(new File(pathToFile)); // place the data text file "numbers.txt" in the root level of your workspace

        
        while (file.hasNext()){
            int num = file.nextInt();
            file.nextLine(); 
            dataArray[dataArrayLength] = num;
            dataArrayLength++;
        }
        file.close();

        System.out.println(Arrays.toString(dataArray));
        
    }

    /**
     * The amount of digits in a number
     * @param num Number to be analyzed
     * @return The amount of digits.
     */
    public int getDigits(int num){

        int digitCounter = 0;

        while (num > 0) {
            num = num / 10;
            digitCounter++;
        }     

        return digitCounter;

    }

    /**
     * Returns the data array
     * @return Data Array
     */
    public int[] getDataArray(){
        return dataArray;
    }

    /**
     * Reads the numbers in a data file and puts it into an array.
     * @param path Path to the data file
     * @return data array
     * @throws IOException
     */
    public int[] readMysteriousNumbers(String path) throws IOException{

        pathToFile = path;

        Scanner file = new Scanner(new File(pathToFile)); // place the data text file "numbers.txt" in the root level of your workspace

        
        while (file.hasNext()){
            while (file.hasNextInt()) {
                int num = file.nextInt();
            file.nextLine(); 
            dataArray[dataArrayLength] = num;
            dataArrayLength++;
            }
        }
        file.close();

        return dataArray;
    
    }

    /**
     * Finds the nth digit from the right of the number
     * @param n How far from the right of the number it should look for.
     * @param num The number being searched
     * @return The digit that is found.
     */
    public int nthDigitBack(int n, int num){

        int returnDigit = 0;

        returnDigit = (int) (num / Math.pow(10, n));

        returnDigit = (int) (returnDigit % 10);

        return returnDigit;

    }

    /**
     * Finds the nth digit from the left of the number
     * @param n How far from the left of the number it should look for.
     * @param num The number being searched
     * @return The digit that is found.
     */
    public int nthDigit(int n, int num){

        int digits = getDigits(num);
        int index = (digits - n) - 1;

        return nthDigitBack(index, num);

    }

    /**
     * Adds the nth digit to the default array based off of what value it is (0-9)
     * @param n digit being searched for
     * @param num Number being searched
     * @param tally An array where the tallies are stored
     * @return The tally array
     */
    public int[] nthDigitTally1(int n, int num){

        return nthDigitTally1(n, num, this.tally); //Default case for using the built int tally array.

    }

    /**
     * Adds the nth digit to an array based off of what value it is (0-9)
     * @param n digit being searched for
     * @param num Number being searched
     * @param tally An array where the tallies are stored
     * @return The tally array
     */
    public int[] nthDigitTally1(int n, int num, int[] tally){

        int indexNumber = nthDigit(n, num);
    
        //This switch adds a tally to the counter based off of the digit found in the number
        //being searched.
        switch (indexNumber) {
            case 0:
                tally[0]++;
                break;
            case 1:
                tally[1]++;
                break;
            case 2:
                tally[2]++;
                break;
            case 3:
                tally[3]++;
                break;
            case 4:
                tally[4]++;
                break;
            case 5:
                tally[5]++;
                break;
            case 6:
                tally[6]++;
                break;
            case 7:
                tally[7]++;
                break;
            case 8:
                tally[8]++;
                break;
            case 9:
                tally[9]++;
                break;
            default:
                System.out.println("Error");
                break;
        }

        return tally;

    }

    /**
     * Tallies an array of numbers in the n collumn and adds the results to a tally list.
     * @param n The nth digit back being searched for
     * @param num The array being searched
     * @return The tally array
     */
    public int[] nthDigitTally(int n, int[] num){

        for(int i = 0; i < dataArrayLength; i++){
            nthDigitTally1(n, num[i]);
        }

        return tally;

    }

    public static void main(String[] args) throws IOException{ //Place the data files "numbers.txt in the root level of your program
        
    //Test cases

    Benford data1 = new Benford("other\\numbers.txt");

    System.out.println("The amount of digits in 1234 is: " + data1.getDigits(1234));

    System.out.println("the 2nd number in 1234 is: " + data1.nthDigitBack(2, 1234));

    System.out.println("The 1st digit to the left of 1234 is: " + data1.nthDigit(0, 1234));

    System.out.println("Tally of the 1st number from the left in the data array 1 is: " + Arrays.toString(data1.nthDigitTally(1, data1.getDataArray())));

    }
}
