package ar.edu.untref.dyasc;

public class Ejecutable {
    public static void main(String[] args) {
    	
    	int maxFibo = Integer.parseInt(args[0]);
    	
    	String resultado = "fibo<" + maxFibo + ">: ";
    	
    	int firstN = 0;
    	int secondN = 1;
    	
    	for(int i = 0; i < maxFibo; i++) {
    		
    		resultado = resultado + firstN + " ";
    		
    		int nextN = firstN + secondN;
    		firstN = secondN;
    		secondN = nextN;
    		
    	}
        System.out.println(resultado);
    }
}
