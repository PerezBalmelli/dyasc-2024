package ar.edu.untref.dyasc;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Opciones {
	public Opciones() {

	}
	public Opciones(String[] args) {
		setOpciones(args);
	}
	private boolean orientacion = false;
	private boolean direccion = false;
	private boolean modo = false;
	private int fiboMax = 1;
	private boolean salida = false;
	private String nombreArchivo = "X";

	private static String REGEX_O = "^[hv][di]$";
	private static String REGEX_ENTRE_0_Y_47 = "^([0-9]|[1-3][0-9]|4[0-7])$";
	private static String REGEX_MODO = "^[sl]$";
	private static String REGEX_ARCHIVO = ".*\\.txt$";

	private void prederteminado() throws EOpcionNoValida {
		setOrientacion(false);
		setDireccion(false);
		setModo(false);
		setFiboMax("1");
		salida = false;
		nombreArchivo = "X";
	}

	public void setOpciones(String[] args) {
		try {
			prederteminado();
			for (int i = 0; i < args.length; i++) {
				String[] partes = args[i].split("=");
				switch (partes[0]) {
				case "-o":
					asignarO(partes[1]);
					break;
				case "-m":
					asignarModo(partes[1]);
					break;
				case "-f":
					asignarNombreArchivo(partes[1]);
					break;
				default:
					setFiboMax(args[i]);
					break;
				}
			}
		} catch (EOpcionNoValida e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
	}
	private void asignarO(String opciones) throws EOpcionNoValida {
		verificarRegex(opciones, REGEX_O);
		if(opciones.contains("v")) {
			setOrientacion(true);
		}
		if(opciones.contains("i")) {
			setDireccion(true);
		}
	}

	private void asignarModo(String nuevoModo) throws EOpcionNoValida {
		verificarRegex(nuevoModo, REGEX_MODO);
		if(nuevoModo.equals("s")) {
			setModo(true);
		}
	}

	private void asignarNombreArchivo(String nombreA) throws EOpcionNoValida {
		verificarRegex(nombreA, REGEX_ARCHIVO);
		salida = true;
		nombreArchivo = nombreA;

	}
	private static void verificarRegex(String O, String regex) throws EOpcionNoValida {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(O);
		if(!matcher.matches()) {
			throw new EOpcionNoValida();
		}
	}

	public boolean obtenerOrientacion() {
		return orientacion;
	}

	private void setOrientacion(boolean orientacion) {
		this.orientacion = orientacion;
	}

	public boolean obtenerDireccion() {
		return direccion;
	}

	private void setDireccion(boolean direccion) {
		this.direccion = direccion;
	}

	public int obtenerFiboMax() {
		return fiboMax;
	}

	private void setFiboMax(String args) throws EOpcionNoValida {
		verificarRegex(args, REGEX_ENTRE_0_Y_47);
		this.fiboMax = Integer.parseInt(args); 
	}

	public boolean obtenerModo() {
		return modo;
	}

	private void setModo(boolean modo) {
		this.modo = modo;
	}

	public boolean obtenerModoSalida() {
		return salida;
	}

	public String obtenerNombreArchiString() {
		return nombreArchivo;
	}
}
