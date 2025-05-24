public class Recursion{

    public static int recursion1(int x){

        int ans = -1;

        if(x > 6){
            ans = recursion1(x - 7) + 3;
        }else if(2 < x && x <= 6){
            ans = recursion1(x - 3) + 1;
        }else{
            ans = x - 2;
        }

        return ans;

    }

    public static int recursion2(int x, int y){

        int returnVal;

        if( x > y ){
            returnVal = recursion2(x-2, y+1) + 3; //Recursion Call
        }else if( x < y ){
            returnVal = recursion2(x+1, y-3) + 2; //Recursion Call
        }else{
            returnVal = 5; //Base Case
        }

        return returnVal;
    }

    public static int fibbonaciRecursion(int a){

        int returnVal;

        if(a == 0 || a == 1){
            returnVal = 1; //Base Case
        } else {
            returnVal = fibbonaciRecursion(a - 1) + fibbonaciRecursion(a-2); //Recursion
        }

        return returnVal;

    }



    public static void main(String[] args) {
        System.out.println(recursion2(10, 5));
    }

}