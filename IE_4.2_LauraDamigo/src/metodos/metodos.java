package metodos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import pojos.Asignatura;
import pojos.Centro;
import static pojos.Centro.devuelveCentro;
import static pojos.Profesor.devuelveProf;
import pojos.Profesor;

public class metodos {

	// método para mostrar todo lo que hay en la BBDD
	public static void mostrarResultado(ObjectSet res) {
		System.out.println("Recuperados " + res.size() + " Objetos");
		while (res.hasNext()) {
			System.out.println(res.next());
		}
	}

	// método para mostrar la lista de profesores
	public static void muestraProf(ObjectContainer bd) {

		Profesor p = new Profesor();
		ObjectSet res = bd.queryByExample(p);
		mostrarResultado(res);
	}

	// metodo para mostrar lista de Centros
	public static void muestraCen(ObjectContainer bd) {

		Centro c = new Centro();
		ObjectSet res = bd.queryByExample(c);
		mostrarResultado(res);
	}

	// metodo para mostrar lista de Asignaturas
	public static void muestraAsig(ObjectContainer bd) {

		Asignatura a = new Asignatura();
		ObjectSet res = bd.queryByExample(a);
		mostrarResultado(res);
	}

	// método para insertar un profesor
	public static void insertarProf(ObjectContainer bd) {

		int centro = usar.Operaciones.addInt("Indique el código del centro");
		Centro c = new Centro(centro);
		ObjectSet res = bd.queryByExample(c);

		if (res.isEmpty()) {
			System.out.print("Ha habido un error, el centro introducido no existe");
		} else {

			int cod = usar.Operaciones.addInt("Indique el codigo del profesor");
			String nombreApe = usar.Operaciones.addString("Indique el nombre");
			String nombreEspe = usar.Operaciones.addString("Indique la especialidad");
			LocalDate fechaNac = usar.Operaciones.addFecha("Indique la fecha de nacimiento");
			String sexo = usar.Operaciones.addString("Indique el sexo");

			Profesor p = new Profesor(cod, nombreApe, nombreEspe, fechaNac, sexo, devuelveCentro(bd, centro));

			if (comprobar(bd, p, cod) == false) {

				bd.store(p);
			} else {
				System.out.print("Ha habido un error, el profesor introducido ya existe");
			}

		}

	}

	// método para insertar un centro
	public static void insertarCen(ObjectContainer bd) {

		int cod = usar.Operaciones.addInt("Indique el código del centro");
		Centro c = new Centro(cod);

		if (comprobar2(bd, c, cod) == false) {

			ObjectSet res = bd.queryByExample(c);

			String nomCentro = usar.Operaciones.addString("Indique el nombre del centro");
			String direccion = usar.Operaciones.addString("Indique la direccion");
			String localidad = usar.Operaciones.addString("Indique la localidad");
			String provincia = usar.Operaciones.addString("Indique la provincia");

			c = new Centro(cod, nomCentro, direccion, localidad, provincia);

			bd.store(c);
		} else {
			System.out.print("Ha habido un error, el centro introducido ya existe");
		}

	}

	// método para insertar una asignatura
	public static void insertarAsig(ObjectContainer bd) {

		int cod = usar.Operaciones.addInt("Indique el código de la asignatura");
		Asignatura a = new Asignatura(cod);

		if (comprobar2(bd, a, cod) == false) {

			ObjectSet res = bd.queryByExample(a);

			String nombre = usar.Operaciones.addString("Indique el nombre de la asignatura");

			a = new Asignatura(cod, nombre);

			bd.store(a);
		} else {
			System.out.print("Ha habido un error, la asignatura introducida ya existe");
		}

	}

	// método para modificar una asignatura
	public static void modificarAsig(ObjectContainer bd) {

		int cod = usar.Operaciones.addInt("Indique el codigo de la asignatura");
		Asignatura a = new Asignatura(cod);

		if (comprobar2(bd, a, cod) == false) {

			System.out.print("Ha habido un error, la asignatura introducida no existe");

		} else {

			ObjectSet res = bd.queryByExample(a);
			a = (Asignatura) res.next();

			a.setNombreAsi(usar.Operaciones.addString("Indique el nombre de la asignatura"));

			bd.store(a);
		}

	}

