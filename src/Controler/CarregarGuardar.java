package Controler;

import Model.FMFacade;

import java.io.*;

public class CarregarGuardar {

    /**
     * Método que guarda os dados num ficheiro
     *
     * @param fileName  nome ficheiro
     * @param c         GestTrazAqui
     * @return          0 se guardou sem erros
     */
    public int guardaDados(String fileName, FMFacade c) {
        try {
            FileOutputStream file = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(c);
            oos.flush();
            oos.close();
        }
        catch (FileNotFoundException e) {
            return 1;
        }
        catch (IOException e) {
            return 2;
        }

        return 0;
    }

    /**
     * Método que carrega os dados guardados num ficheiro
     *
     * @param fileName                  nome ficheiro
     * @return                          estrutura carregada
     * @throws IOException              controlo erros
     * @throws ClassNotFoundException   controlo erros
     */
    public FMFacade carregaDados(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(file);
        FMFacade c = (FMFacade) ois.readObject();
        ois.close();
        return c;
    }
}

