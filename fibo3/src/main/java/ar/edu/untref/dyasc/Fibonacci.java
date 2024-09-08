package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Fibonacci {
	
	private List<Integer> fibSeq;
	private int fibSuma;
	private String fiboString;
	
	public String obtenerFibonacci(boolean ori, boolean dir, int maxFibo, boolean modo) {
		generarFibo(maxFibo);
		darDireccion(dir);
		fiboString = "fibo<" + fibSeq.size() + ">:";
		darModo(modo, ori);
		return fiboString;
	}
	
	private List<Integer> generarFibo(int maxFibo) {
		fibSeq = new ArrayList<>();
		fibSuma = 1;
		if (maxFibo >= 1)
			fibSeq.add(0);
		if (maxFibo >= 2)
			fibSeq.add(1);

		for (int i = 2; i < maxFibo; i++) {
			int valorActual = fibSeq.get(i - 1) + fibSeq.get(i - 2);
			fibSeq.add(valorActual);
			fibSuma = fibSuma + valorActual;
		}
		return fibSeq;
	}

	public void darDireccion(boolean direccion) {
		if (direccion) {
			Collections.reverse(fibSeq);
		}
	}
	
	
	public void darModo(boolean modo, boolean orientacion) {
		if(modo) {
			fiboString = fiboString + obtenerSuma();
		} else {
			fiboString = fiboString + darOrientacion(orientacion);
		}
		
	}
	public int obtenerSuma() {
		return fibSuma;
	}
	public String darOrientacion(boolean o) {
		String string = "";
		String separador = " ";
		if(o) {
			separador = "\n";
		}
		for (int numero : fibSeq) {
			string = string + separador + numero;
		}
		return string;
	}
	public List<Integer> getFibSeq() {
		return fibSeq;
	}
}
