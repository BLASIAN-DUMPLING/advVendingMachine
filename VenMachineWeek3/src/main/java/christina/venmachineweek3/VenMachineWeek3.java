/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package christina.venmachineweek3;
import christina.venmachineweek3.controller.VendingMachineController;
import christina.venmachineweek3.service.VendingMachinePersistenceException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author chris
 */
public class VenMachineWeek3 {

   
      public static void main(String[] args) throws VendingMachinePersistenceException {
       // UserIO myIo = new UserIOImpl();
       // VendingMachineView MyView = new VendingMachineView(myIo);
       // VendingMachineAuditDao MyAuditDao = new VendingMachineAuditDaoImpl();
       // VendingMachineDao MyDao = new VendingMachineDaoImpl();
       // VendingMachineServiceLayer MyService = new VendingMachineServiceLayerImpl(MyDao, MyAuditDao);
       // VendingMachineController controller = new VendingMachineController(MyView, MyService);
       // controller.run();
    
       
       ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
       VendingMachineController controller = ctx.getBean("controller", VendingMachineController.class);
        controller.run();
    }
      }

