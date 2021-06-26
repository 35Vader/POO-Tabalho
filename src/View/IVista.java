package View;

import java.util.List;

public interface IVista {
    void menuInicial();

    void menuTransferências();

    void menuConsulta();

    void printJogador(String posicao, String id, String nome, List<String> historial, String velocidade, String resistencia, String impulsao, String destreza, String cabeca, String remate, String passe, String p,String e);

    void printEquipa(String e);

    void pedirOpcao();

    void pedirJogador();

    void pedirEquipa();
}
