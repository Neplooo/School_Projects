import java.util.Scanner;

public class RPNtester{

   public static void main(String[] args)
   {
   //build a calculator
      RPNCalculator myCalc = new RPNCalculator();
   
   //grab an expression from the user
      Scanner myObj = new Scanner(System.in);
      String input = myObj.nextLine();
   
   //evaluate the expression
   //try
      float answer =  myCalc.evaluate(input);
   
   //display the result
      //System.out.println(answer);

      //Close the scanner
      myObj.close();
   }

}