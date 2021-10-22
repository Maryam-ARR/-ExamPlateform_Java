package classes;


import java.net.*;
import java.io.*;
public class ClientSpace extends Thread{
	public Serveur server;
	Socket clientSocket;
	Boolean statut=true;
	String clientName,msgin,msgout;
	public DataInputStream depuisClient;
	public DataOutputStream versClient;
	public ClientSpace(Socket socket,Serveur server) {
		this.server=server;
		this.clientSocket=socket;
		///creation des cannaux
		try {
			depuisClient=new DataInputStream(socket.getInputStream());
			versClient=new DataOutputStream(socket.getOutputStream());
			clientName=depuisClient.readUTF();
			versClient.writeUTF("Bonjour "+clientName);
			System.out.println("Bonjour "+clientName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Probleme dans la reception du nom client");
			server.listClients.remove(this);
		}
	}
	public void run() {
			try {
				while(true) {
				msgin=depuisClient.readUTF();
				for(int i=0;i<server.listClients.size();i++) {
					server.listClients.get(i).versClient.writeUTF(this.clientName+":"+msgin);
				}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Client deconnecte :"+clientName);
				server.listClients.remove(this);
				System.out.println("il reste :"+server.listClients.size()+"clients");
				return;
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}