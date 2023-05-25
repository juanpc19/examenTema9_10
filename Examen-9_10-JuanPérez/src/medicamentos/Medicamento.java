package medicamentos;

/**
 * clase que contendra metodos para crear y manipular objetos tipo Medicamento
 * 
 * @author jperez
 *
 */
public class Medicamento implements Comparable<Medicamento> {

	int codigo;// atributo que guardara el codigo

	String nombre;// atributo que guardara el nombre

	String descripcion;// atributo que guardara la descripcion

	double precio;// atributo que guardara el precio

	String posologia;// atributo que guardara la pologia

	/**
	 * constructor sin parametros
	 */
	public Medicamento() {
	}

	/**
	 * constructor con parametro de entrada codigo
	 * 
	 * @param codigo
	 */
	public Medicamento(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * constructor con parametros de entrada
	 * 
	 * @param codigo      contiene valor para atributo codigo
	 * @param nombre      contiene valor para atributo nombre
	 * @param descripcion contiene valor para atributo descripcion
	 * @param precio      contiene valor para atributo precio
	 * @param posologia   contiene valor para atributo posologia
	 */
	public Medicamento(int codigo, String nombre, String descripcion, double precio, String posologia) {
		if (codigo > -1) {
			this.codigo = codigo;
		}

		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}

		if (descripcion != null && !descripcion.isEmpty()) {
			this.descripcion = descripcion;
		}

		if (precio >= 0) {
			this.precio = precio;
		}

		if (descripcion != null && !descripcion.isEmpty()) {
			this.posologia = posologia;
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo >= 0) {
			this.codigo = codigo;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getPosologia() {
		return posologia;
	}

	public void setPosologia(String posologia) {
		this.posologia = posologia;
	}

	/**
	 * metodo que devolvera una cadena en formato especificado con los valores de
	 * los atributos del objeto que lo llama
	 */
	@Override
	public String toString() {

		String cadena = "Codigo: " + codigo + "\nNombre:" + nombre + "\nDescripcion:" + descripcion + "\nPrecio:"
				+ precio + "\nPosologia:" + posologia;
		return cadena;
	}

	/**
	 * metodo que comparara los atributos codigo de dos objetos distintos
	 * devolviendo true o false segun sean iguales o no
	 */

	@Override
	public boolean equals(Object o) {
		boolean resultado = false;
		Medicamento med = (Medicamento) o;
		if (this.codigo == med.codigo) {
			resultado = true;
		}
		return resultado;
	}

	/**
	 * metodo que comparara los atributos codigo de dos objetos distintos y
	 * devolvera 1 o -1 para usar en ordenacion
	 */

	@Override
	public int compareTo(Medicamento med) {
		int resultado = 0;

		if (this.codigo < med.codigo) {
			resultado = -1;
		} else if (this.codigo > med.codigo) {
			resultado = 1;
		}

		return resultado;
	}

}
