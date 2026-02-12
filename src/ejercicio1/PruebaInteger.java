package ejercicio1;

import exceptions.AlumnoException;

public class PruebaInteger {
    static void main(String[] args) {
        Equipo<Integer> numEquipo = new Equipo<>("Delanteros");

        try {
            numEquipo.addAlumno(10);
            numEquipo.addAlumno(20);

            numEquipo.addAlumno(10);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Equipo de numeros: " + numEquipo.devolverListaAlumnos());
    }
}
