package ejercicio5;

import java.util.*;

public class Diccionario {


    private Map<String, List<String>> diccionario;


    public Diccionario() {
        diccionario = new HashMap<>();
    }

    public void addPalabra(String palabra, String significado) {
        if (diccionario.containsKey(palabra)) {
            diccionario.get(palabra).add(significado);
        } else {
            List<String> nuevaLista = new ArrayList<>();
            nuevaLista.add(significado);
            diccionario.put(palabra, nuevaLista);
        }
    }

    public List<String> buscarPalabra(String palabra) {
      return diccionario.get(palabra);
    }

    public void borrarPalabra(String palabra) {
        diccionario.remove(palabra);
    }

    public List<String> listadoPalabras(String comienzaPor){
        List<String> palabrasQueEmpiezanPor = new LinkedList<>();


        for (String palabra : diccionario.keySet()){
            if (palabra.startsWith(comienzaPor)){
                palabrasQueEmpiezanPor.add(palabra);
            }
        }
        palabrasQueEmpiezanPor.sort(null);

        return palabrasQueEmpiezanPor;
    }
}
