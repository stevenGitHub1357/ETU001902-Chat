package affichage;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import ecoute.*;
import upload.*;
public class Interface extends JPanel{
    JPanel pan = new JPanel();
        //JPanel pan1 = new JPanel();
        JPanel contenu = new JPanel();
        JTextArea textPane = new JTextArea();
        JTextField text = new JTextField();
        JTextField text1 = new JTextField();
        JButton envoyer = new JButton("Send");
        JButton actu = new JButton("Refresh");
        JLabel lab = new JLabel("welcome to chat");
        JLabel lab1 = new JLabel("");
        
        Upload up = new Upload();
        Vector<String> str = up.getMessageServer("Client.txt");
        Vector<String> str1 = up.getMessageServer("Server.txt");
        JLabel[] anatiny = new JLabel[str.size()];
        JLabel[] anatiny1 = new JLabel[str1.size()];
        int x = 10;
        //JScrollPane scroll = new JScrollPane(anatiny);
        //int y = 10;
        //Vector<String> str = new Vector<String>();
        Window fen;
        public Interface(Window fen){
        this.fen = fen;
        this.setSize(800,400);
        this.setLayout(null);
        lab.setBounds(375,20,200,80);
        pan.setBounds(200,250,400,60);
        pan.setBackground(Color.pink);
        text.setPreferredSize(new Dimension(250, 50));
        pan.add(text);
       // pan1.setBounds(500,250,200,60);
        envoyer.setBackground(Color.RED);
        envoyer.setForeground(Color.YELLOW);
        envoyer.setPreferredSize(new Dimension(100, 30));
        envoyer.addMouseListener(new Listner(this,fen.getSocket()));
        pan.add(envoyer);
        //contenu.add(lab1);
        message1(anatiny,str,anatiny1,str1);
        contenu.setBounds(200,80,400,150);
        //scroll.setPreferredSize(new Dimension(200,100));
        //System.out.println(str.get(0));
        //contenu.setBackground(Color.red);
        //contenu.add(scroll);
        actu.setBounds(80,10,100,20);
        actu.addMouseListener(new Listner(this,fen.getSocket()));
        actu.setBackground(Color.pink);
        this.add(contenu);
        this.add(actu);
        //this.validate();
        this.add(pan);
        //this.add(pan1);
        this.add(lab);
       
    }
        public JButton getBouton(){
                return this.envoyer;
        }
        public JButton getBouton1(){
                return this.actu;
        }
        public JTextField getField(){
                return this.text;
        }
        public JLabel[] getLabel1(){
                return this.anatiny1;
        }
        public void setLabel1(JLabel[] lab){
                this.anatiny1 = lab;
        }
        public JLabel[] getLabel(){
                return this.anatiny;
        }
        public void setLabel(JLabel[] lab){
                this.anatiny = lab;
        }
        public Vector<String> getMessageAffichier(){
                return this.str;
        }
        public Vector<String> getMessageAffichier1(){
                return this.str1;
        }
        public void setMessageAffichier(Vector<String> str1){
                this.str = str1;
        }
        public void setMessageAffichier1(Vector<String> str){
                this.str1 = str;
        }

        public void message1(JLabel[] lab,Vector<String> str,JLabel[] lab1,Vector<String> str1){
            int y =5; int x =200; int y1=5;
            //System.out.println(anatiny.length);
            for(int i=0;i<lab.length;i++){
                contenu.setLayout(null);
                lab[i] = new JLabel(str.get(i));
                lab[i].setBounds(10,y,200,20);
                lab[i].setForeground(Color.blue);
                contenu.add(lab[i]);
                /*anatiny1[i] = new JLabel(str1.get(i));
                anatiny1[i].setBounds(x,y,200,20);
                anatiny1[i].setBackground(Color.gray);
                contenu.add(anatiny1[i]);*/
                y = y+30; 
                //System.out.println(y);
            }
            for(int p=0;p<lab1.length;p++){
                lab1[p] = new JLabel(str1.get(p));
                lab1[p].setBounds(x,y1,200,20);
                lab1[p].setForeground(Color.gray);
                contenu.add(lab1[p]);
                y1 = y1+30;
            }
        }

        public void start(){
            this.removeAll();
            
            //this.add(contenu);
            message1(getLabel(),getMessageAffichier(),getLabel1(),getMessageAffichier1());
            this.add(contenu);
            this.add(actu);
            this.add(pan);
            //this.add(pan1);
            this.add(lab);
            repaint();
        }
}