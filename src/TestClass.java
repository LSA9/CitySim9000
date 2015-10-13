import static org.junit.Assert.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;

public class TestClass {



	//This test ensures that the input by the user is greater than 0.
	//Because the code uses a try/catch block to ensure that the input is actually
	//a integer value there is no need to test that because it is garanteed to fail
	//an non-integer is entered.
	@Test
	public void inputTest() {
		InputReciever inscan = new InputReciever();
		int x = inscan.recieveInput(1);
		assertEquals(x,1);
		x = inscan.recieveInput(-1);
		assertEquals(x,0);
	}

	//This test ensures that the the class used to create the strings to be printed
	//out at every iteration is printing the correct values.  This method
	//uses both mocking and stubbing
	@Test
	public void testToStringStringMaker(){
		StringMaker maker = new StringMaker();
		Location mockLocation = Mockito.mock(Location.class);
		String testString;
		
		//Expected values passed in
		when(mockLocation.getPastLocation()).thenReturn("there");
		when(mockLocation.getLocationName()).thenReturn("here");
		when(mockLocation.getHowGotThere()).thenReturn("street");
		testString = maker.toString(1,mockLocation);
		assertEquals("Driver 1 heading From there to here via street", testString);
		
		//One value is blank
		when(mockLocation.getPastLocation()).thenReturn("");
		when(mockLocation.getLocationName()).thenReturn("here");
		when(mockLocation.getHowGotThere()).thenReturn("street");
		testString = maker.toString(1,mockLocation);
		assertEquals("Driver 1 heading From  to here via street", testString);
	}

	//This test ensures that the method that randomly selects a direction for a moving 
	//car selects the correct numbers
	@Test
	public void testDetermineMove(){
		int number;
		Random rand = Mockito.mock(Random.class);
		Car c = new Car(0,rand);
		
		//Test that method returns 0
		when(rand.nextInt()).thenReturn(0);
		number = c.determineMove();
		assertTrue(number==0);	
	}
	
	//Tests the getter and setter of the StringMaker class
	@Test
	public void testStringMakerSetterAndGetter(){
		StringMaker sm = new StringMaker();
		String testString;
		
		sm.setString("Hello World");
		testString = sm.getString();
		assertEquals(testString,"Hello World");
		
		sm.setString(null);
		testString = sm.getString();
		assertNull(testString);
	}
	
	//Tests the first iteration class which randomly picks an initial location which is not
	//The outside location
	@Test
	public void testfirstIteration(){
		String s;
		FirstIterator firstIterator = new FirstIterator();
		Location location = Mockito.mock(Location.class);
		Random rand = Mockito.mock(Random.class);
		
		//Test Mall when rand returns 0
		when(rand.nextInt(4)).thenReturn(0);
		s = firstIterator.getStartingLocation(location, rand);
		assertEquals(s,"Mall");
		
		//Test Bookstore when rand returns 1
		when(rand.nextInt(4)).thenReturn(1);
		s = firstIterator.getStartingLocation(location, rand);
		assertEquals(s,"Bookstore");
		
		//Test Coffee shop when rand returns 2
		when(rand.nextInt(4)).thenReturn(2);
		s = firstIterator.getStartingLocation(location, rand);
		assertEquals(s,"Coffee Shop");
		
		//Test University when rand returns 3
		when(rand.nextInt(4)).thenReturn(3);
		s = firstIterator.getStartingLocation(location, rand);
		assertEquals(s,"University");
		
		//Test null when rand returns a number greater than 4
		when(rand.nextInt(4)).thenReturn(4);
		s = firstIterator.getStartingLocation(location, rand);
		assertNull(s);
	}

	//Tests the Mover class which determines where the car will go next based off of the past
	//location and a random number (0 or 1) passed in from the car class
	@Test
	public void moverTest(){
		Mover m = new Mover();
		String s;
		Location mockLocation = Mockito.mock(Location.class);

		//Normal tests to test the base case where all values that are passed to the Mover object
		//are valid inputs
		when(mockLocation.getLocationName()).thenReturn("University");
		s = m.moveLocation(mockLocation, 0, 1);
		assertEquals(s,"Coffee Shop");
		
		when(mockLocation.getLocationName()).thenReturn("Mall");
		s = m.moveLocation(mockLocation, 1, 1);
		assertEquals(s,"Coffee Shop");
		
		when(mockLocation.getLocationName()).thenReturn("Bookstore");
		s = m.moveLocation(mockLocation, 0, 0);
		assertEquals(s,"Outside City");
		
		when(mockLocation.getLocationName()).thenReturn("University");
		s = m.moveLocation(mockLocation, 1, 0);
		assertEquals(s,"Bookstore");
		
		when(mockLocation.getLocationName()).thenReturn("Coffee Shop");
		s = m.moveLocation(mockLocation, 0, 0);
		assertEquals(s,"Outside City");
		
		when(mockLocation.getLocationName()).thenReturn("Coffee Shop");
		s = m.moveLocation(mockLocation, 1, 0);
		assertEquals(s,"Mall");
		
		//Test to see if the car will move from the mall to the bookstore after receiving a 0.
		//Also in this test, the Iterator is incorrectly switch to see that it should not matter in this
		//case.
		when(mockLocation.getLocationName()).thenReturn("Mall");
		s = m.moveLocation(mockLocation, 0, 1);
		assertEquals(s, "Bookstore");

		//Test to see if the car will go outside the city on the first iteration.  If it does not
		//The test should return "University" rather than "Outside City"
		when(mockLocation.getLocationName()).thenReturn("Bookstore");
		s = m.moveLocation(mockLocation, 0, 1);
		assertEquals(s,"University");
	}

	//Tests the getters and setters within the Location class
	@Test
	public void testLocationObject()
	{
		Location location = new Location();
		location.setPastLocation("Zoo");
		assertEquals(location.getPastLocation(),"Zoo");
		location.setLocationName("Zoo");
		assertEquals(location.getLocationName(),"Zoo");
		location.setHowGotThere("Zoo");
		assertEquals(location.getHowGotThere(),"Zoo");
	}

	//This tests the OutsideCityChecker object which will ensure that if the car goes out of the
	//city limits it will print the correct warning string.  However, if the car is still in bounds
	//the normal message will be printed to the screen indicated where the car is, how it got there
	//and where the car is coming from
	@Test
	public void testOutsideCityChecker(){
		String s;

		//Checks the output string if the driver has left the city
		OutsideCityChecker occ = new OutsideCityChecker();
		StringMaker maker = Mockito.mock(StringMaker.class);
		when(maker.getString()).thenReturn("Driver 0 heading From Mall to Outside City via Fifth Ave.");
		s = occ.checker(maker, 0);
		assertEquals(s,"Driver 0 has left the city!");

		//Checks the output string if the driver is still in tie city bounds=
		when(maker.getString()).thenReturn("Driver 0 heading From Mall to Coffee via Fifth Ave.");
		s = occ.checker(maker, 0);
		assertEquals(s,"Driver 0 heading From Mall to Coffee via Fifth Ave.");
	}
	







}
