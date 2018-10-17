import java.io.File;
import java.io.RandomAccessFile;

import javax.swing.JOptionPane;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

import metodos.metodos;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opcion = 0, numEmple;

		do {

			ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "alumnos.db4o");
			try {

				try {

					opcion = Integer.parseInt(JOptionPane
							.showInputDialog("Que desea hacer?\n1. Insertar profesor\n2. Borrar profesor"
									+ "\n3. Modificar un profesor\n4. Insertar Centro\n5. Borrar Centro "
									+ "\n6. Modificar Centro\n7. Insertar Asignatura\n8. Borrar Asignatura"
									+ "\n9. Modificar Asignatura\n10. Añadir profesor a una Asignatura\n0. Salir"));

					switch (opcion) {

					case 1:

						metodos.insertarProf(bd);
						metodos.muestraProf(bd);
						
						break;

					case 2:

						metodos.borrar(bd, "Profesor");
						metodos.muestraProf(bd);
						
						break;

					case 3:
						
						metodos.modificarProf(bd);
						metodos.muestraProf(bd);

						break;

					case 4:

						metodos.insertarCen(bd);
						metodos.muestraCen(bd);
						
						break;

					case 5:

						metodos.borrar(bd, "Centro");
						metodos.muestraCen(bd);
						
						break;
						
					case 6:

						metodos.modificarCen(bd);
						metodos.muestraCen(bd);
						
						break;
						
					case 7:

						metodos.insertarAsig(bd);
						metodos.muestraAsig(bd);
						
						break;
						
					case 8:

						metodos.borrar(bd, "Asignatura");
						metodos.muestraAsig(bd);
						
						break;
						
					case 9:

						metodos.modificarAsig(bd);
						metodos.muestraAsig(bd);
						
						break;
						
					case 10:

						metodos.modificarProfAsig(bd);
						metodos.muestraAsig(bd);
						
						break;

					}

				} catch (NumberFormatException e) {

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Accion cancelada !!!", " ^-^ Information^-^ ",
							JOptionPane.INFORMATION_MESSAGE);
					e.printStackTrace();
				}

			} finally {
				bd.close();
			}
			
			
			
			
		} while (opcion != 0);
	}

}
