package ejercicio3;

import exceptions.IESException;

import java.util.LinkedList;
import java.util.stream.Stream;

public abstract class Persona {

    private static final int EDAD_MINIMA = 12;

    // Atributos
    private String dni;
    private String nombre;
    private int edad;
    private LinkedList<Mensaje> mensajes;

    // Constructor
    public Persona(String dni, String nombre, int edad) throws IESException {
        this.dni = dni;
        this.nombre = nombre;
        mensajes = new LinkedList<Mensaje>();
        setEdad(edad);
    }

    // Métodos get y set
    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    private void setEdad(int edad) throws IESException {
        if (edad < EDAD_MINIMA)
            throw new IESException("La edad minima es de" + EDAD_MINIMA);
        this.edad = edad;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }


    public LinkedList<Mensaje> getMensajes() {
        return mensajes;
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dni == null) ? 0 : dni.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }

    public void enviarCorreo(String msg, Persona personaDestinatario) throws IESException {


    }

    /**
     * Si no tiene ningún mensaje salta la excepción
     *
     * @return
     * @throws IESException
     */

    public String mostrarMensajes() throws IESException {

        if (mensajes.isEmpty()) {
            throw new IESException("El buzon esta vacio");
        }
        StringBuilder sb = new StringBuilder();
        int contador = 1;

        for (Mensaje m : mensajes) {
            sb.append("Mensaje ").append(contador++).append(": ")
                    .append("De: ").append(m.getRemitente().getNombre())
                    .append(" Texto: ").append(m.getTexto())
                    .append(" Fecha y hora: ")
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     *
     * @param numeroMensaje De 1 en adelante
     * @throws IESException
     */
    public void borrarMensaje(int numeroMensaje) throws IESException {
        if (numeroMensaje < 1 || numeroMensaje > mensajes.size()) {
            throw new IESException("El mensaje numero " + numeroMensaje + " no existe");
        }
        mensajes.remove(numeroMensaje - 1);
    }


    public String mostrarMensajesOrdenados() throws IESException {
        if (mensajes.isEmpty()) {
            throw new IESException("No hay mensajes");
        }

        LinkedList<Mensaje> copia = new LinkedList<>(mensajes);

        copia.sort((m1, m2) -> m1.getRemitente().getNombre().compareToIgnoreCase(m2.getRemitente().getNombre()));

        StringBuilder sb = new StringBuilder("--- Mensajes Ordenados por Remitente ---\n");
        for (int i = 0; i < copia.size(); i++) {
            sb.append("Mensaje ").append(i + 1).append(": ").append(copia.get(i)).append("\n");

        }
        return sb.toString();
    }


    public String buscarMensajesConTexto(String texto) throws IESException {
        StringBuilder sb = new StringBuilder();
        boolean encontrado = false;

        for (int i = 0; i < mensajes.size(); i++) {
            if (mensajes.get(i).getTexto().toLowerCase().contains(texto.toLowerCase())) {
                sb.append("Mensaje ").append(i + 1).append(": ").append(mensajes.get(i)).append("\n");
                encontrado = true;
            }
        }

        if (!encontrado) throw new IESException("No se encontraron mensajes con ese texto.");
        return sb.toString();
    }

    public void addMensajes(Mensaje m) {
        mensajes.add(m);
    }

}

