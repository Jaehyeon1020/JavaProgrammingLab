import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import java.util.List;
import java.util.ArrayList;

public class StudentEnrollment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel skkuImage;
	private JLabel titleImage;
	private JTextField applicantNameTextField;
	private JLabel aplicantNameLabel;
	private JLabel birthDateLabel;
	private JTextField birthDateTextField;
	private JTextField emailTextField;
	private JLabel emailLabel;
	private JTextField degreeTextField;
	private JLabel degreeLabel;
	private JTextField AttendedUnivTextField;
	private JLabel AttendedUnivLabel;
	private JTextField gpaTextField;
	private JLabel gpaLabel;
	private JLabel personalStatementLable;
	private JTextField personalStatementTextField;
	private JTextField homeAddressTextField;
	private JLabel homeAddressLabel;
	private JButton submitButton;

	private String applicantName; // for storing input of applicantName textfield
	private String birthDate; // for storing input of Birth Date textfield
	private String email; // for storing input of Email textfield
	private String degree; // for storing input of Degree textfield
	private String attendedUniv; // for storing input of Attended University textfield
	private String gpa; // for storing input of GPA textfield
	private String personalStatement; // for storing input of Personal Statement textfield
	private String homeAddress; // for storing input of Home Address textfield

	private List<String> errorMessageList; // for storing error messages

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentEnrollment frame = new StudentEnrollment();
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
	public StudentEnrollment() {
		setTitle("SKKU New Students Enrollment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 895, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		skkuImage = new JLabel("");
		skkuImage.setIcon(new ImageIcon(StudentEnrollment.class.getResource("/images/skku_wallpaper.png")));
		skkuImage.setBounds(17, 6, 228, 555);
		contentPane.add(skkuImage);

		titleImage = new JLabel("");
		titleImage.setIcon(new ImageIcon(StudentEnrollment.class.getResource("/images/title_label.png")));
		titleImage.setBounds(357, 6, 435, 73);
		contentPane.add(titleImage);

		applicantNameTextField = new JTextField();
		applicantNameTextField.setBounds(501, 101, 334, 26);
		contentPane.add(applicantNameTextField);
		applicantNameTextField.setColumns(10);

		aplicantNameLabel = new JLabel("Aplicant Name: ");
		aplicantNameLabel.setBounds(396, 106, 100, 16);
		contentPane.add(aplicantNameLabel);

		birthDateLabel = new JLabel("Birth Date: ");
		birthDateLabel.setBounds(426, 144, 70, 16);
		contentPane.add(birthDateLabel);

		birthDateTextField = new JTextField();
		birthDateTextField.setColumns(10);
		birthDateTextField.setBounds(501, 139, 334, 26);
		contentPane.add(birthDateTextField);

		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(501, 177, 334, 26);
		contentPane.add(emailTextField);

		emailLabel = new JLabel("Email:");
		emailLabel.setBounds(451, 182, 45, 16);
		contentPane.add(emailLabel);

		degreeTextField = new JTextField();
		degreeTextField.setColumns(10);
		degreeTextField.setBounds(501, 215, 334, 26);
		contentPane.add(degreeTextField);

		degreeLabel = new JLabel("Degree:");
		degreeLabel.setBounds(441, 220, 48, 16);
		contentPane.add(degreeLabel);

		AttendedUnivTextField = new JTextField();
		AttendedUnivTextField.setColumns(10);
		AttendedUnivTextField.setBounds(501, 253, 334, 26);
		contentPane.add(AttendedUnivTextField);

		AttendedUnivLabel = new JLabel("Attended University (for Graduates):");
		AttendedUnivLabel.setBounds(268, 258, 228, 16);
		contentPane.add(AttendedUnivLabel);

		gpaTextField = new JTextField();
		gpaTextField.setColumns(10);
		gpaTextField.setBounds(501, 291, 334, 26);
		contentPane.add(gpaTextField);

		gpaLabel = new JLabel("GPA (for Graduates):");
		gpaLabel.setBounds(370, 296, 126, 16);
		contentPane.add(gpaLabel);

		personalStatementLable = new JLabel("Personal Statement");
		personalStatementLable.setBounds(609, 345, 126, 26);
		contentPane.add(personalStatementLable);

		personalStatementTextField = new JTextField();
		personalStatementTextField.setText("At least 100 words...");
		personalStatementTextField.setBounds(501, 383, 334, 89);
		contentPane.add(personalStatementTextField);
		personalStatementTextField.setColumns(10);

		homeAddressTextField = new JTextField();
		homeAddressTextField.setColumns(10);
		homeAddressTextField.setBounds(501, 484, 334, 26);
		contentPane.add(homeAddressTextField);

		homeAddressLabel = new JLabel("Home Address:");
		homeAddressLabel.setBounds(396, 489, 100, 16);
		contentPane.add(homeAddressLabel);

		submitButton = new JButton("Submit Application!");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				errorMessageList = new ArrayList<>();

				applicantName = new String(""); // for storing input of applicantName textfield
				birthDate = new String(""); // for storing input of Birth Date textfield
				email = new String(""); // for storing input of Email textfield
				degree = new String(""); // for storing input of Degree textfield
				attendedUniv = new String(""); // for storing input of Attended University textfield
				gpa = new String(""); // for storing input of GPA textfield
				personalStatement = new String(""); // for storing input of Personal Statement textfield
				homeAddress = new String(""); // for storing input of Home Address textfield

				/*
				 * get texts in textfield. if some exceptions occur, error messages are stored
				 * in errorMessageList
				 */
				try {
					applicantName = getNameField();
				} catch (EmptyNameFieldException | InsufficientNameException err) {
					errorMessageList.add(err.getMessage());
				}

				try {
					birthDate = getBirthDateField();
				} catch (ImproperBirthDateException err) {
					errorMessageList.add(err.getMessage());
				}

				try {
					email = getEmailField();
				} catch (ImproperEmailException err) {
					errorMessageList.add(err.getMessage());
				}

				try {
					degree = getDegreeField();
				} catch (EmptyDegreeException err) {
					errorMessageList.add(err.getMessage());
				}

				/*
				 * if degree is equal to "PhD", the user must fill attended university and gpa
				 * (graduates)
				 */
				if (degree.equals("PhD")) {
					try {
						attendedUniv = getAttendedUniversityField();
					} catch (EmptyAttendedUnivOrGpaException err) {
						errorMessageList.add(err.getMessage());
					}

					try {
						gpa = getGpaField();
					} catch (EmptyAttendedUnivOrGpaException | ImproperGpaException err) {
						errorMessageList.add(err.getMessage());
					}
				}

				try {
					personalStatement = getPersonalStatementField();
				} catch (InsufficientPersonalStatementException err) {
					errorMessageList.add(err.getMessage());
				}

				try {
					homeAddress = getHomeAddressField();
				} catch (ImproperHomeAddressException err) {
					errorMessageList.add(err.getMessage());
				}

				/* the case of No exception occurs */
				if (errorMessageList.size() == 0) {
					JOptionPane.showMessageDialog(null, "Succesfully Submitted", "Success",
							JOptionPane.INFORMATION_MESSAGE); // pop up the success window
				} else {
					boolean isFirstLine = false;
					String errorMessage = new String("");

					/* make all error messages in 1 String variable */
					for (int i = 0; i < errorMessageList.size(); i++) {
						if (!isFirstLine) {
							isFirstLine = true;
							errorMessage = errorMessage + (i + 1) + ". " + errorMessageList.get(i);
						} else {
							errorMessage += "\n";
							errorMessage = errorMessage + (i + 1) + ". " + errorMessageList.get(i);
						}
					}

					JOptionPane.showMessageDialog(null, errorMessage, "You have following problems",
							JOptionPane.ERROR_MESSAGE); // pop up the error message window

					errorMessage = "";
					errorMessageList.clear();
				}
			}
		});
		submitButton.setBounds(672, 522, 163, 39);
		contentPane.add(submitButton);
	} // constructor end

	/* method for get perfect name field data from text field */
	public String getNameField() throws InsufficientNameException, EmptyNameFieldException {
		String name = applicantNameTextField.getText();

		/*
		 * name field has no spacing(for seperate first name) and the field is not blank
		 * -> InsufficientNameException
		 */
		if ((!name.contains(" ")) && name.length() > 0) {
			throw new InsufficientNameException("You forgot to write your name or surname.");
		}
		/* name filed is blank -> EmptyNameFieldException */
		else if (name.length() == 0) {
			throw new EmptyNameFieldException("You forgot to fill the name text field, Please fill it.");
		}

		return name;
	}

	/* method for get perfect birth date data from text field */
	public String getBirthDateField() throws ImproperBirthDateException {
		String birthDate = birthDateTextField.getText();

		/*
		 * birthDate field is blank -> Exception with error message that user to know
		 * the field is blank
		 */
		if (birthDate.length() == 0) {
			throw new ImproperBirthDateException("You forgot to fill the birth date text field, Please fill it.");
		}
		/*
		 * birthDate filed has no "/" character -> Exception with error message that
		 * user to know there is improper format of birth date
		 */
		else if (!birthDate.contains("/")) {
			throw new ImproperBirthDateException("Birthdate must be 06/03/1993 format");
		}

		return birthDate;
	}

	/* method for get Email field */
	public String getEmailField() throws ImproperEmailException {
		String email = emailTextField.getText();

		if (!email.contains("@")) {
			if (!email.contains(".")) {
				throw new ImproperEmailException("Email must be someone@some.some");
			}
		}

		return email;
	}

	/* method for get Degree field */
	public String getDegreeField() throws EmptyDegreeException {
		String degree = degreeTextField.getText();

		if (degree.length() == 0) {
			throw new EmptyDegreeException("You forgot to fill the degree text field, Please fill it.");
		}

		return degree;
	}

	/* method for get Attended University field */
	public String getAttendedUniversityField() throws EmptyAttendedUnivOrGpaException {
		String attendedUniv = AttendedUnivTextField.getText();

		if (attendedUniv.length() == 0) {
			throw new EmptyAttendedUnivOrGpaException(
					"You forgot to fill the attended university text field, Please fill it.");
		}

		return attendedUniv;
	}

	/* method for get GPA field */
	public String getGpaField() throws EmptyAttendedUnivOrGpaException, ImproperGpaException {
		String gpa = gpaTextField.getText();

		if (gpa.length() == 0) {
			throw new EmptyAttendedUnivOrGpaException("You forgot to fill the GPA text field, Please fill it.");
		} else if (Double.parseDouble(gpa) < 0 || Double.parseDouble(gpa) > 4.5) {
			throw new ImproperGpaException("GPA must be between 0 and 4.5.");
		}

		return gpa;
	}

	/* method for get personal statement field */
	public String getPersonalStatementField() throws InsufficientPersonalStatementException {
		String personalStatement = personalStatementTextField.getText();
		String temp = new String(personalStatementTextField.getText());
		int spacingCount = personalStatement.length() - temp.replace(" ", "").length();

		if (spacingCount < 99) {
			throw new InsufficientPersonalStatementException("Your personal Statement must be at least 100 words");
		}

		return personalStatement;
	}

	/* method for get home address field */
	public String getHomeAddressField() throws ImproperHomeAddressException {
		String homeAddress = homeAddressTextField.getText();
		String temp = new String(homeAddressTextField.getText());
		int dotCount = homeAddress.length() - temp.replace(",", "").length();

		if (dotCount != 3) {
			throw new ImproperHomeAddressException("Home address must be in 'number, street, district, city' format.");
		}

		return homeAddress;
	}

}

