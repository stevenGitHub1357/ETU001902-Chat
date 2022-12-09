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
public class Window1 extends JFrame{
	Interface1 tab;
	Socket socket;
    public Window1(Socket so){
    	this.socket = so;
    	this.tab = new Interface1(this);
        this.setSize(800,400);
        this.setTitle("ChatServer");
        this.setLayout(null);
        this.add(tab);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Socket getSocket(){
    	return this.socket;
    }
}