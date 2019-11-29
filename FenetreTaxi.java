

package AgenTaxi;


import jade.gui.GuiEvent;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
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
public class FenetreTaxi extends JFrame{
     AgenTaxi taxi;
    JTextField ChampNumTaxi=new JTextField();
    JLabel labelNumTaxi=new JLabel("Numero du taxi");
    JTextField champnombreDePlace=new JTextField();
    JLabel labelnombreDePlace=new JLabel("Nombre de place");
    JTextField champdistance=new JTextField();
    JLabel labeldistance=new JLabel("Tableau de bord du taxi");
    JTextArea champMessage=new JTextArea();
    JCheckBox etatTaxi=new JCheckBox();
    
    JButton envoi= new JButton("Tableau de bord du taxi");
    
    JPanel paneauPrincipal=new JPanel();
    
    public FenetreTaxi(){
        paneauPrincipal.add(labeldistance);
       
        this.add(paneauPrincipal,BorderLayout.NORTH);
        this.add(new JScrollPane(champMessage),BorderLayout.CENTER);
        this.setSize(500,500);
        this.setVisible(true);
    }
public static void main(String[] args){
    FenetreTaxi demar=new FenetreTaxi();
    
} 
public void setAgenTaxi(AgenTaxi agenTaxi){
        this.taxi=agenTaxi;
                }
    public AgenTaxi getAgenTaxi(){
        return taxi;
                }

public void setText(String text){
    if(champMessage.getText()==null){
       
       champMessage.setText(text); 
    }
    else
    {
        
       champMessage.setText("-------------------------------------------------------------\n");
      champMessage.setText(""+text);  
    }
    
    
}
public String getText(){
    return champMessage.getText();
        
    }
public void showMessage(String message, boolean append){
        if(append==true){
            champMessage.append(message);
            
        }
        else{
                 champMessage.setText(message+"\n");
                 champMessage.setText("----------------------------------------------------------------------\n");
        }
    
}
}