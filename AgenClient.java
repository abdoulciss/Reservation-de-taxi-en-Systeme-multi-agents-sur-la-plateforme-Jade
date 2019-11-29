/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AgenTaxi;

import jade.core.* ;
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
import jade.lang.acl.MessageTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class AgenClient extends GuiAgent {
    /*Agument de l'agent */
    String livre;
     private AID[] listTaxi;
    private FenetreAgen monFentre;
 
    protected void setup(){
        monFentre=new FenetreAgen();
        monFentre.setAgenClient(this);
        Object[] object=getArguments();
         
      
    
       
     
 
      
                /*ajouter un comportement */
       
        
       
            
             addBehaviour(new TickerBehaviour(this, 6000) {
            
            @Override
            protected void onTick() {
                
               ACLMessage envoiMessage=new ACLMessage(ACLMessage.CFP);
                 envoiMessage.addReceiver(new AID("taxi1",AID.ISLOCALNAME));
                if(monFentre.getTextField()!=null){
                envoiMessage.setContent(monFentre.getabelTypeTaxi());
               
                send(envoiMessage);
                block();
                }
                else{
                    block();
                }
              /*Enregistre les service de l'agen*/
                try {
               DFAgentDescription descriptAgenLiaison=new DFAgentDescription();
                descriptAgenLiaison.setName(getAID());
                ServiceDescription serviceAgenLiaison=new ServiceDescription();
                serviceAgenLiaison.setType("Conduire");
                /*enregistrement*/
               descriptAgenLiaison.addServices(serviceAgenLiaison);
               
                
                    /*liste les agen taxi enregistre avec le mme nom de service*/
                    DFAgentDescription[] agenDescription=DFService.search(myAgent, descriptAgenLiaison);
                    listTaxi =new AID[agenDescription.length];
                    
                    /*envoi de message a tou les agent qui divuse le service conduire*/
                    for(int i=0;i<agenDescription.length;i++){
                        listTaxi[i]=agenDescription[i].getName();
                  envoiMessage=new ACLMessage(ACLMessage.CFP);
                envoiMessage.addReceiver(new AID(listTaxi[i].getName(),AID.ISLOCALNAME));
                if(monFentre.getchamp()!=null){
                envoiMessage.setContent(monFentre.getabelTypeTaxi());
                send(envoiMessage);
                } 
                else{
                    block();
                }
                        
                        
                    
                    }
                } catch (FIPAException ex) {
                    Logger.getLogger(AgenClient.class.getName()).log(Level.SEVERE, null, ex);
                }
               
              
                       
               
                
                
                
            }
        }); 
        
           
            
            
               addBehaviour(new CyclicBehaviour() {
            int compter=0;
            public void action() {
                
            
                //MessageTemplate monfiltre=MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM),MessageTemplate.MatchOntology("achat"));
            ACLMessage aclmessage=receive();//monfiltre
            if(aclmessage!=null){
                switch(aclmessage.getPerformative()){
                         case ACLMessage.INFORM:
                            monFentre.showMessage(aclmessage.getContent(), false);
                             break;
                         case ACLMessage.PROPOSE:
                            monFentre.showMessage("\n", false);
                            monFentre.showMessage(aclmessage.getContent(), false);
                               /*envoi de message vers un autre agen*/
                                  ACLMessage envoiMessage=new ACLMessage(ACLMessage.PROPOSE);
                            envoiMessage.addReceiver(new AID("taxi1",AID.ISLOCALNAME));
                                if(monFentre.getTextField()!=null){
                                 envoiMessage.setContent(monFentre.getTextField());
                                  send(envoiMessage);
                                         } 
                                             else{
                                                   block();
                                                         }
                         break;
                             case ACLMessage.AGREE:
                                   monFentre.showMessage(aclmessage.getContent(), false);
                                   block();
                             break;
                         case ACLMessage.NOT_UNDERSTOOD:
                                  envoiMessage=new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                            envoiMessage.addReceiver(new AID("taxi1",AID.ISLOCALNAME));
                               
                                 envoiMessage.setContent("ok");
                                  send(envoiMessage);
                           break;
                             
                             
                 }
                
                 }else{
                block();
            }
            }
        });
        
                
        
        
    }
    public void setAgent(){
         
        
        
       
        
    }
   
    protected void onGuiEvent(GuiEvent ge) {
        
        
    }
    
}
