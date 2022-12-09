package run;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;
public class Ecoute implements Runnable{
	Socket s;
        String msg = ""; 
        DataInputStream dataIn;
        Vector<String> str = new Vector<String>();
	public Ecoute(Socket s){
		this.s = s;
                try{
                        this.dataIn = new DataInputStream(s.getInputStream());
                }catch(Exception e){
                        e.printStackTrace();
                }
	}
	public void run(){
        msg = "";
        while(!msg.equals("stop"))
        {
        	try{ 
        		//System.out.println("zavatra: "+dataIn.readUTF());
                        String n = dataIn.readUTF()+".";
                        System.out.println(n);
                       
                        
        	}catch(Exception e){
        	e.printStackTrace();
        }
        }
	}
        public void setMessage(String str){
                this.msg = str;
        }
        public Vector<String> getMessage(){
                return this.str;
        }

        public void Manoratra(String nom)
        {        
                try 
                { 
                        File fichier = new File("Server.txt"); 
                        FileWriter flux = new FileWriter(fichier,true);
                        flux.write(nom+";;");
                        flux.close();
                }
                        catch (FileNotFoundException e) { e.printStackTrace(); } 
                        catch (IOException e) { e.printStackTrace(); }
        }
}