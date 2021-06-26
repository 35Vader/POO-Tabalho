package FullParser;

import java.io.Serializable;

public class Medio extends Jogador implements Serializable {
    private int recuperacao;
    public Medio(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int rec) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        recuperacao = rec;
        super.setPontuacao(pontuacao(vel, res, imp,des, cab, rem, p,rec));
    }

    public Medio(Medio g) {
        super(g);
        recuperacao = g.getRecuperacao();
        super.setPontuacao(g.getPontuacao());

    }

    private int pontuacao(int velocidade, int resistencia, int impulsao, int destreza, int cabeca, int remate, int passe,int recuperacao){
        int p = (int) (resistencia * 0.15 + velocidade * 0.15 + impulsao * 0.05 + cabeca * 0.05 + destreza * 0.1 + remate * 0.1 + passe * 0.2 + recuperacao * 0.2);
        return (p);
    }

    public int getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(int recuperacao) {
        this.recuperacao = recuperacao;
    }

    public static Medio parse(String input){
        String[] campos = input.split(",");
        return new Medio(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]));
    }

    @Override
    protected Jogador clone() {
        Medio j = new Medio(this);
        return j;
    }

    @Override
    public String toString() {
        String s = "/Médio" + super.toString();
        return s;
    }

}
