package ExamenColecciones2022;

public class Jugador extends Cromo {
    private String nombreJugador;
    private String equipo;
    private double altura;

    public Jugador(String identificador, String nombre, String equipo, double altura) {
        super(identificador, nombre);
        this.equipo = equipo;
        this.altura = altura;
    }

    //Getters y Setters




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
