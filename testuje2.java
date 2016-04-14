import java.awt.EventQueue;

public class testuje2 {

	public static void main(String[] args) {
		JDBCConnection.makeConnection();
		System.out.println(JDBCConnection.queryStudents().get(1));

	}

}
