package v2vPackage;

/** Programmed by Garrett Gruber **/

/* This is the vehicle constructor class. Each vehicle in the simulations
 * will be an instance of this class as an object.
 */

public class Vehicle {
	
	// Declaring variables that are used to identify vehicles and do not change.
	private String Make, Model;
	private int Year;
	private String VID;
	private boolean IsSmart, IsEmergency;
	// Declaring variables that update as a vehicle drives and describes its driving
	private int Speed, Lane; 
	private char Direction;
	private int Position;
	// Other identifiers
	private String Console, Name;
	
	
	// Constructor for a Vehicle object
	public Vehicle(String make, String model, int year, String vID, boolean isSmart, boolean isEmergency) {
		Make = make;
		Model = model;
		Year = year;
		VID = vID;
		IsSmart = isSmart;
		IsEmergency = isEmergency;
	}
	
	
	/** *********************BASIC SET AND GET METHODS********************* **/
	
	// Set and Get methods for a vehicle's make
	public void setMake(String make) {
		Make = make;
	}
	public String getMake() {
		return Make;
	}
	
	// Set and Get methods for a vehicle's model
	public void setModel(String model) {
		Model = model;
	}
	public String getModel() {
		return Model;
	}

	// Set and Get methods for a vehicle's year
	public void setYear(int year) {
		Year = year;
	}
	public int getYear() {
		return Year;
	}	
	
	// Set and Get methods for a vehicle's ID
	public void setVID(String vID) {
		VID = vID;
	}
	public String getVID() {
		return VID;
	}	

	// Set and Get methods for a vehicle's smart status
	public void setIsSmart(boolean isSmart) {
		IsSmart = isSmart;
	}
	public boolean getIsSmart() {
		return IsSmart;
	}
	
	// Set and Get methods for if a vehicle is an emergency vehicle
	public void setIsEmergency(boolean isEmergency) {
		IsEmergency = isEmergency;
	}
	public boolean getIsEmergency() {
		return IsEmergency;
	}	

	// Set and Get methods for a vehicle's speed
	public void setSpeed(int speed) {
		Speed = speed;
	}
	public int getSpeed() {
		return Speed;
	}
	
	// Set and Get methods for the lane a vehicle is in
	public void setLane(int lane) {
		Lane = lane;
	}
	public int getLane() {
		return Lane;
	}
	
	// Set and Get methods for the direction a vehicle is going
	public void setDirection(char dir) {
		//checks that the parameter dir is a supported direction
		if (dir == 'N' || dir == 'E' || dir == 'S' || dir == 'W')
			Direction = dir;
		else
			System.out.println("Invalid Direction.");
	}
	public char getDirection() {
		return Direction;
	}
	
	// Set and Get methods for the position of a vehicle relative to the next mile marker
	public void setPosition(int pos) {
		Position = pos;
	}
	public int getPosition() {
		return Position;
	}
	
	// Set and Get methods for a vehicle's console string
	public void setCons(String cons) {
		Console = cons;
	}
	public String getCons() {
		return Console;
	}	
	
	// Set and Get methods for a vehicle's label (used for easy identification in the console simulation)
	public void setName(String name) {
		Name = name;
	}
	public String getName() {
		return Name;
	}	
	
	
	
	/** *********************OTHER METHODS********************* **/
	
	// Method to summerize a car's ID info
	public void summerizeID() {
		String smart;
		if (getIsSmart() == true)
			smart = "Yes";
		else 
			smart = "No, TAG Device Equipped";
		String emer;
		if (getIsEmergency() == true)
			emer = "Yes";
		else
			emer = "No";
		System.out.println("\tVehicle: " + Year + " " + Make + " " + Model);
		System.out.println("\tVID: " + VID);
		System.out.println("\tSmart Vehicle: " + smart);
		System.out.println("\tEmergency Vehicle: " + emer);
	}	

	// Method that converts the Direction interger to its corresponding compass direction:
		// N = North, E = East, S = South, W = West
		// Intermediate directions like NorthWest are not included for the sake of simplicity
	public String compassDir() {
		String cDir = "";
		switch(Direction) {
		case 'N' :
			cDir = "NORTH";
			break;
		case 'E' :
			cDir = "EAST";
			break;
		case 'S' :
			cDir = "SOUTH";
			break;
		case 'W' :
			cDir = "WEST";
			break;
		}
		return cDir;
	}
	
	// Method to update a car's driving characteristics all at once
	public void setDrivingInfo(int speed, int lane, char dir, boolean print) {
		Speed = speed;
		Lane = lane;
		setDirection(dir);
		if(print) 	// If 'print' is true, the summarizeDriving() method will run
			summerizeDriving();
	}
	
	// Method to summerize a car's driving
	public void summerizeDriving() {
		String dir = compassDir();
		System.out.println("The " + Year + " " + Make + " " + Model);
		System.out.println("is currently heading " + dir + " at " + Speed + " MPH");
		System.out.println("in lane number " + Math.abs(Lane) + ".");
	}
	
	// Method to return a car's Year, Make, and Model as a string
	public String yearMakeModel() {
		return "" + Year + " " + Make + " " + Model;
	}
	
	
	/** ********************* METHODS FOR SPECIFIC SCENARIOS ********************* **/
	
	// Method to determine whether a car is able to recieve automatic brake notification
		// Used in ScenarioTwo.java
	public boolean isBehind(Vehicle car2) {
		boolean cond = false;
		if (Direction == car2.getDirection()) {  // If the cars are heading in the same direction
			if (Lane == car2.getLane()) {  // If the cars are in the same lane
				if (Position < car2.getPosition()) { // If the second car is behind the first car
					int diff = car2.getPosition() - Position; // Distance between the cars
					int spd = (car2.getSpeed() / 10) * 15; // Stopping distance is 15' for every 10 mph
					if (diff <= spd) { // If car2 is within stopping distance of the first car
						cond = true;
					}
				}
			}
		}
		return cond;
	}
	
}