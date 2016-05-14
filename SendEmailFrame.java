import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SendEmailFrame extends JFrame {

	private static final int WIDTH = 360;
	private static final int HEIGHT = 370;
	private static JLabel student;
	private static JComboBox<String> studenci;
	private static JButton wyslij;
	private static JButton wyjdz;
	private static JLabel wiadomosc;
	private static JTextArea textArea;
	private static String[] tabela;
	private static JTextField textField;
	private static JButton pobierzEmail;
	
	public static JLabel getStudent() {
		return student;
	}
	public static void setStudent(JLabel student) {
		SendEmailFrame.student = student;
	}
	public static JComboBox<String> getStudenci() {
		return studenci;
	}
	public static void setStudenci(JComboBox<String> studenci) {
		SendEmailFrame.studenci = studenci;
	}
	public static JButton getWyslij() {
		return wyslij;
	}
	public static void setWyslij(JButton wyslij) {
		SendEmailFrame.wyslij = wyslij;
	}
	public static JButton getWyjdz() {
		return wyjdz;
	}
	public static void setWyjdz(JButton wyjdz) {
		SendEmailFrame.wyjdz = wyjdz;
	}
	public static JLabel getWiadomosc() {
		return wiadomosc;
	}
	public static void setWiadomosc(JLabel wiadomosc) {
		SendEmailFrame.wiadomosc = wiadomosc;
	}
	public static JTextArea getTextArea() {
		return textArea;
	}
	public static void setTextArea(JTextArea textArea) {
		SendEmailFrame.textArea = textArea;
	}
	
	public SendEmailFrame(){
		super("Wyslij do studenta");
		initGUI();
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	private void initGUI() {
		
		setLayout(new FlowLayout());
		
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
		
		textField = new JTextField();
		textField.setColumns(20);
		pobierzEmail = new JButton("Pobierz Email");
		add(textField);
		add(pobierzEmail);
		
		pobierzEmail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					String email = JDBCConnection.findEmail(studenci);
					textField.setText(email);
				} catch (Exception event){
					event.printStackTrace();
				}
				
			}
		});
		
		textArea = new JTextArea();
		textArea.setColumns(30);
		textArea.setRows(10);
		add(textArea);
		
		wyslij = new JButton("Wyœlij");
		wyslij.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				EmailOperations sendingMessage = new EmailOperations(textField.getText(), textArea.getText());
				sendingMessage.sendMessage();
				
			}
		});
		
		wyjdz = new JButton("Wyjdz");
		
		wyjdz.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		add(wyslij);
		add(wyjdz);
		
	}
}
