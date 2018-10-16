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
									+ "\n3. Modificar un salario\n4. Borrar un empleado\n5.-Salir"));

					switch (opcion) {

					case 1:

						metodos.insertarProf(bd);
						metodos.muestraProf(bd);
						
						break;

					case 2:

						metodos.borrarProf(bd);
						metodos.muestraProf(bd);
						
						break;

					case 3:

						break;

					case 4:

						break;

					case 5:

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
			
			
			
			
		} while (opcion != 5);
	}

}
