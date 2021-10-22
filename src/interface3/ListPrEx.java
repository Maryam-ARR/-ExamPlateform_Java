package interface3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Window;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.table.DefaultTableModel;

import Application.Application;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;

public class ListPrEx extends JFrame {

	Connection con ;
	PreparedStatement pst;
	Statement ps1;
	ResultSet rs = null;

	private JTextField txtC1;
	private JTextField txtC2;
	private JTextField txtC3;
	private JTextField txtC4;
	private JTextField txtnbQ;
	
	static String ExamID;
	private JPanel contentPane;
    public JButton btnCom;
    public JTextPane xtDescription;
	private JTextField txtEID;
	private JTextField txtEID1;
	private JTextField txtNbQ;
	private JTextField txtNbQ2;
	private JTable table_1;
	int Id_Q;
	
	ProfChoice P_C;
    
	/**
	 * Launch the application.
	 */
	public static void main(int EID) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListPrEx frame = new ListPrEx(EID);
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
	public ListPrEx(int IDE) {
		setBackground(new Color(255, 250, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1362, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setForeground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(7, 7, 7, 7));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(191, 205, 219));
		tabbedPane.setBounds(0,0,1340, 700 );
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		panel.setLayout(null);
		
		JLabel lbltitle = new JLabel("Liste Of Questions Created");
		lbltitle.setBounds(0, 5, 1303, 57);
		lbltitle.setForeground(new Color(0, 0, 128));
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel.add(lbltitle);
		
		JLabel lblNb = new JLabel("Number of Question :");
		lblNb.setBounds(27, 186, 191, 25);
		lblNb.setForeground(new Color(0, 0, 128));
		lblNb.setFont(new Font("Times New Roman", Font.BOLD, 21));
		panel.add(lblNb);
		
		txtEID = new JTextField();
		txtEID.setText(String.valueOf(IDE));
		txtEID.setBounds(149, 125, 114, 31);
		txtEID.setForeground(new Color(0, 0, 128));
		txtEID.setHorizontalAlignment(SwingConstants.CENTER);
		txtEID.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtEID.setEditable(false);
		txtEID.setBackground(SystemColor.menu);
		panel.add(txtEID);
		txtEID.setColumns(10);
		
		txtNbQ = new JTextField();
		txtNbQ.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtNbQ.setBounds(224, 187, 41, 26);
		txtNbQ.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(txtNbQ);
		txtNbQ.setColumns(10);
		
		JLabel lblerror = new JLabel("");
		lblerror.setHorizontalAlignment(SwingConstants.CENTER);
		lblerror.setForeground(new Color(255, 0, 0));
		lblerror.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblerror.setBounds(126, 161, 139, 20);
		panel.add(lblerror);
		
		
		JLabel lblEID = new JLabel("Exam ID :");
		lblEID.setBounds(27, 128, 107, 25);
		lblEID.setFont(new Font("Times New Roman", Font.BOLD, 21));
		lblEID.setForeground(new Color(0, 0, 128));
		lblEID.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblEID);
		
