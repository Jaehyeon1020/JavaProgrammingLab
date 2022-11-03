import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.Font;
import java.util.ArrayList; // import for using ArrayList that stores PublicTransport class instance

public class TripPlanner {
	private JFrame frame;
	
	private static String currentShowingText = new String(""); // for storing text that is showing now
	private static String fareString = new String(""); // for storing price to String
	private static String baseFareString = new String(""); // for storing price to String(basefare)
	private static String farePerDistanceString = new String(""); // for storing price to String(fare per km or station)
	private static String numStationsString = new String(""); // for storing number of stations to String
	private static ArrayList<PublicTransport> transportList = new ArrayList<>(); // for storing instances of PublicTransport class
	
	/**
	 * flags for indicating type of user input: base fare, fare per distance(station), number of stations
	 */
	private boolean isInputBaseFare = false;
	private boolean isInputDistanceFare = false;
	private boolean isInputNStations = false;
	
	/**
	 * flags for indicating type of transport
	 */
	private boolean isTrain = false;
	private boolean isBus = false;
	private boolean isTaxi = false;
	
	/**
	 *	print each transport's fare and total fare of this Trip
	 */
	private static void printTripFare(JTextPane middleText) {
		int transportNum = 1;
		double totalTripFare = 0;
		double transportFare = 0;
		currentShowingText = "";
		
		for(PublicTransport transport : transportList) {
			currentShowingText = currentShowingText + "Transport " + transportNum + ": ";
			
			// if this instance is Train
			if(transport.getModel().equals("Train")) {
				transportFare = ((Train)transport).calculatePayment();
				totalTripFare += transportFare;
				currentShowingText = currentShowingText + "KORAIL\n";
				currentShowingText = currentShowingText + "Fare: " + transportFare + "\n";
				
			}
			// if this instance is Bus
			else if(transport.getModel().equals("Bus")) {
				transportFare = ((Bus)transport).calculatePayment();
				totalTripFare += transportFare;
				currentShowingText = currentShowingText + "KORBUS\n";
				currentShowingText = currentShowingText + "Fare: " + transportFare + "\n";
			}
			// if this instance is Taxi
			else if(transport.getModel().equals("Taxi")) {
				transportFare = ((Taxi)transport).calculatePayment();
				totalTripFare += transportFare;
				currentShowingText = currentShowingText + "KAKAO TAXI\n";
				currentShowingText = currentShowingText + "Fare: " + transportFare + "\n";
			}
			
			transportNum += 1;
		}
		
		currentShowingText = currentShowingText + "==============================\n" + "Total Trip Fare: " + totalTripFare + "\n";
		middleText.setText(currentShowingText);
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TripPlanner window = new TripPlanner();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TripPlanner() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 484, 618);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel textTrainPlanner = new JLabel("TRIP PLANNER");
		textTrainPlanner.setHorizontalAlignment(SwingConstants.CENTER);
		textTrainPlanner.setBounds(109, 109, 279, 16);
		frame.getContentPane().add(textTrainPlanner);
		
		JLabel topImage = new JLabel("");
		topImage.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/planner_logo.png")));
		topImage.setBounds(41, 23, 402, 74);
		frame.getContentPane().add(topImage);
		
		JTextPane middleText = new JTextPane();
		middleText.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		middleText.setText("Choose transport (from left menu):");
		middleText.setEditable(false);
		middleText.setBounds(130, 125, 234, 201);
		frame.getContentPane().add(middleText);
		
		
		JButton trainButton = new JButton("TRAIN");
		trainButton.addActionListener(new ActionListener() {
			// behavior if train button pushed
			public void actionPerformed(ActionEvent e) {
				isTrain = true;
				isInputBaseFare = true;
				currentShowingText = "You choose TRAIN\nEnter base fare: ";
				middleText.setText(currentShowingText);
			}
		});
		trainButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/train.png")));
		trainButton.setBackground(UIManager.getColor("Button.background"));
		trainButton.setBounds(28, 125, 90, 29);
		frame.getContentPane().add(trainButton);
		
		JButton busButton = new JButton("BUS");
		busButton.addActionListener(new ActionListener() {
			// behavior if bus button pushed
			public void actionPerformed(ActionEvent e) {
				isBus = true;
				isInputBaseFare = true;
				currentShowingText = "You choose BUS\nEnter base fare: ";
				middleText.setText(currentShowingText);
			}
		});
		busButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/bus.png")));
		busButton.setBackground(SystemColor.window);
		busButton.setBounds(28, 152, 90, 29);
		frame.getContentPane().add(busButton);
		
