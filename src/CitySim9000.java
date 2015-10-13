import java.util.InputMismatchException;
import java.util.*;
import java.util.Scanner;

/**
 * Created by Aronson1 on 10/7/15.
 *
 * Location Values:
 * 0 = Outside City
 * 1 = Mall
 * 2 = Bookstore
 * 3 = Coffee
 * 4 = University
 */


public class CitySim9000 {
    public static void main(String[] args){
        int seed=0;
        Random rand;
        InputReciever scanCheck = new InputReciever();
        int inchecker=0;

        System.out.println("Welcome to City Sim 9000!");
        System.out.println("Please enter a valid number");
        
        //reads for input and checks if valid int
        try{
        	seed = Integer.parseInt(args[0]);
        }catch(InputMismatchException exception){
        	System.out.println("Invalid Input!");
        	System.exit(0);
        }
        
        //checks the input to see if it is greater than 0
        inchecker = scanCheck.recieveInput(seed);
        if(inchecker==0){
        	System.out.println("Invalid Input!");
        	System.exit(0);
        }
        	
 
        
        rand = new Random(seed);
        for(int carNumber=0; carNumber<4;carNumber++) {
            Car currentCar = new Car(carNumber,rand);
            System.out.println("-----");
        }
        System.out.println("End of Program");
    }
}
