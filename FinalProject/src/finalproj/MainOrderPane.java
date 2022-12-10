package finalproj;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class MainOrderPane extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel descriptionLabel;
	private JLabel mainMenuLabel;
	private JRadioButton hamburgerButton;
	private JLabel hamburgerPriceLabel;
	private JRadioButton sandwichButton;
	private JLabel sandwichPriceLabel;
	private JRadioButton pizzaButton;
	private JLabel pizzaPriceLabel;
	private JRadioButton chickenButton;
	private JLabel chickenPriceLabel;
	private JRadioButton gimbapButton;
	private JLabel gimbapPriceLabel;
	private JRadioButton ramenButton;
	private JLabel ramenPriceLabel;
	private JRadioButton jjajangmienButton;
	private JLabel JjajangmienPriceLabel;
	private JRadioButton sushiButton;
	private JLabel sushiPriceLabel;
	private JRadioButton kimchiButton;
	private JLabel kimchiPriceLabel;
	private JButton nextButton;
	
	private String userSelectedMainMenu; // for storing user selected main menu
	private SideOrderPane sideOrderpane; // side order pane: next to main order page

	/**
	 * Create the frame.
	 */
	public MainOrderPane(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Meal Delivery System for Covid-19 Paitients");
		
		panel = new JPanel();
		panel.setBounds(6, 6, 688, 660);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/* radio buttons of main menues */
		descriptionLabel = new JLabel("Choose Menu for Your Happy Meal");
		descriptionLabel.setFont(new Font("Serif", Font.BOLD, 30));
		descriptionLabel.setBounds(111, 30, 465, 84);
		panel.add(descriptionLabel);
		
		mainMenuLabel = new JLabel("Main Menu");
		mainMenuLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		mainMenuLabel.setBounds(286, 141, 113, 64);
		panel.add(mainMenuLabel);
		
		hamburgerButton = new JRadioButton("Hamburger");
		hamburgerButton.setSelected(true);
		hamburgerButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		hamburgerButton.setBounds(111, 234, 112, 24);
		panel.add(hamburgerButton);
		
		hamburgerPriceLabel = new JLabel("7,000 won");
		hamburgerPriceLabel.setBounds(146, 259, 89, 16);
		panel.add(hamburgerPriceLabel);
		
		sandwichButton = new JRadioButton("Sandwich");
		sandwichButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		sandwichButton.setBounds(286, 234, 112, 24);
		panel.add(sandwichButton);
		
		sandwichPriceLabel = new JLabel("6,000 won");
		sandwichPriceLabel.setBounds(316, 259, 83, 16);
		panel.add(sandwichPriceLabel);
		
		pizzaButton = new JRadioButton("Pizza");
		pizzaButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		pizzaButton.setBounds(464, 234, 112, 24);
		panel.add(pizzaButton);
		
		pizzaPriceLabel = new JLabel("15,000 won");
		pizzaPriceLabel.setBounds(488, 259, 114, 16);
		panel.add(pizzaPriceLabel);
		
		chickenButton = new JRadioButton("Chicken");
		chickenButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		chickenButton.setBounds(111, 376, 112, 24);
		panel.add(chickenButton);
		
		chickenPriceLabel = new JLabel("18,000 won");
		chickenPriceLabel.setBounds(132, 401, 80, 16);
		panel.add(chickenPriceLabel);
		
		gimbapButton = new JRadioButton("Gimbap");
		gimbapButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		gimbapButton.setBounds(286, 376, 112, 24);
		panel.add(gimbapButton);
		
		gimbapPriceLabel = new JLabel("4,000 won");
		gimbapPriceLabel.setBounds(316, 401, 66, 16);
		panel.add(gimbapPriceLabel);
		
		ramenButton = new JRadioButton("Ramen");
		ramenButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		ramenButton.setBounds(464, 376, 112, 24);
		panel.add(ramenButton);
		
		ramenPriceLabel = new JLabel("4,000 won");
		ramenPriceLabel.setBounds(489, 401, 74, 16);
		panel.add(ramenPriceLabel);
		
		jjajangmienButton = new JRadioButton("Jjajangmien");
		jjajangmienButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		jjajangmienButton.setBounds(111, 521, 124, 24);
		panel.add(jjajangmienButton);
		
		JjajangmienPriceLabel = new JLabel("6,000 won");
		JjajangmienPriceLabel.setBounds(143, 546, 80, 16);
		panel.add(JjajangmienPriceLabel);
		
		sushiButton = new JRadioButton("Sushi");
		sushiButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		sushiButton.setBounds(286, 521, 112, 24);
		panel.add(sushiButton);
		
		sushiPriceLabel = new JLabel("10,000 won");
		sushiPriceLabel.setBounds(296, 546, 86, 16);
		panel.add(sushiPriceLabel);
		
		kimchiButton = new JRadioButton("KimchiJjigae");
		kimchiButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		kimchiButton.setBounds(464, 521, 124, 24);
		panel.add(kimchiButton);
		
		kimchiPriceLabel = new JLabel("8,000 won");
		kimchiPriceLabel.setBounds(502, 546, 74, 16);
		panel.add(kimchiPriceLabel);
		
		ButtonGroup mainMenues = new ButtonGroup(); // radio button groups of main menu
		mainMenues.add(hamburgerButton);
		mainMenues.add(sandwichButton);
		mainMenues.add(pizzaButton);
		mainMenues.add(chickenButton);
		mainMenues.add(gimbapButton);
		mainMenues.add(ramenButton);
		mainMenues.add(jjajangmienButton);
		mainMenues.add(sushiButton);
		mainMenues.add(kimchiButton);
		
		nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener() {
			/*
			 * if button pressed, save selected menu and change to order complete window
			 */
			public void actionPerformed(ActionEvent e) {
				Enumeration<AbstractButton> enums = mainMenues.getElements();
				while (enums.hasMoreElements()) {
					AbstractButton button = enums.nextElement();
					
					if (((JRadioButton)button).isSelected()) {
						userSelectedMainMenu = ((JRadioButton)button).getText();
					}
				}
				
				user.setMain(new MainFood(getFoodTypeFromMenuName(userSelectedMainMenu))); // set main menu of user
				sideOrderpane = new SideOrderPane(user);
				sideOrderpane.setVisible(true); // show the next page
				setVisible(false); // close current window
			}
		});
		nextButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		nextButton.setBounds(523, 590, 159, 64);
		panel.add(nextButton);
	}
	
	/** getter for class variable userSelectedMainMenu */
	public String getUserSelectedMainMenu() {
		return this.userSelectedMainMenu;
	}
	
	/** convert String main menu name to enum FoodType */
	public FoodType getFoodTypeFromMenuName(String menu) {
		if (menu.equals("Hamburger")) {
			return FoodType.HAMBURGER;
		} else if (menu.equals("Sandwich")) {
			return FoodType.SANDWICH;
		} else if (menu.equals("Pizza")) {
			return FoodType.PIZZA;
		} else if (menu.equals("Chicken")) {
			return FoodType.CHICKEN;
		} else if (menu.equals("Ramen")) {
			return FoodType.RAMEN;
		} else if (menu.equals("KimchiJjigae")) {
			return FoodType.KIMCHI_JJIGAE;
		} else if (menu.equals("Gimbap")) {
			return FoodType.GIMBAP;
		} else if (menu.equals("Jjajangmien")) {
			return FoodType.JJAJANGMIEN;
		} else if (menu.equals("Sushi")) {
			return FoodType.SUSHI;
		} else {
			return FoodType.NONE;
		}
	}
}
