import java.io.*;
import java.util.Scanner;
/**
 * <h2>Hexadecimal.java - Create a Hexadecimal class that will take in users input and convert it to decimal and binary.</h2> 
 * <p>Algorithm:</p>
 * <ol>
 *   <li>Instantiate the PrintWriter object and a Scanner object.</li>
 *   <li>Set all class variables to private so that no one has direct access to them.</li>
 *   <li>Make sure that in the output methods the binary number will have leading 32 bit 0s.</li>
 *   <li>Use the decToBin() and decToHex() methods to call the methods that contain the input, conversion and output.</li>
 *   
 * </ol>
 * @author Brandon Figueroa
 * 
 */
public class Hexadecimal
{
    //PrintWriter Object
    private PrintWriter pw;
    private String hex, bin;
    private double numTemp;
    /**
     * Single arg constructor
     * @param pw is the variable for the PrintWriter object to write to file
     */
    public Hexadecimal(PrintWriter pw){
        this.pw = pw;
        hex = "";
        bin = "";
        numTemp = 0;
    }
    /**
     * Method hexToDec() calls inputHex(), toDec() and outDec() methods
     */
    public void hexToDec(){
        inputHex();
        toDec();
        outDec();
    }
    /**
     * Method inputHex() Creates a Scanner object to take in user input as a String
     */
    private void inputHex(){
        Scanner user = new Scanner(System.in);
        System.out.println("Enter a Hexadecimal number: ");
        //prints to file
        this.pw.print("Enter a Hexadecimal number: ");
        hex = user.nextLine();
    }
    /**
     * Method toDec() takes user input hexadecimal and converts it to decimal
     * String temp gets the users input hex as a temporary varaible
     * double numTemp is set to zero and used to parse the string into a decimal
     * int length get the temp length of the users input 
     */
    private void toDec(){
        String temp = hex;
        numTemp = 0;
        int length = temp.length();
        
        for(int i = 0; i < temp.length(); i++){
            char hexChar = temp.charAt(length - i - 1);
            if(hexChar >= '0' && hexChar <= '9'){
                 numTemp = (Math.pow(16, i) * (hexChar - '0')) + numTemp;
            }else if(hexChar >= 'A' && hexChar <= 'F'){
                numTemp = (Math.pow(16, i) * (hexChar - 55)) + numTemp;
                
            }else{
                System.out.println("Error!");
            }

        }
    }
    /**
     * Method outDec() displays the users original input and displays its conversion
     */
    private void outDec(){
        System.out.println("You entered " + hex + " which converts to " + (int)numTemp + " in decimal form.");
        //prints to file
        this.pw.println("You entered " + hex + " which converts to " + (int)numTemp + " in decimal form.");
    }
    /**
     * Method hexToBin() calls inputHex(), toBin() and outBin() methods
     */
    public void hexToBin(){
        inputHex();
        toBin();
        outBin();
    }
    /**
     * Method toBin() converts users input hexadecimal to a binary number 
     * String bin gets the users input hex
     * String tempHolder serves as a temporary holder for the switch cases
     * int length gets the varaible bins length
     */
    private void toBin(){
        bin = hex;
        String tempHolder = "";
        int length = bin.length();
        for(int i = 0; i < length; i++){
            char hexBin = bin.charAt(i);
            switch(hexBin){
                case '0': tempHolder = tempHolder + "0000";
                break;
                case '1': tempHolder = tempHolder + "0001";
                break;
                case '2': tempHolder = tempHolder + "0010";
                break;
                case '3': tempHolder = tempHolder + "0011";
                break;
                case '4': tempHolder = tempHolder + "0100";
                break;
                case '5': tempHolder = tempHolder + "0101";
                break;
                case '6': tempHolder = tempHolder + "0110";
                break;
                case '7': tempHolder = tempHolder + "0111";
                break;
                case '8': tempHolder = tempHolder + "1000";
                break;
                case '9': tempHolder = tempHolder + "1001";
                break;
                case 'A': tempHolder = tempHolder + "1010";
                break;
                case 'B': tempHolder = tempHolder + "1011";
                break;
                case 'C': tempHolder = tempHolder + "1100";
                break;
                case 'D': tempHolder = tempHolder + "1101";
                break;
                case 'E': tempHolder = tempHolder + "1110";
                break;
                case 'F': tempHolder = tempHolder + "1111";
                break;
            }
            
        }
        bin = tempHolder;
    }
    /**
     * Method outBin() displays user input hexadecimal and the conversion to binary.
     * int max is the max number of bits
     * int length is the length of the users input after it has been converted
     * String tempStr is a temp string holder
     */
    private void outBin(){
        int max = 32;
        int length = bin.length();
        String tempStr = "";
        if(length < max){
            for(int i = 0; i < max -length; i++){
                tempStr = tempStr + "0";
            }
            bin = tempStr + bin;
        }
        //display of conversion
        System.out.print("The Hexadecimal number " + hex);
        //prints to file
        this.pw.print("The Hexadecimal number " + hex);
        System.out.print(" converts to ");
        //prints to file
        this.pw.print(" converts to ");
        for(int i = 0; i < max;i++){
            System.out.print(bin.charAt(i));
            this.pw.print(bin.charAt(i));
            if(i % 4 == 3){
                System.out.print(' ');
                this.pw.print(' ');
            }
        }
        System.out.println("in Binary form.");
        //prints to file
        this.pw.print(" in Binary form.");
    }
    
}









