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
		return "Asignatura: " + codAsig + ", nombre: " + nombreAsi + ", profesores=" + setprofesores;
	}

	public Asignatura(int codAsig, String nombreAsi, ArrayList<Profesor> setprofesores) {

		this.codAsig = codAsig;
		this.nombreAsi = nombreAsi;
		this.setprofesores = setprofesores;
	}

	public Asignatura(int codAsig, String nombreAsi) {

		this.codAsig = codAsig;
		this.nombreAsi = nombreAsi;

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

	public Asignatura devuelveProf(ObjectContainer bd, int cod) {

		Asignatura c = new Asignatura(cod);
		ObjectSet res = bd.queryByExample(c);
		if (res.isEmpty()) {
			c = null;
			return c;
		} else {
			Asignatura ce = (Asignatura) res.next();
			return ce;

		}

	}
	
	

}
