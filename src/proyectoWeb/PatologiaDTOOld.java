package proyectoWeb;

import java.util.List;

public class PatologiaDTOOld {

	private int id;
	private String nombre;
	private String descripcion;
	private String tratamiento;
	private String causa;
	private List<SintomaDTO> lista_sintomas;

	public PatologiaDTOOld(int id, String nombre, String descripcion, String tratamiento, String causa,
			List<SintomaDTO> lista_sintomas) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tratamiento = tratamiento;
		this.causa = causa;
		this.lista_sintomas = lista_sintomas;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<SintomaDTO> getLista_sintomas() {
		return lista_sintomas;
	}
	public void setLista_sintomas(List<SintomaDTO> lista_sintomas) {
		this.lista_sintomas = lista_sintomas;
	}
	
	public String mostrarListaSintomas ()
	{
		String res = "";
		for (SintomaDTO s : lista_sintomas) {
			res += s.toString()+"<br>";
		}
		return res;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		//return super.toString();
		String res = null;
			
			res = "<strong>Nombre:</strong> "+this.nombre+"<br><strong>Descripción:</strong> <br>"+this.descripcion+"<br><strong>Tratamiento:</strong> <br>"+this.tratamiento+"<br><strong>Causa:</strong> <br>"+this.causa+"<br><strong>Síntomas:</strong> <br>"+mostrarListaSintomas();
			
		return res;
	}
	
}
