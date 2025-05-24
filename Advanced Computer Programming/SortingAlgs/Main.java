/**
 * Who up sortin it rn
 * @author Alberto
 */
public class Main {
   
    /**
     * Bubble Sort: Algorithm to sort a list in O(n^2) time by
     * bubbling the smallest values to the front of the list.
     */
    public static void bubbleSort(int[] array){
        int maxElement = array.length;

        for(int i = 0; i < maxElement; i++){
            for(int j = 0; j < maxElement - i; j++){ //This code is O(n^2) because it runs all the way through
                if(j == maxElement - 1){             //both for loops!
                    break; //Base case to break out of loop.
                }else if(array[j] > array[j+1]){ //If the index is bigger than the next one...
                    swap(array, j, j+1);
                }
            }
        }

        //System.out.println(Arrays.toString(array));

    }

    /**
     * Insertion Sort: Sorting algorithm that sorts an array in O(n^2) time by 
     * iterating through the list, and inserting the value where it belongs.
     * @param array The array to be sorted.
     */
    public static void insertionsort(int[] array){
        
        int len = array.length;

        for(int i = 1; i < len; ++i){

            int j = i - 1;
            int key = array[i]; //THE KEY NEEDS TO BE DECLARED HERE FOR THE SORT TO WORK!!!

            while(j >= 0 && array[j] > key){
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

        //System.out.println(Arrays.toString(array));

    }

    /**
     * Selection Sort: An algorithm that sort an array in O(n^2) time
     * by swapping the smaller values to the front of the list with their
     * larger counterparts.
     * @param array Array to be sorted.
     */
    public static void selectionsort(int[] array){

        int minIndex = 0;


        for(int i = 0; i < array.length; i++){

            minIndex = i;

            for(int j = i + 1; j < array.length; j++){
                
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
                
            }

            swap(array, minIndex, i);

            // int temp = array[i];
            // array[i] = array[minIndex];
            // array[minIndex] = temp;

        }

        //System.out.println(Arrays.toString(array));
        
    }

    /**
     * Helper function that merges two arrays together by order.
     * @param array Main array
     * @param start The start of the array
     * @param t1 The first sub array to be sorted
     * @param t2 The second sub array to be sorted
     */
    private static void merge(int[] array, int start, int[] t1, int[] t2){

        int index = start;
        int end = start + t1.length + t2.length;
        int t1index = 0;
        int t2index = 0;


        while(t1index < t1.length && t2index < t2.length){
            if(t1[t1index] <= t2[t2index]){
                array[index++] = t1[t1index++];
            }else{
                array[index++] = t2[t2index++];
            }
        }

        while(t1index < t1.length){
            array[index++] = t1[t1index++];
        }

        while(t2index < t2.length){
            array[index++] = t2[t2index++];
        }

    }

    /**
     * Merge Sort: Sorts an array in O(nlogn) time by spliting the
     * array into sub-arrays and merging them together.
     * @param array Array to be sorted
     */
    public static void mergesort(int[] array){

        if(array.length > 1){
            mergesort(array, 0, array.length);
        }

    }

    /**
     * Merge Sort: Sorts an array in O(nlogn) time by spliting the
     * array into sub-arrays and merging them together.
     * @param array Array to be sorted
     * @param start Array start
     * @param segLength Desired length of subarrays
     */
    private static void mergesort(int[] array, int start, int segLength){

        int half = segLength / 2;

        if(half > 1){
            mergesort(array, start, half);
        }
        if(segLength - half > 1){
            mergesort(array, start + half, segLength - half);
        }

        
        int[] tempArray = new int[half];
        int[] tempArray2 = new int[segLength - half];
        int i = start;

        for(int j = 0; j < half;){
            tempArray[j++] = array[i++];
        }
        for(int j = 0; j < segLength - half;){
            tempArray2[j++] = array[i++];
        }

        merge(array, start, tempArray, tempArray2);

        //System.out.println(Arrays.toString(array));

    }

    /**
     * Quicksort: Sorting Algorithm that sorts an array in O(nlogn) time by
     * swapping all of the numbers around a selected pivot
     * @param array Array to be sorted
     */
    public static void quicksort(int[] array){
        quicksort(array, 0, array.length - 1);
    }

    /**
     * Private helper function to partition numbers around a pivot.
     * @param array Array provided
     * @param low Low index
     * @param high High Index
     * @return Partitioned array
     */
    private static int partition(int[] array, int low, int high){

        int pivot = array[high];

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);  
        return i + 1;

    }

    /**
     * Quicksort: Sorting Algorithm that sorts an array in O(nlogn) time by
     * swapping all of the numbers around a selected pivot
     * @param array Array to be sorted
     * @param low Low index
     * @param high High Index
     */
    private static void quicksort(int[] array, int low, int high){
        if(low < high){
            int partitionIndex = partition(array, low, high);

            quicksort(array, low, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, high);
        }

        //System.out.println(Arrays.toString(array));
    }


    /**
     * Function that swaps two indecies in an array.
     * @param array The are you are operating on.
     * @param i The first index you want to swap.
     * @param j The second index you want to swap.
     * @return The new array.
     */
    private static int[] swap(int[] array, int i, int j){
        int tempIndex = array[i]; //Save the i index.
        array[i] = array[j]; //Set i to j
        array[j] = tempIndex; //Set j to the saved index.

        return array;
    }


    //public static void main(String[] args) {
        
         //int[] array = {9, 36, 27, 16, 42, 8, 74, 56, 25, 4, 41};

    //     //mergesort(array);

    //     //bubblesort(array);

        //insertionsort(array);

    //     //selectionsort(array);

    //     quicksort(array);


    //}

}
