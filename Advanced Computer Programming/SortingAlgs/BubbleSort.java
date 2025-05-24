import java.util.Arrays;

public class BubbleSort{

    /**
     * Bubble Sort: Sorts an array by moving each largest index to the end of the array untill it moves all
     * of them. O(n^2)
     * @param array The array you want to sort.
     * @return The sorted array.
     */
    public static int[] sort(int[] array){

        int maxElement = array.length;

        for(int i = 0; i < maxElement; i++){
            for(int j = 0; j < maxElement - i; j++){ //This code is O(n^2) because it runs all the way through
                if(j == maxElement - 1){             //both for loops!
                    break; //Base case to break out of loop.
                }else if(array[j] > array[j+1]){ //If the index is bigger than the next one...
                    int tempIndex = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempIndex; //Swap the values.
                }
            }
        }

        return array;

    }


    public static void main(String[] args) {
        
        int[] numArray = {31, 26, 42, 18, 63, 2, 54, 28};

        System.out.println(Arrays.toString(sort(numArray)));

    }

}