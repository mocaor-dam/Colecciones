package ejercicio1;

import exceptions.AlumnoException;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo<T> {
    private String nombre;

    private Set<T> alumnos;


    public Equipo(String nombre) {
        this.nombre = nombre;
        alumnos = new HashSet<>();
    }

    public Equipo(Set<T> alumnos, String nombre) {
        this.alumnos = alumnos;
        this.nombre = nombre;
    }

    public void addAlumno(T alumno) throws AlumnoException {
        if (!alumnos.add(alumno)){
            throw new AlumnoException("Ese alumno ya esta en la coleccion");
        }
    }

    public void borrarAlumno(T alumno) throws AlumnoException {
        if (!alumnos.remove(alumno)){
            throw new AlumnoException("El alumno no esta en la lista");
        }
    }

    public T buscarAlumno(T a){
        if (!alumnos.contains(a)){
            return null;
        }
        return a;
    }

    public List<T> devolverListaAlumnos(){
        return new ArrayList<>(alumnos);
    }

    public Equipo<T> unirEquipos(Equipo<T> otroEquipo){
        Set<T> union = new HashSet<>(this.alumnos);
        union.addAll(otroEquipo.alumnos);
        return new Equipo<>(union,"Union de " + this.nombre + " y " + otroEquipo.nombre);
    }


    public Equipo<T> interseccionEquipos(String nombreEquipos, Equipo<T> equipo2){
        Set<T> nuevaLista = new HashSet<>(this.alumnos);
        nuevaLista.retainAll(equipo2.alumnos);
        return new Equipo<>(nuevaLista,nombreEquipos);
    }


}
