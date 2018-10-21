package pojos;

import java.time.LocalDate;
import java.util.Date;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Profesor {

	private Integer codProf;
	private String nombreApe;
	 private String nombreEspe;
	 private LocalDate fechaNac;
	 private String sexo;
	private Centro centro;
	
	public Integer getCodProf() {
		return codProf;
	}
	public void setCodProf(Integer codProf) {
		this.codProf = codProf;
	}
	public String getNombreApe() {
		return nombreApe;
	}
	public void setNombreApe(String nombreApe) {
		this.nombreApe = nombreApe;
	}
	public String getNombreEspe() {
		return nombreEspe;
	}
	public void setNombreEspe(String nombreEspe) {
		this.nombreEspe = nombreEspe;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Centro getCentro() {
		return centro;
	}
	public void setCentro(Centro centro) {
		this.centro = centro;
	}
	public Profesor(Integer codProf, String nombreApe, String nombreEspe, LocalDate fechaNac, String sexo, Centro centro) {
		
		this.codProf = codProf;
		this.nombreApe = nombreApe;
		this.nombreEspe = nombreEspe;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.centro = centro;
	}
	
	public Profesor() {}
	
	public Profesor(Integer codProf) {
		this.codProf = codProf;
		this.nombreApe = null;
		this.nombreEspe = null;
		this.fechaNac = null;
		this.sexo = null;
		this.centro = null;
	}
	
	public Profesor(Centro cen) {
		this.codProf = null;
		this.nombreApe = null;
		this.nombreEspe = null;
		this.fechaNac = null;
		this.sexo = null;
		this.centro = cen;
	}
	
	public Profesor (Integer codProf, String nombreApe, String nombreEspe, LocalDate fechaNac, String sexo) {
		
		this.codProf = codProf;
		this.nombreApe = nombreApe;
		this.nombreEspe = nombreEspe;
		this.fechaNac = fechaNac;
		this.sexo = sexo;
		this.centro = null;
		
	}
	
	
	public static Profesor devuelveProf(ObjectContainer bd, int cod) {

		Profesor c = new Profesor(cod);
		ObjectSet res = bd.queryByExample(c);
		if(res.isEmpty()) {
			c=null;
			return c;
		}else {
			c=(Profesor)res.next();
		}
		return c;
	}
	
	
	
	@Override
	public String toString() {
		
		if(centro == null) {
			return "Profesor: " + codProf + ", \nNombre=" + nombreApe + ", \nespecialidad=" + nombreEspe
					+ ", \nfecha de nacimiento=" + fechaNac + ", \nsexo=" + sexo + "\nNo tiene centro asignado"
					+"\n********************************************";
		}else {
		return "Profesor: " + codProf + ", \nNombre=" + nombreApe + ", \nespecialidad=" + nombreEspe
				+ ", \nfecha de nacimiento=" + fechaNac + ", \nsexo=" + sexo + ", \ncentro=" +  centro.getNomCentro()
				+"\n********************************************";
		}
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
