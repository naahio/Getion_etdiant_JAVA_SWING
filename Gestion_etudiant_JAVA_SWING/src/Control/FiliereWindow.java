package Control;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import javax.swing.JTable;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.table.DefaultTableModel;


import DAO.FiliereDAO;
import DAO_impl.FiliereDAOimpl;
import Enteties.Filieres;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Map.Entry;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class FiliereWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable list_filiere;
    public  JLabel NF;
    public  JLabel CF;
    public  JLabel DF;
    private JButton ajoute;
    FiliereDAO f = new FiliereDAOimpl();
    private JScrollPane scrollPane;
    DefaultTableModel model;
    public JTextField Nom_F;
    private JTextField Code_F;
    private JTextField Dep_F;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FiliereWindow frame = new FiliereWindow();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FiliereWindow() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
							
				Filieres fio = new Filieres();
				try {
					
					f.List_filiere();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Nom_F.setVisible(false);
				Code_F.setVisible(false);
				Dep_F.setVisible(false);
				
				NF.setVisible(false);
				CF.setVisible(false);
				DF.setVisible(false);
				
				ajoute.setVisible(false);
				if( !f.list_fil.isEmpty() )
				{
				model.setRowCount(0);
				
				Object[] row = new Object[4];
				for (Entry<String, Filieres> entry : f.list_fil.entrySet()) {
		            String key = entry.getKey();
		            Filieres value = entry.getValue();
		            System.out.println("Clé: " + key + ", Valeur: " + value);
		            row[0] = value.getNom();
					row[1] = key;
					row[2] = value.getDepartement();
					model.addRow(row);
		        }
				
				}
				
				
				
				
				Nom_F.setText("");
				Code_F.setText("");
				Dep_F.setText("");
				
			}
		});
		setTitle("Gestion des Filieres");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pc\\Downloads\\39982.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 504, 425);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 24, 400, 111);
		panel.add(scrollPane);
		
		list_filiere = new JTable();
		scrollPane.setViewportView(list_filiere);
		list_filiere.setEnabled(false);
		list_filiere.setAutoCreateRowSorter(true);
		list_filiere.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_filiere.setToolTipText("");
		list_filiere.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		model = new DefaultTableModel();
		Object[] colum = { " Filiere", "Code", " Departement" };
		Object[] row = new Object[3];
		list_filiere.setModel(model);
		model.setColumnIdentifiers(colum);
		
		
			
		JButton add_filier = new JButton(" Add ");
		add_filier.setBackground(Color.WHITE);
		add_filier.setBorder(null);
		add_filier.setForeground(Color.WHITE);
		add_filier.setIcon(new ImageIcon("C:\\Users\\pc\\Downloads\\iconfinder_ic_playlist_add_48px_3669292 (2).png"));
		add_filier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nom_F.setVisible(true);
				Code_F.setVisible(true);
				Dep_F.setVisible(true);			
				
				
				NF.setVisible(true);
				CF.setVisible(true);
				DF.setVisible(true);
				
				add_filier.setVisible(false);
				ajoute.setVisible(true);
				
			}
		});
		add_filier.setBounds(406, 164, 88, 42);
		panel.add(add_filier);
		
		NF = new JLabel("Nom Filiere");
		NF.setFont(new Font("Times New Roman", Font.BOLD, 13));
		NF.setBounds(92, 177, 96, 17);
		panel.add(NF);
		
		CF = new JLabel("Code Filiere");
		CF.setFont(new Font("Times New Roman", Font.BOLD, 13));
		CF.setBounds(92, 232, 96, 17);
		panel.add(CF);
		
		DF = new JLabel("Departement ");
		DF.setFont(new Font("Times New Roman", Font.BOLD, 13));
		DF.setBounds(92, 284, 96, 17);
		panel.add(DF);
		
		ajoute = new JButton("");
		ajoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					FiliereDAO filiere = new FiliereDAOimpl();					
					
					Filieres F = new Filieres();
					
					if( Nom_F.getText().isBlank() ||  Code_F.getText().isBlank() || Dep_F.getText().isBlank())
					{
					
						JOptionPane.showMessageDialog(panel,"erreur complete all the field !.","Alert",JOptionPane.WARNING_MESSAGE); 
						add_filier.setVisible(true);
					} else {
					F.setNom(Nom_F.getText());
					F.setCode(Code_F.getText());
					F.setDepartement(Dep_F.getText());
					
					
					filiere.creer(F);
					
					row[0] = Nom_F.getText();
					row[1] = Code_F.getText();
					row[2] = Dep_F.getText();
									
					model.addRow(row);
					
					Nom_F.setText("");
					Code_F.setText("");
					Dep_F.setText("");
					}
					add_filier.setVisible(true);
			}
		});
		ajoute.setIcon(new ImageIcon("C:\\Users\\pc\\Downloads\\iconfinder_add_476322.png"));
		ajoute.setForeground(Color.WHITE);
		ajoute.setBorder(null);
		ajoute.setBackground(Color.WHITE);
		ajoute.setBounds(200, 338, 88, 57);
		panel.add(ajoute);
		
		Nom_F = new JTextField();
		Nom_F.setColumns(10);
		Nom_F.setBounds(214, 175, 114, 20);
		panel.add(Nom_F);
		
		
		Code_F = new JTextField();
		Code_F.setColumns(10);
		Code_F.setBounds(214, 230, 114, 20);
		panel.add(Code_F);
		
		
		Dep_F = new JTextField();
		Dep_F.setColumns(10);
		Dep_F.setBounds(214, 282, 114, 20);
		panel.add(Dep_F);
		
		
		
	}

	public String getNom_F() {
		return Nom_F.getText();
	}

	public void setNom_F(JTextField nom_F) {
		Nom_F = nom_F;
	}

	public String getCode_F() {
		return Code_F.getText();
	}

	public void setCode_F(JTextField code_F) {
		Code_F = code_F;
	}

	public String getDep_F() {
		return Dep_F.getText();
	}

	public void setDep_F(JTextField dep_F) {
		Dep_F = dep_F;
	}

	
}
