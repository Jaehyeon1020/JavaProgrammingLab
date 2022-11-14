import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class lucas extends JFrame {

	private JPanel contentPane;
	private JPanel topPanel;
	private JLabel descriptionLabel;
	private JTextField userInputTextField;
	private JButton startButton;
	private JButton cancelButton;
	private JPanel bottomPanel;
	private JProgressBar progressBar;
	private JLabel sumLabel;
	private JScrollPane scrollPane;
	private JTextPane textPane;
	
	private String userInput; // for storing user input number of lucas calculation
	private int userNumber; // for storing converted value of userInput (String to int)
	private int previousLucas = 2; // for storing previous number of lucas calculation
	private int currentLucas = 1; // for storing the latest number of lucas calculation
	private int sum = 2; // for storing sum of all values in the progress of lucas calculation
	private boolean isCanceled; // for judge if cancel button is pressed

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lucas frame = new lucas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public lucas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		descriptionLabel = new JLabel("Number of row in Lucas series:"); // label for indicate what user should enter in the textfield
		topPanel.add(descriptionLabel);
		
		userInputTextField = new JTextField();
		topPanel.add(userInputTextField);
		userInputTextField.setColumns(5);
		
		startButton = new JButton("Get sum of Lucas series"); // button for starting lucas calculation
		startButton.addActionListener(new ActionListener() {
			/*
			 * actions when clicking this button:
			 * 1. enable the cancel button
			 * 2. get user input from text field
			 * 3. do lucas calculation and update center textpane
			 * 4. disable the cancel button after doing all job
			 */
			public void actionPerformed(ActionEvent e) {
				cancelButton.setEnabled(true); // enable the cancel button
				isCanceled = false;
				
				try {
					userInput = getUserInput(userInputTextField); // get user input
					userNumber = Integer.parseInt(userInput); // convert user input string to integer
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Enter valid input!", "ERROR", JOptionPane.ERROR_MESSAGE); // if user entered worng value, error message pop up
					return;
				}
				
				/* SwingWorker for update content of center textpane by calculating lucas */
				SwingWorker<Void, Void> lucasUpdater = new SwingWorker<Void, Void>() {
					@Override
					protected Void doInBackground() throws Exception {
						int temp = 0;
						sum = 2;
						currentLucas = 1;
						previousLucas = 2;
						
						String lucasProgress = "";
						
						/* prints the progress of lucas calculation */
						lucasProgress += previousLucas + "\n";
						textPane.setText(lucasProgress);
						for (int i = 0; i < userNumber - 1; i++) {
							/* if cancel button pressed, stop processing */
							if (isCanceled == true) {
								return null;
							}
							
							Thread.sleep(100);
							
							lucasProgress += currentLucas + "\n";
							textPane.setText(lucasProgress);
							sum += currentLucas;
							sumLabel.setText("sum = " + sum); // change sum value
								
							/* set new current lucas number to the sum of current number + previous number */
							temp = currentLucas + previousLucas;
							previousLucas = currentLucas;
							currentLucas = temp;
						}
						cancelButton.setEnabled(false);
							
						return null;
					}
					
					@Override
					protected void done() {
						FileWriter writer;
						try {
							writer = new FileWriter("lucas.txt", true); // store the content to lucas.txt file
							writer.write(textPane.getText());
							writer.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
					}
				}; /* end lucasUpdater */
				
				/* SwingWorker for progress bar */
				SwingWorker<Void, Void> progressBarSetter = new SwingWorker<Void, Void>() {
					@Override
					protected Void doInBackground() throws Exception {
						/* progress bar grows depend on the amount of prints of lucas numbers */
						for (int i = 0; i <= 100; i += 100 / userNumber) {
							/* if cancel button pressed, stop processing */
							if (isCanceled == true) {
								return null;
							}
							
							progressBar.setValue(i);
							Thread.sleep(100);
						}
						
						return null;
					}
					
					@Override
					protected void done() {
						if (isCanceled == false) {
							progressBar.setValue(100);
						}
					}
				}; /* end progressBar */
				
				lucasUpdater.execute();
				progressBarSetter.execute();
				
			} /* end actionPerformed */
		}); /* end startButton */
		
		topPanel.add(startButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setEnabled(false); // set cancel button disabled before the calculation starts
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isCanceled = true;
			}
		});
		topPanel.add(cancelButton);
		
		bottomPanel = new JPanel();
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setToolTipText("");
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		bottomPanel.add(progressBar, BorderLayout.CENTER);
		
		sumLabel = new JLabel("sum = 0");
		bottomPanel.add(sumLabel, BorderLayout.EAST);
		
		textPane = new JTextPane();
		scrollPane = new JScrollPane(textPane);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
	} /* end constructor */
	
	/**
	 * get user input from text field
	 * if user enters wrong input, this method throws an exception
	 */
	private String getUserInput(JTextField userInputTextField) throws Exception {
		String userInput = userInputTextField.getText();
		
		try {
			checkInteger(userInput);
			
			if (Integer.parseInt(userInput) < 3 || Integer.parseInt(userInput) > 20) {
				throw new Exception();
			}
			
			return userInput;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * if input has a form of integer, nothing happens but if it is not a form of integer, throws exception
	 */
	private void checkInteger(String input) throws Exception {
		try {
			Integer.parseInt(input);
		} catch (Exception e) {
			throw e;
		}
	}
}
