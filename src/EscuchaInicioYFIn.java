

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class EscuchaInicioYFIn
 *
 */
@WebListener
public class EscuchaInicioYFIn implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public EscuchaInicioYFIn() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("PROGRAMA DESTRUIDO");
    	System.out.println("PROGRAMA DESTRUIDO");
    	System.out.println("PROGRAMA DESTRUIDO");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	 System.out.println("PROGRAMA INICIADO");
    	 System.out.println("PROGRAMA INICIADO");
    	 System.out.println("PROGRAMA INICIADO");
    }
	
}
