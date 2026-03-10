package ExamenColecciones2022;

import exceptions.MazoException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mazo {

    Map<Cromo, Integer> mazo;

    public Mazo() {
        mazo = new HashMap<>();
    }

    public void addCromo(Cromo c) {
       /*
        Informacion  sobre el comando compute
        https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/Map.html#compute(K,java.util.function.BiFunction)
        */
        mazo.compute(c, (k, v) -> (v == null) ? 1 : v + 1);
    }

    public void intercambiarCromo(Cromo miCromo, Cromo cromoOtro) throws MazoException {
        if (!mazo.containsKey(miCromo)) {
            throw new MazoException("No tienes el " + miCromo.getNombre());
        }

        mazo.computeIfPresent(miCromo, (k, v) -> v > 1 ? v - 1 : null);
        addCromo(cromoOtro);
    }

    public void mezclarMazo(Mazo otroMazo) {
        otroMazo.getMazo().forEach(((cromo, integer) ->
                this.getMazo().merge(cromo, integer, Integer::sum)));
    }

    public int contarCromosDistintos() {
        return mazo.size();
    }

    public List<Cromo> cromosQueSonDeUnEquipo(String nombreDelEquipo) {
        return mazo.keySet().stream()
                .filter(cromo -> {
                    if (cromo instanceof Jugador j) {
                        return j.getEquipo().equalsIgnoreCase(nombreDelEquipo);
                    } else {
                        return cromo.getNombre().equalsIgnoreCase(nombreDelEquipo);
                    }
                }).toList();
    }


    public double calcularAlturaMedia(String equipoDeseado) {

        return mazo.keySet().stream()
                                    .filter(c2 -> c2 instanceof Jugador)
                                    .map(c2 -> (Jugador) c2)
                                    .filter(jugador -> jugador.getEquipo().equalsIgnoreCase(equipoDeseado))
                                    .mapToDouble(Jugador::getAltura).average().orElse(Double.NaN);
    }

    public List<Cromo> devolverOrdenados() {
        return mazo.keySet().stream()
                .sorted((c1, c2) -> {
                   if (c1 instanceof Escudo && c2 instanceof Jugador){
                        return -1;
                   }
                   if (c1 instanceof Jugador && c2 instanceof Escudo){
                       return 1;
                   }

                    String nombre1 = (c1 instanceof Escudo) ? ((Escudo) c1).getNombre() : ((Jugador) c1).getNombreJugador();
                    String nombre2 = (c2 instanceof Escudo) ? ((Escudo) c2).getNombre() : ((Jugador) c2).getNombreJugador();

                    return nombre1.compareToIgnoreCase(nombre2);
                }).toList();
    }

    public Map<Cromo, Integer> getMazo() {
        return mazo;
    }

    public void setMazo(Map<Cromo, Integer> mazo) {
        this.mazo = mazo;
    }
}
