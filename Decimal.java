import java.io.*;
import java.util.Scanner;
/**
 * <h2>Decimal.java - Create a Decimal class that will take in users input and convert it to binary and hexadecimal.</h2> 
 * <p>Algorithm:</p>
 * <ol>
 *   <li>Instantiate the PrintWriter object and a Scanner object.</li>
 *   <li>Set all class variables to private so that no one has direct access to them.</li>
 *   <li>Make sure that in the output methods the binary number will have leading 32 bit 0s 
 *       and the hexadecimal number has 8 bit leading 0s.</li>
 *   <li>Use the decToBin() and decToHex() methods to call the methods that contain the input, conversion and output.</li>
 *   
 * </ol>
 * @author Brandon Figueroa
 * 
 */

public class Decimal
{
    //printwriter object
    private PrintWriter pw;
    private int number;
    private String str;
    /**
     * Single arg constructor
     * @param pw is the variable for the PrintWriter object to write to file
     */
    public Decimal(PrintWriter pw){
        this.pw = pw;
        number = 0;
        str = "";
    }

    /**
     * Method decToBin() calls the inputDec(), toBin() and outBin() methods
     */
    public void decToBin(){
        //call all of the methods that make up the conversion decToBin
        inputDec();
        toBin();
        outBin();
    }

    /**
     * Method inputDec() creates a scanner object to take in user input as a integer
     */
    private void inputDec(){
        //user input
        Scanner user = new Scanner(System.in);
        System.out.println("Enter a Decimal(whole) number: ");
        number = user.nextInt();
        this.pw.println("Enter a Decimal(whole) number: ");//prints to file
    }

    /**
     * Method toBin() converts the users integer to a binary number.
     * int binValues[] is an array that has two element starting with the number 0 and ending with 1
     * int remainder holds the value of the modulus value
     * int temp gets the user input, number
     */
    private void toBin(){
        int binValues[] = {0,1};
        int remainder = 0;
        int temp = number;//temp get users input
        str = "";
        //conversion of users input
        while(temp > 0){
            remainder = temp % 2;
            str = binValues[remainder] + str;//remainder iterates throught the array searching fo the correct values
            temp = temp / 2;

        }

    }

    /**
     * Method outBin() prints the conversion based on the users input with 32 bits and spaces
     * int max is the max number of bits
     * int length is the lenght of the conversion after the users input
     * String tempStr is a temp string holder
     */
    private void outBin(){
        int max = 32;
        int length = str.length();
        String tempStr = "";
        if(length < max){
            for(int i = 0; i < max -length; i++){
                tempStr = tempStr + "0";
            }
            str = tempStr + str;
        }
        //display of conversion
        System.out.print("The decimal number " + number);
        this.pw.print("The decimal number " + number);//prints to file
        System.out.print(" converts to ");
        this.pw.print(" converts to ");//prints to file
        for(int i = 0; i < max;i++){
            System.out.print(str.charAt(i));
            this.pw.print(str.charAt(i));//prints to file
            if(i % 4 == 3){
                System.out.print(' ');
                this.pw.print(' ');//prints to file
            }
        }
        System.out.println(" in Binary form.");
        this.pw.println(" in Binary form.");//prints to file

    }

    /**
     * Method decToHex() calls 3 methods inputDec(), toHex() and outHex()
     */
    public void decToHex(){
        //call all of the methods that make up the conversion decToHex
        inputDec();
        toHex();
        outHex();
    }

    /**
     * Method toHex() converts the users inputted integer to hexadecimal form
     * char values is and array that holds the characters that are presented in hexadecimal form
     * int remainder holds the remainder of the user input after the modulus has be performed
     * int temp gets the users input
     * String str gets an empty string so that it is reset
     */
    private void toHex(){
        char values[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int remainder = 0;
        int temp = number;
        str = "";
        while(temp > 0){
            remainder = temp % 16;
            str = values[remainder] + str;
            temp = temp / 16;
        }
    }

    /**
     * Method outHex() prints out all the original value that user input and the converted value
     * int max is the max number of bits
     * int length is the length of the users input after it has been converted
     * String tempStr is a temp string holder
     */
    private void outHex(){
        int max = 8;
        int length = str.length();
        String tempStr = "";
        if(length < max){
            for(int i = 0; i < max -length; i++){
                tempStr = tempStr + "0";
            }
            str = tempStr + str;
        }
        //display of conversion
        System.out.print("The decimal number " + number);
        this.pw.print("The decimal number " + number);//prints to file
        System.out.print(" converts to 0x");
        this.pw.print(" converts to 0x");//prints to file
        for(int i = 0; i < max;i++){
            System.out.print(str.charAt(i));
            this.pw.print(str.charAt(i));//prints to file
            if(i % 8 == 7){
                System.out.print(' ');
                this.pw.print(' ');//prints to file
            }
        }
        System.out.println(" in Hexadecimal form.");
        this.pw.println(" in Hexadecimal form.");//prints to file

    }
}
