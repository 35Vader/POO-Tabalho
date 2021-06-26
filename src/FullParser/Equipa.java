package FullParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Equipa implements Serializable {

    private String nome;
    private int pontuacao;
    private Map<String,Jogador> jogadores;

    public Equipa(String nomeE) {
        nome=nomeE;
        jogadores = new HashMap();
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

    public void insereJogador(Jogador j){
        j.addHistorial(nome);
        j.setEquipaAtual(nome);
        this.jogadores.put(j.getNomeJogador(), j.clone());
        int s = jogadores.size();
        this.pontuacao = (this.pontuacao * (s-1) + j.getPontuacao())/s;
    }

    public boolean removeJogador(String nome){
        boolean val = false;
        if (jogadores.containsKey(nome)) {
            pontuacao = jogadores.get(nome).getPontuacao();
            val = this.jogadores.remove(nome) != null;
            int s = jogadores.size();
            //adicionar exception s=0
            if (s == 0)
                pontuacao = 0;
            else
                this.pontuacao = (this.pontuacao * (s + 1) - pontuacao) / s;
        }
        return val;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public String getNome(){
        return nome;
    }

    public String toString(){
        String r =  "Equipa:" + nome + "   Pontuação:" + pontuacao + "\n";
        for (Jogador j : jogadores.values()){
            r += j.toString();
        }
        return r;
    }

}


