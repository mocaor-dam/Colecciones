package ejercicio7;

import exceptions.RecetaException;

import java.util.*;

public class Recetario {

    private Map<String, Receta> recetario;

    public Recetario() {
        recetario = new HashMap<>();
    }

    public void addReceta(Receta nuevaReceta) throws RecetaException {
        if (recetario.containsKey(nuevaReceta.getNombre())) {
            throw new RecetaException("Esa receta ya existe en el recetario");
        }
        recetario.put(nuevaReceta.getNombre(), nuevaReceta);
    }

    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
        if (recetario.isEmpty()) {
            throw new RecetaException("El recetario esta vacio");
        }

        List<Receta> lista = new ArrayList<>(recetario.values());

        lista.sort(Comparator.comparing(Receta::getNombre));

        StringBuilder sb = new StringBuilder();
        for (Receta receta : lista){
            sb.append("Nombre: ").append(receta.getNombre())
                    .append(" Tiempo: ").append(receta.getTiempoPreparacion())
                    .append("\n");
        }

        return sb.toString();
    }

    public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {
        List<Receta> recetaFiltrada = new ArrayList<>();
        for (Receta receta : recetario.values()){
            if (receta.necesitaIngrediente(ingrediente)){
                recetaFiltrada.add(receta);
            }
        }
        if (recetaFiltrada.isEmpty()){
            throw new RecetaException("No hay recetas con ese ingrediente");
        }

        recetaFiltrada.sort(Comparator.comparing(Receta::getTiempoPreparacion));

        StringBuilder sb = new StringBuilder();
        for (Receta receta : recetaFiltrada){
            sb.append("Nombre: ").append(receta.getNombre())
                    .append(" Tiempo: ").append(receta.getTiempoPreparacion())
                    .append("\n");
        }

        return sb.toString();
    }


}
