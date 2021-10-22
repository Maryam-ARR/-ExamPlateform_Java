package interface2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class ResultsExams extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public JButton btnNenu;
	Connection con ;
	PreparedStatement pst;
	
	ResultSet rs = null;
	/**
	 * Launch the application.
	 */
	public static void main(String N) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultsExams frame = new ResultsExams(N);
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
	public ResultsExams(String name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 935, 623);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Results Concerning MCQs That You Have Already Passed");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(0, 51, 102));
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 33));
		lblTitle.setBounds(15, 16, 883, 45);
		contentPane.add(lblTitle);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 77, 883, 10);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 122, 883, 319);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(240, 248, 255));
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Module", "Exam's Title", "Score"
			}
		));
		
		try{
			String query = "SELECT examqcm.Module,examqcm.Title,`student'slist`.Score FROM examqcm INNER JOIN `student'slist` ON examqcm.IdExam = `student'slist`.`Exam` Where `student'slist`.`Student`= '"+name+"'; ";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			
			DefaultTableModel tm=(DefaultTableModel)table.getModel();
			
			tm.setRowCount(0);
				while(rs.next())
					{
				 Object o[]={rs.getString("Module"),rs.getString("Title"),rs.getInt("Score")};
			      tm.addRow(o);
					}
				}catch(Exception ex){
						JOptionPane.showMessageDialog(null, ex.getMessage()	);
					}
		scrollPane.setViewportView(table);
		
		btnNenu = new JButton("MENU");
		
		btnNenu.setBackground(new Color(0, 51, 102));
		btnNenu.setForeground(new Color(255, 250, 240));
		btnNenu.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNenu.setBounds(762, 488, 115, 52);
		contentPane.add(btnNenu);
	}
}