	// método para modificar un profesor
	public static void modificarProfAsig(ObjectContainer bd) {

		int cod = usar.Operaciones.addInt("Indique el codigo de la asignatura");
		Asignatura a = new Asignatura(cod);

		if (comprobar2(bd, a, cod) == false) {

			System.out.print("Ha habido un error, la asignatura introducida no existe");
		} else {

			ObjectSet res = bd.queryByExample(new Asignatura(cod));
			a = (Asignatura) res.next();

			int prof = usar.Operaciones.addInt("Indique el codigo del profesor");
			Profesor p = new Profesor(prof);
			ObjectSet res1 = bd.queryByExample(p);

			if (res1.isEmpty()) {
				System.out.print("Ha habido un error, el profesor introducido no existe");
			} else {

				p = (Profesor) res1.next();
				a.addProfesor(p);

				bd.store(a);
			}

		}

	}

	// método para modificar un profesor
	public static void eliminarProfAsig(ObjectContainer bd) {

		int cod = usar.Operaciones.addInt("Indique el codigo de la asignatura");
		Asignatura a = new Asignatura(cod);

		if (comprobar2(bd, a, cod) == false) {

			System.out.print("Ha habido un error, la asignatura introducida no existe");
		} else {

			ObjectSet res = bd.queryByExample(new Asignatura(cod));
			a = (Asignatura) res.next();

			int prof = usar.Operaciones.addInt("Indique el codigo del profesor");
			Profesor p = new Profesor(prof);
			ObjectSet res1 = bd.queryByExample(p);

			if (res1.isEmpty()) {
				System.out.print("Ha habido un error, el profesor introducido no existe");
			} else {

				p = (Profesor) res1.next();
				a.deleteProfesor(p);

				bd.store(a);
			}

		}

	}

	// método para modificar un profesor
	public static void modificarProf(ObjectContainer bd) {

		int cod = usar.Operaciones.addInt("Indique el codigo del profesor");
		Profesor p = new Profesor(cod);

		if (comprobar(bd, p, cod) == false) {

			System.out.print("Ha habido un error, el profesor introducido no existe");
		} else {

			ObjectSet res = bd.queryByExample(new Profesor(cod));
			p = (Profesor) res.next();

			int centro = usar.Operaciones.addInt("Indique el código del centro");
			Centro c = new Centro(centro);
			ObjectSet res1 = bd.queryByExample(c);

			if (res1.isEmpty()) {
				System.out.print("Ha habido un error, el centro introducido no existe");
			} else {

				p.setCentro(devuelveCentro(bd, centro));
				p.setNombreApe(usar.Operaciones.addString("Indique el nombre"));
				p.setNombreEspe(usar.Operaciones.addString("Indique la especialidad"));
				p.setFechaNac(usar.Operaciones.addFecha("Indique la fecha de nacimiento"));
				p.setSexo(usar.Operaciones.addString("Indique el sexo"));

				bd.store(p);
			}

		}

	}

	// método para modificar un centro
	public static void modificarCen(ObjectContainer bd) {

		int cod = usar.Operaciones.addInt("Indique el codigo del centro");
		Centro c = new Centro(cod);

		if (comprobar(bd, c, cod) == false) {

			System.out.print("Ha habido un error, el centro introducido no existe");
		} else {

			ObjectSet res = bd.queryByExample(c);
			c = (Centro) res.next();

			int prof = usar.Operaciones.addInt("Indique el código del director");
			Profesor p = new Profesor(prof);
			ObjectSet res1 = bd.queryByExample(p);

			if (res1.isEmpty()) {
				System.out.print("Ha habido un error, el director introducido no existe");
			} else {

				c.setDirector(devuelveProf(bd, prof));
				c.setDireccion(usar.Operaciones.addString("Indique la direccion"));
				c.setLocalidad(usar.Operaciones.addString("Indique la localidad"));
				c.setProvincia(usar.Operaciones.addString("Indique la provincia"));

				bd.store(c);
			}

		}

	}

