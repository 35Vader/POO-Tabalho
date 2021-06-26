package FullParser;


import java.io.Serializable;

public class Avancado extends Jogador implements Serializable {
    public Avancado(String nomeJ, int numeroJ, int vel, int res, int des, int imp, int cab, int rem, int p) {
        super(nomeJ, numeroJ, vel, res, des, imp, cab, rem, p);
        super.setPontuacao(pontuacao(vel, res, imp,des, cab, rem, p));

    }

    public Avancado(Avancado a) {
        super(a);
        super.setPontuacao(a.getPontuacao());
    }


    private int pontuacao(int velocidade, int resistencia, int impulsao, int destreza, int cabeca, int remate, int passe){
        int p=0;
         p = (int) (resistencia * 0.1 + velocidade * 0.25 + impulsao * 0.1 + cabeca * 0.15 + destreza * 0.05 + remate * 0.3 + passe * 0.05);
        return (p);
    }

    public static Avancado parse(String input){
        String[] campos = input.split(",");
        return new Avancado(campos[0], Integer.parseInt(campos[1]),
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
        Avancado d = new Avancado(this);
        return d;
    }

    @Override
    public String toString() {
        String s = "/Avançado" + super.toString();
        return s;
    }
}
