import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class JDBCConnection {

	private static final String DATABASEURL = "jdbc:mysql://127.0.0.1:3306/";
	private static final String DATABASENAME = "planer";
	private static final String DATABASEDRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASEUSER = "root";
	private static final String DATABASEPASSWORD = "";
	private static Connection connection;
	private static String query = null;
	private static String dataFromBase;

	// tworzenie po³¹czenia
	public static Connection makeConnection() {
		try {
			try {
				Class.forName(DATABASEDRIVER).newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(DATABASEURL + DATABASENAME, DATABASEUSER, DATABASEPASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// wyszukiwanie studentów
	public static ArrayList<String> queryStudents() {

		ArrayList<String> lista = new ArrayList<>();
		query = "select * from studenci";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				dataFromBase = rs.getString(1) + ". " + rs.getString(2) + " " + rs.getString(3) + " | "
						+ rs.getString(4) + " | " + rs.getString(5);
				lista.add(dataFromBase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	// dodawanie studentów do bazy
	public static void addStudentToDatabase() {

		query = "INSERT INTO `studenci`(`Imie`, `Nazwisko`, `Email`, `Telefon`) VALUES ('"
				+ AddStudentToDatabase.getImieText().getText() + "','"
				+ AddStudentToDatabase.getNazwiskoText().getText() + "','"
				+ AddStudentToDatabase.getEmailText().getText() + "','"
				+ AddStudentToDatabase.getTelefonText().getText() + "')";

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static String findId(JComboBox<String> box) {

		int selectedStudent = box.getSelectedIndex() + 1;
		String id = null;
		query = "select Id from studenci limit " + selectedStudent;

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				id = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;

	}
	
	public static String findEmail(JComboBox<String> box) {

		int selectedStudent = box.getSelectedIndex() + 1;
		String email = null;
		query = "select Email from studenci limit " + selectedStudent;

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				email = rs.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return email;

	}
	
	

	// usuwanie z bazy studenta o podanym id
	public static boolean deleteStudent(int id) {
		query = "delete from studenci where id=" + id;
		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	// zmiana danych studenta w bazie
	public static void changeStudentParameters(int id) {

		String a = ChangeStudentParameters.getImieText().getText();
		String b = ChangeStudentParameters.getNazwiskoText().getText();
		String c = ChangeStudentParameters.getEmailText().getText();
		String d = ChangeStudentParameters.getTelefonText().getText();

		if (a.equals("") && b.equals("") && c.equals("") && d.equals("")) {
			query = "update studenci set where Id=" + id;
		} else if (a.equals("") && b.equals("") && c.equals("")) {
			query = "update studenci set Telefon='" + d + "' where Id=" + id;
		} else if (b.equals("") && c.equals("") && d.equals("")) {
			query = "update studenci set Imie='" + a + "' where Id=" + id;
		} else if (a.equals("") && b.equals("") && d.equals("")) {
			query = "update studenci set Email='" + c + "' where Id=" + id;
		} else if (a.equals("") && c.equals("") && d.equals("")) {
			query = "update studenci set Nazwisko='" + b + "' where Id=" + id;
		} else if (a.equals("") && b.equals("")) {
			query = "update studenci set Email='" + c + "', Telefon='" + d + "' where Id=" + id;
		} else if (a.equals("") && c.equals("")) {
			query = "update studenci set Nazwisko='" + b + "', Telefon='" + d + "' where Id=" + id;
		} else if (a.equals("") && d.equals("")) {
			query = "update studenci set Nazwisko='" + b + "', Email='" + c + "' where Id=" + id;
		} else if (b.equals("") && c.equals("")) {
			query = "update studenci set Imie='" + a + "', Telefon='" + d + "' where Id=" + id;
		} else if (b.equals("") && d.equals("")) {
			query = "update studenci set Imie='" + a + "', Email='" + c + "' where Id=" + id;
		} else if (c.equals("") && d.equals("")) {
			query = "update studenci set Imie='" + a + "', Nazwisko='" + b + "' where Id=" + id;
		} else if (a.equals("")) {
			query = "update studenci set Nazwisko='" + b + "', Email='" + c + "', Telefon='" + d + "' where Id=" + id;
		} else if (b.equals("")) {
			query = "update studenci set Imie='" + a + "', Email='" + c + "', Telefon='" + d + "' where Id=" + id;
		} else if (c.equals("")) {
			query = "update studenci set Imie='" + a + "', Nazwisko='" + b + "', Telefon='" + d + "' where Id=" + id;
		} else if (d.equals("")) {
			query = "update studenci set Imie='" + a + "', Nazwisko='" + b + "', Email='" + c + "' where Id=" + id;
		} else {
			query = "update studenci set Imie='" + a + "', Nazwisko='" + b + "', Email='" + c + "', Telefon='" + d
					+ "' where Id=" + id;
		}

		try {
			Statement stmt = connection.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
