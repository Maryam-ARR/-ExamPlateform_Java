package interface3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class ProfChoice extends JFrame {

	private JPanel contentPane;
	public JButton btnStudentScore;
	public JButton btnListExam;
	public JButton btnNewExam;
	/**
	 * Launch the application.
	 */
	public static void main(String []M) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfChoice frame = new ProfChoice();
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
	public ProfChoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 359);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStudentScore = new JButton("Student's Score\r\n");
		
		btnStudentScore.setBackground(new Color(0, 51, 102));
		btnStudentScore.setForeground(SystemColor.menu);
		btnStudentScore.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnStudentScore.setBounds(119, 16, 271, 46);
		contentPane.add(btnStudentScore);
		
		btnNewExam = new JButton("Create New Exam");
		btnNewExam.setBackground(new Color(0, 51, 102));
		btnNewExam.setForeground(SystemColor.menu);
		btnNewExam.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnNewExam.setBounds(119, 89, 271, 46);
		contentPane.add(btnNewExam);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(181, 16, -146, -17);
		contentPane.add(tabbedPane);
		
		btnListExam = new JButton("List Of Exams Created\r\n");
		btnListExam.setForeground(SystemColor.menu);
		btnListExam.setBackground(new Color(0, 51, 102));
		
		btnListExam.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		btnListExam.setBounds(91, 163, 326, 46);
		contentPane.add(btnListExam);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem =new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if u want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
				}
			}});
		btnExit.setForeground(SystemColor.menu);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBackground(new Color(0, 51, 102));
		btnExit.setBounds(181, 235, 141, 46);
		contentPane.add(btnExit);
	}

	
}
