import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
				dataFromBase = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getString(5);
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
}
