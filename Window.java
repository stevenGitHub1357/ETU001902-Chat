package affichage;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class Window extends JFrame{
	Interface tab;
	Socket socket;
    public Window(Socket so){
    	this.socket = so;
    	this.tab = new Interface(this);
        this.setSize(800,400);
        this.setTitle("ChatClient");
        this.setLayout(null);
        this.add(tab);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Socket getSocket(){
    	return this.socket;
    }
}