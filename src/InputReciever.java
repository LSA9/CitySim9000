import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReciever {
	
	public InputReciever(){
	}
	
	public int recieveInput(int inputVal){
        Scanner inscan = new Scanner(System.in);
        int scanCheck=0;
       
     if(inputVal>0)
    	 scanCheck=1;
    	        
        return scanCheck;
	}

}
