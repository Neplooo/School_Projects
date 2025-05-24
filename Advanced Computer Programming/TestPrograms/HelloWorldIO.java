/* 
TITLE: HelloWorldIO
AUTHOR/PROGRAMMER: Albert Mathisz
DATE DUE: 2-10-2025
DATE SUBMITTED: 2-10-25
COURSE TITLE: Advanced Computer Programming
MEETING TIME(S): MWF 9-10AM
DESCRIPTION: This code outputs your name to the terminal after prompting you for it.
HONOR CODE: Albert Mathisz
HOWTO: Load it into your favorite IDE and run it.
INPUT FILE: N/A
OUTPUT FILE: N/A
BIBLIOGRAPHY: N/A
RESOURCES: N/A
TUTORS: N/A
COMMENTS: V1.1
*/

import java.util.Scanner;

/**
 * Says hello to a user.
 */
public class HelloWorldIO {
    
    //PublicVoidMain
    public static void main(String[] args) {
        
        //Create a scanner to look for an input.
        Scanner myScanner = new Scanner(System.in);

        //Ask for a name through a prompt
        System.out.print("Please, input your name: ");

        //Create an input for a name
        String name = myScanner.nextLine();

        //Output the variable because submitty
        System.out.println(name);

        //Output the name
        System.out.println("Hello, " + name + "!");

        //Close the scanner because I have to be nice to it.
        myScanner.close();

    }

}
