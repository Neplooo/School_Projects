/**
 * Part 3 class. Contains various mathematical sequences.
 * @author Albert Mathisz
 */
public class Part3 {
    
    /**
     * Returns the factorial of num n
     * @param n the number you would like to get factorial of.
     * @return Solved factorial.
     */
    public static int factorial(int n){

        int outval = 1;

        for(int i = 2; i <= n; i++){
            outval = outval * i;
        }

        return outval;

    }

    /**
     * Returns the fibbonacci sequence of number n
     * @param n The number you would like to find the fibbonacci sequence of.
     * @return The value.
     */
    public static int fib(int n){
     
        int returnVal;
        if(n == 0){
            returnVal = 0;
        }else if(n == 1){
            returnVal = 1; //Base Case
        } else {
            returnVal = fib(n - 2) + fib(n - 1); //Recursion
        }

        return returnVal;

    }

    /**
     * Solves the fibbonacci sequence without recursion.
     * @param n The index of the sequence.
     * @return The number
     */
    public static int fibFast(int n){

        int[] sequence = new int[n + 1];

        for(int i = 0; i <= n; i++){
            if(i == 0){
                sequence[i] = 0;
            }else if(i == 1){
                sequence[i] = 1;
            }else{
                sequence[i] = sequence[i - 2] + sequence[i - 1];
            }
        }

        return sequence[n];

    }


    // public static void main(String[] args) {

    //     for(int i = 0; i <= 29; i++){
    //         //System.out.println(fib(i));
    //         System.out.println(fibFast(i));
    //     }
    // }

}
