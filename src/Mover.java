
public class Mover {

	public Mover(){
	}
	
	public String moveLocation(Location location, int whereToMove, int firstIteration){
		String s="";
		if(location.getLocationName().equals("Mall")){
			location.setPastLocation("Mall");
			if(whereToMove==0){
				location.setLocationName("Bookstore");
				s = "Bookstore";
				location.setHowGotThere("Fourth Ave.");
			}
			else{
				location.setLocationName("Coffee Shop");
				s = "Coffee Shop";
				location.setHowGotThere("Meow Street");
			}
		}
		else if(location.getLocationName().equals("Bookstore")){
			location.setPastLocation("Bookstore");
			if(whereToMove==0 && firstIteration==0){
				location.setLocationName("Outside City");
				s = "Outside City";
				location.setHowGotThere("Fourth Ave.");
			}
			else{
				location.setLocationName("University");
				s = "University";
				location.setHowGotThere("Chirp St.");
			}
		}
		else if(location.getLocationName().equals("University")){
			location.setPastLocation("University");
			if(whereToMove==0){
				location.setLocationName("Coffee Shop");
				s = "Coffee Shop";
				location.setHowGotThere("Fifth Ave.");
			}
			else{
				location.setLocationName("Bookstore");
				s = "Bookstore";
				location.setHowGotThere("Chirp St.");
			}
		}
		else if(location.getLocationName().equals("Coffee Shop")){
			location.setPastLocation("Coffe");
			if(whereToMove==0 && firstIteration==0){
				location.setLocationName("Outside City");
				s = "Outside City";
				location.setHowGotThere("Fifth Ave.");
			}
			else{
				location.setLocationName("Mall");
				s = "Mall";
				location.setHowGotThere("Meow St.");
			}    				
		}
		else if(location.getLocationName().equals("Outside City")){
			location.setPastLocation("Outside City");
			if(whereToMove==0){
				location.setLocationName("Mall");
				s= "Mall";
				location.setHowGotThere("Fourth Ave.");
			}
			else{
				location.setLocationName("University");
				s= "University";
				location.setHowGotThere("Fifth Ave.");
			}
		}
		return s;
	}
	
}
