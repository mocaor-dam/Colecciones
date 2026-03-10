package ExamenColecciones2022;

import exceptions.MazoException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mazo {

    Map<Cromo,Integer> mazo;

    public Mazo() {
        mazo = new HashMap<>();
    }

    public void addCromo(Cromo c){
       /*
        Informacion  sobre el comando compute
        https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Map.html#compute(K,java.util.function.BiFunction)
        */
        mazo.compute(c, (k,v) -> (v == null) ? 1 : v + 1);
    }

    public void intercambiarCromo(Cromo miCromo, Cromo cromoOtro) throws MazoException {
        if (!mazo.containsKey(miCromo)){
            throw new MazoException("No tienes el " + miCromo.getNombre());
        }

        mazo.computeIfPresent(miCromo, (k, v) -> v > 1 ? v - 1 : null);
            addCromo(cromoOtro);
    }

    public void mezclarMazo(Mazo otroMazo){
        otroMazo.getMazo().forEach(((cromo, integer) ->
                this.getMazo().merge(cromo, integer, Integer::sum)));
    }

    public int contarCromosDistintos(){
        return mazo.size();
    }

    public List<Cromo> cromosQueSonDeUnEquipo(String nombreDelEquipo){
        return mazo.keySet().stream()
                .filter(cromo -> {
                if (cromo instanceof Jugador j){
                    return j.getEquipo().equalsIgnoreCase(nombreDelEquipo);
                } else {
                    return cromo.getNombre().equalsIgnoreCase(nombreDelEquipo);
                }
        }).toList();
    }


    public Map<Cromo, Integer> getMazo() {
        return mazo;
    }

    public void setMazo(Map<Cromo, Integer> mazo) {
        this.mazo = mazo;
    }
}