	/*
	 * /método para borrar un profesor public static void borrarProf(ObjectContainer
	 * bd) {
	 * 
	 * int cod = usar.Operaciones.addInt("Indique el codigo del profesor");
	 * //Profesor p =new Profesor (cod); ObjectSet res = bd.queryByExample(new
	 * Profesor (cod));
	 * 
	 * if (res.isEmpty()) {
	 * System.out.print("Ha habido un error, el profesor introducido no existe"); }
	 * else {
	 * 
	 * Profesor p=(Profesor)res.next(); bd.delete(p);
	 * 
	 * }
	 * 
	 * }
	 */

	// metodo para borrar cualquier tipo de objeto
	public static void borrar(ObjectContainer bd, String tipo) {
		int cod = usar.Operaciones.addInt("Indique el codigo");
		
		if (tipo == "Profesor") {
			Profesor p = new Profesor(cod);
			ObjectSet res = bd.queryByExample(p);

			if (res.isEmpty()) {
				System.out.print("Ha habido un error, el profesor introducido no existe");
			} else {

				Centro c = new Centro(0, null, p, null, null, null);
				ObjectSet res1 = bd.queryByExample(c);
				while (res1.hasNext()) {
					Centro c1 = (Centro) res.next();
					c1.setDireccion(null);
					bd.store(c1);
				}
				
				
				

				p = (Profesor) res.next();
				bd.delete(p);

			}

		} else if (tipo == "Asignatura") {
			ObjectSet res = bd.queryByExample(new Asignatura(cod));

			if (res.isEmpty()) {
				System.out.print("Ha habido un error, la asignatura introducida no existe");
			} else {

				Asignatura a = (Asignatura) res.next();
				bd.delete(a);

			}

		} else if (tipo == "Centro") {
			Centro c = new Centro(cod);
			ObjectSet res = bd.queryByExample(c);

			if (res.isEmpty()) {
				System.out.print("Ha habido un error, el centro introducido no existe");
			} else {

				Profesor p = new Profesor(0, null, null, null, null, c);
				ObjectSet res1 = bd.queryByExample(p);
				while (res1.hasNext()) {
					Profesor p1 = (Profesor) res.next();
					p1.setCentro(null);
					bd.store(p1);
				}
				c = (Centro) res.next();
				bd.delete(c);

			}
		}
	}

	public static boolean comprobar2(ObjectContainer bd, Object obj, int cod) {
		boolean exists = false;

		ObjectSet res = bd.queryByExample(obj);
		if (res.isEmpty()) {
			exists = false;
		} else {
			exists = true;
		}
		return exists;
	}

	// método para comprobar si un objeto ya existe
	public static boolean comprobar(ObjectContainer bd, Object obj, int cod) {
		boolean exists = false;

		if (obj instanceof Profesor) {
			Profesor p = new Profesor(cod);
			ObjectSet res = bd.queryByExample(p);
			if (res.isEmpty()) {
				exists = false;
			} else {
				exists = true;
			}
			return exists;

		} else if (obj instanceof Asignatura) {
			Asignatura a = new Asignatura(cod);
			ObjectSet res = bd.queryByExample(a);
			if (res.isEmpty()) {
				exists = false;
			} else {
				exists = true;
			}
			return exists;

		} else if (obj instanceof Centro) {
			Centro c = new Centro(cod);
			ObjectSet res = bd.queryByExample(c);
			if (res.isEmpty()) {
				exists = false;
			} else {
				exists = true;
			}
			return exists;
		} else {
			return exists;
		}

	}

	public static void insertar(ObjectContainer bd, Object obj) {

		if (obj instanceof Profesor) {

			Profesor p = (Profesor) obj;
			bd.store(p);

		} else if (obj instanceof Asignatura) {

			Asignatura a = (Asignatura) obj;
			bd.store(a);

		} else if (obj instanceof Centro) {

			Centro c = (Centro) obj;
			bd.store(c);

		}

	}
}
