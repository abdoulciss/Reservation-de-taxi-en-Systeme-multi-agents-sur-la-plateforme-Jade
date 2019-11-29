/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AgenTaxi;
import jade.core.AID;
import jade.core.Agent;
import jade.core.ServiceDescriptor;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAException;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AgenTaxi extends GuiAgent{
        FenetreTaxi fenetre;
    public void setup(){
        
        
        
        fenetre=new FenetreTaxi();
        fenetre.setAgenTaxi(this);
        fenetre.setVisible(true);
        Object[] object=getArguments();
        
         addBehaviour(new OneShotBehaviour() {

            @Override
            public void action() {
              
              /*bublier service*/
                DFAgentDescription descriptionAgenTaxi=new DFAgentDescription();
                descriptionAgenTaxi.setName(getAID());
                ServiceDescription taxiService=new ServiceDescription();
                taxiService.setType("Conduire");
                taxiService.setName("Transporter-client");
                descriptionAgenTaxi.addServices(taxiService);
                try {                
                    DFService.register(myAgent, descriptionAgenTaxi);
                } catch (FIPAException ex) {
                    Logger.getLogger(AgenTaxi.class.getName()).log(Level.SEVERE, null, ex);
                }
                
    }
});
         
        
          addBehaviour(new CyclicBehaviour() {

            @Override
            public void action() {
                int counter=0;
                /*envoi de message entre Agen*/
                 ACLMessage aclmessage=receive();
                 if(aclmessage!=null){
                     ++counter;
                     System.out.println("En attente de reception"+counter);
                     switch(aclmessage.getPerformative()){
                         case ACLMessage.CFP:
                              
                              /*metre dans la fenetre*/
                              fenetre.setText(aclmessage.getContent());
                          
                                 ACLMessage envoiMessage=new ACLMessage(ACLMessage.PROPOSE);
                                 envoiMessage.addReceiver(new AID("client1",AID.ISLOCALNAME));
                                    
                                 envoiMessage.setContent("je suis libre a 100 dn par km");
                                 send(envoiMessage);
                                
                             break;
                             
                             case ACLMessage.PROPOSE: 
                                  
                                fenetre.setText("\n"+aclmessage.getContent());
              
                                envoiMessage=new ACLMessage(ACLMessage.NOT_UNDERSTOOD);
                                envoiMessage.addReceiver(new AID("client1",AID.ISLOCALNAME));
                                    
                                 envoiMessage.setContent("je peut je suis d'acord pour 90 dn pa km");
                                send(envoiMessage);
                              
                               
                             break;
                                 
                                 
                         case ACLMessage.ACCEPT_PROPOSAL:
                             
                               envoiMessage=new ACLMessage(ACLMessage.AGREE);
                                envoiMessage.addReceiver(new AID("client1",AID.ISLOCALNAME));
                                
                                 envoiMessage.setContent("je sui ok");
                                 send(envoiMessage);
                                
                             break;
                             
                       
                         
                             
                     }
              
                
            } else{
                block();
            }
                
            }
        });
         
        
    }

    @Override
    protected void onGuiEvent(GuiEvent ge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
