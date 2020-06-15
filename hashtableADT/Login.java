package hashtableADT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	static String accountName;
	static String password;
	static String fileName = "input.txt";
	Hashtable<String, String> a = new Hashtable<String, String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
//					window.writeText("abc", "123");
					window.readText();
					// window.a.search("du");
					// System.out.println(window.a.search("0"));
//					System.out.println(window.a.search("123"));
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
	public Login() {
		initialize();
	}
	public void run (){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
//					window.writeText("abc", "123");
					window.readText();
					// window.a.search("du");
					// System.out.println(window.a.search("0"));
//					System.out.println(window.a.search("123"));
					window.frame.setVisible(true);
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
		frame.setBounds(100, 100, 466, 309);
		frame.setTitle("Login system");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 43));
		lblNewLabel.setBounds(173, 24, 122, 51);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Account");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 99, 78, 35);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(10, 153, 78, 35);
		frame.getContentPane().add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setBounds(99, 101, 326, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(98, 152, 327, 35);
		frame.getContentPane().add(passwordField);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountName = textField.getText();
				password = String.valueOf(passwordField.getPassword()); //lấy pass từ chuỗi nhập vào trong giao diện
				String pas = String.valueOf(a.hashfuction(password));
				
				if(a.search(accountName).equals(pas)){
					JOptionPane.showMessageDialog(null, "Success");
				}else {
					JOptionPane.showMessageDialog(null, "ERROR!");
				}
				// if (a.search(String.valueOf(a.hashfuction(password))).equals(accountName)) {
				// 	JOptionPane.showMessageDialog(null, "Success");
				// } else {
				// 	JOptionPane.showMessageDialog(null, "ERROR!");
				// }
				// key = pass
				// value = account
			}
		});
		btnLogin.setBounds(340, 213, 85, 35);
		frame.getContentPane().add(btnLogin);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				CreateAccount cre = new CreateAccount();
				cre.run();
				cre.pack();
				cre.setLocationRelativeTo(null);
				cre.dispose();
			}
		});

		btnCreate.setBounds(255, 213, 85, 35);
		frame.getContentPane().add(btnCreate);
	}

	public void readText() {
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
//	public void writeText(String acc, String passw) {
//
//		try {
//			FileWriter fw = new FileWriter(new File(fileName), true) ;
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(acc +"\n");
//			bw.write(a.hashfuction(passw) +"\n");
//			bw.close();
//			fw.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
