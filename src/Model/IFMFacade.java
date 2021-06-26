package Model;

import FullParser.Equipa;
import FullParser.Jogador;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IFMFacade{
    void adicionaJogador(Jogador j, String equipa);
    void adicionaEquipa (String nome);
    String getJogador(String nome);
    String toString();
    void addFMFacade(Map<String, Equipa> equipas, Map<String, Jogador> jogadores);
    boolean transferencia(String j,String equipa);
    String getEquipa(String equipa);
    String getTranferencias();
    String getEquipas();
    String getJogadores();
    //String getJogador(int jogadorID);
}
