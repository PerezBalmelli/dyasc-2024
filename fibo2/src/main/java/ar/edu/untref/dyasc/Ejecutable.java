package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.List;

public class Ejecutable {
	public static void main(String[] args) {
		ejecutar(args);
	}
	
	/*
	 * pre: recibe el arreglo de String de main.
	 * post: Ejecuta todos los metodos en orden y luego printea en consola como es pedido en el ejercicio.
	 * Lo que se hace en este metodo se puede hacer directamente en el main, pero no me gusta.
	 */
	public static void ejecutar(String[] args) {
		List<Object> parametros = setParametros(args);
		String direccion = (String) parametros.get(0);
		if (!(direccion.equals("h")) && !(direccion.equals("v"))) {
			//Si direccion no es "h" o "v", es invalido.
			//Aca se filtra la mayoria de los errores de formato con una X
			System.out.println("Valor no valido.");
			return;
		}
		String orden = (String) parametros.get(1);
		if (!(orden.equals("d")) && !(orden.equals("i"))) {
			//Lo mismo. Si el orden no es "d" o "i", es invalido.
			System.out.println("Valor no valido.");
			return;
		}
		if ((Integer) parametros.get(2) < 0) {
			//Si el valor maximo de fibonacci es menor a 0, no tiene sentido.
			//Por lo tanto, se toma como invalido.
			System.out.println("Valor no valido.");
			return;
		}
		List<Integer> fibSeq = secuenciaFibo(orden, (Integer) parametros.get(2)); //Se obtiene la lista con la secuencia fibo.
		String fibo = getString(direccion, fibSeq); //Se obtiene el string con el formato pedido.
		// System.out.println(fibSeq);
		System.out.println(fibo); //Se printea en consola.
	}

	/*
	 * pre: Su argumento tiene que ser un array de String post: devuelve una lista
	 * de objetos. En el primer lugar, va la orientacion. En el segundo el orden. En
	 * el tercero, va el numero que queremos de fibonacci. Si el numero de fibonacci
	 * no es valido, atrapa el error y pone solo una X. La X luego servira para
	 * señalar la invalidez. Si el formato con que se le pasa la orientacion y la
	 * direccion no es "-o=" mas las 2 letras que le siguen, pone una X.
	 */
	private static List<Object> setParametros(String[] args) {

		List<Object> parametros = new ArrayList<Object>();
		if (args.length == 1) {
			// Si el largo del arreglo es 1, se asume que solo se paso el n de fibo.
			// Si se paso otra cosa, se atrapa el error.
			try {
				Integer fiboMax = Integer.parseInt(args[0]);
				parametros.add("h");
				parametros.add("d");
				parametros.add(fiboMax);
				return parametros;
			} catch (NumberFormatException e) {
				parametros.add("X");
				return parametros;
			}
		}
		if ((args[0].length() == 5) && args[0].substring(0, 3).equals("-o=")) {
			// Si el largo no es igual a 5, no se sigue el formato pedido, entonce X.
			// Si el formato es apropiado, pero se introduce una letra no apropaida,
			// funciona igual,
			// la invalidez se atrapara luego.
			try {
				Integer fiboMax = Integer.parseInt(args[1]);
				parametros.add(args[0].substring(3, 4));
				parametros.add(args[0].substring(4));
				parametros.add(fiboMax);
				return parametros;
			} catch (NumberFormatException e) {
				parametros.add("X");
				return parametros;
			}
		}
		parametros.add("X");
		return parametros;
	}

	/*
	 * pre: El parametro tiene que ser un entenro.
	 * post: Devuelve una lista que contiene el fibonacci.
	 */
	private static List<Integer> secuenciaFibo(int maxFibo) {
		List<Integer> fibSeq = new ArrayList<>();
		if (maxFibo >= 1)
			fibSeq.add(0);
		if (maxFibo >= 2)
			fibSeq.add(1);

		for (int i = 2; i < maxFibo; i++) {
			fibSeq.add(fibSeq.get(i - 1) + fibSeq.get(i - 2));
		}
		return fibSeq;
	}
	/*
	 * pre: Necesita un string que señale el orden y un entero para saber el maximo del fibo.
	 * post: Invierte la lista si es necesario. Caso contrario, no cambia el resultado original.
	 * Pude meterlo todo en un mismo metodo, pero me parecio mas "limpio" de esta forma.
	 */
	private static List<Integer> secuenciaFibo(String o, int maxFibo) {
		List<Integer> fibo = secuenciaFibo(maxFibo);
		if (o.equals("i")) {
			List<Integer> fiboInv = new ArrayList<Integer>();
			for (int i = fibo.size() - 1; i >= 0; i--) {
				fiboInv.add(fibo.get(i));
			}
			return fiboInv;
		}
		return fibo;
	}
	
	/*
	 * Pre: o es un String. si es h, se toma como orizontal, sino es vertical.
	 * fibo una lista de enteros. Se espera que se utilice la lista producida por secuenciaFibo
	 * o una lista con el mismo formato.
	 * Post: Devuelve un String con el formato en horizontal o vertical.
	 */
	private static String getString(String o, List<Integer> fibo) {
		String fiboString = "fibo<" + fibo.size() + ">: ";
		if (o.equals("h")) {
			//Si o es h, lo hace horizontal.
			for (int numero : fibo) {
				fiboString = fiboString + numero + " ";
			}
		} else {
			//Sino lo hace vertical.
			for (int numero : fibo) {
				fiboString = fiboString + "\n" + numero;
			}
		}
		return fiboString;
	}
}
