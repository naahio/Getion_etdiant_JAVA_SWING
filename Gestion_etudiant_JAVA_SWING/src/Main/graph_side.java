package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;

public class graph_side {

	private JFrame frmGestionDesEtudiants;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					graph_side window = new graph_side();
					window.frmGestionDesEtudiants.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public graph_side() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesEtudiants = new JFrame();
		frmGestionDesEtudiants.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		frmGestionDesEtudiants.setForeground(Color.WHITE);
		frmGestionDesEtudiants.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\Downloads\\39982.png"));
		frmGestionDesEtudiants.setResizable(false);
		frmGestionDesEtudiants.setTitle("Gestion des etudiants");
		frmGestionDesEtudiants.setBounds(100, 100, 566, 350);
		frmGestionDesEtudiants.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGestionDesEtudiants.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 560, 321);
		frmGestionDesEtudiants.getContentPane().add(panel);
	}
}
