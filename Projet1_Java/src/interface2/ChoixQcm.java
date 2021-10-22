package interface2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class ChoixQcm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTable table;
	public JTable tab1;
	public JButton btnMenu;
	Connection con ;
	PreparedStatement pst;
	Statement ps1;
	ResultSet rs = null;
	public Object T[][];

	/**
	 * Launch the application.
	 */
	public static void main(String F) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoixQcm frame = new ChoixQcm(F);
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
	public ChoixQcm(String Field) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 577);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblChoose = new JLabel("the MCQs available");
		lblChoose.setBounds(5, 5, 763, 49);
		lblChoose.setForeground(new Color(0, 51, 102));
		lblChoose.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoose.setBackground(SystemColor.control);
		lblChoose.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		contentPane.add(lblChoose);

		JSeparator separator = new JSeparator();
		separator.setBounds(15, 70, 738, 2);
		contentPane.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 86, 728, 271);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(240, 248, 255));

		table.setFillsViewportHeight(true);
		table.setFont(new Font("Times New Roman", Font.BOLD, 18));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Exam's ID","Module", "Exam's Title", "Professor"
				}
				));
		scrollPane.setViewportView(table);
		tab1=new JTable();
		try{
			String query = "SELECT IdExam,Module,Title,CreativeProfessor,ExamQuestions,E_Timing,E_Mark FROM `examqcm`WHERE Field ='"+Field +"' ";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			DefaultTableModel tm0=(DefaultTableModel)tab1.getModel();
			DefaultTableModel tm=(DefaultTableModel)table.getModel();
			tm0.setColumnCount(3);
			tm.setRowCount(0);
			while(rs.next())
			{

				Object o[]={rs.getInt("IdExam"),rs.getString("Module"),rs.getString("Title"),rs.getString("CreativeProfessor")};
				tm.addRow(o);

				Object O[]= {rs.getInt("E_Timing"),rs.getInt("ExamQuestions"),rs.getInt("E_Mark")};
				tm0.addRow(O);		
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage()	);
		}
		btnMenu = new JButton("MENU");

		btnMenu.setBackground(new Color(0, 51, 102));
		btnMenu.setForeground(new Color(255, 250, 240));
		btnMenu.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnMenu.setBounds(574, 434, 141, 43);
		contentPane.add(btnMenu);
	}
	boolean i=false;

	public boolean passedExam(int IDE,String S) {
		try{
			String query = "SELECT Exam FROM `student'slist`WHERE Student ='"+S +"' ";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next())
			{
				if(IDE==rs.getInt(1)) {
					i=true;
				}
				else {
					i=false;
				}
			}
		}catch(Exception ex){
			JOptionPane.showMessageDialog(null, ex.getMessage()	);
		}
		return i ;
	}
}
