package ejercicio7;

import exceptions.RecetaException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Receta {
    private String nombre;
    private int tiempoPreparacion;

    private Set<Ingrediente> ingredientes;
    private List<String> pasos;

    public Receta(String nombre, int tiempoPreparacion) {
        this.nombre = nombre;
        this.tiempoPreparacion = tiempoPreparacion;
        ingredientes = new HashSet<>();
        pasos = new LinkedList<>();
    }

    public boolean necesitaIngrediente(String nombreIngrediente) {

    }

    public void addIngrediente(Ingrediente ingredienteNuevo) {
        if (!ingredientes.add(ingredienteNuevo)){
            for (Ingrediente i : ingredientes){
                if (i.equals(ingredienteNuevo)){
                    i.setCantidad(i.getCantidad()+ingredienteNuevo.getCantidad());
                }
            }
        }
    }

    public void borrarIngrediente(Ingrediente ingrediente) throws RecetaException {

    }

    public void addPaso(String paso){
        pasos.add(paso);
    }

    public void addPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        int posicion = pasos.indexOf(pasoExistente);
        if (posicion != -1){
            pasos.set(posicion+1, pasoNuevo);
        } else {
            throw new RecetaException("No se puede añadir ese paso");
        }
    }


}
