/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AgenTaxi;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class FenetreAgen  extends JFrame{
 
  
  
    private JLabel labelNomAgen= new JLabel("Recherche de taxi");
    private JTextField champText=new JTextField(25);
    
    private JLabel labelTypeTaxi=new JLabel("Poposer votre prix");
    private JTextField champTextTypeTaxi=new JTextField(25);
    private JTextArea champMessage= new JTextArea();
    
    JButton buttonEnvoi=new JButton("Envoi");
    JButton buttonRecher=new JButton("Recherche");
    AgenClient client;
    public FenetreAgen(){
        super();
        JPanel composantPrincipal= new JPanel();
        JPanel composantPrincipal2= new JPanel();
        composantPrincipal.setLayout(new FlowLayout());
         // composantPrincipal.add(buttonEnvoi);
        composantPrincipal.add(labelNomAgen);
        composantPrincipal.add(champTextTypeTaxi);
        composantPrincipal.add(labelTypeTaxi);
        
         champText.setFont(new Font("arial",Font.BOLD,14));
         composantPrincipal.add(champText );
        this.setLayout(new BorderLayout());
        
        this.add(composantPrincipal,BorderLayout.NORTH);
         this.add(composantPrincipal2,BorderLayout.SOUTH);
        this.add(new JScrollPane(champMessage),BorderLayout.CENTER);
       this.setSize(600, 600);
       this.setVisible(true);
       buttonEnvoi.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                client.setAgent();
               
            }
        });
        
    }
    public static void main(String[] args){
        FenetreAgen demare=new FenetreAgen();       
    }
    /*pour pouvoir faire les modification quil fau 
    depuis la fenetre sur un agent taxi ou 
    recuperer les inf dont on a besoi*/
    public AgenClient getAgenClient(){
        return client;
    }
    public void setAgenClient(AgenClient clien){
        this.client=client; 
    }
    /*pour pouvoir metre du texte dans le champ de text*/
    public void showMessage(String message, boolean append){
        if(append==true){
            champMessage.append(message+"\n");
             champMessage.append("-----------------------------------------------------------");
        }
        else{
                 champMessage.setText(message+"\n");
                 champMessage.append("-----------------------------------------------------------");
        }
  
   // public String sendMessage(){
       
        
   }
      public String getchamp(){
        return champMessage.getText();
                }
       public String getTextField(){
       return champText.getText();
                }
       
        public String getabelTypeTaxi(){
       
          return champTextTypeTaxi.getText();
                }
      
     
    
}
