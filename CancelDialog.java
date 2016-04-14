
/**
 *
 * @author Huncwot
 */
public class CancelDialog extends javax.swing.JDialog {

	public CancelDialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		setLocationRelativeTo(null);
	}

	private void initComponents() {

		jScrollPane2 = new javax.swing.JScrollPane();
		jTextPane1 = new javax.swing.JTextPane();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Anulowanie");

		jTextPane1.setEditable(false);
		jTextPane1.setContentType("Czy");
		jTextPane1.setText("Czy aby na pewno chcesz opuœciæ program?");
		jScrollPane2.setViewportView(jTextPane1);

		jButton1.setText("Tak");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("Nie");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(61, 61, 61)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(15, 15, 15).addComponent(jButton1)
										.addGap(35, 35, 35).addComponent(jButton2))
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(64, Short.MAX_VALUE)));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(30, 30, 30)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButton1).addComponent(jButton2))
								.addContainerGap(56, Short.MAX_VALUE)));

		pack();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);

	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextPane jTextPane1;
	// End of variables declaration
}
