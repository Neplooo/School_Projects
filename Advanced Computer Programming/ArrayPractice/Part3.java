import java.util.Scanner;

public class Part3 {


    public static void main(String[] args) {
        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        int fourCount = 0;
        int fiveCount = 0;
        int sixCount = 0;
        int sevenCount = 0;
        int eightCount = 0;
        int nineCount = 0;
        int randCount76 = 0;
        int randCount45 = 0;
        int randCount54 = 0;

        Scanner asker = new Scanner(System.in);
        int currNum = 0;

        //Take new integers while the current number is not -1
        while(currNum != -1){
            System.out.print("Enter an positive integer, -1 will stop:");
            currNum = asker.nextInt();
            System.out.println(currNum);
            switch (currNum) {
                case 1:
                    oneCount++;
                    break;
                case 2:
                    twoCount++;
                    break;
                case 3:
                    threeCount++;
                    break;
                case 4:
                    fourCount++;
                    break;
                case 5:
                    fiveCount++;
                    break;
                case 6:
                    sixCount++;
                    break;
                case 7:
                    sevenCount++;
                    break;
                case 8:
                    eightCount++;
                    break;
                case 9:
                    nineCount++;
                    break;
                default:
                    if(currNum == 76){
                        randCount76++;
                    }else if(currNum == 45){
                        randCount45++;
                    }else if(currNum == 54){
                        randCount54++;
                    }
                    break;
            }
        }


        //Print out the results.
        System.out.print("Number: 1, ");
        System.out.println("Count: " + oneCount);

        System.out.print("Number: 2, ");
        System.out.println("Count: " + twoCount);

        System.out.print("Number: 3, ");
        System.out.println("Count: " + threeCount);

        System.out.print("Number: 4, ");
        System.out.println("Count: " + fourCount);

        System.out.print("Number: 5, ");
        System.out.println("Count: " + fiveCount);

        System.out.print("Number: 6, ");
        System.out.println("Count: " + sixCount);

        System.out.print("Number: 7, ");
        System.out.println("Count: " + sevenCount);

        System.out.print("Number: 8, ");
        System.out.println("Count: " + eightCount);

        System.out.print("Number: 9, ");
        System.out.println("Count: " + nineCount);

        if(randCount45 != 0){
            System.out.print("Number: 45, ");
            System.out.println("Count: " + randCount45);
        }

        if(randCount54 != 0){
            System.out.print("Number: 54, ");
            System.out.println("Count: " + randCount54);
        }

        if(randCount76 != 0){
            System.out.print("Number: 76, ");
            System.out.println("Count: " + randCount76);
        }

        asker.close();

    }
    
    



}
