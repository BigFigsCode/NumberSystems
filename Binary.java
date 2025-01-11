import java.io.*;
import java.util.Scanner;
/**
 * <h2>Binary.java - Create a Binary class that will take in users input and convert it to decimal and hexadecimal.</h2> 
 * <p>Algorithm:</p>
 * <ol>
 *   <li>Instantiate the PrintWriter object and a Scanner object.</li>
 *   <li>Set all class variables to private so that no one has direct access to them.</li>
 *   <li>Make sure that in the output of the hexadecimal number has 8 bit leading 0s.</li>
 *   <li>Use the decToBin() and decToHex() methods to call the methods that contain the input, conversion and output.</li>
 *   
 * </ol>
 * @author Brandon Figueroa
 * 
 */
public class Binary
{
    private PrintWriter pw;
    private StringBuilder hex;
    private String bin;
    private double decimal;
    /**
     * Single arg constructor
     * @param pw is the variable for the PrintWriter object to write to file
     */
    public Binary(PrintWriter pw){
        this.pw = pw;
        bin = "";
        decimal = 0;
    }
    /**
     * Method binToDec() calls the inputBin(), toDec() and outDec() methods
     */
    public void binToDec(){
        inputBin();
        toDec();
        outDec();
    }
    /**
     * Method inputBin() takes in user input as a String for a binary number
     * 
     */
    private void inputBin(){
        Scanner user = new Scanner(System.in);
        System.out.println("Enter a Binary number: ");
        bin = user.nextLine();
        this.pw.println("Enter a Binary number: ");
    }
    /**
     * Method toDec() converts the users input, binary, to a decimal number
     * int newBin gets the length of the users binary input
     * String temp gets the users input, bin
     * double decimal get intialized to zero
     */
    private void toDec(){
        //converts binary to decimal
        int newBin = bin.length();
        String temp = bin;//temp gets users input
        decimal = 0;//type double
        for(int i = 0; i < temp.length(); i++){
            //decimal = decValues[bin.charAt(i)] + decimal;
            char binChar = temp.charAt(newBin - i - 1);
            if(binChar >= '0' && binChar <= '1'){
                decimal = (Math.pow(2, i) * (binChar - 48)) + decimal;
            }else{
                System.out.println("Error!");
            }
            
        }
        
        
        
    }
    /**
     * Method outDec() displays the user original input and converted input 
     */
    private void outDec(){
        System.out.println("The binary number " + bin + " converts to " + (int)decimal + " in decimal form.");
        //prints to file
        this.pw.println("The binary number " + bin + " converts to " + (int)decimal + " in decimal form.");
    }
    /**
     * Method binToHex calls inputBin(), toHex() and outHex() methods
     */
    public void binToHex(){
        inputBin();
        toHex();
        outHex();
    }
    /**
     * Method toHex() converts the users binary number input to hexadecimal form
     * hex is the variable for the string builder which is set to a default of 8-bits
     * Stringbuilder is used to set the character the user inputs length to a new character
     */
    private void toHex(){
        hex = new StringBuilder("00000000");
        for(int i = 0, j = 0; i < bin.length();i = i + 4, j++){
            
                String temp = bin.substring(i, i + 4);
                if(temp.equals("0000")){
                    hex.setCharAt(j, '0');
                }else if(temp.equals("0001")){
                    hex.setCharAt(j, '1');
                }else if(temp.equals("0010")){
                    hex.setCharAt(j, '2');
                }else if(temp.equals("0011")){
                    hex.setCharAt(j, '3');
                }else if(temp.equals("0100")){
                    hex.setCharAt(j, '4');
                }else if(temp.equals("0101")){
                    hex.setCharAt(j, '5');
                }else if(temp.equals("0110")){
                    hex.setCharAt(j, '6');
                }else if(temp.equals("0111")){
                    hex.setCharAt(j, '7');
                }else if(temp.equals("1000")){
                    hex.setCharAt(j, '8');
                }else if(temp.equals("1001")){
                    hex.setCharAt(j, '9');
                }else if(temp.equals("1010")){
                    hex.setCharAt(j, 'A');
                }else if(temp.equals("0011")){
                    hex.setCharAt(j, 'B');
                }else if(temp.equals("1100")){
                    hex.setCharAt(j, 'C');
                }else if(temp.equals("1101")){
                    hex.setCharAt(j, 'D');
                }else if(temp.equals("1110")){
                    hex.setCharAt(j, 'E');
                }else if(temp.equals("1111")){
                    hex.setCharAt(j, 'F');
                }
            
        }
    }
    /**
     * Method outHex() displays the users original input and the conversion for it
     */
    private void outHex(){
        System.out.println("The binary number " + bin + " converts to 0x" + hex.toString() + " in hexadecimal form.");
        this.pw.println("The binary number " + bin + " converts to 0x" + hex.toString() + " in hexadecimal form.");
    }
}










