package pojos;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Centro {

	private Integer codCentro;
	private String nomCentro;
	private Profesor director;
	private String direccion;
	private String localidad;
	private String provincia;
	
	
	
	
	@Override
	public String toString() {
		if (director == null) {
			
			return "Centro: " + codCentro + ", nombre:" + nomCentro + ", direccion: "
					+ direccion + ", localidad: " + localidad + ", provincia: " + provincia 
					+ "\nEste centro no tiene director]"+"\n********************************************";
		}else {
		
		return "Centro: " + codCentro + ", nombre:" + nomCentro + ", director:" + director + ", direccion: "
				+ direccion + ", localidad: " + localidad + ", provincia: " + provincia + "]";
		}
	}
	
	
	
	public Integer getCodCentro() {
		return codCentro;
	}
	public void setCodCentro(Integer codCentro) {
		this.codCentro = codCentro;
	}
	public String getNomCentro() {
		return nomCentro;
	}
	public void setNomCentro(String nomCentro) {
		this.nomCentro = nomCentro;
	}
	public Profesor getDirector() {
		return director;
	}
	public void setDirector(Profesor director) {
		this.director = director;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Centro(Integer codCentro, String nomCentro, Profesor director, String direccion, String localidad,
			String provincia) {
		
		this.codCentro = codCentro;
		this.nomCentro = nomCentro;
		this.director = director;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
	public Centro(Integer codCentro, String nomCentro, String direccion, String localidad,
			String provincia) {
		
		this.codCentro = codCentro;
		this.nomCentro = nomCentro;
		
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
	}
	
	public Centro() {
		
	}
	
	public Centro(int cod) {
		this.codCentro = cod;
	}
	
	public static Centro devuelveCentro(ObjectContainer bd, int cod) {

		Centro c = new Centro(cod);
		ObjectSet res = bd.queryByExample(c);
		if(res.isEmpty()) {
			c=null;
			return c;
		}else {
			c=(Centro)res.next();
		}
		return c;
	}
	
	
	
	
	
	
	
	
	
	
	
}
