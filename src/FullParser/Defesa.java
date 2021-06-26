package FullParser;

import java.io.Serializable;

public class Defesa extends Jogador implements Serializable {
    public Defesa(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        super.setPontuacao(pontuacao(vel, res, imp,des, cab, rem, p));
    }

    public Defesa(Defesa d){
        super(d);
        super.setPontuacao(d.getPontuacao());
    }

    private int pontuacao(int velocidade, int resistencia, int impulsao, int destreza, int cabeca, int remate, int passe){
        int p=0;
        p = (int) (resistencia * 0.2 + velocidade * 0.2 + impulsao * 0.2 + cabeca * 0.25 + destreza * 0.05 + remate * 0.03 + passe * 0.07);
        return (p);
    }

    public static Defesa parse(String input){
        String[] campos = input.split(",");
        return new Defesa(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]));
    }

    @Override
    protected Jogador clone() {
        Defesa d = new Defesa(this);
        return d;
    }

    @Override
    public String toString() {
        String s = "/Defesa" + super.toString();
        return s;
    }

}
