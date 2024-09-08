package ar.edu.untref.dyasc;

//import java.util.ArrayList;

public class Ejecutable {
	public static void main(String[] args) {
		ejecutar(args);
	}
	
	public static void ejecutar(String[] args) {
		Fibonacci fib = new Fibonacci();
		Opciones op = new Opciones(args);
		boolean orientacion = op.obtenerOrientacion();
		boolean direccion = op.obtenerDireccion();
		int numeroFib = op.obtenerFiboMax();
		boolean modo = op.obtenerModo();
		String fibonacci = fib.obtenerFibonacci(orientacion, direccion, numeroFib, modo);
		Imprimir.imprimirModo(op.obtenerNombreArchiString(), fibonacci);
	}
	
}
