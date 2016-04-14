import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Huncwot
 */
public class OknoLogowania extends javax.swing.JFrame {

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JPasswordField jPasswordField1;
	private javax.swing.JTextField jTextField1;
	// End of variables declaration

	public OknoLogowania() {
		initComponents();
		setLocationRelativeTo(null);
	}

	private void initComponents() {

		jButton1 = new JButton();
		jButton2 = new JButton();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jTextField1 = new JTextField();
		jPasswordField1 = new JPasswordField();
		jMenuBar1 = new JMenuBar();
		jMenu1 = new JMenu();
		jMenuItem2 = new JMenuItem();
		jMenu2 = new JMenu();
		jMenuItem3 = new JMenuItem();
		jMenuItem4 = new JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Logowanie");

		jButton1.setText("OK");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);

			}
		});

		jButton2.setText("Anuluj");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel1.setText("Login:");

		jLabel2.setText("Has³o:");

		jMenu1.setText("Plik");

		jMenuItem2.setText("Zamknij");
		jMenuItem2.setName("");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Pomoc");

		jMenuItem3.setText("O programie");
		jMenuItem3.setName("");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem3);

		jMenuItem4.setText("Od autora");
		jMenuItem4.setName("");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu2.add(jMenuItem4);

		jMenuBar1.add(jMenu2);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(126, 126, 126).addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(8, 8, 8)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel2).addComponent(jLabel1))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jTextField1).addComponent(jPasswordField1,
												javax.swing.GroupLayout.PREFERRED_SIZE, 70,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup().addComponent(jButton1).addGap(29, 29, 29)
								.addComponent(jButton2)))
						.addContainerGap(127, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(32, 32, 32)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jPasswordField1,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1).addComponent(jButton2))
						.addContainerGap(56, Short.MAX_VALUE)));

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		CancelDialog cancelDialog = new CancelDialog(this, rootPaneCheckingEnabled);
		cancelDialog.setVisible(true);

	}

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
		FromAuthorDialog fromAuthorDialog = new FromAuthorDialog(this, rootPaneCheckingEnabled);
		fromAuthorDialog.setVisible(true);
	}

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
		AbautProgramDialog abautProgramDialog = new AbautProgramDialog(this, rootPaneCheckingEnabled);
		abautProgramDialog.setVisible(true);
	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (jPasswordField1.getText().equals("admin") && jTextField1.getText().equals("admin")) {
			DigiPlannerFrame digiPlannerFrame = new DigiPlannerFrame();
			digiPlannerFrame.setVisible(true);

		} else {
			WrongDataDialog wrongDataDialog = new WrongDataDialog(this, rootPaneCheckingEnabled);
			wrongDataDialog.setVisible(true);
		}

	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new OknoLogowania().setVisible(true);
			}
		});
	}

}
