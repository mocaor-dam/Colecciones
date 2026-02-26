package ejercicio7;

import exceptions.RecetaException;

import java.util.HashMap;
import java.util.Map;

public class Recetario {

    private Map<Receta, Receta> recetario;

    public Recetario() {
        recetario = new HashMap<>();
    }

    public void addReceta(Receta nuevaReceta) throws RecetaException {

    }

    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {

    }

    public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {

    }
}
