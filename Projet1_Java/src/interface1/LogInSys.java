package interface1;

import java.awt.BorderLayout;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.management.loading.PrivateClassLoader;
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
import javax.swing.border.MatteBorder;

import interface2.ChoixQcm;
import interface2.StudentChoice;
import interface3.ProfChoice;

import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JComboBox;

public class LogInSys extends JFrame {

	private JPanel contentPane;
	public JTextField txtUser;
	public JButton btnLogin;
	public JComboBox comboBox;
	public String name;
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
					LogInSys frame = new LogInSys();
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
	public LogInSys() {
		setTitle("Student's Space");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 434);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(SystemColor.inactiveCaption);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtLogin = new JLabel("Authentification For Students");
		txtLogin.setFont(new Font("Times New Roman", Font.BOLD, 40));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setForeground(new Color(0, 51, 102));
		txtLogin.setBackground(new Color(255, 204, 102));
		txtLogin.setBounds(0, 0, 558, 78);
		contentPane.add(txtLogin);
		JLabel lblerror1 = new JLabel("");
		lblerror1.setHorizontalAlignment(SwingConstants.CENTER);
		lblerror1.setForeground(new Color(255, 0, 0));
		lblerror1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblerror1.setBounds(185, 108, 303, 20);
		contentPane.add(lblerror1);
		
		JLabel lblerror2 = new JLabel("");
		lblerror2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblerror2.setForeground(new Color(255, 0, 0));
		lblerror2.setHorizontalAlignment(SwingConstants.CENTER);
		lblerror2.setBounds(185, 201, 303, 20);
		contentPane.add(lblerror2);
		
		JLabel lblUser = new JLabel("UserName");
		lblUser.setForeground(new Color(0, 51, 102));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setBounds(15, 129, 155, 35);
		contentPane.add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBackground(SystemColor.control);
		txtUser.setFont(new Font("Tahoma", Font.BOLD, 23));
		txtUser.setBounds(185, 132, 303, 31);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		btnLogin = new JButton("LogIn");
		btnLogin.setForeground(SystemColor.control);
		btnLogin.setBackground(new Color(0, 51, 102));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 27));
		
		btnLogin.setBounds(25, 312, 130, 51);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Reset"); 
		btnReset.setForeground(SystemColor.control);
		btnReset.setBackground(new Color(0, 51, 102));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUser.setText(null);
			}
		});
		btnReset.setBounds(201, 312, 137, 51);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(0, 51, 102));
		btnExit.setForeground(SystemColor.control);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 27));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem =new JFrame("Exit");
				if(
						JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if u want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
				}}});
		btnExit.setBounds(383, 312, 137, 51);
		contentPane.add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 286, 529, 24);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 76, 528, 2);
		contentPane.add(separator_1);
		
		JLabel lblField = new JLabel("Field");
		lblField.setForeground(new Color(0, 51, 102));
		lblField.setBackground(new Color(0, 51, 102));
		lblField.setHorizontalAlignment(SwingConstants.CENTER);
		lblField.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblField.setBounds(15, 221, 145, 35);
		contentPane.add(lblField);
		
		 comboBox = new JComboBox();
		 comboBox.setBackground(SystemColor.control);
		try{
			String query1 = "SELECT*FROM FIELD";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
			Statement pst1 = con.createStatement();
			rs=pst1.executeQuery(query1);
			
			while(rs.next()) {
				
				comboBox.addItem(rs.getString(2));
			}
	}catch(Exception ex){
		JOptionPane.showMessageDialog(null, "ERROR");
		 
		}
		comboBox.setBounds(185, 229, 153, 26);
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 23));
		contentPane.add(comboBox);
	}
	
	public String loginS(LogInSys student,StudentChoice CHoice) {
		String userName=student.txtUser.getText();
		String field=(String) student.comboBox.getSelectedItem(); 
		String F = null;
		try{
			String query = "SELECT * FROM `students` WHERE StudentName='"+userName+"' AND Field='"+field+"'";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
			pst=con.createStatement();
			rs=pst.executeQuery(query);
			if(rs.next()){
				name=userName;
				student.setVisible(false);
				CHoice.setVisible(true);
				F=field;
				}else{
			JOptionPane.showMessageDialog(null, "Invalide LogIn Details","LogIn Error",JOptionPane.ERROR_MESSAGE);
			student.txtUser.setText(null);}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage());
			}
		
		
		return F;
		}
}
