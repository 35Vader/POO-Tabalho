package Model;

import FullParser.Avancado;
import FullParser.Equipa;
import FullParser.Jogador;

import java.io.Serializable;
import java.util.*;

public class FMFacade implements IFMFacade, Serializable {
    private Map<String, Equipa> equipas;
    Map<String, Jogador> jogadores;
    List<String> tranferencias;

    public FMFacade(){
        this.equipas = new HashMap<>();
        this.jogadores = new HashMap<>();
        tranferencias = new ArrayList<>();
    }

    public void addFMFacade(Map<String, Equipa> equipas, Map<String, Jogador> jogadores) {
        this.equipas = equipas;
        this.jogadores = jogadores;
        tranferencias = new ArrayList<>();
    }

    public void adicionaEquipa (String nome){
        this.equipas.put(nome, new Equipa(nome));
    }


    public void adicionaJogador(Jogador j, String equipa){
        j.setEquipaAtual(equipa);
        j.addHistorial(equipa);
        jogadores.put(j.getNomeJogador(),j);
        this.equipas.get(equipa).insereJogador(j);

    }

    public boolean transferencia(String j,String equipa){
        boolean val = false;
        if (!jogadores.containsKey(j) || !equipas.containsKey(equipa))
            return val;
        Jogador jog = jogadores.get(j);
        String equipaAntiga = jog.getEquipaAtual();

        if (!equipas.get(equipaAntiga).removeJogador(j))
            return val;
        else
            val = true;
        equipas.get(equipa).insereJogador(jog);
        jog.setEquipaAtual(equipa);
        jog.addHistorial(equipa);
        tranferencias.add("JOGADOR: " + j + "\n         EQUIPA ANTIGA: " + equipaAntiga + "\n         EQUIPA ATUAL: " + equipa + "\n");

        return val;
    }

    public String getTranferencias() {
        String s = "TRANSFERÊNCIAS\n";
        for (String l : tranferencias)
            s += l;
        return s;
    }

    public void removeJ(String nome, String equipa){
        this.equipas.get(equipa).removeJogador(nome);
    }

    public String getJogador(String n) {
        String res = "";
        if (jogadores.containsKey(n))
            res = jogadores.get(n).toString();
        return res;
    }

    public String getEquipa(String equipa) {
        Equipa e = equipas.get(equipa);
        if(e == null){
            return null;}
        else
            return e.toString();
    }

    public String getEquipas() {
        String res = "";
        Map<Integer,List <String>> r = new TreeMap();
        int pont = 0;

        for(String equipa:equipas.keySet()) {
            pont = equipas.get(equipa).getPontuacao();
            if (!r.containsKey(pont))
                r.put(pont, new ArrayList<>());
            r.get(pont).add(equipa);
        }

        for(List<String> lista:r.values()) {
            pont = equipas.get(lista.get(0)).getPontuacao();
            for (String equipa : lista)
                res += "\nPontuação:" + pont + "      Equipa:" + equipa;
        }
        return res;
    }

    public String getJogadores() {
        String res = "";
        Map<Integer,List<String>> r = new TreeMap();
        int pont = 0;

        for(String jogador:jogadores.keySet()) {
            pont = jogadores.get(jogador).getPontuacao();
            if (!r.containsKey(pont))
                r.put(pont, new ArrayList<>());
            r.get(pont).add(jogador);
        }

        for(List<String> lista:r.values()) {
            pont = jogadores.get(lista.get(0)).getPontuacao();
            for (String jogador : lista)
                res += "\nPontuação:" + pont + "      Jogador:" + jogador;
        }

        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Equipa e:equipas.values())
            sb.append(e.toString()).append('\n');
        for (Jogador j:jogadores.values())
            sb.append(j.toString()).append('\n');
        return sb.toString();
    }
}
