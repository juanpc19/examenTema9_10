package medicamentos;

import java.util.Scanner;
import java.util.TreeSet;

public class MedicamentoMain {

	public static void main(String[] args) {

		TreeSet<Medicamento> listaMedicamentos = FicheroMedicamento.leerFichero();

		Scanner dogma = new Scanner(System.in);

		int codigo = -1;

		String nombre = "";

		String descripcion = "";

		double precio = -1;

		String posologia = "";

		int seleccion = 5;

		System.out.println("Bienvenido!");

		while (seleccion != 0) {

			FuncionesMain.menu();

			seleccion = dogma.nextInt();

			switch (seleccion) {

			case 1 -> {
				System.out.println("Introduzca los datos del medicamento:");
				System.out.println();

				System.out.println("Introduzca el codigo:");
				codigo = dogma.nextInt();
				dogma.nextLine();

				System.out.println("Introduzca el nombre:");
				nombre = dogma.nextLine();

				System.out.println("Introduzca la descripcion:");
				descripcion = dogma.nextLine();

				System.out.println("Introduzca el precio:");
				precio = dogma.nextDouble();
				dogma.nextLine();

				System.out.println("Introduzca la posologia:");
				posologia = dogma.nextLine();

				Medicamento m = new Medicamento(codigo, nombre, descripcion, precio, posologia);

				if (listaMedicamentos.add(m)) {
					System.out.println("Se añadio el medicamento correctamente.");
				} else {
					System.out.println("No se pudo añadir el medicamento.");
				}
			}

			case 2 -> {
				for (Medicamento m : listaMedicamentos) {
					System.out.println(m);
					System.out.println("--------------------------------------------------");
					System.out.println("--------------------------------------------------");
				}
			}

			case 3 -> {
				System.out.println("Introduzca el codigo del medicamento que desea eliminar:");
				codigo = dogma.nextInt();
				dogma.nextLine();

				for (Medicamento m : listaMedicamentos) {
					if (m.getCodigo() == codigo) {
						listaMedicamentos.remove(m);
						System.out.println("Medicamento eliminado.");
						break;
					} else {
						System.out.println("El medicamento especificado no existe.");
					}
				}

			}

			case 4 -> {
				FicheroMedicamento.escribirFichero(listaMedicamentos);
			}

			case 0 -> {
				System.out.println("Saliendo del sistema...");
			}

			}
		}
		dogma.close();
	}

}
