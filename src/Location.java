
public class Location {
	
	private String locationName;
	private String howGotThere;
	private String pastLocation;

	
	public Location(){		
	}
	
	public String getLocationName(){
		return locationName;
	}
	
	
	public void setLocationName(String name){
		locationName = name;
		
	}

	public String getHowGotThere(){
		return howGotThere;
	}
	
	public void setHowGotThere(String how){
		howGotThere = how;
	}
	
	public String getPastLocation(){
		return pastLocation;
	}
	
	public void setPastLocation(String location){
		pastLocation = location;
	}
	

}
