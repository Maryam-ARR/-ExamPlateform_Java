package interface3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class SetQuestions extends JFrame {

	private JPanel contentPane;
	public JTextField txtC1;
	public JTextField txtC2;
	public JTextField txtC3;
	public JTextField txtC4;
	public JTextField txtnbQ;
	public JTextField txtEID;
	public JTextArea xtDescription;
	public JButton btnNext;
	public  int i =1;
	public static int clickS=0, click=0;
	Connection con ;
	PreparedStatement pst;
	ResultSet rs = null;
	static String ExamID;


	/**
	 * Create the frame.
	 */
	public SetQuestions(String ExamID) {
		setTitle("Set Exam's Question");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 718);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Set Exam's Questions");
		lblTitle.setForeground(new Color(0, 0, 128));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblTitle.setBounds(25, 11, 671, 46);
		contentPane.add(lblTitle);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(25, 73, 661, 2);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 96, 681, 174);
		contentPane.add(scrollPane);
		
		xtDescription = new JTextArea();
		xtDescription.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		xtDescription.setBounds(401, 164, 280, 106);
		scrollPane.setViewportView(xtDescription);
	
		
		JLabel lblC1 = new JLabel("Choice 1 :");
		
		lblC1.setForeground(new Color(0, 0, 128));
		lblC1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblC1.setBounds(40, 286, 85, 20);
		contentPane.add(lblC1);
		
		JLabel lblC2 = new JLabel("Choice 2 :");
		
		lblC2.setForeground(new Color(0, 0, 128));
		lblC2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblC2.setBounds(40, 340, 85, 20);
		contentPane.add(lblC2);
		
		JLabel lblC3 = new JLabel("Choice 3 :");
		lblC3.setForeground(new Color(0, 0, 128));
		lblC3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblC3.setBounds(40, 393, 85, 20);
		contentPane.add(lblC3);
		
		JLabel lblC4 = new JLabel("Choice 4 :");
		lblC4.setForeground(new Color(0, 0, 128));
		lblC4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblC4.setBounds(40, 448, 85, 20);
		contentPane.add(lblC4);
		
		JLabel lblRA = new JLabel("Right Answer :");
		lblRA.setForeground(new Color(0, 0, 128));
		lblRA.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblRA.setBounds(40, 513, 130, 20);
		contentPane.add(lblRA);
		
		JLabel lblEID = new JLabel("ExamID :");
		lblEID.setHorizontalAlignment(SwingConstants.CENTER);
		lblEID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEID.setBounds(10, 24, 85, 26);
		contentPane.add(lblEID);
		
		txtC1 = new JTextField();
		txtC1.setFont(new Font("Verdana", Font.BOLD, 17));
		txtC1.setBounds(160, 283, 526, 26);
		contentPane.add(txtC1);
		txtC1.setColumns(10);
		
		txtC2 = new JTextField();
		txtC2.setFont(new Font("Verdana", Font.BOLD, 17));
		txtC2.setBounds(160, 337, 526, 26);
		contentPane.add(txtC2);
		txtC2.setColumns(10);
		
		txtC3 = new JTextField();
		txtC3.setFont(new Font("Verdana", Font.BOLD, 17));
		txtC3.setBounds(160, 390, 526, 26);
		contentPane.add(txtC3);
		txtC3.setColumns(10);
		
		txtC4 = new JTextField();
		txtC4.setFont(new Font("Verdana", Font.BOLD, 17));
		txtC4.setBounds(160, 445, 526, 26);
		contentPane.add(txtC4);
		txtC4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 19));
		comboBox.setForeground(new Color(0, 0, 128));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		comboBox.setBounds(188, 511, 63, 26);
		contentPane.add(comboBox);
		
		
		txtEID = new JTextField();
		txtEID.setText(ExamID);
		txtEID.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		txtEID.setHorizontalAlignment(SwingConstants.CENTER);
		txtEID.setBounds(94, 24, 52,26);
		contentPane.add(txtEID);
		txtEID.setColumns(10);
		txtEID.setEditable(false);
		txtEID.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(25, 572, 661, 2);
		contentPane.add(separator_1);
		
		txtnbQ = new JTextField();
		txtnbQ.setText("1");
		txtnbQ.setEditable(false);
		txtnbQ.setForeground(new Color(255, 250, 240));
		txtnbQ.setBackground(new Color(0, 0, 128));
		txtnbQ.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtnbQ.setHorizontalAlignment(SwingConstants.CENTER);
		txtnbQ.setBounds(642, 23, 44, 33);
		contentPane.add(txtnbQ);
		txtnbQ.setColumns(10);
		
		
		
