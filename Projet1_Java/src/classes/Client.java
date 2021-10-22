package classes;
import java.io.*;
import java.net.*;
import java.sql.SQLException;

import Application.Application;
public class Client extends Thread{
	public String ClientName;
	public String ipServeur;
	public int port;
	Socket SocketClient;
	DataOutputStream dataOut;
	DataInputStream dataIn;
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		new Client();
	}
	public Client() throws SQLException {
		new Application(this);
	}
	public void openConnexion() throws IOException {
	System.out.println("connecter au serveur");/////////////////////////////////////
	System.out.println(ipServeur);
	System.out.println(port);
		SocketClient =new Socket(ipServeur,port);
		
		System.out.println("creation des canneaux");/////////////////////////////////////
		dataIn=new DataInputStream(SocketClient.getInputStream());
		dataOut=new DataOutputStream(SocketClient.getOutputStream());
	
		System.out.println("envoyer le nom du client au serveur");///////////////////////////////
		dataOut.writeUTF(ClientName);

	}
	//boite de reception
		public void run() {
			while(true) {
				try {
					String msg=dataIn.readUTF();///recuperer du serveur!!!!!!
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Boitereception: probleme");
				}
			}
			
		}
	}
