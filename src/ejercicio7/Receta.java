package ejercicio7;

import exceptions.RecetaException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Receta {
    private String nombre;
    private int tiempoPreparacion;

    HashSet<Ingrediente> ingredientes;
    List<String> pasos;

    public Receta(String nombre, int tiempoPreparacion) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
        ingredientes = new HashSet<>();
        pasos = new LinkedList<>();
    }

    public boolean necesitaIngrediente(String nombreIngrediente){

    }

    public void addIngrediente(Ingrediente ingredienteNuevo){

    }

    public void borrarIngrediente(Ingrediente ingrediente) throws RecetaException {

    }

    public void addPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {

    }



}
