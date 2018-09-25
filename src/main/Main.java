
package main;
import views.viewLeer;
import models.modelLeer;
import controllers.controllerLeer;
/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        viewLeer viewleer = new viewLeer();
        modelLeer modelleer = new modelLeer();
        controllerLeer controllerbloc = new controllerLeer(viewleer, modelleer);

    }
    
}
