import java.io.*;
import java.util.Scanner;
/**
 * <h2>Menu.java - Create a menu so that the user can choose what conversion they want.</h2> 
 * <p>Algorithm:</p>
 * <ol>
 *   <li>Create a PrintWriter object and pass it to a single arg constructor.</li>
 *   <li>Prompt the user for a number based on the menu displayed.</li>
 *   <li>Create a display method showing the selection the user can make.</li>
 *   <li>Create a get selection method that will return the user input.</li>
 *
 * </ol>
 * @author Brandon Figueroa
 * 
 */
public class Menu
{
    private PrintWriter pw;
    private int userNum;
    /**
     * Single arg constructor
     * @param pw is the variable for the PrintWriter object
     */
    public Menu(PrintWriter pw){
        this.pw = pw;
        userNum = 0;
    }
    /**
     * Method display() displays the menu for the 6 different conversions
     */
    public void display(){
        System.out.println("Please choose which conversion you want.");
        System.out.println("1. Decimal to Binary");
        System.out.println("2. Decimal to Hexadecimal");
        System.out.println("3. Binary to Decimal");
        System.out.println("4. Binary to Hexadecimal");
        System.out.println("5. Hexadecimal to Decimal");
        System.out.println("6. Hexadecimal to Binary");
        //Prints to file
        this.pw.println("Please choose which conversion you want.");
        this.pw.println("1. Decimal to Binary");
        this.pw.println("2. Decimal to Hexadecimal");
        this.pw.println("3. Binary to Decimal");
        this.pw.println("4. Binary to Hexadecimal");
        this.pw.println("5. Hexadecimal to Decimal");
        this.pw.println("6. Hexadecimal to Binary");
    }
    /**
     * Methods getSelection() gets the users input based of the display() method
     * @return userNum is the number the user has entered
     */
    public int getSelection(){
        Scanner user = new Scanner(System.in);
        userNum = user.nextInt();
        return userNum;
        
    }
}