/////////////////////////////////////////////////////////btns code
		String D= xtDescription.getText();
		String C1= txtC1.getText();
		String C2= txtC2.getText();
		String C3=txtC3.getText();
		String C4=	txtC4.getText();
		
		/////////////////////////////////////////////////////////////////////////
		//Save button
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent arg0) {
			 if(clickS<i) {
				 click=clickS;
			 if(!xtDescription.getText().isEmpty()&&!txtC1.getText().isEmpty()&&!txtC2.getText().isEmpty()&&!txtC3.getText().isEmpty()&&!txtC4.getText().isEmpty()) {
				 	clickS++;
				 	
						try{
							String query = "INSERT INTO questionqcm(ID_E,Id_Q,Description,Choice_1,Choice_2,Choice_3,Choice_4,RightAnswer)  VALUES ('"+ExamID+"','"+txtnbQ.getText()+"','"+xtDescription.getText()+"','"+txtC1.getText()+"','"+txtC2.getText()+"','"+txtC3.getText()+"','"+txtC4.getText()+"','"+comboBox.getSelectedItem()+"')";
							con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
							pst=con.prepareStatement(query);
							pst.executeUpdate();
							
							JOptionPane.showMessageDialog(null,"Question Saved" );
							
							}catch(Exception ex){
								JOptionPane.showMessageDialog(null, ex.getMessage()	);
						}}
			 else {
					JOptionPane.showMessageDialog(null, "Please make sure u fulfilled all Fields","Error",JOptionPane.ERROR_MESSAGE);
				}
			 }else {
				 JOptionPane.showMessageDialog(null, "Question Already Saved");
			 }}});
				btnSave.setForeground(SystemColor.menu);
				btnSave.setFont(new Font("Tahoma", Font.BOLD, 18));
				btnSave.setBackground(new Color(0, 51, 102));
				btnSave.setBounds(383, 600, 115, 46);
				contentPane.add(btnSave);
		//Next button
		
		btnNext = new JButton("NEXT"); 
		
		
		btnNext.setForeground(SystemColor.menu);
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNext.setBackground(new Color(0, 51, 102));
		btnNext.setBounds(571, 600, 115, 46);
		contentPane.add(btnNext);
		
		
		//modify button
		JButton btnModify = new JButton("MODIFY");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(!xtDescription.getText().isEmpty()&&!txtC1.getText().isEmpty()&&!txtC2.getText().isEmpty()&&!txtC3.getText().isEmpty()&&!txtC4.getText().isEmpty()) {
					
					 if(clickS==click+1) {
		try{
			String query = "UPDATE questionqcm SET Description='"+xtDescription.getText()+"',Choice_1='"+txtC1.getText()+"',Choice_2='"+txtC2.getText()+"',Choice_3='"+txtC3.getText()+"',Choice_4='"+txtC4.getText()+"',RightAnswer='"+comboBox.getSelectedItem()+"' WHERE Id_Q='"+txtnbQ.getText()+"' AND ID_E='"+txtEID.getText()+"'";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
			pst=con.prepareStatement(query);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Modification Saved" );
			
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage()	);
		}}
				 else {
					 JOptionPane.showMessageDialog(null, "Please make sure u saved the Question ");
				 }
			} else {
						JOptionPane.showMessageDialog(null, "Please make sure u fulfilled all Fields","Error",JOptionPane.ERROR_MESSAGE);
					}
				 
			}});
		btnModify.setBackground(new Color(0, 51, 102));
		btnModify.setForeground(SystemColor.menu);
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnModify.setBounds(193, 600, 115, 46); 
		contentPane.add(btnModify);
		
		//delete button
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if(clickS==click+1) {
		  try {
			  con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
				
	             if(JOptionPane.showConfirmDialog(null,"attention you have delete a Question , are you sure?"
	                     ,"Delete Question",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
	         
	          
	        pst.executeUpdate("Delete From questionqcm where Id_Q='"+txtnbQ.getText()+"' AND ID_E='"+txtEID.getText()+"'");
	        xtDescription.setText(null);
			txtC1.setText(null);
			txtC2.setText(null);
			txtC3.setText(null);
			txtC4.setText(null);
			
	        JOptionPane.showMessageDialog(null,"Question Deleted succesfully ");
	        
	        }catch (Exception e){JOptionPane.showMessageDialog(null,"DELETE ERROR \n"+e.getMessage());} 
				 }else{
					 JOptionPane.showMessageDialog(null, " The Question Is not Seved yet !!");
				 }
		}});
		btnDelete.setBackground(new Color(0, 51, 102));
		btnDelete.setForeground(SystemColor.menu);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDelete.setBounds(10, 600, 115, 46);
		contentPane.add(btnDelete);
		
		
		
		
		
			
	}
	/**
	 * Launch the application.
	 */
	public static void main(String IDE) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetQuestions frame = new SetQuestions(IDE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
