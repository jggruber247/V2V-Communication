package v2vPackage;

/** Programmed by Garrett Gruber **/

/* This program will simulate simple direct messaging between drivers.
 * The following situations can be emulated:
 *	-Messaging between two smart cars.
 *	-Messaging between one smart car and one non-smart car equipped with a TAG Device
 */
import java.util.Scanner;
public class ScenarioOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("**************** VEHICLES *****************");
		
		// Creating an object for the first car, which is a smart car
		Vehicle car1 = new Vehicle("Tesla", "Model 3", 2018, "111", true, false);
		System.out.println("{CAR 1} Created:");
		car1.summerizeID();
		car1.setCons("[{CAR 1} Console] ");
		car1.setName("{CAR 1}");
		car1.setDrivingInfo(30, 1, 'N', true);
		System.out.println("");
		
		// Creating an object for the second car, which is also a smart car
		Vehicle car2 = new Vehicle("Honda", "Civic", 2021, "222", true, false);
		System.out.println("{CAR 2} Created:");
		car2.summerizeID();
		car2.setCons("[{CAR 2} Console] ");
		car2.setName("{CAR 2}");
		car2.setDrivingInfo(26, 1, 'N', true);
		System.out.println("");

		// Creating an object for the third car, which is not a smart car but does have a TAG Device
		Vehicle car3 = new Vehicle("Oldsmobile", "Bravada", 2000, "333", false, false);
		System.out.println("{CAR 3} Created:");
		car3.summerizeID();
		car3.setCons("[{CAR 3} TAG SIGNAL READER] ");
		car3.setName("{CAR 3}");
		car3.setDrivingInfo(35, 2, 'N', true);
		System.out.println("");
		System.out.println("");
		
		System.out.println("=========BEGIN Simulation=========\n");
		String c1Console = car1.getCons();
		String c2Console = car2.getCons();
		String c3SignalR = car3.getCons();
		String user = "[{CAR 1} User] ";
		String user2 = "[{CAR 2} User] ";
		String message = null;
		String signal = null;
		System.out.println(c1Console + "Which vehicle would you like to send a message to?");
		System.out.println(c1Console + "Nearby Cars:\n\t1: " + car2.yearMakeModel() + "\n\t2: " + car3.yearMakeModel());
		System.out.print(user);
		int ch1 = sc.nextInt();
		if (ch1 == 1) { // If user selects the smart car as the recipient
			System.out.println(c1Console + "Recipient Vehicle Summary:");
			car2.summerizeID();
			System.out.println(c1Console + "Select message to send:\n\t1: Slow Down!\n\t2: Please let me pass.\n\t3: Sorry!\n\t4: Go ahead.\n\t5: Thanks!");
			System.out.print(user);
			int ch2a = sc.nextInt();
			switch(ch2a) {
			case 1:
				message = "Slow down!";
				break;
			case 2:
				message = "Please let me pass.";
				break;
			case 3:
				message = "Sorry!";
				break;
			case 4:
				message = "Go ahead.";
				break;
			case 5:
				message = "Thanks!";
				break;
			default:
				System.out.println(c1Console + "ERROR- Invalid Selection.");
				break;
			}
			if (message != null) { 
				String reply = null;
				int ch3 = 0;
				System.out.println(c1Console + "Successfully sent message \"" + message + "\" to " + car2.getName() + " (" + car2.yearMakeModel() + ").");
				System.out.println("");
				System.out.println("\t" + c2Console + "Message received from " + car1.getName() + " (" + car1.yearMakeModel() + ").");
				System.out.println("\t" + c2Console + car1.getName() + " says \"" + message + "\"");
				System.out.println("\t" + c2Console + "Reply?\n\t\t0: Do not reply.");
				switch(ch2a) { // uses the message to give contextual reply options
				case 1: // "Slow down!"
					System.out.println("\t\t1: Sorry!\n\t\t2: Speed Up!");
					System.out.print("\t" + user2);
					ch3 = sc.nextInt();
					switch(ch3) {
					case 0:
						break;
					case 1:
						reply = "Sorry!";
						break;
					case 2:
						reply = "Speed Up!";
						break;
					default:
						break;
					}
					break;
				case 2: // "Please let me pass."
					System.out.println("\t\t1: I will try.\n\t\t2: Sorry, I cannot.");
					System.out.print("\t" + user2);
					ch3 = sc.nextInt();
					switch(ch3) {
					case 0:
						break;
					case 1:
						reply = "I will try.";
						break;
					case 2:
						reply = "Sorry, I cannot.";
						break;
					default:
						break;
					}
					break;
				case 3: // "Sorry!"
					System.out.println("\t\t1: Its cool.\n\t\t2: Yeah, you better be!");
					System.out.print("\t" + user2);
					ch3 = sc.nextInt();
					switch(ch3) {
					case 0:
						break;
					case 1:
						reply = "Its cool.";
						break;
					case 2:
						reply = "Yeah, you better be!";
						break;
					default:
						break;
					}
					break;
				case 4: // "Go ahead."
					System.out.println("\t\t1: Thanks!\n\t\t2: No, you can go ahead.");
					System.out.print("\t" + user2);
					ch3 = sc.nextInt();
					switch(ch3) {
					case 0:
						break;
					case 1:
						reply = "Thanks!";
						break;
					case 2:
						reply = "No, you can go ahead.";
						break;
					default:
						break;
					}
					break;
				case 5: // "Thanks!"
					System.out.println("\t\t1: You are welcome.\n\t\t2: No problem!");
					System.out.print("\t" + user2);
					ch3 = sc.nextInt();
					switch(ch3) {
					case 0:
						break;
					case 1:
						reply = "You are welcome.";
						break;
					case 2:
						reply = "No problem!";
						break;
					default:
						break;
					}
					break;
				}
				if (reply != null) {
					System.out.println("\t" + c2Console + "Successfully sent reply \"" + reply + "\" to " + car1.getName() + " (" + car1.yearMakeModel() + ").");
					System.out.println("");
					System.out.println(c1Console + "Reply received from " + car2.getName() + " (" + car2.yearMakeModel() + ").");
					System.out.println(c1Console + car2.getName() + " says \"" + reply + "\"");
				}
			}
		}
		else if (ch1 == 2) { // If user selects the nonsmart car as the recipient
			System.out.println(c1Console + "Recipient Vehicle Summary:");
			car3.summerizeID();
			System.out.println(c1Console + "Select signal to send:\n\t1: Red Signal (Negative Sentiment)\n\t2: Green Signal (Positive Sentiment)\n\t3: Blue Signal (\"Sorry\")\n\t4: Yellow Signal (\"Thanks\")");
			System.out.print(user);
			int ch2b = sc.nextInt();
			switch(ch2b) {
			case 1:
				signal = "<RED>";
				break;
			case 2:
				signal = "<GREEN>";
				break;
			case 3:
				signal = "<BLUE>";
				break;
			case 4:
				signal = "<YELLOW>";
				break;
			default:
				System.out.println(c1Console + "ERROR- Invalid Selection.");
				break;
			}
			if (signal != null) { 
				System.out.println(c1Console + "Successfully sent " + signal + " signal to " + car3.getName() + " (" + car3.yearMakeModel() + ").");
				System.out.println("");
				System.out.println("\t" + c3SignalR + signal);
			}
		}
		else {
			System.out.println(c1Console + "ERROR- Invalid Selection.");
		}
		System.out.println("\n=========END Simulation=========\n\n");
		
		sc.close();
	}
}