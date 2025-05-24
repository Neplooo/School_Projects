import java.util.Scanner;

public class Part2 {

    /**
     * Gets the average of the array by adding all of it's elements together
     * and dividing it by the length of the array.
     * @param array The array you want to get the average of.
     * @return a double representing the average.
     */
    public static double getAvgOfArray(int[] array){

        double returnVal = 0.0;

        for (int i : array) {
            returnVal += i;
        }

        returnVal = returnVal / array.length;

        return returnVal;

    }
    
    public static void main(String[] args) {
        
        //Open a scanner to ask questions
        Scanner asker = new Scanner(System.in);
        int listSize;

        //Get the list size
        System.out.println("How many grades do you have");
        listSize = asker.nextInt();
        System.out.println(listSize);

        //Create the list.
        int[] grades = new int[listSize];

        //Keep asking for scores.
        for(int i = 0; i < listSize; i++){
            System.out.println("Enter integer score");
            grades[i] = asker.nextInt();
            System.out.println(grades[i]);
        }

        //Print out the averge.
        System.out.println("Your average is: " + getAvgOfArray(grades));

        asker.close();


    }

}
