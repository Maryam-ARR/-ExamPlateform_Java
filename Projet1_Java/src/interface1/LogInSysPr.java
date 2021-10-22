package interface1;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import interface0.PrSt;
import interface2.ChoixQcm;
import interface3.ProfChoice;

import java.awt.SystemColor;

public class LogInSysPr extends JFrame {

	private JPanel panPr;
	public JTextField txtUser;
	public JTextField txtSpeciality;
	public JButton btnLogin ;
	String PrN;
	Connection con ;
	Statement pst;
	ResultSet rs = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInSysPr frame = new LogInSysPr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public LogInSysPr() {
		
		
		setTitle("Professor's Space");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 434);
		panPr = new JPanel();
		panPr.setForeground(UIManager.getColor("CheckBox.interiorBackground"));
		panPr.setBackground(new Color(200, 200, 200));
		setContentPane(panPr);
		panPr.setLayout(null);
		
		JLabel txtLoginForPr = new JLabel("Authentification For Professors");
		txtLoginForPr.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtLoginForPr.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoginForPr.setForeground(new Color(0, 51, 102));
		txtLoginForPr.setBackground(UIManager.getColor("Button.light"));
		txtLoginForPr.setBounds(0, 0, 558, 78);
		panPr.add(txtLoginForPr);
		
		JLabel lblUser = new JLabel("UserName");
		lblUser.setForeground(new Color(0, 51, 102));
		lblUser.setBackground(SystemColor.control);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(25, 122, 145, 35);
		panPr.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBackground(UIManager.getColor("CheckBox.background"));
		txtUser.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtUser.setBounds(185, 125, 335, 32);
		panPr.add(txtUser);
		txtUser.setColumns(10);
		
		btnLogin = new JButton("LogIn");
		btnLogin.setForeground(SystemColor.menu);
		btnLogin.setBackground(new Color(0, 51, 102));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 27));
		
		btnLogin.setBounds(25, 312, 130, 51);
		panPr.add(btnLogin);
		
		JButton btnReset = new JButton("Reset"); 
		btnReset.setForeground(SystemColor.menu);
		btnReset.setBackground(new Color(0, 51, 102));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setText(null);
				txtSpeciality.setText(null);
			}});
		btnReset.setBounds(201, 312, 137, 51);
		panPr.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(SystemColor.menu);
		btnExit.setBackground(new Color(0, 51, 102));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem =new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if u want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
				}
			}});
		btnExit.setBounds(383, 312, 137, 51);
		panPr.add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 286, 529, 24);
		panPr.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 76, 528, 2);
		panPr.add(separator_1);
		
		txtSpeciality = new JTextField();
		txtSpeciality.setBackground(UIManager.getColor("CheckBox.background"));
		txtSpeciality.setFont(new Font("Tahoma", Font.BOLD, 24));
		txtSpeciality.setBounds(185, 198, 335, 35);
		panPr.add(txtSpeciality);
		txtSpeciality.setColumns(10);
		
		JLabel lblSpiciality = new JLabel("Speciality");
		lblSpiciality.setForeground(new Color(0, 51, 102));
		lblSpiciality.setBackground(SystemColor.control);
		lblSpiciality.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpiciality.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblSpiciality.setBounds(25, 184, 145, 60);
		panPr.add(lblSpiciality);
		
	}
	 
	public String login(ProfChoice P_C,LogInSysPr professor) {
		String speciality=professor.txtSpeciality.getText();
		String prN=professor.txtUser.getText();
		try{
			String query = "SELECT * FROM `professors` WHERE Name='"+prN+"'AND Speciality='"+speciality+"'";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
			pst=con.createStatement();
			rs=pst.executeQuery(query);
			
			if(rs.next()){
				professor.setVisible(false);
				P_C.setVisible(true);
				PrN=prN;
				
			}else{
			JOptionPane.showMessageDialog(null, "Invalide LogIn Details","LogIn Error",JOptionPane.ERROR_MESSAGE);
			professor.txtUser.setText(null);
			professor.txtSpeciality.setText(null);
		    }
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());}
		return PrN;
	}
	
}
