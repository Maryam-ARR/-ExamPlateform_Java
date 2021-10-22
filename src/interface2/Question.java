package interface2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.TimerDown;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;



import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;



public class Question extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea QuestionText;
	public JRadioButton rdbtn1;
	public JRadioButton rdbtn2;
	public JRadioButton rdbtn3;
	public JRadioButton rdbtn4;
	int clickCount=0;
	Connection con ;
	PreparedStatement pst;
	ResultSet rs = null;
	public int []tab;
	public int []tabS;
	public JLabel lblTimer;
	public JButton btnNext;
	private JPanel contentPane;
	public final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtNbQ;
	private TimerDown time;
	public int []nb;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(int E,int q) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Question frame = new Question(E,q);
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
	public Question(int EID,int Q) {
		setTitle("Exam's Questions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 668);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuestion = new JLabel("Choose One Correct Answer");
		lblQuestion.setBounds(76, 16, 432, 58);
		lblQuestion.setForeground(new Color(0, 51, 102));
		lblQuestion.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblQuestion);
		
		rdbtn1=new JRadioButton(); 
		rdbtn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 if (rdbtn1.isSelected()) {

				        if (++clickCount % 2 == 0) {

				        	buttonGroup.clearSelection();
				        }}
			}
		});
		rdbtn1.setForeground(new Color(0, 0, 128));
		rdbtn1.setBounds(15, 279, 626, 68);
		rdbtn1.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		buttonGroup.add(rdbtn1);
		rdbtn1.setBackground(new Color(240, 248, 255));
		contentPane.add(rdbtn1);
		
		rdbtn2=new JRadioButton();
		rdbtn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (rdbtn2.isSelected()) {

				        if (++clickCount % 2 == 0) {

				        	buttonGroup.clearSelection();
				        }}
			}
		});
		rdbtn2.setForeground(new Color(0, 0, 128));
		rdbtn2.setBounds(15, 343, 626, 68);
		rdbtn2.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		buttonGroup.add(rdbtn2);
		rdbtn2.setBackground(new Color(240, 248, 255));
		contentPane.add(rdbtn2);
		
		rdbtn3=new JRadioButton();
		rdbtn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (rdbtn3.isSelected()) {

				        if (++clickCount % 2 == 0) {

				        	buttonGroup.clearSelection();
				        }}
			}
		});
		rdbtn3.setForeground(new Color(0, 0, 128));
		rdbtn3.setBounds(15, 407, 626, 68);
		rdbtn3.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		buttonGroup.add(rdbtn3);
		rdbtn3.setBackground(new Color(240, 248, 255));
		contentPane.add(rdbtn3);
		
		rdbtn4=new JRadioButton();
		rdbtn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 if (rdbtn4.isSelected()) {

				        if (++clickCount % 2 == 0) {

				        	buttonGroup.clearSelection();
				        }}
			}
		});
		
		rdbtn4.setForeground(new Color(0, 0, 128));
		rdbtn4.setBounds(15, 469, 626, 68);
		rdbtn4.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		buttonGroup.add(rdbtn4);
		rdbtn4.setBackground(new Color(240, 248, 255));
		contentPane.add(rdbtn4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 90, 796, 10);
		contentPane.add(separator);
		
		nb=RandomNum(Q);
		tab=new int[Q];
		tabS=new int[Q];
		//time.runTimer(*60,lblTimer);
	    btnNext = new JButton("NEXT");
		btnNext.setBounds(522, 553, 119, 43);
		btnNext.setForeground(new Color(0, 51, 102));
		btnNext.setBackground(new Color(220, 220, 220));
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 28));
		contentPane.add(btnNext);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 98, 626, 173);
		contentPane.add(scrollPane);
		
		QuestionText = new JTextArea();
		QuestionText.setEditable(false);
		QuestionText.setBounds(249, 138, 392, 117);
		QuestionText.setFont(new Font("Tahoma", Font.ITALIC, 22));
		QuestionText.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(QuestionText);
		
		txtNbQ = new JTextField();
		
		txtNbQ.setText("1");
		showQ( 0, nb[0],EID);
		txtNbQ.setForeground(new Color(255, 250, 240));
		txtNbQ.setHorizontalAlignment(SwingConstants.CENTER);
		txtNbQ.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtNbQ.setBackground(new Color(0, 51, 102));
		txtNbQ.setEditable(false);
		txtNbQ.setBounds(15, 31, 42, 37);
		contentPane.add(txtNbQ);
		txtNbQ.setColumns(10);
		
		lblTimer = new JLabel("");
		lblTimer.setForeground(new Color(255, 51, 51));
		lblTimer.setFont(new Font("Ubuntu Mono", Font.PLAIN, 30));
		
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(509, 16, 147, 58);
		contentPane.add(lblTimer);
		
		
		
		
	}
	 
	/////////////////////////////////////////////////////////
	void Rdbtn(JRadioButton Rb,String text) {
		Rb=new JRadioButton();
		Rb.setText(text);
		Rb.setForeground(new Color(0, 0, 128));
		Rb.setBounds(15, 279, 626, 68);
		Rb.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		buttonGroup.add(Rb);
		Rb.setBackground(new Color(255, 250, 240));
		contentPane.add(Rb);
	}
	int[] RandomNum(int n) {
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=i+1;
		}
		int[]result=new int[n];
		int j=n;
		SecureRandom Sr=new SecureRandom();
		for(int i=0;i<n;i++) {
			int k=Sr.nextInt(j);
			result[i]=a[k];
			a[k]=a[j-1];
			j--;
		}
		return result;
		}
	////////////
	public int selectedButton() {
		int i=0;
		 
		if(rdbtn1.isSelected()) {
			i=1;
			
		}
		else if(rdbtn2.isSelected()) {
			i=2;
			
		}
		else if(rdbtn3.isSelected()) {
			i=3;
			
		}
		else if(rdbtn4.isSelected()) {
			i=4;
			
		}
		else {
			i=-1;
		}
		return i;
	}
	///////////
	
	public void showQ(int i,int Q,int E) {
		
		txtNbQ.setText(String.valueOf(i+1));
		try{
			String query = "SELECT Description,Choice_1,Choice_2,Choice_3,Choice_4,RightAnswer FROM `Questionqcm`WHERE ID_E='"+E +"'AND Id_Q='"+Q+"' ";
			con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
			pst=con.prepareStatement(query);
			rs=pst.executeQuery();
			while(rs.next())
					{	QuestionText.setText(rs.getString(1));
					
					rdbtn1.setText(rs.getString(2));
					rdbtn2.setText(rs.getString(3));
					rdbtn3.setText(rs.getString(4));
					rdbtn4.setText(rs.getString(5));
						tabS[i]=rs.getInt(6);
				
					}}catch(Exception ex){
						JOptionPane.showMessageDialog(null, "eeeeeee"	);
					}
		
	}
	///////////
	
	public int Score(int []i,int []j,int m) {
		int []S=new int[i.length];
		int A=0;
		for(int k=0;k<i.length;k++) {
			if(m==1) {
				if(i[k]==j[k]) {
					S[k]=1;
				}
				else {
					S[k]=0;
				}
			}
			if(m==2) {
				if(i[k]==j[k]) {
					S[k]=1;
				}
				else if(i[k]==-1) {
					S[k]=0;
				}
				else{
					S[k]=-1;
			}
			}
		}
		for(int n=0;n<S.length;n++) {
			A=A+S[n];
		}
		
		return  A;
	}
	///////////////
	
}
