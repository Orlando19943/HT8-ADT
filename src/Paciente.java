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
	public Paciente (String Nombre, String Descripcion, String Codigo) {
		this.Nombre = Nombre;
		this.Descripcion = Descripcion;
		this.Codigo = Codigo;
	}
	
	@Override
	public int compareTo(Paciente o) {
		// TODO Auto-generated method stub
		return Codigo.compareTo(o.getCodigo());
	}
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}
	public String toString () {
		return "Nombre: " + Nombre + " Descripcion: " + Descripcion + " Codigo: " + Codigo;
	}

}
