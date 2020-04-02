import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.PriorityQueue;
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
		VectorHeap<Paciente> heap = new VectorHeap<Paciente>();
		PriorityQueue <String> pQueue = new PriorityQueue<String> ();
		System.out.println("Introduzca el nombre del documento (pacientes.txt)");
		String documento;
		String nombre;
		String descripcion;
		String codigo;
		int n1;
		int n2;
		int n3;
		documento = teclado.nextLine();
		String texto = "";
	    try {
	      FileReader fr = new FileReader("pacientes.txt");
	      BufferedReader br = new BufferedReader(fr);
	      String linea;	      
	      while((linea = br.readLine()) != null) {
	    	  n1 = 0;
	    	  n2 = 0;
	    	  n3 = 0;
	    	  nombre = "";
	    	  descripcion = "";
	    	  codigo = "";
	    	  for (int i = 0; i<linea.length(); i++) {
	    		  if (linea.substring(i, i+1).equals(",")){
	    			  n1 = i;	
	    			  
	    			  break;
	    		  }
	    	  }
	    	  for (int i = 0; i<linea.length(); i++) {
	    		  if (linea.substring(i, i+1).equals(",")){
	    			  n2 = i;
	    			  n3++;
	    			  if (n3 == 2) {
	    				  break;
	    			  }
	    		  }
	    	  }
	    	  nombre = linea.substring(0,n1);
	    	  descripcion = linea.substring(n1 + 2, n2);
	    	  codigo = linea.substring(n2 + 2, linea.length());
	    	  texto = linea;	    	  
	    	  System.out.println (nombre + ", " + descripcion + ", " + codigo);

	    	  Paciente paciente = new Paciente(nombre, descripcion, codigo);
	    	  heap.add(paciente);
	    	  pQueue.add(linea);
	      }
	    	  
	        
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento + ": " + e);
	    }
	    
	    System.out.println("Prueba");
	   
	    while (!heap.isEmpty()) {
			System.out.println(heap.remove() + " ");
			
		}
	    

	}

}
