import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
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
		System.out.println("Introduzca el nombre del documento (pacientes.txt)");
		String documento;
		String nombre;
		String descripcion;
		String codigo;
		int n = 0;
		int n1;
		int n2;
		int n3;
		documento = teclado.nextLine();
		//------------------Leer el archivo y ordenar los pacientes por prioridad----------------------
	    try {
	      FileReader fr = new FileReader(documento);
	      BufferedReader br = new BufferedReader(fr);
	      String linea;	      
	      while((linea = br.readLine()) != null) {
	    	  n1 = 0;
	    	  n2 = 0;
	    	  n3 = 0;
	    	  nombre = "";
	    	  descripcion = "";
	    	  codigo = "";
	    	  //Saco la posicion de la primera coma
	    	  for (int i = 0; i<linea.length(); i++) {
	    		  if (linea.substring(i, i+1).equals(",")){
	    			  n1 = i;	
	    			  
	    			  break;
	    		  }
	    	  }
	    	  //Saco la posicion de la segunda coma
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
	    	  //System.out.println (nombre + ", " + descripcion + ", " + codigo);

	    	  Paciente paciente = new Paciente(nombre, descripcion, codigo);
	    	  heap.add(paciente);
	      }
	    	  
	        
	      fr.close();
	    }
	    catch(Exception e) {
	      System.out.println("Excepcion leyendo fichero "+ documento + ": " + e);
	    }
	   //--------------------------------------Fin del lector de archivo--------------------------
	    System.out.println("----Registros----");
	    while (n<3) {
			do {
				try {
					System.out.println("1.Ver lista de pacientes");
					System.out.println("2.Atender a paciente");
					System.out.println("3.Salir");
					n = teclado.nextInt();
					if (n == 1) {
						if (!heap.isEmpty()) {
							System.out.println("Listado de pacientes");
							for (int i = 0; i < heap.size(); i++) {							
						    	System.out.println(heap.get(i));
						    }
							
							}else {
								System.out.println("Lista de pacientes vacia");
							}
						
					}
					if (n == 2) {
						if (!heap.isEmpty()) {
						System.out.println("Atender a: " + heap.remove());
						}else {
							System.out.println("Lista de pacientes vacia");
						}
					}
					}catch (Exception e) {
						System.out.println("Introduzca correctamente el numero");
						teclado.nextLine();
				}
			}while (n>3||n<0);
	    
	    
	    
	    

	}

	}
}
