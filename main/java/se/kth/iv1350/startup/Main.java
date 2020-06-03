package se.kth.iv1350.startup;

import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.CatalogCreator;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.integration.SystemCreator;
import se.kth.iv1350.view.View;

/**
 * Contains the <code>main</code> method.
 * Performs all startup of the application.
 */
public class Main {

    /**
     * Starts the application.
     *
     * @param args The application does not take any command line parameters.
     */
    public static void main(String[] args) {
        SystemCreator systemCreator = new SystemCreator();
        CatalogCreator catalogCreator = new CatalogCreator();
        Printer printer = new Printer();
        Controller controller = new Controller(systemCreator, catalogCreator, printer);
        View view = new View(controller);
        view.sampleExecution();
    }
}
