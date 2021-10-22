package interface3;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.fabric.xmlrpc.base.Fault;

import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Student_Score extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private JPanel contentPane;
	
	private ProfChoice PR1;
	Connection con ;
	PreparedStatement pst;
	ResultSet rs = null;
	public JButton btnBack;
	public JButton btnExit;
	private JLabel lblStudentScore;
	private JSeparator separator;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_Score frame = new Student_Score();
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
	public Student_Score() throws SQLException 
	{
		setAlwaysOnTop(true);
		setTitle("Student's Score");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 660);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollBar ;
			scrollBar = new JScrollPane();
			scrollBar.setBounds(25, 91, 668, 400);
			contentPane.add(scrollBar);
		table = new JTable();
		table.setEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
			table.setBounds(28, 134, 668, 361);
			table.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0,0,0)));
			table.setFont(new Font("Times New Roman", Font.BOLD, 20));
			
			  table.setModel(new DefaultTableModel(
			  	new Object[][] {
			  		{null, null, null},
			  	},
			  	new String[] {
			  		"Student's Name", "Exam", "Score"
			  	}
			  ));
			try{
				String query = "SELECT * FROM `student'slist` ";
				con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
				pst=con.prepareStatement(query);
				rs=pst.executeQuery();
				DefaultTableModel tm=(DefaultTableModel)table.getModel();
			
				tm.setRowCount(0);
				while(rs.next())
				{
				   Object o[]={rs.getString("Student"),rs.getInt("Exam"),rs.getInt("Score")};
				      tm.addRow(o);
				}
				
				
			}catch(Exception ex){
	JOptionPane.showMessageDialog(null, ex.getMessage()	);
			}
			scrollBar.setViewportView(table);
			
			separator = new JSeparator();
			separator.setBounds(15, 73, 681, 2);
			contentPane.add(separator);
			
			JLabel lblNewLabel = new JLabel("List Of Students How Passed the Exam");
			lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 30));
			lblNewLabel.setForeground(new Color(0, 0, 128));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(15, 0, 681, 75);
			contentPane.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("UpDate Table");
			btnNewButton.setForeground(new Color(255, 250, 240));
			btnNewButton.setBackground(new Color(0, 51, 102));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					try{
						String query = "SELECT * FROM `student'slist` ";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
						pst=con.prepareStatement(query);
						rs=pst.executeQuery();
						DefaultTableModel tm=(DefaultTableModel)table.getModel();
						tm.setColumnCount(3);
						tm.setRowCount(0);
						while(rs.next())
						{
						   Object o[]={rs.getString("Student"),rs.getInt("Exam"),rs.getInt("Score")};
						      tm.addRow(o);
						}
						
						
		    rs.close();
			pst.close();
		    con.close();
						
					}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage()	);
					}
	
					
				}
			});
						
			btnNewButton.setBounds(47, 541, 152, 29);
			contentPane.add(btnNewButton);
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(15, 124, 681, 0);
			contentPane.add(separator_1);
			
			btnBack = new JButton("MENU");
			
			btnBack.setForeground(new Color(255, 250, 240));
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnBack.setBackground(new Color(0, 51, 102));
			btnBack.setBounds(261, 541, 152, 29);
			contentPane.add(btnBack);
			
			btnExit = new JButton("EXIT");
			btnExit.setBackground(new Color(0, 51, 102));
			btnExit.setForeground(new Color(255, 250, 240));
			btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnExit.setBounds(491, 541, 132, 29);
			contentPane.add(btnExit);
			
		
	}
}
