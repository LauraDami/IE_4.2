package pojos;

import java.util.ArrayList;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Asignatura {

	private int codAsig;
	private String nombreAsi;
	private ArrayList<Profesor> setprofesores;

	@Override
	public String toString() {
		return "Asignatura: " + codAsig + ", nombre: " + nombreAsi + ", profesores=" + setprofesores+
				"\n*********************************************************";
	}

	public Asignatura(int codAsig, String nombreAsi, ArrayList<Profesor> setprofesores) {

		this.codAsig = codAsig;
		this.nombreAsi = nombreAsi;
		this.setprofesores = setprofesores;
	}

	public Asignatura(int codAsig, String nombreAsi) {

		this.codAsig = codAsig;
		this.nombreAsi = nombreAsi;
		this.setprofesores=new ArrayList<Profesor>();

	}

	public Asignatura() {

	}

	public Asignatura(int cod) {
		this.codAsig = cod;
	}

	public int getCodAsig() {
		return codAsig;
	}

	public void setCodAsig(int codAsig) {
		this.codAsig = codAsig;
	}

	public String getNombreAsi() {
		return nombreAsi;
	}

	public void setNombreAsi(String nombreAsi) {
		this.nombreAsi = nombreAsi;
	}

	public ArrayList<Profesor> getSetprofesores() {
		return setprofesores;
	}

	public void setSetprofesores(ArrayList<Profesor> setprofesores) {
		this.setprofesores = setprofesores;
	}

	/*public Asignatura devuelveProf(ObjectContainer bd, int cod) {

		Asignatura c = new Asignatura(cod);
		ObjectSet res = bd.queryByExample(c);
		if (res.isEmpty()) {
			c = null;
			return c;
		} else {
			Asignatura ce = (Asignatura) res.next();
			return ce;

		}

	}*/
	
	public boolean comprobarProfesor(Profesor p) {
		boolean exists=false;
		
		if(setprofesores!=null) {
					
		for (int i=0; i<setprofesores.size(); i++) {
			if(setprofesores.get(i).equals(p) ) {
				exists=true;
			}
		}}
		return exists;
	}
	
	
	public boolean addProfesor(Profesor p) {
		if (comprobarProfesor(p)) {
			return false;
		}else {
			ArrayList<Profesor>lista = getSetprofesores();
			lista.add(p);
			setSetprofesores(lista);
			return true;
		}
	}
	
	
	public boolean deleteProfesor(Profesor p) {
		if (comprobarProfesor(p)) {
			setprofesores.remove(p);
			return true;
		}else {
			return false;
		}
	}

}
