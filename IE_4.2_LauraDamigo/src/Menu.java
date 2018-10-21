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

					opcion = Integer.parseInt(
							JOptionPane.showInputDialog("Que desea gestionar?\n1. Profesores\n2. Centros"
									+ "\n3. Asignaturas\n4. Consultar profesores de un centro"
									+"\n5. Consultar las asignaturas de un profesor\n0. Salir"));

					switch (opcion) {

					case 1:

						try {

							opcion = Integer.parseInt(JOptionPane
									.showInputDialog("Que desea hacer?\n1. Insertar profesor\n2. Borrar profesor"
											+ "\n3. Modificar un profesor\n4. Listar Profesores\n0. Salir"));

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

								metodos.muestraProf(bd);

								break;

							}

						} catch (NumberFormatException e) {

						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Accion cancelada !!!", " ^-^ Information^-^ ",
									JOptionPane.INFORMATION_MESSAGE);
							e.printStackTrace();
						}

						break;

					case 2:

						try {

							opcion = Integer.parseInt(JOptionPane
									.showInputDialog("Que desea hacer?\n1. Insertar Centro\n2. Borrar Centro"
											+ "\n3. Modificar un Centro\n4. Listar Centro\n0. Salir"));

							switch (opcion) {
							case 1:

								metodos.insertarCen(bd);
								metodos.muestraCen(bd);
								
								break;

							case 2:

								metodos.borrar(bd, "Centro");
								metodos.muestraCen(bd);
								
								break;
								
							case 3:

								metodos.modificarCen(bd);
								metodos.muestraCen(bd);
								
								break;
								
							case 4:

								metodos.muestraCen(bd);
								
								break;
								
							}

						} catch (NumberFormatException e) {

						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Accion cancelada !!!", " ^-^ Information^-^ ",
									JOptionPane.INFORMATION_MESSAGE);
							e.printStackTrace();
						}


						break;

					case 3:

						try {

							opcion = Integer.parseInt(JOptionPane
									.showInputDialog("Que desea hacer?\n1. Insertar Asignatura\n2. Borrar Asignatura"
											+ "\n3. Modificar Asignatura\n4. Listar Asignatura\n5. Anyadir profesor a una asignatura"
											+"\n6. Eliminar profesor de una asignatura\n0. Salir"));

							switch (opcion) {
							case 1:

								metodos.insertarAsig(bd);
								metodos.muestraAsig(bd);
								
								break;

							case 2:

								metodos.borrar(bd, "Asignatura");
								metodos.muestraAsig(bd);
								
								break;
								
							case 3:

								metodos.modificarAsig(bd);
								metodos.muestraAsig(bd);
								
								break;
								
							case 4:

								metodos.muestraAsig(bd);
								
								break;
								
							case 5:

								metodos.modificarProfAsig(bd);
								metodos.muestraAsig(bd);
								
								break;
								
							case 6:

								metodos.eliminarProfAsig(bd);
								metodos.muestraAsig(bd);
								
								break;
								
							}

						} catch (NumberFormatException e) {

						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Accion cancelada !!!", " ^-^ Information^-^ ",
									JOptionPane.INFORMATION_MESSAGE);
							e.printStackTrace();
						}

						break;

					case 4:

						metodos.profesoresCentro(bd);
						

						break;

					case 5:

						metodos.asignaturasProf(bd);
						

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
