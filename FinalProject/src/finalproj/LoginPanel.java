package finalproj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.Button;

public class LoginPanel {

	private JFrame frame;
	private JPanel panel;
	private JLabel welcomeLabel;
	private JLabel description1;
	private JLabel description2;
	private JLabel description3;
	private JTextField nameTextField;
	private JLabel nameLabel;
	private JLabel phoneNumberLabel;
	private JTextField phoneNumberTextField;
	private JLabel addressLabel;
	private JTextField addressTextField;
	private JButton nextButton;
	
	private OrderPanel orderPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel window = new LoginPanel();
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
	public LoginPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Meal Delivery System for Covid-19 Paitients");
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(6, 6, 688, 660);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("WELCOME!");
		welcomeLabel.setBounds(255, 21, 179, 48);
		welcomeLabel.setFont(new Font("Serif", Font.BOLD, 30));
		panel.add(welcomeLabel);
		
		description1 = new JLabel("Order Meals and Drinks!");
		description1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		description1.setBounds(109, 117, 179, 16);
		panel.add(description1);
		
		description2 = new JLabel("The delivery fee is free.");
		description2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		description2.setBounds(405, 151, 168, 16);
		panel.add(description2);
		
		description3 = new JLabel("If you are a COVID-19 patient, a discount will be applied.");
		description3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		description3.setBounds(130, 226, 412, 16);
		panel.add(description3);
		
		/* textfield to get user's name */
		nameTextField = new JTextField();
		nameTextField.setToolTipText("4 ~ 16 characters");
		nameTextField.setBounds(206, 352, 273, 39);
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		nameLabel = new JLabel("Enter your name :");
		nameLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		nameLabel.setBounds(212, 334, 168, 16);
		panel.add(nameLabel);
		
		phoneNumberLabel = new JLabel("Enter your phone number :");
		phoneNumberLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		phoneNumberLabel.setBounds(212, 421, 238, 16);
		panel.add(phoneNumberLabel);
		
		/* textfield to get user's phone number */
		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setToolTipText("000-0000-0000");
		phoneNumberTextField.setColumns(10);
		phoneNumberTextField.setBounds(206, 439, 273, 39);
		panel.add(phoneNumberTextField);
		
		addressLabel = new JLabel("Enter your address :");
		addressLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		addressLabel.setBounds(212, 507, 168, 16);
		panel.add(addressLabel);
		
		/* textfield to get user's address */
		addressTextField = new JTextField();
		addressTextField.setToolTipText("detailed address, city");
		addressTextField.setColumns(10);
		addressTextField.setBounds(206, 525, 273, 39);
		panel.add(addressTextField);
		
		nextButton = new JButton("Let's go");
		nextButton.addActionListener(new ActionListener() {
			/*
			 * if the button is clicked, window will change to order stage
			 */
			public void actionPerformed(ActionEvent e) {
				try {
					checkUserInput(); // check user input
					
					orderPanel = new OrderPanel();
					orderPanel.setVisible(true); // change to new page
					frame.dispose(); // close the login page
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Improper Input", JOptionPane.ERROR_MESSAGE); // pop up error message about user's wrong input
				}
			}
		});
		nextButton.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		nextButton.setBounds(488, 585, 168, 48);
		panel.add(nextButton);
	} /* initialize() end */
	
	/**
	 * method for checking user's inputs
	 * - checking format of user name: if user entered wrong, throws ImproperUserNameException
	 * - checking format of phone number: if user entered wrong, throws ImproperPhoneNumberException
	 * - checking format of address: if user entered wrong, throws ImproperAddressException
	 */
	private void checkUserInput() throws Exception {
		if (!checkName()) {
			throw new ImproperUserNameException();
		} else if (!checkPhoneNumber()) {
			throw new ImproperPhoneNumberException();
		} else if (!checkAddress()) {
			throw new ImproperAddressException();
		}
	}
	
	/**
	 * check user entered name: if user entered wrong, returns false
	 */
	private boolean checkName() {
		if (4 <= nameTextField.getText().length() && nameTextField.getText().length() <= 16) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * check user entered phone number: if user entered wrong, returns false
	 */
	private boolean checkPhoneNumber() {
		/* phone number must be 000-0000-0000 format */
		if (Pattern.matches("[0-9]{3}-[0-9]{4}-[0-9]{4}", phoneNumberTextField.getText())) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * check user entered address: if user entered wrong, returns false
	 */
	private boolean checkAddress() {
		if (addressTextField.getText().contains(",")) {
			return true;
		} else {
			return false;
		}
	}
}
