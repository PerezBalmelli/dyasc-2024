package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Imprimir {
	public static void imprimirModo(String nombreArchivo, String fibo) {
		if(nombreArchivo.equals("X")) {
			ImprimirEnConsola(fibo);
		} else
			imprimirEnArchivo(nombreArchivo, fibo);
	}
	private static void ImprimirEnConsola(String fibo) {
		System.out.println(fibo);
	}
	private static void imprimirEnArchivo(String nombreArchivo, String fibo) {
        try {
            FileWriter escritorArchivo = new FileWriter(nombreArchivo);
            
            PrintWriter impresor = new PrintWriter(escritorArchivo);
            
            impresor.println(fibo);
            
            impresor.close();

        } catch (IOException e) {
            System.out.println("Opcion no valida");
        }
	}
}
