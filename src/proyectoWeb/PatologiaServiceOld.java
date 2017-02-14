package proyectoWeb;

import java.util.ArrayList;
import java.util.List;

public class PatologiaServiceOld {
	
	public List<PatologiaDTOOld> listarPatologias () throws Throwable
	{
		List<PatologiaDTOOld> lista_patologias = null;
		PatologiaDAOOld pdao = new PatologiaDAOOld();
		
			lista_patologias = new ArrayList<PatologiaDTOOld>();
			lista_patologias = pdao.getListaPatologias();
			
		return lista_patologias;
	}
	
	public PatologiaDTOOld buscarPatologiaPorID (int id) throws Throwable
	{
		PatologiaDTOOld pdto = null;
		PatologiaDAOOld pdao = new PatologiaDAOOld();
		
			pdto = pdao.getPatologiaPorID(id);
			//GenerarEstadística
		
		return pdto;
	}
	
	public PatologiaDTOOld buscarPatologiaPorNombre (String nombre)
	{
		PatologiaDTOOld pdto = null;
		PatologiaDAOOld pdao = new PatologiaDAOOld();
		
			pdto = pdao.getPatologiaPorNombre(nombre);
		
		return pdto;
	}
	
	

}
