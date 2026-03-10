package ExamenColecciones2022;

public class Jugador extends Cromo {
    private String nombreJugador;
    private String equipo;
    private double altura;

    public Jugador(String identificador, String nombre,String nombreJugador, String equipo, double altura) {
        super(identificador, nombre);
        this.nombreJugador = nombreJugador;
        this.equipo = equipo;
        this.altura = altura;
    }

    //Getters y Setters


    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
