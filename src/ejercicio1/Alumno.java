package ejercicio1;

import java.util.Objects;

public class Alumno {
    private String nombre;
    private String dni;

    public Alumno(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(nombre, alumno.nombre) && Objects.equals(dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, dni);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
