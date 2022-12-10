package finalproj;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.SwingWorker;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class BeverageOrderPane extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel descriptionLabel;
	private JLabel beverageLabel;
	private JRadioButton waterButton;
	private JRadioButton cokeButton;
	private JLabel cokePriceLabel;
	private JButton nextButton;
	private JRadioButton greenTeaButton;
	private JLabel greenTeaPriceLabel;
	private JRadioButton orangeJuiceButton;
	private JLabel orangeJuicePriceLabel;
	private JRadioButton lemonAdeButton;
	private JLabel lemonadePriceLabel;
	private JRadioButton sodaButton;
	private JLabel sodaPriceLabel;
	
	private String userSelectedBeverage; // for storing user selected beverage
	private ReceiptPane receiptPane; // ReceiptPane: next to beverage order page
	private JProgressBar orderProgressBar;
	private JLabel progressBarLabel;

	/**
	 * Create the frame.
	 */
	public BeverageOrderPane(User user) {
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
		
		beverageLabel = new JLabel("Beverages");
		beverageLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		beverageLabel.setBounds(286, 141, 113, 64);
		panel.add(beverageLabel);
		
		waterButton = new JRadioButton("Water");
		waterButton.setSelected(true);
		waterButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		waterButton.setBounds(133, 267, 80, 24);
		panel.add(waterButton);
		
		cokeButton = new JRadioButton("Coke");
		cokeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cokeButton.setBounds(133, 482, 68, 24);
		panel.add(cokeButton);
		
		cokePriceLabel = new JLabel("2,000 won");
		cokePriceLabel.setBounds(157, 509, 80, 16);
		panel.add(cokePriceLabel);
		
		greenTeaButton = new JRadioButton("Green Tea");
		greenTeaButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		greenTeaButton.setBounds(133, 369, 124, 24);
		panel.add(greenTeaButton);
		
		greenTeaPriceLabel = new JLabel("1,000 won");
		greenTeaPriceLabel.setBounds(157, 396, 80, 16);
		panel.add(greenTeaPriceLabel);
		
		orangeJuiceButton = new JRadioButton("Orange Juice");
		orangeJuiceButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		orangeJuiceButton.setBounds(452, 369, 124, 24);
		panel.add(orangeJuiceButton);
		
		orangeJuicePriceLabel = new JLabel("2,000 won");
		orangeJuicePriceLabel.setBounds(484, 396, 80, 16);
		panel.add(orangeJuicePriceLabel);
		
		lemonAdeButton = new JRadioButton("Lemonade");
		lemonAdeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lemonAdeButton.setBounds(452, 482, 124, 24);
		panel.add(lemonAdeButton);
		
		lemonadePriceLabel = new JLabel("2,500 won");
		lemonadePriceLabel.setBounds(484, 509, 80, 16);
		panel.add(lemonadePriceLabel);
		
		sodaButton = new JRadioButton("Soda");
		sodaButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		sodaButton.setBounds(452, 267, 80, 24);
		panel.add(sodaButton);
		
		sodaPriceLabel = new JLabel("2,000 won");
		sodaPriceLabel.setBounds(472, 294, 80, 16);
		panel.add(sodaPriceLabel);
		
		ButtonGroup beverages = new ButtonGroup(); // radio button groups of beverages
		beverages.add(cokeButton);
		beverages.add(greenTeaButton);
		beverages.add(lemonAdeButton);
		beverages.add(orangeJuiceButton);
		beverages.add(sodaButton);
		beverages.add(waterButton);
		
		progressBarLabel = new JLabel("Processing your order");
		progressBarLabel.setBounds(43, 585, 137, 16);
		panel.add(progressBarLabel);
		
		nextButton = new JButton("ORDER");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Enumeration<AbstractButton> enums = beverages.getElements();
				while (enums.hasMoreElements()) {
					AbstractButton button = enums.nextElement();
					
					if (((JRadioButton)button).isSelected()) {
						userSelectedBeverage = ((JRadioButton)button).getText();
					}
				}
				user.setBeverage(new BeverageFood(getFoodTypeFromMenuName(userSelectedBeverage)));
				
				/* progressbar indicates progress rate to user */
				final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
		            @Override
		            protected Void doInBackground() throws Exception {
		                for (int i = 0; i <= 100; i++) {
		                    orderProgressBar.setValue(i);
		                    orderProgressBar.setString(i + "%");
		                    try {
		                        Thread.sleep(20);
		                    } catch (InterruptedException ex) { }
		                }
		                
		                return null;
		            }
		            
		            @Override
		            protected void done() {
		            	/* when the progress rate reaches 100 percent, go to the next page */
		                receiptPane = new ReceiptPane(user);
						receiptPane.setVisible(true); // show the next page
						setVisible(false); // close current window
		            }
		        };
		        worker.execute();
			}
		});
		
		orderProgressBar = new JProgressBar();
		orderProgressBar.setStringPainted(true);
		orderProgressBar.setBounds(43, 613, 446, 20);
		orderProgressBar.setString("0%");
		panel.add(orderProgressBar);
		
		nextButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		nextButton.setBounds(523, 590, 159, 64);
		panel.add(nextButton);
	}
	
	/** convert String beverage name to enum FoodType */
	public FoodType getFoodTypeFromMenuName(String menu) {
		if (menu.equals("Water")) {
			return FoodType.WATER;
		} else if (menu.equals("Green Tea")) {
			return FoodType.GREEN_TEA;
		} else if (menu.equals("Coke")) {
			return FoodType.COKE;
		} else if (menu.equals("Soda")) {
			return FoodType.SODA;
		} else if (menu.equals("Orange Juice")) {
			return FoodType.ORANGE_JUICE;
		} else if (menu.equals("Lemonade")) {
			return FoodType.LEMONADE;
		} else {
			return FoodType.NONE;
		}
	}
}
