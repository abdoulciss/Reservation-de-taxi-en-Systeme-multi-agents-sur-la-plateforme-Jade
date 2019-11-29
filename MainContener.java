package AgenTaxi;

import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.util.ExtendedProperties;
import jade.wrapper.AgentContainer;
import jade.util.leap.Properties;
import jade.wrapper.ControllerException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author user
 */
public class MainContener {
    /*pour demarer le mainConteneur*/
    public static void main(String[] args){
        try {
            Runtime rt=Runtime.instance();
            Properties p=new ExtendedProperties();
            p.setProperty("gui", "true");
            ProfileImpl pc=new ProfileImpl(p);
            AgentContainer container=rt.createMainContainer(pc);
            container.start();
        } catch (ControllerException ex) {
            Logger.getLogger(MainContener.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
 
    
}
