package finalproj;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class SideOrderPane extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel descriptionLabel;
	private JLabel sideMenuLabel;
	private JRadioButton noneButton;
	private JRadioButton frenchFriesButton;
	private JLabel frenchFriesPriceLabel;
	private JRadioButton cheeseStickButton;
	private JLabel cheeseStickPriceLabel;
	private JButton nextButton;
	private JRadioButton friedRiceButton;
	private JLabel friedRicePriceLabel;
	
	private String userSelectedSideMenu; // for storing user selected side menu
	private BeverageOrderPane beverageOrderPane; // beverage order pane: next to side order page

	/**
	 * Create the frame.
	 */
	public SideOrderPane(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(6, 6, 688, 660);
		contentPane.add(panel);
		panel.setLayout(null);
		
		setTitle("Meal Delivery System for Covid-19 Paitients");
		
		descriptionLabel = new JLabel("Choose Menu for Your Happy Meal");
		descriptionLabel.setFont(new Font("Serif", Font.BOLD, 30));
		descriptionLabel.setBounds(111, 30, 465, 84);
		panel.add(descriptionLabel);
		
		sideMenuLabel = new JLabel("Side Menu");
		sideMenuLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		sideMenuLabel.setBounds(286, 141, 113, 64);
		panel.add(sideMenuLabel);
		
		noneButton = new JRadioButton("No Side Menu");
		noneButton.setSelected(true);
		noneButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		noneButton.setBounds(111, 269, 146, 24);
		panel.add(noneButton);
		
		frenchFriesButton = new JRadioButton("French Fries");
		frenchFriesButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		frenchFriesButton.setBounds(452, 269, 132, 24);
		panel.add(frenchFriesButton);
		
		frenchFriesPriceLabel = new JLabel("4,000 won");
		frenchFriesPriceLabel.setBounds(487, 293, 66, 16);
		panel.add(frenchFriesPriceLabel);
		
		cheeseStickButton = new JRadioButton("Cheese Stick");
		cheeseStickButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cheeseStickButton.setBounds(111, 445, 124, 24);
		panel.add(cheeseStickButton);
		
		cheeseStickPriceLabel = new JLabel("2,000 won");
		cheeseStickPriceLabel.setBounds(147, 472, 80, 16);
		panel.add(cheeseStickPriceLabel);
		
		friedRiceButton = new JRadioButton("Fried Rice");
		friedRiceButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		friedRiceButton.setBounds(452, 447, 112, 24);
		panel.add(friedRiceButton);
		
		friedRicePriceLabel = new JLabel("5,000 won");
		friedRicePriceLabel.setBounds(484, 472, 89, 16);
		panel.add(friedRicePriceLabel);
		
		ButtonGroup sideMenues = new ButtonGroup(); // radio button groups of side menu
		sideMenues.add(cheeseStickButton);
		sideMenues.add(frenchFriesButton);
		sideMenues.add(friedRiceButton);
		sideMenues.add(noneButton);
		
		nextButton = new JButton("NEXT");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enumeration<AbstractButton> enums = sideMenues.getElements();
				while (enums.hasMoreElements()) {
					AbstractButton button = enums.nextElement();
					
					if (((JRadioButton)button).isSelected()) {
						userSelectedSideMenu = ((JRadioButton)button).getText();
					}
				}
				
				user.setSide(new SideFood(getFoodTypeFromMenuName(userSelectedSideMenu))); // set side menu of user
				beverageOrderPane = new BeverageOrderPane(user);
				beverageOrderPane.setVisible(true); // show the next page
				setVisible(false); // close current window
			}
		});
		nextButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		nextButton.setBounds(523, 590, 159, 64);
		panel.add(nextButton);
	}

	/** getter for class variable userSelectedSideMenu */
	public String getUserSelectedSideMenu() {
		return this.userSelectedSideMenu;
	}
	
	/** convert String side menu name to enum FoodType */
	public FoodType getFoodTypeFromMenuName(String menu) {
		if (menu.equals("French Fries")) {
			return FoodType.FRENCH_FRIES;
		} else if (menu.equals("Cheese Stick")) {
			return FoodType.CHEESE_STICK;
		} else if (menu.equals("Fried Rice")) {
			return FoodType.FRIED_RICE;
		} else {
			return FoodType.NONE;
		}
	}
}
