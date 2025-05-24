import java.util.ArrayList;

public class Part1{

    /**
     * Creates an array with the specified size.
     * @param size the size of the array
     * @return an empty array of size s
     */
    public static int[] createArray(int size){
        return new int[size];
    }

    /**
     * Creates an empty ArrayList
     * @return ArrayList
     */
    public static ArrayList<Integer> createArrayList(){
        return new ArrayList<Integer>();
    }

    /**
     * Deploys a simple linear search algorithm to find a number
     * in an array.
     * @param array The array being searched
     * @param num The number being searched for
     * @return The index of the number of -1 if the number is not found.
     */
    public static int findInArray(int[] array, int num){

        int returnVal = -1;
        int counter = 0;

        while(counter < array.length){
            if(array[counter] == num){
                returnVal = counter;
                break;
            }

            counter++;
        }

        return returnVal;

    }

    /**
     * Deploys a simple linear search to find a value in
     * an ArrayList.
     * @param arrayList The Arraylist being searched.
     * @param num The number being searched for.
     * @return The index of the number or -1 if it's not found.
     */
    public static int findInArrayList(ArrayList<Integer> arrayList, int num){

        int returnVal = -1;
        int counter = 0;

        while(counter < arrayList.size()){
            if(arrayList.get(counter) == num){
                returnVal = counter;
                break;
            }
            counter++;
        }

        return returnVal;

    }

    /**
     * Gets the size of an array.
     * @param array The array specifed.
     * @return The size of the specified array.
     */
    public static int getSizeOfArray(int[] array){
        return array.length;
    }

    /**
     * Gets the size of an ArrayList
     * @param arrayList The arraylist specifed.
     * @return The size of the arraylist.
     */
    public static int getSizeOfArrayList(ArrayList<Integer> arrayList){
        return arrayList.size();
    }

    /**
     * Prints the array in human readable formatting.
     * @param array The specified array.
     */
    public static void printArray(int[] array){

        for (int i : array) {
            System.out.print(i + " ");
        }

        System.out.println(" ");

    }

    /**
     * Prints the ArrayList in a human readable format.
     * @param arrayList The ArrayList specified.
     */
    public static void printAL(ArrayList<Integer> arrayList){

        arrayList.forEach(age -> {
            System.out.print(age + " ");
        });

        System.out.println("");

    }


    // public static void main(String[] args) {
        
    //     int[] testEmptyArr = new int[0];
    //     int[] testArray = {2, 5, 8, 10, 16, 24, 48};
    //     ArrayList<Integer> testAL = new ArrayList();

    //     for (int i : testArray) {
    //         testAL.add(i);
    //     }

    //     System.out.println(findInArray(testArray, 24));
    //     System.out.println(findInArray(testEmptyArr, 24));
    //     System.out.println(findInArrayList(testAL, 24));

    //     printArray(testArray);
    //     printAL(testAL);

    // }


}