package interface0;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import interface1.LogInSys;
import interface1.LogInSysPr;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class PrSt extends JFrame {

	public JButton txtStudent;
	public JButton txtProf;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrSt frame = new PrSt();
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
	public PrSt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 108, 487, 2);
		contentPane.add(separator);
		
		 txtStudent = new JButton("Student's Space");
		txtStudent.setForeground(SystemColor.control);
		txtStudent.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtStudent.setBackground(new Color(0, 51, 102));
		
		txtStudent.setBounds(120, 220, 263, 51);
		contentPane.add(txtStudent);
		
		txtProf = new JButton("Professor's Space");
		txtProf.setForeground(SystemColor.control);
		txtProf.setFont(new Font("Tahoma", Font.PLAIN, 26));
		
		txtProf.setBackground(new Color(105, 105, 105));
		txtProf.setBounds(120, 133, 263, 51);
		contentPane.add(txtProf);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 37));
		lblWelcome.setBounds(120, 16, 263, 62);
		contentPane.add(lblWelcome);
	}

}
