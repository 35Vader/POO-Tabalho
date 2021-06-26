package FullParser;

import java.io.Serializable;

public class Lateral extends Jogador implements Serializable {
    private int cruzamento;
    public Lateral(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int cruz) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        cruzamento = cruz;
        super.setPontuacao(pontuacao(vel, res, imp,des, cab, rem, p,cruz));
    }

    public Lateral(Lateral g) {
        super(g);
        cruzamento = g.getCruzamento();
        super.setPontuacao(g.getPontuacao());
    }

    private int pontuacao(int velocidade, int resistencia, int impulsao, int destreza, int cabeca, int remate, int passe,int cruzamento){
        int p = (int) (resistencia * 0.2 + velocidade * 0.2 + impulsao * 0.05 + cabeca * 0.05 + destreza * 0.1 + remate * 0.05 + passe * 0.15 + cruzamento * 0.2);
        return (p);
    }

    public int getCruzamento() {
        return cruzamento;
    }

    public void setCruzamento(int cruzamento) {
        this.cruzamento = cruzamento;
    }

    public static Lateral parse(String input){
        String[] campos = input.split(",");
        return new Lateral(campos[0], Integer.parseInt(campos[1]),
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
        Lateral j = new Lateral(this);
        return j;
    }

    @Override
    public String toString() {
        String s = "/Lateral" + super.toString();
        return s;
    }
}
