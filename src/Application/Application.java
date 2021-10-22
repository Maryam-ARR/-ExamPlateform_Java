package Application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.mysql.jdbc.PreparedStatement;

import classes.Client;
import classes.TimerDown;
import interface0.PrSt;
import interface1.LogInSys;
import interface1.LogInSysPr;
import interface2.ChoixQcm;
import interface2.Question;
import interface2.ResultsExams;
import interface3.ExamListPr;
import interface3.ListPrEx;
import interface3.NewExam;
import interface3.ProfChoice;
import interface3.SetQuestions;
import interface3.Student_Score;

public class Application {
	Connection con ;

	java.sql.PreparedStatement pst;;
	Statement pst1;
	ResultSet rs = null;
	
	private PrSt space;
	//prof
	private LogInSysPr professor;
	String U_N_P;
	String ExamID;
	String Field;
	private ProfChoice P_C ;
	private Student_Score S_S;
	private NewExam N_E;
	private SetQuestions S_Q;
	private ListPrEx L_P_E;
	private ExamListPr E_L_P;
	//student
	private LogInSys student;
	private interface2.StudentChoice S_C;
	private Question Qs;
	private ChoixQcm C_Q;
	private ResultsExams R_E;
	private TimerDown time;
    Client clt;

	public Application(Client cl) throws SQLException {
		super();
		space=new PrSt();
		student=new LogInSys();
		professor=new LogInSysPr();
		///Space choice
		space.setVisible(true);
		//student login
		space.txtStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				space.setVisible(false);
				student.setVisible(true);
			}});
		//professor login
		space.txtProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				space.setVisible(false);
				professor.setVisible(true);
			}
		});

		//Prof's Space

		/////Prof's LogIn
		P_C =new ProfChoice() ;
        clt=cl;
		professor.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				U_N_P=professor.login( P_C,professor);	
				C_S(U_N_P);
				ProfChoice();
			}});
		/*professor.txtSpeciality.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				super.keyTyped(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				U_N_P=professor.login( P_C,professor);	
				C_S(U_N_P);
				ProfChoice();
			}});*/

		////Student's Space
		///log in 
		S_C=new interface2.StudentChoice();

		student.btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Field=student.loginS(student,S_C);
				C_S(student.txtUser.getText());
				StudentChoice();

			}});
		student.comboBox.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				super.keyTyped(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER) 
				Field=student.loginS(student,S_C);
				C_S(student.txtUser.getText());
				StudentChoice();
			}});


	}
	public void ProfChoice() {
		/////Prof's Choice	
		////view student's Score
		P_C.btnStudentScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				S_S.setVisible(true);
				P_C.setVisible(false);
			}});
		try {
			S_S= new Student_Score();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		S_S.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_C.setVisible(true);
				S_S.setVisible(false);
			}});
		S_S.btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		////Create New Exam
		try {
			N_E=new NewExam(U_N_P);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		P_C.btnNewExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				N_E.setVisible(true);
				P_C.setVisible(false);
			}});
		///Set Exam's Questions
		N_E.btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(N_E.i==1&&N_E.j==0){
					JOptionPane.showMessageDialog(null,"You Saved THe Exam !! Please Set Its Questions Or Delete It !!!");
				}
				else if(N_E.i==1&&N_E.j==1){

					N_E.setVisible(false);
					P_C.setVisible(true);
				}
				else {
					N_E.setVisible(false);
					P_C.setVisible(true);
				}
			}
		});
		N_E.btnSetQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(N_E.i==1){
					ExamID=N_E.ExId(); 
					S_Q=new SetQuestions(ExamID);
					N_E.setVisible(false);
					S_Q.setVisible(true); 
					if (S_Q.btnNext.getText()!="View") {
						S_Q.btnNext.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent one) {
								if(S_Q.clickS>=S_Q.i){
									try {
										String query = "SELECT MCQsAvailable FROM `examqcm` WHERE IdExam='"+S_Q.txtEID.getText()+"' ";
										con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
										pst1=con.createStatement();
										rs=pst1.executeQuery(query);
										while(rs.next())
										{ int j=rs.getInt(1);
										if(S_Q.i==j) {
											S_Q.btnNext.setText("View");
											//JOptionPane.showMessageDialog(null, "Press View Button To See the List Of Question Of The Exam You Created  ");
											L_P_E=new ListPrEx(Integer.parseInt(ExamID));
											S_Q.btnNext.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent two) {
													S_Q.xtDescription.setText(null);
													S_Q.txtC1.setText(null);
													S_Q.txtC2.setText(null);
													S_Q.txtC3.setText(null);
													S_Q.txtC4.setText(null);
													L_P_E.setVisible(true);
													S_Q.setVisible(false);
													//view exam's Questions
													L_P_E.btnCom.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent arg0) {
															if(JOptionPane.showConfirmDialog(null, "Exam Completed !?","",
																	JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) 
															{
																L_P_E.setVisible(false);
															JOptionPane.showMessageDialog(null,"Exam's submission is done succesfully"	);
															P_C.setVisible(true);
															ProfChoice();
														
															}}});
												}});	}
										else {
											S_Q.i++;
											S_Q.xtDescription.setText(null);
											S_Q.txtC1.setText(null);
											S_Q.txtC2.setText(null);
											S_Q.txtC3.setText(null);
											S_Q.txtC4.setText(null);
											S_Q. txtnbQ.setText(String.valueOf(S_Q.i) );
										}}}
									catch (Exception ex) {  
										JOptionPane.showMessageDialog(null, ex.getMessage()	);}
								}
								else {
									JOptionPane.showMessageDialog(null, "Please make sure you SAVED the Question"); }
							}});}



				}else {
					JOptionPane.showMessageDialog(null,"Please Make Sure You SAVED Exam's Informations!!! ");}
			}});	
		///view List Of Exams Created
		E_L_P= new ExamListPr(U_N_P);
		P_C.btnListExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				P_C.setVisible(false);
				E_L_P.setVisible(true);
			}
		});
		E_L_P.btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				E_L_P.setVisible(false);
				P_C.setVisible(true);
			}
		});
	}
	int j=0;

	void StudentChoice() {

		S_C.btnExam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				C_Q=new ChoixQcm(Field);
				C_Q.setVisible(true);
				S_C.setVisible(false);
				///Exam's Choice
				C_Q.btnMenu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						C_Q.setVisible(false);
						S_C.setVisible(true);
					}
				});
				C_Q.table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int i=C_Q.table.getSelectedRow();
						if(!C_Q.passedExam(Integer.valueOf(C_Q.table.getValueAt(i,0).toString()),student.name)) {
							JOptionPane.showMessageDialog(null, "You Have "+C_Q.tab1.getValueAt (i, 1).toString()+" Questions To Answer IN "+C_Q.tab1.getValueAt (i, 0)+" Minutes");
							int M=Integer.valueOf(C_Q.tab1.getValueAt (i, 2).toString());
							if(M==1) {
								JOptionPane.showMessageDialog(null,"1 for a correct answer otherwise 0");
							}else {
								JOptionPane.showMessageDialog(null,"-1: wrong answer, 0: no answer, 1: right answer");
							}
							if(JOptionPane.showConfirmDialog (null,"ready to start the Exam !!","",
									JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {

								int E=(int) C_Q.table.getValueAt (i, 0);
								int Qnb=(int) C_Q.tab1.getValueAt (i, 1);
								C_Q.setVisible(false);
								Qs=new Question(E,Qnb);
								Qs.setVisible(true);
								time=new TimerDown();
								time.runTimer(Integer.parseInt(C_Q.tab1.getValueAt (i, 0).toString())*60,Qs.lblTimer);

								Qs.btnNext.addActionListener(new ActionListener() {       
									public void actionPerformed(ActionEvent one) {

										if(Qs.lblTimer.getText().equalsIgnoreCase("00:00:00")) {
											JOptionPane.showMessageDialog(null, "Time Is UP!!! ");  
											int score=Qs.Score(Qs.tab,Qs.tabS ,M);
											try {
												String query = "SELECT ExamQuestions FROM `examqcm` WHERE IdExam='"+E+"' ";
												con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
												pst1=con.createStatement();
												rs=pst1.executeQuery(query);
												while(rs.next())
												{ 
											JOptionPane.showMessageDialog(null, student.name+",Your Score Is : "+score+" / "+rs.getInt(1));
											Qs.setVisible(false);
											S_C.setVisible(true);
												}
											}catch(Exception ex){
												JOptionPane.showMessageDialog(null, ex.getMessage() );}
											try{
												String query = "INSERT INTO  `student'slist`(Student,Exam,Score) VALUES('"+student.name+"','"+E+"','"+score+"') ;";
												con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
												pst=con.prepareStatement(query);
												pst.executeUpdate();

											}catch(Exception ex){
												JOptionPane.showMessageDialog(null, ex.getMessage() );}
										}	else {
											if(j<Qnb) {
												Qs.tab[j]=Qs.selectedButton();
												Qs.buttonGroup.clearSelection();
												j++;

												if(j!=Qnb) {
													Qs.showQ( j, Qs.nb[j],E);
												}

												if(j==Qnb) {
													JOptionPane.showMessageDialog(null, "Exam subitted successfully , Press Score Button To See your Marke Of The Exam You pased  ");                             
													Qs.btnNext.setText("Score");
													Qs.btnNext.addActionListener(new ActionListener() {
														public void actionPerformed(ActionEvent two) {
															int score=Qs.Score(Qs.tab,Qs.tabS ,M);
															try {
																String query = "SELECT ExamQuestions FROM `examqcm` WHERE IdExam='"+E+"' ";
																con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
																pst1=con.createStatement();
																rs=pst1.executeQuery(query);
																while(rs.next())
																{ 
															JOptionPane.showMessageDialog(null, student.name+",Your Score Is : "+score+" / "+rs.getInt(1));
															Qs.setVisible(false);
															S_C.setVisible(true);
																}
															}catch(Exception ex){
																JOptionPane.showMessageDialog(null, ex.getMessage() );}
															try{
																String query = "INSERT INTO  `student'slist`(Student,Exam,Score) VALUES('"+student.name+"','"+E+"','"+score+"') ;";
																con = DriverManager.getConnection("jdbc:mysql://localhost:3308/loginsys", "root", "");
																pst=con.prepareStatement(query);
																pst.executeUpdate();

															}catch(Exception ex){
																JOptionPane.showMessageDialog(null, ex.getMessage() );}
														}});	

												}}}}});
							}
						}else {
							JOptionPane.showMessageDialog(null, "You Have Already Passed This exam !!! " );
						}
					}});
			}});
		////examResults
		S_C.btnScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				R_E=new ResultsExams(student.name);
				R_E.setVisible(true);
				S_C.setVisible(false);
				R_E.btnNenu.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						R_E.setVisible(false);
						S_C.setVisible(true);
					}
				});
			}
		});
	}
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//new Application();
	}
 void C_S(String name) {
	 try {
			clt.ipServeur=InetAddress.getLocalHost().getHostAddress().toString();
			System.out.println(clt.ipServeur);
			clt.port=1564;
			clt.ClientName= name;
			try {
				clt.openConnexion();
				clt.start();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		} catch (UnknownHostException e2) {
			e2.printStackTrace();
		}
		
	
 }
}
