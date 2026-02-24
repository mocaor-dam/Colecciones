package ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Almacen {

    private final int MAX_CAJAS = 20;
    private List<Caja> cajas;

    public Almacen() {
         cajas = new ArrayList<>(MAX_CAJAS);
         crearCajas();
    }

    public void crearCajas(){
        for (int i = 0; i < MAX_CAJAS; i++) {
            Caja caja = new Caja();
            cajas.add(caja);
        }
    }


    static void main(String[] args) {

    }
}
