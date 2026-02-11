import java.util.ArrayList;
import java.util.Collection;

public class Main {
    static void main(String[] args) {
        Collection<String> coleccion = new ArrayList<>();
        coleccion.add("Javi");
        coleccion.add("Alvaro");
        coleccion.add("Carlos");


        for (String n : coleccion) {
            System.out.println(n);
        }

        if (coleccion.contains("Carlos")){
            coleccion.remove("Carlos");
        }

        for (String n : coleccion) {
            System.out.println(n);
        }

        if (!coleccion.remove("Alvaro")){

        }

    }
}
