package emotiometer.visuals;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class About extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About dialog = new About();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setResizable(false);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.WHITE);
		label.setIcon(new ImageIcon("/Users/mikaelericsson/Documents/Eclipse/workspace/Emotiometer/data/Emotionlogo.png"));
		
		JLabel lblTronEmotiometer = new JLabel("Tron Emotiometer 2011");
		lblTronEmotiometer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTronEmotiometer.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblCreatedForThe = new JLabel("Created for the Bachelors Programme for");
		lblCreatedForThe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblForInteractionDesign = new JLabel("Interaction Design at Malm\u00F6 University.");
		lblForInteractionDesign.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblAuthors = new JLabel("Authors:");
		lblAuthors.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblAlanCheng = new JLabel("Alan Cheng");
		lblAlanCheng.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblJasminGhoreishi = new JLabel("Jasmin Ghoreishi");
		lblJasminGhoreishi.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblAndersLarm = new JLabel("Anders Larm");
		lblAndersLarm.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblJohannesNilsson = new JLabel("Johannes Nilsson");
		lblJohannesNilsson.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblJohanPalm = new JLabel("Johan Palm");
		lblJohanPalm.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblMikaelEricssonDuffy = new JLabel("Mikael Ericsson Duffy");
		lblMikaelEricssonDuffy.setFont(new Font("Tahoma", Font.PLAIN, 10));
		
		JLabel lblWwwtronlegacycom = new JLabel("www.tronlegacyemotiometer.com");
		lblWwwtronlegacycom.setFont(new Font("Tahoma", Font.PLAIN, 10));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCreatedForThe, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
								.addComponent(lblForInteractionDesign, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
								.addComponent(lblAuthors)
								.addComponent(lblAlanCheng)
								.addComponent(lblJohanPalm)
								.addComponent(lblAndersLarm)
								.addComponent(lblJasminGhoreishi)
								.addComponent(lblMikaelEricssonDuffy)
								.addComponent(lblJohannesNilsson)
								.addComponent(lblTronEmotiometer, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(48)
							.addComponent(lblWwwtronlegacycom)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTronEmotiometer)
							.addGap(15)
							.addComponent(lblCreatedForThe)
							.addGap(3)
							.addComponent(lblForInteractionDesign)
							.addGap(21)
							.addComponent(lblAuthors)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblAlanCheng)
							.addGap(2)
							.addComponent(lblMikaelEricssonDuffy)
							.addGap(2)
							.addComponent(lblJasminGhoreishi)
							.addGap(1)
							.addComponent(lblAndersLarm)
							.addGap(2)
							.addComponent(lblJohannesNilsson)
							.addGap(2)
							.addComponent(lblJohanPalm)
							.addPreferredGap(ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
							.addComponent(lblWwwtronlegacycom)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

	}
}
