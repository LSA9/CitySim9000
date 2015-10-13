/**
 * Created by Aronson1 on 10/8/15.
 */
import java.util.*;

public class Car {

    private int carNumber;
    private Location location; 
    private Random rand;
    private StringMaker maker;
    private Mover mover;
    private FirstIterator firstIterator;
    private OutsideCityChecker outsideCityChecker;

    //Car constructors
    public Car(){
    }
    
    public Car(int carNum, Random r){ 
        carNumber = carNum;
        location = new Location();
        rand = r;
        maker = new StringMaker();
        mover = new Mover();
        firstIterator = new FirstIterator();
        outsideCityChecker = new OutsideCityChecker();
   
        firstIterator.getStartingLocation(location,rand);
        moveToNext();
    }
    
    public void moveToNext(){
    	int whereToMove;
    	int firstIteration = 1;
    	String moveInfo;
		
		while(!location.getLocationName().equals("Outside City")){
			whereToMove = determineMove();
			
			mover.moveLocation(location,whereToMove,firstIteration);
			
			maker.toString(carNumber,location);
			outsideCityChecker.checker(maker,carNumber);
			System.out.println(maker.getString());
			
			firstIteration=0;
		}//End While	
    }


    public int determineMove(){
    	int move = rand.nextInt(2);
    	return move;
    }
    


}
