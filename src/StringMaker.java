
public class StringMaker {
	
	String currentString;
	
	public StringMaker(){
	}
	
	public String toString(int carNum, Location location){
		String information = "Driver "+carNum+" heading From "+location.getPastLocation()+" to "+location.getLocationName()+" via "+location.getHowGotThere();
		currentString = information;
		return information;
	}
	
	public String getString(){
		return currentString;
	}
	
	public void setString(String s){
		currentString = s;
	}

}
