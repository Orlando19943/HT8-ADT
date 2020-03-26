import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Orlando
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner (System.in);
		int tipo = 0;	
		System.out.println("Introduzca el nombre del documento (cards_desc.txt)");
		String documento;
		teclado.nextLine();
		documento = teclado.nextLine();
		String texto = "";
	    try {
	      FileReader fr = new FileReader(documento);
	      BufferedReader br = new BufferedReader(fr);
	      String linea;	      
	      while((linea = br.readLine()) != null) {
	    	  texto = texto + linea;    	  
	      }
	    	  
	        
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento + ": " + e);
	    }

	}

}
