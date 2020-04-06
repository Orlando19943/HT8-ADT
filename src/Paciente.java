/**
 * 
 */

/**
 * @author Orlando
 * 
 *
 */
public class Paciente implements Comparable<Paciente>{

	String Nombre;
	String Descripcion;
	String Codigo;
	/**
	 * 
	 * @param Nombre
	 * @param Descripcion
	 * @param Codigo
	 * Constructor para los datos del paciente
	 */
	public Paciente (String Nombre, String Descripcion, String Codigo) {
		this.Nombre = Nombre;
		this.Descripcion = Descripcion;
		this.Codigo = Codigo;
	}
	/**
	 * @post: El paciente con mayor importancia
	 * @return: El paciente con codigo mayor
	 */
	@Override
	public int compareTo(Paciente o) {
		// TODO Auto-generated method stub
		return Codigo.compareTo(o.getCodigo());
	}
	/**
	 * 
	 * @return Codigo del paciente
	 */
	public String getCodigo() {
		return Codigo;
	}

	public String toString () {
		return "Nombre: " + Nombre + " Descripcion: " + Descripcion + " Codigo: " + Codigo;
	}

}
