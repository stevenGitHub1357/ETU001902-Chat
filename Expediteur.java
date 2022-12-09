package run;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
public class Expediteur implements Runnable{
	Socket s;
    String msg = "";
    Vector<String> str = new Vector<String>();
	public Expediteur(Socket s){
		this.s = s;
	}
	public void run(){
		DataOutputStream dataOut = null;
		try{
        	dataOut = new DataOutputStream(s.getOutputStream());
        }catch(Exception e){
        	e.printStackTrace();
        }
        BufferedReader pen = new BufferedReader(new InputStreamReader(System.in));
        msg = "";
        while(!msg.equals("stop"))
        {
            System.out.print("Me : ");
            try{
                str.add(pen.readLine());
            	String myMsg = pen.readLine();
            	dataOut.writeUTF(myMsg);
            }catch(Exception e){
            	e.printStackTrace();
            }
            System.out.println();
        }
	}
    public void setMessage(String str){
        this.msg = str;
    }
    public Vector<String> getMessage(){
        return this.str;
    }
}