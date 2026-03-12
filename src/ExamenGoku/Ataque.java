package ExamenGoku;

import exceptions.DBException;

public class Ataque {
    private String nombre;
    private int kiNecesario;
    private int nivelDePerfeccion;
    private int daño;

    public Ataque(String nombre, int kiNecesario, int nivelDePerfeccion, int daño) throws DBException {
        this.nombre = nombre;
        setKiNecesario(kiNecesario);
        setNivelDePerfeccion(nivelDePerfeccion);
        setDaño(daño);
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getKiNecesario() {
        return kiNecesario;
    }

    public void setKiNecesario(int kiNecesario) throws DBException {
        if (kiNecesario <= 0){
            throw new DBException("El ki tiene que ser mayor que 0");
        }
        this.kiNecesario = kiNecesario;
    }

    public int getNivelDePerfeccion() {
        return nivelDePerfeccion;
    }

    public void setNivelDePerfeccion(int nivelDePerfeccion) throws DBException {
        if (nivelDePerfeccion < 1 || nivelDePerfeccion > 3){
            throw new DBException("El nivel debe ser entre 1 y 3");
        }
        this.nivelDePerfeccion = nivelDePerfeccion;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) throws DBException {
        if (daño < 0){
            throw new DBException("El daño debe ser mayor que 0");
        }
        this.daño = daño;
    }
}