		table_1 = new JTable();
		table_1.setBackground(SystemColor.control);
		table_1.setFillsViewportHeight(true);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Exam", "Question", "Description", "Choice 1", "Choice 2", "Choice 3", "Choice 4", "Right Answer"
			}
		));
		table_1.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		table_1.setBounds(297, 102, 991, 517);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(299, 78, 989, 541);
		panel.add(scrollPane);
			try{
	String query = "SELECT * FROM `questionqcm`WHERE ID_E ='"+IDE+"' ";
	con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
	pst=con.prepareStatement(query);
	rs=pst.executeQuery();
	
	DefaultTableModel tm=(DefaultTableModel)table_1.getModel();
	tm.setRowCount(0);
		while(rs.next())
			
			{
	   Object o[]={rs.getInt("ID_E"),rs.getInt("Id_Q"),rs.getString("Description"),rs.getString("Choice_1"),rs.getString("Choice_2"),rs.getString("Choice_3"),rs.getString("Choice_4"),rs.getString("RightAnswer")};
	      tm.addRow(o);
			}
		}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage()	);
			}
			scrollPane.setViewportView(table_1);
		tabbedPane.addTab("Exam's Questions", null, panel, null);
		tabbedPane.setEnabledAt(0, true);
	JButton btnModify = new JButton("Modify the Question");
		btnModify.setBounds(13, 246, 269, 57);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!txtNbQ.getText().isEmpty()) {
				Pattern pt = Pattern.compile("^[0-9]{0,30}$");
					Matcher mt = pt.matcher(txtNbQ.getText());
					if(!mt.matches()) {
						lblerror.setText("Not A Number!!!");
					}
		////////////////////////////////////////////////////////////
					else { 
						lblerror.setText(null);
						try{
							String query = "SELECT COUNT(Id_Q) FROM `questionqcm`WHERE ID_E ='"+IDE+"' ";
							con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
							pst=con.prepareStatement(query);
							rs=pst.executeQuery();
								while(rs.next())
								{
									if(rs.getInt(1)>=Integer.parseInt(txtNbQ.getText())) {
										 JPanel panel_1 = new JPanel();
											panel_1.setBackground(new Color(240, 240, 240));
									        tabbedPane.addTab("UPDATE A Question", null, panel_1, null);
											panel_1.setLayout(null);
									        
										JLabel lblTitle = new JLabel("UPDATE  Questions");
											lblTitle.setForeground(new Color(0, 0, 128));
											lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
											lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
											lblTitle.setBounds(0, 7, 1303, 69);
											panel_1.add(lblTitle);
											
											JLabel lblN = new JLabel("N :");
											lblN.setFont(new Font("Times New Roman", Font.BOLD, 25));
											lblN.setForeground(new Color(0, 0, 128));
											lblN.setHorizontalAlignment(SwingConstants.CENTER);
											lblN.setBounds(1056, 32, 45, 20);
											panel_1.add(lblN);
											JSeparator separator = new JSeparator();
											separator.setBounds(426, 24, 0, 2);
											panel_1.add(separator);
											
											xtDescription = new JTextPane();
											xtDescription.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
											xtDescription.setBounds(92, 92, 1124, 136);
											panel_1.add(xtDescription);
										
											
											JLabel lblC1 = new JLabel("Choice 1 :");
											lblC1.setForeground(new Color(0, 0, 128));
											lblC1.setFont(new Font("Times New Roman", Font.BOLD, 25));
											lblC1.setBounds(342, 248, 107, 39);
											panel_1.add(lblC1);
											
											JLabel lblC2 = new JLabel("Choice 2 :");
											lblC2.setForeground(new Color(0, 0, 128));
											lblC2.setFont(new Font("Times New Roman", Font.BOLD, 25));
											lblC2.setBounds(342, 308, 107, 45);
											panel_1.add(lblC2);
											
											JLabel lblC3 = new JLabel("Choice 3 :");
											lblC3.setForeground(new Color(0, 0, 128));
											lblC3.setFont(new Font("Times New Roman", Font.BOLD, 25));
											lblC3.setBounds(342, 375, 107, 45);
											panel_1.add(lblC3);
											
											JLabel lblC4 = new JLabel("Choice 4 :");
											lblC4.setForeground(new Color(0, 0, 128));
											lblC4.setFont(new Font("Times New Roman", Font.BOLD, 25));
											lblC4.setBounds(342, 456, 107, 33);
											panel_1.add(lblC4);
											
											JLabel lblRA = new JLabel("Right Answer :");
											lblRA.setForeground(new Color(0, 0, 128));
											lblRA.setFont(new Font("Times New Roman", Font.BOLD, 25));
											lblRA.setBounds(342, 520, 163, 41);
											panel_1.add(lblRA);
											
											JLabel lblEID1 = new JLabel("ExamID :");
										  	lblEID1.setForeground(new Color(0, 0, 128));
											lblEID1.setHorizontalAlignment(SwingConstants.CENTER);
											lblEID1.setFont(new Font("Times New Roman", Font.BOLD, 25));
											lblEID1.setBounds(23, 24, 117, 36);
											panel_1.add(lblEID1);
											
											txtC1 = new JTextField();
											txtC1.setFont(new Font("Verdana", Font.BOLD, 17));
											txtC1.setBounds(460, 248, 629, 41);
											panel_1.add(txtC1);
											txtC1.setColumns(10);
											
											txtC2 = new JTextField();
											txtC2.setFont(new Font("Verdana", Font.BOLD, 17));
											txtC2.setBounds(458, 310, 631, 41);
											panel_1.add(txtC2);
											txtC2.setColumns(10);
											
											txtC3 = new JTextField();
											txtC3.setFont(new Font("Verdana", Font.BOLD, 17));
											txtC3.setBounds(464, 377, 625, 41);
											panel_1.add(txtC3);
											txtC3.setColumns(10);
											
											txtC4 = new JTextField();
											txtC4.setFont(new Font("Verdana", Font.BOLD, 17));
											txtC4.setBounds(464, 448, 625, 41);
											panel_1.add(txtC4);
											txtC4.setColumns(10);
											
											JComboBox comboBox = new JComboBox();
											comboBox.setFont(new Font("Times New Roman", Font.BOLD, 25));
											comboBox.setForeground(new Color(0, 0, 128));
											comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
											comboBox.setBounds(520, 520, 107, 37);
											panel_1.add(comboBox);
											
											
											txtEID1 = new JTextField();
											txtEID1.setText(String.valueOf(IDE));
											txtEID1.setBackground(SystemColor.menu);
											txtEID1.setHorizontalAlignment(SwingConstants.CENTER);
											txtEID1.setBounds(155, 24, 107,36);
											panel_1.add(txtEID1);
											txtEID1.setColumns(10);
											txtEID1.setEditable(false);
											txtEID1.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
											
											txtNbQ2 = new JTextField();
											txtNbQ2.setEditable(false);
											txtNbQ2.setText(txtNbQ.getText());
											txtNbQ2.setForeground(new Color(255, 250, 240));
											txtNbQ2.setBackground(new Color(0, 0, 128));
											txtNbQ2.setFont(new Font("Times New Roman", Font.BOLD, 20));
											txtNbQ2.setHorizontalAlignment(SwingConstants.CENTER);
											txtNbQ2.setBounds(1119, 16, 55, 49);
										    txtNbQ2.setText(txtNbQ.getText());
											panel_1.add(txtNbQ2);
											txtNbQ2.setColumns(10);
											try{
												String query1 = "SELECT Description,Choice_1,Choice_2,Choice_3,Choice_4 FROM `questionqcm` WHERE ID_E='"+IDE+"'AND Id_Q='"+Integer.parseInt(txtNbQ2.getText())+"';";
												con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
												ps1=con.createStatement();
												rs=ps1.executeQuery(query1);
												if(rs.next()){
													xtDescription.setText(rs.getString(1));
													txtC1.setText(rs.getString(2));
													txtC2.setText(rs.getString(3));
													txtC3.setText(rs.getString(4));
													txtC4.setText(rs.getString(5));
												}else{
												JOptionPane.showMessageDialog(null, "ERROR!!!","Error",JOptionPane.ERROR_MESSAGE);
												
											    }
											}catch(Exception ex){
												JOptionPane.showMessageDialog(null, ex.getMessage());}
											
											JButton btnNewButton = new JButton("DONE");
											btnNewButton.addActionListener(new ActionListener() {
												@SuppressWarnings("deprecation")
												public void actionPerformed(ActionEvent arg0) {
													 if(!xtDescription.getText().isEmpty()&&!txtC1.getText().isEmpty()&&!txtC2.getText().isEmpty()&&!txtC3.getText().isEmpty()&&!txtC4.getText().isEmpty()) {
													try{
											String query = "UPDATE questionqcm SET Description='"+xtDescription.getText()+"',Choice_1='"+txtC1.getText()+"',Choice_2='"+txtC2.getText()+"',Choice_3='"+txtC3.getText()+"',Choice_4='"+txtC4.getText()+"',RightAnswer='"+comboBox.getSelectedItem()+"' WHERE Id_Q='"+Integer.parseInt(txtNbQ2.getText())+"' AND ID_E='"+IDE+"'";
											con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
											pst=con.prepareStatement(query);
											pst.executeUpdate();
											
											JOptionPane.showMessageDialog(null, "Question UPDATED Succesfully "); 
											panel_1.setVisible(false);
											//panel_1.hide();
											}catch(Exception ex){
												JOptionPane.showMessageDialog(null, ex.getMessage()	);
										    }}else {
										    	JOptionPane.showMessageDialog(null, "make sure you fulfilled all feilds ");
										    }
												}});
											btnNewButton.setBackground(new Color(0, 51, 102));
											btnNewButton.setForeground(SystemColor.textHighlightText);
											btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
											btnNewButton.setBounds(1087, 537, 117, 53);
											panel_1.add(btnNewButton);
									}
									else {
										JOptionPane.showMessageDialog(null, "Question Doesn't exist!!!");
									}
									}
								}catch(Exception ex){
										JOptionPane.showMessageDialog(null, "Question Doesn't exist!!!");
									}}
					}else {
						JOptionPane.showMessageDialog(null, "Please Enter The Number Of The Question You Want To Modify");
					}}});
		
		btnModify.setForeground(SystemColor.textHighlightText);
		btnModify.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		btnModify.setBackground(new Color(0, 51, 102));
		panel.add(btnModify);
		
		JButton btnUpDT = new JButton("UPDATE The Liste");
		btnUpDT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String query = "SELECT * FROM `questionqcm`WHERE ID_E ='"+IDE+"' ";
					con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
					pst=con.prepareStatement(query);
					rs=pst.executeQuery();
					
					DefaultTableModel tm=(DefaultTableModel)table_1.getModel();
					tm.setRowCount(0);
						while(rs.next())
						{
					   Object o[]={rs.getInt("ID_E"),rs.getInt("Id_Q"),rs.getString("Description"),rs.getString("Choice_1"),rs.getString("Choice_2"),rs.getString("Choice_3"),rs.getString("Choice_4"),rs.getString("RightAnswer")};
					      tm.addRow(o);
							}
						}catch(Exception ex){
								JOptionPane.showMessageDialog(null, ex.getMessage()	);
						}}});
		
		btnCom = new JButton("CONFIRM the Exam");
		
		btnCom.setBounds(13, 426,  269, 57);
	    btnCom.setForeground(SystemColor.textHighlightText);
		btnCom.setBackground(new Color(0, 51, 102));
		btnCom.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		btnCom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		;
		panel.add(btnCom);
	
		btnUpDT.setForeground(SystemColor.textHighlightText);
		btnUpDT.setFont(new Font("Trebuchet MS", Font.BOLD, 25));
		btnUpDT.setBackground(new Color(0, 51, 102));
		btnUpDT.setBounds(13, 332, 269, 57);
		panel.add(btnUpDT);
	
}
}
