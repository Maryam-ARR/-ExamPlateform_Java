package interface2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentChoice extends JFrame {

	private JPanel contentPane;
	public JButton btnExam ;
	public JButton btnScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentChoice frame = new StudentChoice();
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
	public StudentChoice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 336);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnExam = new JButton("Available Exams");
		btnExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExam.setBackground(new Color(220, 220, 220));
		btnExam.setForeground(new Color(0, 51, 102));
		btnExam.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExam.setBounds(31, 16, 396, 46);
		contentPane.add(btnExam);
		
		btnScore = new JButton("Results Of MCQ Exams Passed");
		
		btnScore.setBackground(new Color(220, 220, 220));
		btnScore.setForeground(new Color(0, 51, 102));
		btnScore.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnScore.setBounds(15, 115, 424, 46);
		contentPane.add(btnScore);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmLoginSystem =new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if u want to exit","Login Systems",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) 
				{
					System.exit(0);
				}
			}
		});
		btnExit.setBackground(new Color(220, 220, 220));
		btnExit.setForeground(new Color(0, 51, 102));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExit.setBounds(104, 218, 242, 46);
		contentPane.add(btnExit);
	}
}