/* this exception occurs when user entered insufficient name */
class InsufficientNameException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InsufficientNameException(String message) {
		super(message);
	}
}

/* this exception occurs when user leaves the name text field empty */
class EmptyNameFieldException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmptyNameFieldException(String message) {
		super(message);
	}
}

/* this exception occurs when user entered improper birth date format */
class ImproperBirthDateException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ImproperBirthDateException(String message) {
		super(message);
	}
}

/* this exception occurs when user entered improper email address format */
class ImproperEmailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ImproperEmailException(String message) {
		super(message);
	}
}

/*
 * this exception occurs when a graduate user leaves attended university field
 * or GPA field empty
 */
class EmptyAttendedUnivOrGpaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmptyAttendedUnivOrGpaException(String message) {
		super(message);
	}
}

/*
 * this exception occurs when user entered under 100 words in personal statement
 * field
 */
class InsufficientPersonalStatementException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InsufficientPersonalStatementException(String message) {
		super(message);
	}
}

/* this exception occurs when user entered improper GPA number */
class ImproperGpaException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ImproperGpaException(String message) {
		super(message);
	}
}

/* this exception occurs when user entered improper home address */
class ImproperHomeAddressException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ImproperHomeAddressException(String message) {
		super(message);
	}
}

/* this exception occurs when user leaves degree field empty */
class EmptyDegreeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmptyDegreeException(String message) {
		super(message);
	}
}
