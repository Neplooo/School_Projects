/**
 * Part 2 class. Contains various mathematical functions.
 * @author Albert Mathisz
 */
public class Part2 {
    
    public static int add(int a, int b){
        return a + b;
    }

    public static int sub(int a, int b){
        return a - b;
    }

    public static int mult(int a, int b){
        return a * b;
    }

    public static int intDiv(int a, int b){
        return a / b;
    }

    /**
     * Return a solution to a quadratic with coefficients a, b, c
     * @param a Squared term in the polynomial
     * @param b 1st order term in the polynomial
     * @param c Constant in the polynomial
     * @param isPositive Boolean representing if you want the positive or negative answer to the problem.
     * @return One of the roots to the quadratic
     */
    public static double quadratic(int a, int b, int c, boolean isPositive){

        double solution;

        if(isPositive){
            solution = (-b + Math.sqrt((b*b) - 4*a*c)) / (2*a);
        }else{
            solution = (-b - Math.sqrt((b*b) - 4*a*c)) / (2*a);
        }

        return solution;

    }


}
