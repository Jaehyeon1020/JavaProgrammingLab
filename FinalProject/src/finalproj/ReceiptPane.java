package finalproj;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReceiptPane extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton closeButton;
	private JLabel descriptionLabel;
	private JTextPane textPane;
	private JButton saveButton;
	
	private Receipt receipt; // Receipt class instance to show order history and user information

	/**
	 * Create the frame.
	 */
	public ReceiptPane(User user) {
		/* if user is covid patient, receipt will display information about discount for patients */
		if (user.getIsCovidPatient() == true) {
			receipt = new PatientReceipt(user);
		} else {
			receipt = new Receipt(user);
		}
		
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
		
		descriptionLabel = new JLabel("Thank You for Your Order");
		descriptionLabel.setFont(new Font("Serif", Font.BOLD, 30));
		descriptionLabel.setBounds(165, 30, 356, 84);
		panel.add(descriptionLabel);
		
		textPane = new JTextPane();
		textPane.setBounds(186, 143, 325, 374);
		textPane.setText(receipt.getReceipt());
		textPane.setEditable(false);
		panel.add(textPane);
		
		closeButton = new JButton("CLOSE");
		closeButton.addActionListener(new ActionListener() {
			/* when close button pressed, dispose current window */
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closeButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		closeButton.setBounds(523, 590, 159, 64);
		panel.add(closeButton);
		
		saveButton = new JButton("SAVE RECEIPT to TXT FILE");
		saveButton.addActionListener(new ActionListener() {
			/* when save button pressed,save the contents of the receipt as a txt file */
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedWriter receiptMaker = new BufferedWriter(new FileWriter("Receipt.txt", true));
					receiptMaker.write(textPane.getText());
					JOptionPane.showMessageDialog(null, "Save success", "", JOptionPane.INFORMATION_MESSAGE);
					receiptMaker.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		saveButton.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		saveButton.setBounds(279, 590, 232, 64);
		panel.add(saveButton);
	}
}
