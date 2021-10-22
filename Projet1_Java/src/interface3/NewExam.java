package interface3;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import interface2.ChoixQcm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;



public class NewExam extends JFrame {
				/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
				Connection con ;
				java.sql.PreparedStatement pst;
				Statement pst1;
				ResultSet rs = null,rs1;
	String eid;
	private JPanel contentPane;
	private JTextField txtTitle;
	private JTextField txtProf;
	public int i=0;
	private JTextField txtModule;
	public JTextField txtNb2;
	private JTextField txtNb1;
	public JTextField txtID;
	private JTextField txtTime;
	public JButton btnSetQ;
	public JButton btnMenu;
	String Prof;
	public int j=0;
	static JComboBox comboBoxMark;
	/**
	 * Launch the application.
	 */
	public static void main(String Prof) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewExam frame = new NewExam(Prof);
					frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NewExam(String prof) throws SQLException {
		setTitle("Create new Exam ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652,681);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(0, 0, 128));
		separator.setBackground(new Color(0, 0, 128));
		separator.setBounds(478, 0, 4, 625);
		contentPane.add(separator);
		

		JLabel lblerr2= new JLabel("");
		lblerr2.setForeground(new Color(255, 0, 0));
		lblerr2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblerr2.setBounds(284, 364, 159, 20);
		contentPane.add(lblerr2);
		
		JLabel lblerr3 = new JLabel("");
		lblerr3.setForeground(new Color(255, 0, 0));
		lblerr3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblerr3.setBounds(284, 443, 179, 20);
		contentPane.add(lblerr3);
		
		JLabel lblerr1 = new JLabel("");
		lblerr1.setHorizontalAlignment(SwingConstants.CENTER);
		lblerr1.setForeground(new Color(255, 0, 0));
		lblerr1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblerr1.setBounds(480, 82, 149, 20);
		contentPane.add(lblerr1);
		
		JLabel lblExamID = new JLabel("Exam ID :");
		lblExamID.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblExamID.setForeground(new Color(0, 0, 128));
		lblExamID.setBounds(497, 17, 176, 33);
		contentPane.add(lblExamID);
		
		
		txtID=new JTextField();
		txtID.setBackground(new Color(255, 255, 255));
		txtID.setForeground(new Color(0, 0, 128));
		txtID.setFont(new Font("Tahoma", Font.BOLD, 19));
		txtID.setEditable(true);
		txtID.setBounds(497, 53, 115, 29);
		contentPane.add(txtID);
		txtID.setColumns(10);
		JLabel lblTitle = new JLabel("Title :");
		lblTitle.setForeground(new Color(0, 0, 128));
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(15, 88, 69, 20);
		contentPane.add(lblTitle);
		
		txtTitle = new JTextField();
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTitle.setBounds(110, 82, 314, 34);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel lblProf = new JLabel("Creative Professor :");
		lblProf.setForeground(new Color(0, 0, 128));
		lblProf.setHorizontalAlignment(SwingConstants.CENTER);
		lblProf.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblProf.setBounds(15, 151, 182, 20);
		contentPane.add(lblProf);
		
		txtProf = new JTextField();
		txtProf.setBackground(new Color(248, 248, 255));
		txtProf.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtProf.setBounds(210, 148, 226, 26);
		txtProf.setText(prof);
		txtProf.setEditable(false);
		contentPane.add(txtProf);
		txtProf.setColumns(10);
		
		JLabel lblField = new JLabel("Field\r\n:");
		lblField.setForeground(new Color(0, 0, 128));
		lblField.setHorizontalAlignment(SwingConstants.CENTER);
		lblField.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblField.setBounds(15, 215, 69, 20);
		contentPane.add(lblField);
		
		JLabel lblModule = new JLabel("Module :");
		lblModule.setForeground(new Color(0, 0, 128));
		lblModule.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblModule.setHorizontalAlignment(SwingConstants.CENTER);
		lblModule.setBounds(15, 276, 92, 20);
		contentPane.add(lblModule);
		
		txtModule=new JTextField();
		txtModule.setBounds(122, 273, 314, 26);
		txtModule.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(txtModule);
		txtModule.setColumns(10);
		
		JLabel lblInfo = new JLabel("Exam's Infos\r\n");
		lblInfo.setForeground(new Color(0, 0, 128));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblInfo.setBounds(0, 16, 465, 34);
		contentPane.add(lblInfo);
		
		JLabel lblNb2 = new JLabel("The number of exam questions :");
		lblNb2.setForeground(new Color(0, 0, 128));
		lblNb2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNb2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNb2.setBounds(15, 401, 450, 20);
		
		contentPane.add(lblNb2);
		txtNb2=new JTextField();
		txtNb2.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtNb2.setBounds(210, 438, 69, 26);
		contentPane.add(txtNb2);
		txtNb2.setColumns(10);
		
		JLabel lblNbQ1 = new JLabel("Number of questions proposed for the exam :");
		lblNbQ1.setBounds(15, 323, 482, 20);
		lblNbQ1.setForeground(new Color(0, 0, 128));
		lblNbQ1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		contentPane.add(lblNbQ1);
		
		txtNb1 = new JTextField();
		txtNb1.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtNb1.setBounds(210, 359, 69, 26);
		contentPane.add(txtNb1);
		txtNb1.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(482, 100, 146, 2);
		contentPane.add(separator_1);
		
	 JComboBox comboBox = new JComboBox();	
		comboBox.setMaximumRowCount(50);
		comboBox.setBounds(110, 214, 169, 26);
		contentPane.add(comboBox);
			try{
					String query1 = "SELECT*FROM FIELD";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
					pst1=con.createStatement();
					rs=pst1.executeQuery(query1);
					
					while(rs.next()) {
						//String Field=rs.getString("FieldName");
						comboBox.addItem(rs.getString(2));
					}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "ERROR");
				 
				}finally {
					try {
					rs.close();
					con.close();
					pst1.close();
					}catch (Exception e) {
						JOptionPane.showMessageDialog(null, "ERROR CLOSE");
					}
				}

			comboBoxMark = new JComboBox();
			comboBoxMark.setBackground(new Color(220, 220, 220));
			comboBoxMark.setForeground(new Color(0, 0, 128));
			comboBoxMark.setModel(new DefaultComboBoxModel(new String[] {"1 for a correct answer otherwise 0", "-1: wrong answer, 0: no answer, 1: right answer"}));
			comboBoxMark.setFont(new Font("Times New Roman", Font.BOLD,20));
			comboBoxMark.setBounds(55, 567, 362, 42);
			contentPane.add(comboBoxMark);
			JLabel lblerrTime = new JLabel("");
			lblerrTime.setForeground(Color.RED);
			lblerrTime.setBounds(367, 486, 115, 20);
			contentPane.add(lblerrTime);
	////////////////////////////////////////////////////////////////////////
			    
		 Pattern pt = Pattern.compile("^[0-9]{0,30}$");
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i==0) {
				Matcher m1 = pt.matcher(txtNb1.getText());
				Matcher mt = pt.matcher(txtID.getText());
				Matcher m2 = pt.matcher(txtNb2.getText());
				Matcher m3=pt.matcher(txtTime.getText()) ;
				if(!m1.matches()||!mt.matches()||!m2.matches()||!m3.matches()) {
					if(!m1.matches()) {
						lblerr2.setText("Not A Number!!!");
					}
					 if(!mt.matches()) {
						lblerr1.setText("Not A Number!!!");
					}	
					 if(!m2.matches()) {
						lblerr3.setText("Not A Number!!!");
					}
					 if(!m3.matches()) {
							lblerrTime.setText("Not A Number!!!");
						}}
			    else {
						lblerr1.setText(null);
						lblerr2.setText(null);
						lblerr3.setText(null);
						lblerrTime.setText(null);
				String Title= txtTitle.getText();
				
				String Module =txtModule.getText();
				String Field= (String) comboBox.getSelectedItem() ;
				
			if(!Title.isEmpty()&&!Module.isEmpty()&&!Field.isEmpty()&&!txtNb1.getText().isEmpty()&&!txtNb2.getText().isEmpty()&&!txtID.getText().isEmpty()&&!txtTime.getText().isEmpty()) {
				int Nb1=Integer.parseInt(txtNb1.getText());
				int Nb2=Integer.parseInt(txtNb2.getText());
				int ID=Integer.parseInt(txtID.getText());
						
							if(Nb2 <20) {
								txtNb2.setText(null);
								JOptionPane.showMessageDialog(null, "The number of exam questions must be >20,Please Modify it");
								}
							
							else if(Nb1 <30) {
								txtNb1.setText(null);
								JOptionPane.showMessageDialog(null, "Number of questions proposed for the exam must be >30,Please Modify it");
								}
							else if(Integer.parseInt(txtNb1.getText()) < Integer.parseInt(txtNb2.getText()) ) {
								txtNb1.setText(null);
								JOptionPane.showMessageDialog(null, "Number of questions proposed for the exam must be greater than the number of exam questions ,Please Modify it");
								}
							else {
								try{
					String query = "INSERT INTO examqcm(IdExam,Title,CreativeProfessor,Field,Module,ExamQuestions,MCQsAvailable,E_Timing,E_Mark) VALUES('"+ID+"','"+Title+"','"+prof+"','"+Field+"','"+Module+"','"+Nb2+"','"+Nb1+"','"+txtTime.getText()+"','"+Mark()+"') ";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
					pst=con.prepareStatement(query);
					pst.executeUpdate();
					eid=txtID.getText();
						JOptionPane.showMessageDialog(null, "Exam infos subitted successfully");
						i=1;
					}catch(Exception ex){
					JOptionPane.showMessageDialog(null, "please change the Exam ID because it's already assigned for another Exam !!" );
					 
					}finally {
						try {
							con.close();
							pst.close();
							}catch (Exception ex) {
								JOptionPane.showMessageDialog(null, "ERROR CLOSE");
							}
						}}}
			else {
				JOptionPane.showMessageDialog(null, "Please make sure u fulfilled all infos","Exam infos Error",JOptionPane.ERROR_MESSAGE);
			}
			}}else{
				JOptionPane.showMessageDialog(null, "Question Already Saved");
			}}
		});
		btnSave.setBackground(new Color(220, 220, 220));
		btnSave.setForeground(new Color(0, 0, 128));
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSave.setBounds(497, 147, 115, 29);
		contentPane.add(btnSave);
		
		
		JButton btnModify = new JButton("MODIFY");
	
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Matcher m1 = pt.matcher(txtNb1.getText());
				Matcher mt = pt.matcher(txtID.getText());
				Matcher m2 = pt.matcher(txtNb2.getText());
				Matcher m3=pt.matcher(txtTime.getText()) ;
				if(!m1.matches()||!mt.matches()||!m2.matches()||!m3.matches()) {
					if(!m1.matches()) {
						lblerr2.setText("Not A Number!!!");
					}
					 if(!mt.matches()) {
						lblerr1.setText("Not A Number!!!");
					}	
					 if(!m2.matches()) {
						lblerr3.setText("Not A Number!!!");
					}
					 if(!m3.matches()) {
						lblerrTime.setText("Not A Number!!!");
						}}
			else {
						lblerr1.setText(null);
						lblerr2.setText(null);
						lblerr3.setText(null);
						lblerrTime.setText(null);
						String Title= txtTitle.getText();
						String Module =txtModule.getText();
						String Field= (String) comboBox.getSelectedItem() ;
						
			      if(!Title.isEmpty()&&!Module.isEmpty()&&!Field.isEmpty()&&!txtNb1.getText().isEmpty()&&!txtNb2.getText().isEmpty()&&!txtID.getText().isEmpty()) 
			    {
				int Nb1=Integer.parseInt(txtNb1.getText());
				int Nb2=Integer.parseInt(txtNb2.getText());
				int ID=Integer.parseInt(txtID.getText());
						
							if(Nb2 <20) {
								txtNb2.setText(null);
								JOptionPane.showMessageDialog(null, "The number of exam questions must be >=20,Please Modify it");
								}
							
							else if(Nb1 <30) {
								txtNb1.setText(null);
								JOptionPane.showMessageDialog(null, "Number of questions proposed for the exam must be >=30,Please Modify it");
								}
							else if(Integer.parseInt(txtNb1.getText()) < Integer.parseInt(txtNb2.getText()) ) {
								txtNb1.setText(null);
								JOptionPane.showMessageDialog(null, "Number of questions proposed for the exam must be greater than the number of exam questions ,Please Modify it");
								}
							else {
								try{
		        if (JOptionPane.showConfirmDialog (null,"CONFIRM YOUR MODIFICATION","modification",
		                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
		            	con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
						pst1=con.createStatement();
						
		                pst1.executeUpdate("UPDATE examqcm SET Title='"+txtTitle.getText()+"',CreativeProfessor='"+txtProf.getText()+
		                        "',Module='"+txtModule.getText()+"',Field='"+comboBox.getSelectedItem().toString()+"',ExamQuestions='"+Integer.parseInt(txtNb2.getText())+"',MCQsAvailable='"+Integer.parseInt(txtNb1.getText())+"',E_Timing='"+txtTime.getText()+"',E_Mark='"+Mark()+
		                        "' WHERE IdExam= '"+Integer.parseInt(txtID.getText())) ;
		                
		           
		                JOptionPane.showMessageDialog(null,"Exam's INFOs Are Modified successfully");
		            } 
		        } catch (Exception ex){
		        	JOptionPane.showMessageDialog(null,"MODIFY ERROR !!!!!!!");
		        System.err.println(ex);}
		    }}}
			}});

		btnModify.setForeground(new Color(0, 0, 128));
		btnModify.setBackground(new Color(220, 220, 220));
		btnModify.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnModify.setBounds(497, 214, 115, 29);
		contentPane.add(btnModify);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					 
		             if(JOptionPane.showConfirmDialog(null,"attention you have delete Exam's INFOs, are you sure?"
		                     ,"Delete Exam's INFOs",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
		            	 con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
						pst1=con.createStatement();
						
		            if(txtID.getText().length() != 0){
		        pst1.executeUpdate("Delete From examqcm where IdExam = "+Integer.parseInt(txtID.getText()));
		        txtTitle.setText(null);
		        txtID.setText(null);
		        txtModule.setText(null);
		        txtProf.setText(null);
		        txtNb2.setText(null);
		        txtNb1.setText(null);
		        txtTime.setText(null);
		        j=1;
		        JOptionPane.showMessageDialog(null,"Exam's INFOs Deleted successfully");
		             }
		            else { JOptionPane.showMessageDialog(null,"Infos Cannot Be Deleted ");}
		        
		        }catch (Exception ex){
		        	JOptionPane.showMessageDialog(null,"DELETE ERROR ! \n"+ex.getMessage());}
		    }
		       
	});
		btnDelete.setForeground(new Color(0, 0, 128));
		btnDelete.setBackground(new Color(220, 220, 220));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnDelete.setBounds(497, 283, 115, 29);
		contentPane.add(btnDelete);
		
		
		
		btnSetQ = new JButton("Set Questions");
		btnSetQ.setForeground(new Color(0, 0, 128));
		btnSetQ.setHorizontalAlignment(SwingConstants.LEFT);
		btnSetQ.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSetQ.setBackground(new Color(220, 220, 220));
		
		btnSetQ.setBounds(478, 401, 159, 66);
		contentPane.add(btnSetQ);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(480, 364, 149, -1);
		contentPane.add(separator_2);
		
		JLabel lblET = new JLabel("Exam's Timing :");
		lblET.setForeground(new Color(0, 0, 128));
		lblET.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblET.setHorizontalAlignment(SwingConstants.CENTER);
		lblET.setBounds(15, 478, 169, 33);
		contentPane.add(lblET);
		
		JLabel lblNewLabel_1 = new JLabel("The mark for each question will be :");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel_1.setBounds(25, 527, 368, 34);
		contentPane.add(lblNewLabel_1);
		
		txtTime = new JTextField();
		txtTime.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTime.setForeground(new Color(0, 0, 0));
		txtTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtTime.setBounds(183, 483, 146, 26);
		contentPane.add(txtTime);
		txtTime.setColumns(10);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setForeground(new Color(0, 0, 128));
		lblMin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblMin.setBounds(331, 486, 39, 20);
		contentPane.add(lblMin);
		
		 btnMenu = new JButton("MENU");
		btnMenu.setBackground(new Color(220, 220, 220));
		btnMenu.setForeground(new Color(0, 0, 128));
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnMenu.setBounds(478, 514, 159, 66);
		contentPane.add(btnMenu);
		
	
}
	static int Mark() {
		String M1="1 for a correct answer otherwise 0";
		String M2="-1: wrong answer, 0: no answer, 1: right answer";
		if(comboBoxMark.getSelectedItem()==M1) {
			return 1;
		}
		else {
			return 2;
		}
	}


public String ExId() {
	
	return eid;
}
}
