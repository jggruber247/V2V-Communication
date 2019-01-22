package v2vPackage;

import java.util.ArrayList;
import java.util.Scanner;

/** Programmed by Garrett Gruber **/

/* This program will simulate "intelligent braking." This is the automatic notification
 * that car sends to a car behind it when the first car brakes. The signal would make
 * the second car apply its brakes automatically. This signal would only be sent if
 * the following conditions are met:
 * 		-The second car is in close proximity to the first, determined by a formula
 * 		that takes into account the speed of second car. The faster the speed, the
 * 		shorter the minimum distance between the two cars for the signal to send.
 * 		-The second car is in the same lane as the first car. 
 * 		-The two cars are going in the same direction.
 */

public class ScenarioTwo {

	private static String Tab = ""; // Allows for indentation

	/** Brake Method **/
	// This method runs when a smart car applies its brakes. Sends the automatic brake signal to the car close behind it (if there is one.)
	public static void brake(Vehicle car1, ArrayList<Vehicle> cars, boolean indent, boolean forward) {
		String c1Console = car1.getCons();
		if (indent) {  // If true, resets the Indentation
			Tab = "";
		}
		if (forward) {  // If the method is running as a response to a signal 
			System.out.println(Tab + c1Console + "Smart Brake signal alert received.");
		}
		System.out.println(Tab + c1Console + "Brakes applied. Signaling any trailing vehicle(s)...");
		boolean b = false;
		for (int i = 0; i < 3; i++) {
			if (car1.isBehind(cars.get(i)) && b == false) {
				System.out.println(Tab + c1Console + "Signaling vehicle " + cars.get(i).getName() + " (" + cars.get(i).yearMakeModel() + ")\n");
				Tab = Tab + "\t";  // Increments the identation to create a heirarchy
				Vehicle temp = cars.get(i);
				cars.set(i, car1);
				brake(temp, cars, false, true); // Recusively runs the brake method for the receiving car
				b = true;
			}
		}
		if (b == false) {
			System.out.println(Tab + c1Console + "No appropriate vehicle found. Signal not sent.");
		}
	}
	
	/** MAIN METHOD **/
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**************** VEHICLES *****************");
		
		// Creating an object for the first car
		Vehicle car1 = new Vehicle("Tesla", "Model 3", 2018, "111", true, false);
		System.out.println("{CAR 1} Created:");
		car1.summerizeID();
		car1.setCons("[{CAR 1} Console] ");
		car1.setName("{CAR 1}");

		// Creating an object for the second car
		Vehicle car2 = new Vehicle("Honda", "Civic", 2021, "222", true, false);
		System.out.println("{CAR 2} Created:");
		car2.summerizeID();
		car2.setCons("[{CAR 2} Console] ");
		car2.setName("{CAR 2}");


		// Creating an object for the third car
		Vehicle car3 = new Vehicle("Oldsmobile", "Bravada", 2000, "333", true, false);
		System.out.println("{CAR 3} Created:");
		car3.summerizeID();
		car3.setCons("[{CAR 3} Console] ");
		car3.setName("{CAR 3}");
		
		// Creating an object for the fourth car
		Vehicle car4 = new Vehicle("Toyota", "Tundra", 2004, "444", true, false);
		System.out.println("{CAR 4} Created:");
		car4.summerizeID();
		car4.setCons("[{CAR 4} Console] ");
		car4.setName("{CAR 4}");
		System.out.println("");

		System.out.println("****************** SCENARIO 2A *******************");
		System.out.println("See Figure 2A for visual reference.");
		System.out.println("DESCRIPTION: {CAR 1} brakes and sends a signal to {CAR 2}, which is received and causes {CAR 2} to also brake.");
		
		// Setting the initial driving characteristics for the cars
		car1.setDrivingInfo(70, 1, 'N', false);
		car2.setDrivingInfo(70, 1, 'N', false);
		car3.setDrivingInfo(70, 2, 'N', false);
		car4.setDrivingInfo(70, -1, 'S', false);

		// Setting the positions of the cars
			// This number is the distance the car is from the next mile marker (a V2I device).
			// Vehicles with lower numbers are in front of vehicles with higher numbers.
			// This does not take into account which lane the cars are in.
		car1.setPosition(100); 
		car2.setPosition(200);
		car3.setPosition(150);
		car4.setPosition(-50);
		
		// Putting the cars near car1 into an arraylist
		ArrayList<Vehicle> nearbyCars = new ArrayList<Vehicle>();
		nearbyCars.add(car2);
		nearbyCars.add(car3);
		nearbyCars.add(car4);
		
		// Testing the smart braking system
		System.out.println("Press ENTER to execute smart brake test.");
		String test1 = sc.nextLine();
		System.out.println("=========BEGIN Simulation=========");
		if (test1 != null) 
			brake(car1, nearbyCars, true, false);
		else
			brake(car1, nearbyCars, true, false);
		System.out.println("=========END Simulation=========\n\n");
		
		
		System.out.println("****************** SCENARIO 2B *******************");
		System.out.println("See Figure 2B for visual reference.");
		System.out.println("DESCRIPTION: {CAR 2} is now farther behind {CAR 1}, so {CAR 1} will not send the signal because no car would receive it.");
		
		// Moving car2 farther from car1 so that enough distance is between them for the notification not to send
		car2.setPosition(400);
		
		// Putting the cars near car1 into an arraylist
		ArrayList<Vehicle> nearbyCars2 = new ArrayList<Vehicle>();
		nearbyCars2.add(car2);
		nearbyCars2.add(car3);
		nearbyCars2.add(car4);
		
		// Testing the smart braking system
		System.out.println("Press ENTER to execute smart brake test.");
		String test2 = sc.nextLine();
		System.out.println("=========BEGIN Simulation=========");
		if (test2 != null) 
			brake(car1, nearbyCars2, true, false);
		else
			brake(car1, nearbyCars2, true, false);
		System.out.println("=========END Simulation=========\n\n");
		
		
		System.out.println("****************** SCENARIO 2C *******************");
		System.out.println("See Figure 2C for visual reference.");
		System.out.println("DESCRIPTION: All cars are in a single file line heading in the same direction. Each car should send the signal in sequence when {CAR 1} brakes.");
		// Modifying lane placement, direction, and position so all 4 cars are in a line
		car3.setDrivingInfo(70, 1, 'N', false);
		car4.setDrivingInfo(70, 1, 'N', false);
		car1.setPosition(100); 
		car2.setPosition(200);
		car3.setPosition(250);
		car4.setPosition(300);
		
		// Putting the cars near car1 into an arraylist
		ArrayList<Vehicle> nearbyCars3 = new ArrayList<Vehicle>();
		nearbyCars3.add(car2);
		nearbyCars3.add(car3);
		nearbyCars3.add(car4);
		
		// Testing the smart braking system
		System.out.println("Press ENTER to execute smart brake test.");
		String test3 = sc.nextLine();
		System.out.println("=========Begin Simulation=========");
		if (test3 != null) 
			brake(car1, nearbyCars3, true, false);
		else
			brake(car1, nearbyCars3, true, false);
		System.out.println("=========END Simulation=========\n\n");
		
		sc.close();
	}
}