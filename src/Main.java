import Controler.Controlador;
import FullParser.LinhaIncorretaException;
import FullParser.Parser;
import Model.FMFacade;
import Model.IFMFacade;
import View.IVista;
import View.Vista;

import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {

    public static void main(String[] args) throws LinhaIncorretaException, IOException, ClassNotFoundException {
        IFMFacade ifmFacade = new FMFacade();
        IVista vista = new Vista();
        Controlador c = new Controlador(ifmFacade, vista);
        c.interpretador();
        System.out.println("\n Saindo do programa....");

    }
}
