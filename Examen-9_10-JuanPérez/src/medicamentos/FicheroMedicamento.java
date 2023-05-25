package medicamentos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;

/**
 * clase que contendra metodos para lectura y escritura de una collecion en un
 * archivo de texto
 * 
 * @author jperez
 *
 */
public class FicheroMedicamento {

	/**
	 * metodo que leera un archivo y devolvera una collecion tipo TreeSet con datos
	 * extraidos del archivo
	 * 
	 * @return listaMedicamentos devolvera una collecion tipo TreeSet con datos
	 *         extraidos del archivo
	 */
	public static TreeSet<Medicamento> leerFichero() {
		TreeSet<Medicamento> listaMedicamentos = new TreeSet<>();

		Medicamento m;
		int codigo;
		String nombre;
		String descripcion;
		double precio;
		String posologia;
		String linea;
		String[] lineaSeparada;

		BufferedReader lector = null;

		try {
			lector = new BufferedReader(new FileReader("src\\medicamentos\\medicamentos.txt"));

			linea = lector.readLine();

			while (linea != null) {
				lineaSeparada = linea.split(";");

				codigo = Integer.parseInt(lineaSeparada[0]);
				nombre = lineaSeparada[1];
				descripcion = lineaSeparada[2];
				precio = Double.parseDouble(lineaSeparada[3]);
				posologia = lineaSeparada[4];

				m = new Medicamento(codigo, nombre, descripcion, precio, posologia);

				listaMedicamentos.add(m);

				linea = lector.readLine();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error, al abrir el fichero.");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error, al leer el fichero.");
			System.out.println(e.getMessage());

		} finally {
			if (lector != null) {
				try {
					lector.close();
				} catch (IOException e) {
					System.out.println("Error, al cerrar el buffer.");
					System.out.println(e.getMessage());
				}
			}
		}
		return listaMedicamentos;
	}

	/**
	 * metodo que leera una collecion tipo TreeSet pasado como parametro de entrada
	 * y escribira sus datos en un archivo
	 */
	public static void escribirFichero(TreeSet<Medicamento> listaMedicamentos) {

		int codigo;
		String nombre;
		String descripcion;
		double precio;
		String posologia;

		BufferedWriter escriba = null;

		try {
			escriba = new BufferedWriter(new FileWriter("src\\medicamentos\\medicamentos.txt"));

			for (Medicamento m : listaMedicamentos) {
				codigo = m.getCodigo();
				descripcion = m.getDescripcion();
				nombre = m.getNombre();
				precio = m.getPrecio();
				posologia = m.getPosologia();

				escriba.write(codigo + ";" + descripcion + ";" + nombre + ";" + precio + ";" + posologia);
				escriba.newLine();

				escriba.flush();
			}
		} catch (IOException e) {
			System.out.println("Error, al abrir el fichero.");
			System.out.println(e.getMessage());

		} finally {
			if (escriba != null) {
				try {
					escriba.close();
				} catch (IOException e) {
					System.out.println("Error, al cerrar el buffer.");
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
