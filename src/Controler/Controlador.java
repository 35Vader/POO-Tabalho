package Controler;

import FullParser.LinhaIncorretaException;
import FullParser.Parser;
import Model.FMFacade;
import Model.IFMFacade;
import View.IVista;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Controlador implements Serializable {
    private IFMFacade ifmFacade;
    private IVista vista;
    private Input input;

    public Controlador(IFMFacade ifmFacade, IVista vista) {
        this.ifmFacade = ifmFacade;
        this.vista = vista;
    }

    public void interpretador() throws LinhaIncorretaException, IOException, ClassNotFoundException {
        Parser p = new Parser();
        p.parse(ifmFacade);
        input = new Input();
        CarregarGuardar g = new CarregarGuardar();

        boolean sair = false;
        int i=-1;
        while(!sair){
            vista.menuInicial();
            this.vista.pedirOpcao();
            i = this.input.lerInt();
            switch (i) {
                case 1:
                    interpretadorTransferencias();
                    break;
                case 2:
                    interpretadorConsultas();
                    break;
                case 3: break;
                case 4: break;
                case 5:
                    g.guardaDados("teste.txt", (FMFacade) ifmFacade);
                    break;
                case 6:
                    ifmFacade = g.carregaDados("teste.txt");
                    System.out.println(ifmFacade.toString());
                    break;
                case 0:
                    sair = true;
                    break;
                default:;
            }
        }
    }
    private void interpretadorTransferencias(){
        input = new Input();
        boolean voltar = false;
        //vista.menuTransferências();
        int i = -1;
        while(!voltar){
            vista.menuTransferências();
            this.vista.pedirOpcao();
            i = this.input.lerInt();
            switch (i) {
                case 1:
                    System.out.println(ifmFacade.getTranferencias());
                    break;
                case 2:
                    this.vista.pedirJogador();
                    String nome = this.input.lerString();
                    this.vista.pedirEquipa();
                    String equipa = this.input.lerString();

                    boolean val = ifmFacade.transferencia(nome,equipa);
                    if (val)
                        System.out.println("Transferência bem sucedida!");
                    break;
                case 0:
                    voltar = true;
                    vista.menuInicial();
                    break;
                default:;
            }
        }
    }

    private void interpretadorConsultas(){
        input = new Input();
        boolean voltar = false;
        int pedido=-1;
        String nome;
        int i=-1;
        while(!voltar){
            vista.menuConsulta();
            this.vista.pedirOpcao();
            i = this.input.lerInt();
            switch (i) {
                case 1:
                    this.vista.pedirEquipa();
                    nome = this.input.lerString();
                    String e = ifmFacade.getEquipa(nome);
                    System.out.println(e);
                    break;
                case 2:
                    this.vista.pedirJogador();
                    nome = this.input.lerString();
                    String j = ifmFacade.getJogador(nome);
                    parseJogador(j);
                    break;
                case 3:
                    System.out.println(ifmFacade.getJogadores());
                    break;
                case 4:
                    System.out.println(ifmFacade.getEquipas());
                    break;
                case 0:
                    voltar = true;
                    vista.menuInicial();
                    break;
                default:;
            }
        }
    }

    private void parseJogador(String jogador) {
        if (jogador == "")
                return;
        String [] j = jogador.split("/");
        int size = j.length,inicio = 2;
        String posicao = j[1];
        String id = j[inicio++],nome = j[inicio++],equipa = j[inicio++], pontuacao = j[inicio++],
                velocidade = j[inicio++], resistencia = j[inicio++],impulsao = j[inicio++],
                destreza = j[inicio++], cabeça = j[inicio++], remate = j[inicio++], passe = j[inicio++];
        List<String> historico = new ArrayList<>();
        while (inicio < size)
            historico.add(j[inicio++]);

        this.vista.printJogador(posicao, id, nome, historico, velocidade, resistencia, impulsao,destreza,cabeça,remate,passe,equipa,pontuacao);
    }

}
