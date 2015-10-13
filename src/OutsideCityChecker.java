
public class OutsideCityChecker {
	
	public OutsideCityChecker(){
	}
	
	public String checker(StringMaker stringMaker, int carNumber){
		String s = stringMaker.getString();
		String[] tokens = s.split(" ");
		if((tokens[6].equals("Outside") && tokens[7].equals("City")) || (tokens[7].equals("Outside") && tokens[8].equals("City"))){
			String newString = "Driver "+ carNumber +" has left the city!";
			stringMaker.setString(newString);
			s = newString;
		}
		return s;
	}


}
