package ecoute;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import affichage.*;
import run.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import upload.*;
public class Listner1 implements MouseListener
{
	Interface1 cre;
	Ecoute ex;
	DataOutputStream dat;
	public Listner1(Interface1 cre, Socket so)
	{
		try{
		this.dat = new DataOutputStream(so.getOutputStream());
	}catch(Exception ey){
		ey.printStackTrace();
	}	
		this.cre = cre;
	
	}

	public void Manoratra()
	{		try 
			{ 
				File fichier = new File("Server.txt"); 
				FileWriter flux = new FileWriter(fichier,true);
				flux.write(cre.getField().getText()+";;");
				flux.close();
			}
			catch (FileNotFoundException e) { e.printStackTrace(); } 
			catch (IOException e) { e.printStackTrace(); }
	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==cre.getBouton()){
			
			try{
				dat.writeUTF(cre.getField().getText());
			}catch(Exception ex){
				ex.printStackTrace();
			}
			Manoratra();
			Upload up = new Upload();
			Vector<String> str = up.getMessageServer("Server.txt");
        	Vector<String> str1 = up.getMessageServer("Client.txt");
        	cre.setMessageAffichier(str);
        	cre.setMessageAffichier1(str1);
        	JLabel[] lab = new JLabel[str.size()];
        	JLabel[] lab1 = new JLabel[str1.size()];
        	cre.setLabel(lab);
        	cre.setLabel1(lab1);
			cre.getField().setText("");
			cre.start();
		}
		if (e.getSource()==cre.getBouton1()) {
			Upload up = new Upload();
			Vector<String> str = up.getMessageServer("Server.txt");
        	Vector<String> str1 = up.getMessageServer("Client.txt");
        	cre.setMessageAffichier(str);
        	cre.setMessageAffichier1(str1);
        	JLabel[] lab = new JLabel[str.size()];
        	JLabel[] lab1 = new JLabel[str1.size()];
        	cre.setLabel(lab);
        	cre.setLabel1(lab1);
			cre.getField().setText("");
			cre.start();
		}
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseExited(MouseEvent e)
	{

	}
	public void mousePressed(MouseEvent e)
	{

	}
	public void mouseReleased(MouseEvent e)
	{

	}
}