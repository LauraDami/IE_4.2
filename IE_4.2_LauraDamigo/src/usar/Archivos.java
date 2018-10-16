package usar;

import java.io.*;

public class Archivos {
	public static void crearArchivo(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		try {
			archivo.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("El archivo se ha creado correctamente\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void escribirArchivo(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo));
			String contenido = "Contenido a escribir en el archivo";
			salida.println(contenido);
			salida.println();
			salida.println("Fin de escritura");
			salida.close();
			System.out.println("Se ha escrito correctamente al archivo\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void leerArchivo(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String lectura;
			lectura = entrada.readLine();
			while (lectura != null) {
				System.out.println(lectura);
				lectura = entrada.readLine();
			}
			entrada.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void anexarArchivo(String nombreArchivo, String contenido) {
		File archivo = new File(nombreArchivo);
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
			salida.println(contenido);
			salida.println();
			salida.close();
			System.out.println("Se ha anexado la informacioncorrectamente\n");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/*public static boolean recuperarDatos(File archivo) {

	try {

		do {

			String aux = JOptionPane.showInputDialog("Ha realizado cambios que no ha guardado en el disco."
					+ "\nSi continua la carga del archivo se restauraran los datos del disco "
					+ "\ny se perderan los cambios no guardados.\n¿Desea continuar con la carga y restaurar los datos del archivo? (S/N)");

			if (aux.equalsIgnoreCase("s")) {

				importarDatos(archivo);
				return true;

			} else if (aux.equalsIgnoreCase("n")) {

				JOptionPane.showMessageDialog(null, "Operacion cancelada", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
				return false;

			} else {

				JOptionPane.showMessageDialog(null, "Accion no valida", "Informacion",
						JOptionPane.INFORMATION_MESSAGE);
				return false;
			}

		} while (true);

	} catch (Exception e) {

		JOptionPane.showMessageDialog(null, "Accion Cancelada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		return false;

	}

}*/

/*public static boolean salir(boolean modificado, File archivo) {

	if (modificado == true) {

		try {

			do {

				String aux = JOptionPane.showInputDialog("Ha realizado cambios que no ha guardado en el disco."
						+ "\n¿Desea guardarlos antes de salir? (S/N)");

				if (aux.equalsIgnoreCase("s")) {

					JOptionPane.showMessageDialog(null, "Datos guardados, Hasta pronto!!", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
					exportarDatos(archivo);
					return true;

				} else if (aux.equalsIgnoreCase("n")) {

					JOptionPane.showMessageDialog(null, "Datos no modificados, Hasta pronto!!", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);
					return true;

				} else {

					JOptionPane.showMessageDialog(null, "Accion no valida", "Informacion",
							JOptionPane.INFORMATION_MESSAGE);

				}

			} while (true);

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Accion Cancelada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			return false;

		}
		
	}
	
	
	return true;
	
}*/
	
	
}
