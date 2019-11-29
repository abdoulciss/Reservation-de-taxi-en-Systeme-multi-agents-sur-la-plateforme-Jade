/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AgenTaxi;

import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

/**
 *
 * @author user
 */
public class ContenerAgenTaxi {
       public static void main(String[] args){
        try {
            jade.core.Runtime rt=jade.core.Runtime.instance();
            ProfileImpl pc=new ProfileImpl(false); 
            pc.setParameter(ProfileImpl.MAIN_HOST, "localhost");
            AgentContainer ct=rt.createAgentContainer(pc);
            /*pour demarer un Agen dans */
            AgentController agentController=ct.createNewAgent("taxi1","AgenTaxi.AgenTaxi",new Object[]{"conduire"});
            agentController.start();
        } catch (ControllerException ex) {
            ex.printStackTrace();
        }
        
    
} 
}
