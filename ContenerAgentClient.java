/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AgenTaxi;

import jade.core.ProfileImpl;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jade.core.Runtime;
import jade.wrapper.AgentController;
/**
 *
 * @author user
 */
public class ContenerAgentClient  {
    AgenClient client=new AgenClient();
     public static void main(String[] args){
        try {
            Runtime rt=Runtime.instance();
            ProfileImpl pc=new ProfileImpl(false); 
            pc.setParameter(ProfileImpl.MAIN_HOST, "localhost");
            AgentContainer ct=rt.createAgentContainer(pc);
            /*pour demarer un Agen dans */
            AgentController agentController=ct.createNewAgent("client1","AgenTaxi.AgenClient",new Object[]{"client"});
            agentController.start();
        } catch (ControllerException ex) {
            ex.printStackTrace();
        }
        
    
}
}
