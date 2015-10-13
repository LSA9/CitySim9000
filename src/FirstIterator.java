import java.util.*;

public class FirstIterator {
	
	public FirstIterator(){ 
	}
	
    public String getStartingLocation(Location location, Random rand){
        int locationNumber;
        String s=null;
        locationNumber = rand.nextInt(4);
        
        //Setting the initial location of the car by its English
        //name rather than its numerical representation
        if(locationNumber==0){
        	location.setLocationName("Mall");
        	s = "Mall";
        }
        else if(locationNumber==1){
        	location.setLocationName("Bookstore");
        	s = "Bookstore";
        }
        else if(locationNumber==2){
        	location.setLocationName("Coffee Shop");
        	s = "Coffee Shop";
        }
        else if(locationNumber==3){
        	location.setLocationName("University");
        	s = "University";
        }
        
        return s;
    }

}
