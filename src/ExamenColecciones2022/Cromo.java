package ExamenColecciones2022;

import java.util.Objects;

public class Cromo {
    private String identificador;
    private String nombre;


    public Cromo(String identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }


    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cromo cromo)) return false;
        return Objects.equals(identificador, cromo.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identificador);
    }
}
