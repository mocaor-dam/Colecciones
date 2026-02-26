package ejercicio7;

import java.util.Objects;

public class Ingrediente {
    private String nombre;
    private int cantidad;

    public Ingrediente(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ingrediente that)) return false;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
