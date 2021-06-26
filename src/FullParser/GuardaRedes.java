package FullParser;

import java.io.Serializable;

public class GuardaRedes extends Jogador implements Serializable {
    private int elasticidade;
    public GuardaRedes (String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p, int elast) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        elasticidade = elast;
        super.setPontuacao(pontuacao(vel, res, imp,des, cab, rem, p,elast));
    }

    public GuardaRedes(GuardaRedes g) {
        super(g);
        elasticidade = g.elasticidade;
        super.setPontuacao(g.getPontuacao());
    }

    private int pontuacao(int velocidade, int resistencia, int impulsao, int destreza, int cabeca, int remate, int passe,int elasticidade){
        int p = (int) (resistencia * 0.05 + velocidade * 0.05 + impulsao * 0.15 + cabeca * 0.05 + destreza * 0.1 + remate * 0.05 + passe * 0.15 + elasticidade * 0.4);
        return (p);
    }

    public int getElasticidade() {
        return elasticidade;
    }

    public void setElasticidade(int elasticidade) {
        this.elasticidade = elasticidade;
    }

    public static GuardaRedes parse(String input){
        String[] campos = input.split(",");
        return new GuardaRedes(campos[0], Integer.parseInt(campos[1]),
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
        GuardaRedes j = new GuardaRedes(this);
        return j;
    }

    @Override
    public String toString() {
        String s = "/Guarda-Redes" + super.toString();
        return s;
    }
}