		JButton taxiButton = new JButton("TAXI");
		taxiButton.addActionListener(new ActionListener() {
			// behavior if taxi button pushed
			public void actionPerformed(ActionEvent e) {
				isTaxi = true;
				isInputBaseFare = true;
				currentShowingText = "You choose TAXI\nEnter base fare: ";
				middleText.setText(currentShowingText);
			}
		});
		taxiButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/taxi.png")));
		taxiButton.setBackground(SystemColor.window);
		taxiButton.setBounds(28, 179, 90, 29);
		frame.getContentPane().add(taxiButton);
		
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(new ActionListener() {
			// if Yes button clicked : reset all flags to zero and return to start of the program
			public void actionPerformed(ActionEvent e) {
				isInputBaseFare = false;
				isInputDistanceFare = false;
				isInputNStations = false;
				isBus = false;
				isTrain = false;
				isTaxi = false;
				
				middleText.setText("Choose transport (from left menu): ");
			}
		});
		yesButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/enterSmall.png")));
		yesButton.setBackground(SystemColor.window);
		yesButton.setBounds(367, 125, 98, 39);
		frame.getContentPane().add(yesButton);
		
		JButton noButton = new JButton("No");
		noButton.addActionListener(new ActionListener() {
			// if No button clicked : print all transports' information, fare of each transports and total trip fare
			public void actionPerformed(ActionEvent e) {
				printTripFare(middleText);
			}
		});
		noButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/cancelSmall.png")));
		noButton.setBackground(SystemColor.window);
		noButton.setBounds(367, 169, 98, 39);
		frame.getContentPane().add(noButton);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			/**
			 *  behavior if CANCEL button pushed:
			 *  clear all flags, remove all PublicTransport instances in list transports, and set new text in application
			 */
			public void actionPerformed(ActionEvent e) {
				fareString = ""; // clearing fareString (erase entered value before)
				
				// clear all flags
				isInputBaseFare = false;
				isInputDistanceFare = false;
				isInputNStations = false;
				isBus = false;
				isTrain = false;
				isTaxi = false;
				
				transportList.clear(); // remove all PublicTransport instances in list transports
				
				currentShowingText = "Cancelled!\n" + "New plan:\n" + "Choose transport (from left menu):";
				middleText.setText(currentShowingText);
			}
		});
		cancelButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/cancel.png")));
		cancelButton.setBackground(SystemColor.window);
		cancelButton.setBounds(345, 338, 120, 65);
		frame.getContentPane().add(cancelButton);
		
		JButton clearButton = new JButton("CLEAR");
		clearButton.addActionListener(new ActionListener() {
			/**
			 * behavior if CLEAR button clicked:
			 * clear the user inputed numbers and make user to re-enter numbers 
			 */
			public void actionPerformed(ActionEvent e) {
				currentShowingText = currentShowingText.substring(0, currentShowingText.length() - fareString.length());
				middleText.setText(currentShowingText);
				
				fareString = "";
			}
		});
		clearButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/clear.png")));
		clearButton.setBackground(SystemColor.window);
		clearButton.setBounds(345, 399, 120, 65);
		frame.getContentPane().add(clearButton);
		
		JButton enterButton = new JButton("ENTER");
		enterButton.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/enter.png")));
		enterButton.addActionListener(new ActionListener() {
			/**
			 * behavior if ENTER button clicked:
			 * each situation receives input from the user differently
			 */
			public void actionPerformed(ActionEvent e) {
				// input fare per distance(station)
				if(isInputBaseFare == true) {
					isInputBaseFare = false;
					isInputDistanceFare = true;
					
					baseFareString = fareString; // for storing base fare
					fareString = "";
					
					if(isTaxi == true) {
						currentShowingText = "Enter fare per km: ";
						middleText.setText(currentShowingText);
					}
					else {
						currentShowingText = "Enter fare per station (for extra stations): ";
						middleText.setText(currentShowingText);
					}
					
					isInputNStations = true;
				}
				// input distance(number of stations or kilometers)
				else if(isInputDistanceFare == true) {
					isInputDistanceFare = false;
					isInputNStations = true;
					farePerDistanceString = fareString; // for storing fare per distance(station)
					fareString = "";
					
					if(isTaxi == true) {
						currentShowingText = "Enter distance (in km): ";
						middleText.setText(currentShowingText);
					}
					else {
						currentShowingText = "Enter number of stations: ";
						middleText.setText(currentShowingText);
					}
				}
				else if(isInputNStations == true) {
					isInputNStations = false;
					numStationsString = fareString; // for storing number of stations(total km of taxi)
					fareString = "";
					
					// add PublicTransport instance to arraylist
					if(isBus == true) {
						isBus = false;
						transportList.add(new Bus(Double.parseDouble(baseFareString), Double.parseDouble(farePerDistanceString), 
											Integer.parseInt(numStationsString)));
					}
					else if(isTrain == true) {
						isTrain = false;
						transportList.add(new Train(Double.parseDouble(baseFareString), Double.parseDouble(farePerDistanceString), 
											Integer.parseInt(numStationsString)));
					}
					else if(isTaxi == true) {
						isTaxi = false;
						transportList.add(new Taxi(Double.parseDouble(baseFareString), Double.parseDouble(farePerDistanceString), 
											Double.parseDouble(numStationsString)));
					}
					
					currentShowingText = "Add more transport (from right menu)?";
					middleText.setText(currentShowingText);
				}
			}
		});
		enterButton.setBackground(SystemColor.window);
		enterButton.setBounds(345, 457, 120, 65);
		frame.getContentPane().add(enterButton);
		
		JButton numberButton_1 = new JButton("");
		numberButton_1.addActionListener(new ActionListener() {
			// behavior if number button clicked:
			// store entered number to String variable and update the text box immediately that is located center in application
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "1";
				currentShowingText = currentShowingText + "1";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_1.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/1.png")));
		numberButton_1.setBackground(SystemColor.window);
		numberButton_1.setBounds(63, 338, 98, 65);
		frame.getContentPane().add(numberButton_1);
		
		JButton numberButton_2 = new JButton("");
		numberButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "2";
				currentShowingText = currentShowingText + "2";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_2.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/2.png")));
		numberButton_2.setBackground(SystemColor.window);
		numberButton_2.setBounds(157, 338, 98, 65);
		frame.getContentPane().add(numberButton_2);
		
		JButton numberButton_3 = new JButton("");
		numberButton_3.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/3.png")));
		numberButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "3";
				currentShowingText = currentShowingText + "3";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_3.setBackground(SystemColor.window);
		numberButton_3.setBounds(251, 338, 98, 65);
		frame.getContentPane().add(numberButton_3);
		
		JButton numberButton_4 = new JButton("");
		numberButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "4";
				currentShowingText = currentShowingText + "4";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_4.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/4.png")));
		numberButton_4.setBackground(SystemColor.window);
		numberButton_4.setBounds(63, 399, 98, 65);
		frame.getContentPane().add(numberButton_4);
		
		JButton numberButton_6 = new JButton("");
		numberButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "6";
				currentShowingText = currentShowingText + "6";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_6.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/6.png")));
		numberButton_6.setBackground(SystemColor.window);
		numberButton_6.setBounds(251, 399, 98, 65);
		frame.getContentPane().add(numberButton_6);
		
		JButton numberButton_5 = new JButton("");
		numberButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "5";
				currentShowingText = currentShowingText + "5";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_5.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/5.png")));
		numberButton_5.setBackground(SystemColor.window);
		numberButton_5.setBounds(157, 399, 98, 65);
		frame.getContentPane().add(numberButton_5);
		
		JButton numberButton_7 = new JButton("");
		numberButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "7";
				currentShowingText = currentShowingText + "7";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_7.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/7.png")));
		numberButton_7.setBackground(SystemColor.window);
		numberButton_7.setBounds(63, 457, 98, 65);
		frame.getContentPane().add(numberButton_7);
		
		JButton numberButton_9 = new JButton("");
		numberButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "9";
				currentShowingText = currentShowingText + "9";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_9.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/9.png")));
		numberButton_9.setBackground(SystemColor.window);
		numberButton_9.setBounds(251, 457, 98, 65);
		frame.getContentPane().add(numberButton_9);
		
		JButton numberButton_8 = new JButton("");
		numberButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "8";
				currentShowingText = currentShowingText + "8";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_8.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/8.png")));
		numberButton_8.setBackground(SystemColor.window);
		numberButton_8.setBounds(157, 457, 98, 65);
		frame.getContentPane().add(numberButton_8);
		
		JButton numberButton_0 = new JButton("");
		numberButton_0.setIcon(new ImageIcon(TripPlanner.class.getResource("/assets/0.png")));
		numberButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fareString = fareString + "0";
				currentShowingText = currentShowingText + "0";
				middleText.setText(currentShowingText);
			}
		});
		numberButton_0.setBackground(SystemColor.window);
		numberButton_0.setBounds(157, 519, 98, 65);
		frame.getContentPane().add(numberButton_0);
	
	}
}
