package ejercicio3;

import exceptions.IESException;

public class Principal {

	public static void main(String[] args) {
		
		
		try {
			Profesor profesor1=new Profesor("11", "Pepe", 30);
			Profesor profesor2=new Profesor("12", "Pepa", 32);
			
			profesor1.enviarCorreo("Hola hola", profesor2);
			profesor1.enviarCorreo("Adios", profesor2);
			
			System.out.println(profesor1.mostrarMensajesOrdenados());
		} catch (IESException e) {
			System.out.println(e.getMessage());
		}
	}

}
