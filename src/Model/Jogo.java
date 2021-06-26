package Model;

import FullParser.Equipa;

public class Jogo{

    private Equipa casa;
    private Equipa visitante;
    private int golosCasa;
    private int golosVisitante;

    public Jogo (Equipa casa, Equipa visitante) {
        this.casa = casa;
        this.visitante = visitante;
        this.golosCasa = 0;
        this.golosVisitante = 0;
    }

    public void setCasa(Equipa casa) {
        this.casa = casa;
    }

    public Equipa getCasa() {
        return this.casa;
    }

    public void setVisitante(Equipa visitante) {
        this.visitante = visitante;
    }

    public Equipa getVisitante() {
        return this.visitante;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public int getGolosCasa() {
        return this.golosCasa;
    }

    public void setGolosVisitante(int golosVisitante) {
        this.golosVisitante = golosVisitante;
    }

    public int getGolosVisitante() {
        return this.golosVisitante;
    }

}
