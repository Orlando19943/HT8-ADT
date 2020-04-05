import java.io.BufferedReader;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Orlando
 *
 */
public class MainJavaCollectionFramework {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado = new Scanner (System.in);
		PriorityQueue <Paciente> pQueue = new PriorityQueue<Paciente> ();;
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
	    	  pQueue.add(paciente);
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
						if (!pQueue.isEmpty()) {
							System.out.println("Listado de pacientes");
							for (Paciente listaP:pQueue) {
								System.out.println(listaP.toString());
							}
							}else {
								System.out.println("Lista de pacientes vacia");
							}
						
					}
					if (n == 2) {
						if (!pQueue.isEmpty()) {
						System.out.println("Atender a: " + pQueue.remove());
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
