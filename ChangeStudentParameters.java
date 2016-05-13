import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ChangeStudentParameters extends JFrame {

	private static final int WIDTH = 360;
	private static final int HEIGHT = 370;
	private static JLabel student;
	private static JComboBox<String> studenci;
	private static JLabel imie;
	private static JLabel nazwisko;
	private static JLabel email;
	private static JLabel telefon;
	private static JTextField imieText;
	private static JTextField nazwiskoText;
	private static JTextField emailText;
	private static JTextField telefonText;
	private static String[] tabela;
	private static JButton zmien;
	private static JButton wyjdz;

	public static JTextField getImieText() {
		return imieText;
	}

	public static void setImieText(JTextField imieText) {
		ChangeStudentParameters.imieText = imieText;
	}

	public static JTextField getNazwiskoText() {
		return nazwiskoText;
	}

	public static void setNazwiskoText(JTextField nazwiskoText) {
		ChangeStudentParameters.nazwiskoText = nazwiskoText;
	}

	public static JTextField getEmailText() {
		return emailText;
	}

	public static void setEmailText(JTextField emailText) {
		ChangeStudentParameters.emailText = emailText;
	}

	public static JTextField getTelefonText() {
		return telefonText;
	}

	public static void setTelefonText(JTextField telefonText) {
		ChangeStudentParameters.telefonText = telefonText;
	}

	public ChangeStudentParameters() {
		super("Zmiana danych studenta");
		initGUI();
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

	}

	private void initGUI() {
		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		student = new JLabel("Student");
		student.setFont(new Font("Serif", Font.BOLD, 20));
		studenci = new JComboBox<String>();
		tabela = new String[JDBCConnection.queryStudents().size()];

		// wype³niam tabele
		for (int i = 0; i < JDBCConnection.queryStudents().size(); i++) {
			tabela[i] = (String) JDBCConnection.queryStudents().get(i);

		}

		// wrzucam w ComboBox'a
		for (int i = 0; i < tabela.length; i++) {
			studenci.addItem(tabela[i]);
		}
		studenci.setSelectedIndex(-1);

		add(student);
		add(studenci);

		imie = new JLabel("Imie: ");
		nazwisko = new JLabel("Naziwsko: ");
		email = new JLabel("Email: ");
		telefon = new JLabel("Telefon: ");
		imieText = new JTextField(30);
		nazwiskoText = new JTextField(30);
		emailText = new JTextField(30);
		telefonText = new JTextField(30);
		wyjdz = new JButton("Wyjdz");
		zmien = new JButton("Zmieñ");

		imie.setFont(new Font("Serif", Font.BOLD, 16));
		nazwisko.setFont(new Font("Serif", Font.BOLD, 16));
		email.setFont(new Font("Serif", Font.BOLD, 16));
		telefon.setFont(new Font("Serif", Font.BOLD, 16));

		add(imie);
		add(imieText);
		add(nazwisko);
		add(nazwiskoText);
		add(email);
		add(emailText);
		add(telefon);
		add(telefonText);
		add(zmien);
		add(wyjdz);
		pack();

		wyjdz.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		
		zmien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				JDBCConnection.makeConnection();
				try{
				int id = new Integer(JDBCConnection.findId(studenci));
				JDBCConnection.changeStudentParameters(id);
				dispose();} 
				catch (Exception ups){
					System.out.println("Wybierz studenta!");
				}
			} 
		});

	}
}
