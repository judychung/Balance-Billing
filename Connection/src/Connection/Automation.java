package Connection;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Automation {
	private static JFrame frame;
	private static JTextField usernameField;
    private static JPasswordField passwordField;
    JButton loginButton;
    static int count = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					Automation window = new Automation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					StringWriter sw = new StringWriter();
		            PrintWriter pw = new PrintWriter(sw);
		            e.printStackTrace(pw);
		            Automation.printError(sw.toString());
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Automation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("CHIS US Control Point Automation");
		frame.setBounds(100, 100, 300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		usernameField = new JTextField();
		usernameField.setColumns(10);
		
		JLabel username = new JLabel("Username");
		
		passwordField = new JPasswordField();

		JLabel password = new JLabel("Password");

		loginButton = new JButton("Login");
		frame.getRootPane().setDefaultButton(loginButton); // makes pressing Enter key = clicking Login button

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent E) {
				try {		
//				    new Thread(() -> { // threads help to run PokFTP and SbyFTP simultaneously
//						try {
//							pmain();
//						} catch (Exception e) {
//							StringWriter sw = new StringWriter();
//				            PrintWriter pw = new PrintWriter(sw);
//				            e.printStackTrace(pw);
//				            Automation.printError(sw.toString());
//						}
//					}).start();
//					new Thread(() -> {
//						try {
//							smain();
//						} catch (Exception e) {
//							StringWriter sw = new StringWriter();
//				            PrintWriter pw = new PrintWriter(sw);
//				            e.printStackTrace(pw);
//				            Automation.printError(sw.toString());
//						}
//					}).start();
					pmain();
					smain();
				} catch (Exception e) {
					StringWriter sw = new StringWriter();
		            PrintWriter pw = new PrintWriter(sw);
		            e.printStackTrace(pw);
		            Automation.printError(sw.toString());
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(username))
						.addComponent(password))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(usernameField))
					.addContainerGap(37, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(116, Short.MAX_VALUE)
					.addComponent(loginButton)
					.addGap(105))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(username))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(password)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(loginButton)
					.addContainerGap(196, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

	PokFTP pokftp = new PokFTP();
    public void pmain() throws Exception {
        pokftp.main(null);
    }
    
    SbyFTP sbyftp = new SbyFTP();
    public void smain() throws Exception {
    	sbyftp.main(null);
    }

	public static void printUserPassMessage() {
		JOptionPane.showMessageDialog(frame, "Username or password is incorrect");
	}
	
	public static void printLoggedInMessage() {
		JOptionPane.showMessageDialog(frame, "Logged in successfully");
	}
	
	public static void printDoneMessage() {
		JOptionPane.showMessageDialog(frame, "Done! Open Excel and press CTRL+ALT+F9 to refresh");
	}
	
	public static void printFileNotFound() {
		if (count == 0) {
			JOptionPane.showMessageDialog(frame, "Balance Billing Test Review.xls not in home directory");
			count++;
		}
	}
	
	public static void printError(String s) {
		JOptionPane.showMessageDialog(frame, s);
	}

	public static String getUsername() {
		return usernameField.getText();
	}
	
	public static String getPassword() {
		return new String(passwordField.getPassword());
	}
}