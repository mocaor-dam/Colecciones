package ejercicio6;

import exceptions.SupermercadoException;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class Caja {

    private final int NUMERO_CAJAS;
    private static int contador = 1;
    private boolean estaAbierta;

    Queue<Cliente> clientes;

    public Caja() {
        this.NUMERO_CAJAS = contador++;
        this.estaAbierta = false;
        this.clientes = new ArrayDeque<>();
    }

    public void anadirCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void abrirCaja() throws SupermercadoException {
        if (estaAbierta){
            throw new SupermercadoException("La caja ya esta abierta");
        } else {
            estaAbierta = true;
        }
    }

    public void cerrarCaja() throws SupermercadoException{
        if (!estaAbierta || !clientes.isEmpty()){
            throw new SupermercadoException("No se puede cerrar esta caja");
        } else {
            estaAbierta = false;
        }
    }

}
