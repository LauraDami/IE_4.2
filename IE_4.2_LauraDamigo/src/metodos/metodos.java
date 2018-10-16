package metodos;

import java.time.LocalDate;
import java.util.Date;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import pojos.Asignatura;
import pojos.Centro;
import static pojos.Centro.devuelveCentro;
import pojos.Profesor;

public class metodos {
	
	
	//método para mostrar todo lo que hay en la BBDD
	public static void mostrarResultado(ObjectSet res) {
		System.out.println("Recuperados " + res.size() + " Objetos");
		while (res.hasNext()) {
			System.out.println(res.next());
		}
	}

	
	//método para mostrar la lista de profesores
	public static void muestraProf(ObjectContainer bd) {

		Profesor p = new Profesor();
		ObjectSet res = bd.queryByExample(p);
		mostrarResultado(res);
	}
	

	// método para insertar un profesor
	public static void insertarProf(ObjectContainer bd) {
		//Centro d=new Centro (1, "prueba", "ljsnvdWR", "LNSVW", "prov");
		//bd.store(d);

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
	
	
	


	//método para borrar un profesor
	public static void borrarProf(ObjectContainer bd) {
		
		int cod = usar.Operaciones.addInt("Indique el codigo del profesor");
		Profesor p =new Profesor (cod);
		ObjectSet res = bd.queryByExample(p);
		
		if (res.isEmpty()) {
			System.out.print("Ha habido un error, el profesor introducido no existe");
		} else {
			
			bd.delete(p);
			
		}
		
	}
	
	
	
	
	//método para comprobar si un objeto ya existe
	public static boolean comprobar(ObjectContainer bd, Object obj, int cod) {
		boolean exists=false;
		
		if (obj instanceof Profesor) {
			Profesor p = new Profesor(cod);
			ObjectSet res= bd.queryByExample(p);
			if(res.isEmpty()) {
				exists=false;
			}else {
				exists=true;
			}
			return exists;
			
		}else if (obj instanceof Asignatura) {
			Asignatura a = new Asignatura(cod);
			ObjectSet res= bd.queryByExample(a);
			if(res.isEmpty()) {
				exists=false;
			}else {
				exists=true;
			}
			return exists;
			
		}else if (obj instanceof Centro) {
			Centro c = new Centro(cod);
			ObjectSet res= bd.queryByExample(c);
			if(res.isEmpty()) {
				exists=false;
			}else {
				exists=true;
			}
			return exists;
		}else {
			return exists;
		}
		
	}
	
	
	public static void insertar(ObjectContainer bd, Object obj) {

		if (obj instanceof Profesor) {
			
			Profesor p = (Profesor)obj;
			bd.store(p); 			
			
		}else if (obj instanceof Asignatura) {
			
			Asignatura a = (Asignatura)obj;
			bd.store(a);
			
		}else if (obj instanceof Centro) {
			
			Centro c = (Centro)obj;
			bd.store(c);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}}
