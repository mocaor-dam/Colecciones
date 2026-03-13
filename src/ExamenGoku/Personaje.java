package ExamenGoku;

import exceptions.DBException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Personaje {
    private String nombre;
    private TRaza raza;
    private int vidaActual;
    private int vidaMax;
    private int kiActual;
    private int kiMax;
    private boolean muerto;

    Set<Ataque> ataques;

    public Personaje(String nombre, TRaza raza, int vidaActual, int vidaMax, int kiActual, int kiMax, boolean muerto) throws DBException {
        this.nombre = nombre;
        this.raza = raza;
        setKiActual(kiActual);
        setKiMax(kiMax);
        setVidaActual(vidaActual);
        setVidaMax(vidaMax);
        ataques = new HashSet<>();
        this.muerto = false;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TRaza getRaza() {
        return raza;
    }

    public void setRaza(TRaza raza) {
        this.raza = raza;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public void setVidaActual(int vidaActual) throws DBException {
        if (vidaActual > vidaMax || vidaActual < 0){
            throw new DBException("La vida actual tiene que estar entre 0 y la vida maxima");
        }

        this.vidaActual = vidaActual;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) throws DBException {
        if (vidaMax < 1 || vidaMax > 100){
            throw new DBException("La vida maxima tiene que estar entre 1 y 100");
        }

        this.vidaMax = vidaMax;
    }

    public int getKiActual() {
        return kiActual;
    }

    public void setKiActual(int kiActual) throws DBException {
        if (kiActual > kiMax || kiActual < 0){
            throw new DBException("Los valores del ki tienen que estar entre 1 y 100");
        }

        this.kiActual = kiActual;
    }

    public int getKiMax() {
        return kiMax;
    }

    public void setKiMax(int kiMax) throws DBException {
        if (kiMax > 100 || kiMax < 1){
            throw new DBException("Los valores del ki tiene que estar entre 1 y 100");
        }
        this.kiMax = kiMax;
    }

    public Set<Ataque> getAtaques() {
        return ataques;
    }


    public boolean isMuerto() {
        return muerto;
    }

    public void setMuerto(boolean muerto) {
        this.muerto = muerto;
    }

    public void setAtaques(Set<Ataque> ataques) {
        this.ataques = ataques;
    }

    public void addAtaque(Ataque ataque) throws DBException {
        if (!ataques.add(ataque)){
            throw new DBException("No se ha podido añadir el ataque");
        }
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Personaje personaje)) return false;
        return Objects.equals(nombre, personaje.nombre) && raza == personaje.raza;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, raza);
    }

    public void recibirDaño(int daño){
        if (!isMuerto()){
            if (daño > vidaActual){
                vidaActual = 0;
            } else {
                vidaActual = vidaActual - daño;
            }
        }
    }

    public void consumirKi(int cantidad){
        this.kiActual -= cantidad;
        if (this.kiActual < 0){
            this.kiActual = 0;
        }
    }
}
