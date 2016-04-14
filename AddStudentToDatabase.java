import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddStudentToDatabase extends JDialog {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 250;
	private static JLabel imie;
	private static JLabel nazwisko;
	private static JLabel email;
	private static JLabel telefon;
	private static JTextField imieText;
	private static JTextField nazwiskoText;
	private static JTextField emailText;
	private static JTextField telefonText;
	private JButton dodaj;
	private JButton wyjdz;

	public static JTextField getImieText() {
		return imieText;
	}

	public static void setImieText(JTextField imieText) {
		AddStudentToDatabase.imieText = imieText;
	}

	public static JTextField getNazwiskoText() {
		return nazwiskoText;
	}

	public static void setNazwiskoText(JTextField nazwiskoText) {
		AddStudentToDatabase.nazwiskoText = nazwiskoText;
	}

	public static JTextField getEmailText() {
		return emailText;
	}

	public static void setEmailText(JTextField emailText) {
		AddStudentToDatabase.emailText = emailText;
	}

	public static JTextField getTelefonText() {
		return telefonText;
	}

	public static void setTelefonText(JTextField telefonText) {
		AddStudentToDatabase.telefonText = telefonText;
	}

	public AddStudentToDatabase() {
		initGUI();
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
	}

	private void initGUI() {
		GridLayout layout = new GridLayout(5, 2);

		imie = new JLabel("Imie");
		nazwisko = new JLabel("Nazwisko");
		email = new JLabel("Email");
		telefon = new JLabel("Telefon");
		imieText = new JTextField();
		nazwiskoText = new JTextField();
		emailText = new JTextField();
		telefonText = new JTextField();
		dodaj = new JButton("dodaj");
		wyjdz = new JButton("Zakoñcz");
		

		setLayout(layout);
		setTitle("Dodaj studenta!");

		add(imie);
		add(imieText);
		add(nazwisko);
		add(nazwiskoText);
		add(email);
		add(emailText);
		add(telefon);
		add(telefonText);
		add(dodaj);
		add(wyjdz);
		pack();

		wyjdz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDBCConnection.makeConnection();
				JDBCConnection.addStudentToDatabase();
				dispose();
			}
		});

	}

}
