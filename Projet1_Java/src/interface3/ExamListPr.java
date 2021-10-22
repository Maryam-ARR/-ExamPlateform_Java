package interface3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class ExamListPr extends JFrame {

	Connection con ;
	PreparedStatement pst;
	ResultSet rs = null;
	private JPanel contentPane;
	private JTable table;
	public JButton btnMenu;
	/**
	 * Launch the application.
	 */
	public static void main(String Pr) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamListPr frame = new ExamListPr(Pr);
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
	public ExamListPr(String PR) {
		setBackground(new Color(255, 250, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 725, 445);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 106, 673, 183);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(UIManager.getColor("InternalFrame.inactiveBorderColor"));
		table.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Exam ID", "Field", "Module", "Title"
			}
		));
		table.setBounds(100, 100, 600, 100);
		try{
			String query = "SELECT 	IdExam,Field,Module,Title FROM `examqcm`WHERE CreativeProfessor ='"+PR+"' ";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			
			DefaultTableModel tm=(DefaultTableModel)table.getModel();
			
			tm.setRowCount(0);
				while(rs.next())
					
					{
			   Object o[]={rs.getInt("IdExam"),rs.getString("Field"),rs.getString("Module"),rs.getString("Title")};
			      tm.addRow(o);
					}
				}catch(Exception ex){
						JOptionPane.showMessageDialog(null, ex.getMessage()	);
					}
		scrollPane.setViewportView(table);
		
		JLabel lblTitle = new JLabel("List Of Exams Created");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 0, 128));
		lblTitle.setFont(new Font("Yu Gothic", Font.BOLD, 30));
		lblTitle.setBackground(new Color(0, 51, 102));
		lblTitle.setBounds(15, 0, 673, 54);
		contentPane.add(lblTitle);
		
		JLabel lblPR = new JLabel("By Professor :");
		lblPR.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPR.setForeground(new Color(0, 0, 128));
		lblPR.setHorizontalAlignment(SwingConstants.CENTER);
		lblPR.setBounds(25, 70, 158, 20);
		contentPane.add(lblPR);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setForeground(new Color(255, 250, 240));
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnExit.setBackground(new Color(0, 51, 102));
		btnExit.setBounds(496, 326, 115, 47);
		contentPane.add(btnExit);
		
		btnMenu = new JButton("Menu");
		
		btnMenu.setForeground(new Color(255, 250, 240));
		btnMenu.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnMenu.setBackground(new Color(0, 51, 102));
		btnMenu.setBounds(76, 326, 115, 47);
		contentPane.add(btnMenu);
		
		JLabel lblPRN = new JLabel(PR);
		lblPRN.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblPRN.setForeground(new Color(0, 0, 0));
		lblPRN.setBounds(175, 61, 350, 34);
		contentPane.add(lblPRN);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.windowBorder);
		separator.setBounds(25, 61, 663, -13);
		contentPane.add(separator);
	}
}
