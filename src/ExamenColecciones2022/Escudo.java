package ExamenColecciones2022;

import java.util.Date;

public class Escudo extends Cromo{
    private int yearFundacionEquipo;
    private int numJugadores;

    public Escudo(String identificador, String nombre, int yearFundacionEquipo, int numJugadores) {
        super(identificador, nombre);
        this.yearFundacionEquipo = yearFundacionEquipo;
        this.numJugadores = numJugadores;
    }

    //Getters y Setters

    public int getYearFundacionEquipo() {
        return yearFundacionEquipo;
    }

    public void setYearFundacionEquipo(int yearFundacionEquipo) {
        this.yearFundacionEquipo = yearFundacionEquipo;
    }

    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }
}
