package classes;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class Serveur {
	public ServerSocket socServer;
	String ip;
	int port=1564;
	public ArrayList<ClientSpace> listClients=new ArrayList<ClientSpace>();
	public void ecouter() {
		try {
			ip=InetAddress.getLocalHost().getHostAddress().toString();
			try {
				socServer=new ServerSocket(port);
				while(true) {
					Socket socClient=socServer.accept();
					ClientSpace c=new ClientSpace(socClient,this);
					this.listClients.add(c);
					c.start();
					System.out.println("Serveur : nouveau client connnecte! \n il y a "+this.listClients.size()+" clients");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println("impossible de resoudre l'adresse IP du serveur !");
		}
		
	}

	public static void main(String[] args) {
		
		Serveur server=new Serveur();
		server.ecouter();
	}

}
