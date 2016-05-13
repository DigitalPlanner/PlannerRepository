import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DeleteStudentFromDatabase extends JFrame {

	private static final int WIDTH = 400;
	private static final int HEIGHT = 150;
	private static JLabel student;
	private static JComboBox<String> studenci;
	private static JButton usun;
	private static JButton zamknij;
	private static String[] tabela;

	public static JLabel getStudent() {
		return student;
	}

	public static void setStudent(JLabel student) {
		DeleteStudentFromDatabase.student = student;
	}

	public static JComboBox<String> getStudenci() {
		return studenci;
	}

	public static void setStudenci(JComboBox<String> studenci) {
		DeleteStudentFromDatabase.studenci = studenci;
	}

	public static JButton getUsun() {
		return usun;
	}

	public static void setUsun(JButton usun) {
		DeleteStudentFromDatabase.usun = usun;
	}

	public static JButton getZamknij() {
		return zamknij;
	}

	public static void setZamknij(JButton zamknij) {
		DeleteStudentFromDatabase.zamknij = zamknij;
	}

	public DeleteStudentFromDatabase() {
		super("Usuwanie studenta");
		initGUI();
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void initGUI() {
		FlowLayout layout = new FlowLayout();
		setLayout(layout);

		student = new JLabel("Student");
		student.setFont(new Font("Serif", Font.BOLD, 16));
		studenci = new JComboBox();
		usun = new JButton("Usun");
		zamknij = new JButton("Zamknij");
		tabela = new String[JDBCConnection.queryStudents().size()];

		zamknij.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		// wype³niam tabele
		for (int i = 0; i < JDBCConnection.queryStudents().size(); i++) {
			tabela[i] = (String) JDBCConnection.queryStudents().get(i);

		}

		// wrzucam w ComboBox'a
		for (int i = 0; i < tabela.length; i++) {
			studenci.addItem(tabela[i]);
		}
		studenci.setSelectedIndex(-1);

		// usuwanie wybranego studenta
		usun.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JDBCConnection.makeConnection();
				try {
					int id = new Integer(JDBCConnection.findId(studenci));
					JDBCConnection.deleteStudent(id);
					dispose();
				} catch (NumberFormatException ups) {
					System.out.println("Wybierz studenta!");
				}
				
			}
		});

		add(student);
		add(studenci);
		add(usun);
		add(zamknij);
		pack();
	}

}
