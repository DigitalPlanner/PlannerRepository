import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Huncwot
 */
public class DigiPlannerFrame extends javax.swing.JFrame {

	public DigiPlannerFrame() {
		initComponents();
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void initComponents() {

		scrollPane = new javax.swing.JScrollPane();
		textArea = new javax.swing.JTextArea();
		endButton = new javax.swing.JButton();
		getList = new javax.swing.JButton();
		sendSchedule = new javax.swing.JButton();
		changeStudentInfo = new javax.swing.JButton();
		selectTerm = new javax.swing.JButton();
		selectActivities = new javax.swing.JButton();
		selectLecturer = new javax.swing.JButton();
		selectSubject = new javax.swing.JButton();
		menuBar = new javax.swing.JMenuBar();
		plikMenu = new javax.swing.JMenu();
		addStudent = new javax.swing.JMenuItem();
		removeStudent = new javax.swing.JMenuItem();
		jSeparator1 = new javax.swing.JPopupMenu.Separator();
		addSubject = new javax.swing.JMenuItem();
		removeSubject = new javax.swing.JMenuItem();
		addActivities = new javax.swing.JMenuItem();
		removeActivities = new javax.swing.JMenuItem();
		addTerm = new javax.swing.JMenuItem();
		removeTerm = new javax.swing.JMenuItem();
		addLecturer = new javax.swing.JMenuItem();
		removeLecturer = new javax.swing.JMenuItem();
		jSeparator2 = new javax.swing.JPopupMenu.Separator();
		endProgram = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Digi Planner");

		textArea.setColumns(20);
		textArea.setRows(5);
		scrollPane.setViewportView(textArea);

		endButton.setText("WyjdŸ");
		endButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		getList.setText("Pobierz listê");
		getList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDBCConnection.makeConnection();
				textArea.setText("");
				for (int i = 0; i < JDBCConnection.queryStudents().size(); i++)
					textArea.append(JDBCConnection.queryStudents().get(i) + "\n");

			}
		});

		sendSchedule.setText("Wyœlij grafik");

		changeStudentInfo.setText("Zmieñ dane");

		selectTerm.setText("Wybierz termin");

		selectActivities.setText("Wybierz zajêcia");

		selectLecturer.setText("Wybierz wyk³adowcê");

		selectSubject.setText("Wybierz przedmiot");

		plikMenu.setText("Plik");

		addStudent.setText("Dodaj studenta");
		plikMenu.add(addStudent);

		removeStudent.setText("Usuñ studenta");
		plikMenu.add(removeStudent);
		plikMenu.add(jSeparator1);

		addSubject.setText("Dodaj przedmiot");
		plikMenu.add(addSubject);

		removeSubject.setText("Usuñ przedmiot");

		plikMenu.add(removeSubject);

		addActivities.setText("Dodaj zajêcia");
		plikMenu.add(addActivities);

		removeActivities.setText("Usuñ zajêcia");
		plikMenu.add(removeActivities);

		addTerm.setText("Dodaj termin");
		plikMenu.add(addTerm);

		removeTerm.setText("Usuñ termin");
		plikMenu.add(removeTerm);

		addLecturer.setText("Dodaj wyk³adowcê");
		plikMenu.add(addLecturer);

		removeLecturer.setText("Usuñ wyk³adowcê");
		plikMenu.add(removeLecturer);
		plikMenu.add(jSeparator2);

		endProgram.setText("Zakoñcz");
		endProgram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		plikMenu.add(endProgram);

		menuBar.add(plikMenu);

		setJMenuBar(menuBar);
		addStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddStudentToDatabase start = new AddStudentToDatabase();

			}
		});
		removeStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDBCConnection.makeConnection();
				DeleteStudentFromDatabase okno = new DeleteStudentFromDatabase();

			}
		});
		changeStudentInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDBCConnection.makeConnection();
				ChangeStudentParameters okno = new ChangeStudentParameters();
				
			}
		});
		
		sendSchedule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDBCConnection.makeConnection();
				SendEmailFrame start = new SendEmailFrame();
				
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(getList)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(sendSchedule)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(endButton))
								.addGroup(
										layout.createSequentialGroup()
												.addGap(0, 25,
														Short.MAX_VALUE)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(changeStudentInfo).addComponent(selectTerm)
														.addComponent(selectActivities).addComponent(selectLecturer)
														.addComponent(selectSubject))
												.addGap(18, 18, 18).addComponent(scrollPane,
														javax.swing.GroupLayout.PREFERRED_SIZE, 303,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(scrollPane,
								javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(58, 58, 58).addComponent(changeStudentInfo)
								.addGap(18, 18, 18).addComponent(selectTerm).addGap(18, 18, 18)
								.addComponent(selectActivities).addGap(18, 18, 18).addComponent(selectLecturer)
								.addGap(18, 18, 18).addComponent(selectSubject)))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(endButton)
						.addComponent(getList).addComponent(sendSchedule))
				.addGap(29, 29, 29)));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton endButton;
	private javax.swing.JButton getList;
	private javax.swing.JButton sendSchedule;
	private javax.swing.JButton changeStudentInfo;
	private javax.swing.JButton selectTerm;
	private javax.swing.JButton selectActivities;
	private javax.swing.JButton selectLecturer;
	private javax.swing.JButton selectSubject;
	private javax.swing.JMenu plikMenu;
	private javax.swing.JMenuBar menuBar;
	private javax.swing.JMenuItem addStudent;
	private javax.swing.JMenuItem removeLecturer;
	private javax.swing.JMenuItem endProgram;
	private javax.swing.JMenuItem removeStudent;
	private javax.swing.JMenuItem addSubject;
	private javax.swing.JMenuItem removeSubject;
	private javax.swing.JMenuItem addActivities;
	private javax.swing.JMenuItem removeActivities;
	private javax.swing.JMenuItem addTerm;
	private javax.swing.JMenuItem removeTerm;
	private javax.swing.JMenuItem addLecturer;
	private javax.swing.JScrollPane scrollPane;
	private javax.swing.JPopupMenu.Separator jSeparator1;
	private javax.swing.JPopupMenu.Separator jSeparator2;
	private javax.swing.JTextArea textArea;

}
