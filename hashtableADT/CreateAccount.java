package hashtableADT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateAccount extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textAccount;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private String fileName = "input.txt";
	private String accountname;
	private String password;
	private String confirmpass;
	Hashtable<String, String> a = new Hashtable<String, String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount windown = new CreateAccount();
					windown.readText();
					windown.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateAccount() {
		initialize();
		setLocationRelativeTo(null);
	}
	public void run (){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccount windown = new CreateAccount();
					windown.readText();
					windown.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Create account");
		frame.setBounds(100, 100, 498, 310);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 27));
		lblNewLabel.setBounds(280, 10, 192, 38);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Account Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 82, 114, 30);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 138, 114, 30);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Confirm Password");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 192, 114, 30);
		frame.getContentPane().add(lblNewLabel_1_2);

		textAccount = new JTextField();
		textAccount.setBounds(132, 86, 288, 26);
		frame.getContentPane().add(textAccount);
		textAccount.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(132, 138, 288, 26);
		frame.getContentPane().add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(132, 192, 288, 26);
		frame.getContentPane().add(passwordField_1);

		JButton btnNewButton = new JButton("Creat");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateAccount cre = new CreateAccount();
				accountname = textAccount.getText();
				password = String.valueOf(passwordField.getPassword());
				confirmpass = String.valueOf(passwordField_1.getPassword());
				if (password.equals(confirmpass)) {
					cre.writeText(accountname, password);
					JOptionPane.showMessageDialog(null, "Success");
				} else {
					JOptionPane.showMessageDialog(null, "ERROR !");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(379, 235, 93, 26);
		frame.getContentPane().add(btnNewButton);

		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				Login gra = new Login();
				gra.run();
				gra.pack();
				gra.setLocationRelativeTo(null);
				gra.dispose();
			}
		});
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnLogin.setForeground(new Color(34, 139, 34));
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogin.setBounds(276, 235, 93, 26);
		frame.getContentPane().add(btnLogin);
		frame.setLocationRelativeTo(null);

	}

	public void writeText(String acc, String passw) {

		try {
			FileWriter fw = new FileWriter(new File(fileName), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(acc + "\n");
			bw.write(a.hashfuction(passw) + "\n");
			bw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readText() { // tôi có nhét cái read text vào đây để đọc với nhaạp
		try {
			Scanner scan = new Scanner(new File(fileName));
			while (scan.hasNext()) {
				// scan.nextLine();
				String account = scan.nextLine();
				String password = scan.nextLine();
				a.insert(account, password);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
