package ejercicio7;

import exceptions.RecetaException;

import java.util.*;

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
        Ingrediente ingredienteBuscado = new Ingrediente(nombreIngrediente, 0);
        return ingredientes.contains(ingredienteBuscado);
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
        if (!ingredientes.remove(ingrediente)){
            throw new RecetaException("El ingrediente no se encuentra en la receta");
        }

        Iterator<String> iterator = pasos.iterator();
        while (iterator.hasNext()){
            String paso = iterator.next();
            if (paso.contains(ingrediente.getNombre())){
                iterator.remove();
            }

        }
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }

    public Set<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Set<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<String> getPasos() {
        return pasos;
    }

    public void setPasos(List<String> pasos) {
        this.pasos = pasos;
    }
}
