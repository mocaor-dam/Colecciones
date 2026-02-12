package ejercicio1;

import exceptions.AlumnoException;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo {
    private String nombre;

    private Set<Alumno> alumnos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        alumnos = new HashSet<>();
    }

    public Equipo(Set<Alumno> alumnos, String nombre) {
        this.alumnos = alumnos;
        this.nombre = nombre;
    }

    public void addAlumno(Alumno alumno) throws AlumnoException {
        if (!alumnos.add(alumno)){
            throw new AlumnoException("Ese alumno ya esta en la coleccion");
        }
    }

    public void borrarAlumno(Alumno alumno) throws AlumnoException {
        if (!alumnos.remove(alumno)){
            throw new AlumnoException("El alumno no esta en la lista");
        }
    }

    public Alumno buscarAlumno(Alumno a){
        if (!alumnos.contains(a)){
            return null;
        }
        return a;
    }

    public List<Alumno> devolverListaAlumnos(){
        return new ArrayList<>(alumnos);
    }

    public Equipo unirEquipos(Equipo a){
        Set<Alumno> union = new HashSet<>();
        union.addAll(this.alumnos);
        union.addAll(a.alumnos);
        return new Equipo("UnionFC");
    }


    public Equipo interseccionEquipos(String nombreEquipos, Equipo equipo2){
        Set<Alumno> nuevaLista = new HashSet<>(alumnos);
        nuevaLista.retainAll(equipo2.alumnos);
        return new Equipo(nuevaLista,nombreEquipos);
    }


}
