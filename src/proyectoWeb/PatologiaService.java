package proyectoWeb;

import java.util.ArrayList;
import java.util.List;

public class PatologiaService {
	
	public List<PatologiaDTO> listarPatologias () throws Throwable
	{
		List<PatologiaDTO> lista_patologias = null;
		PatologiaDAO pdao = new PatologiaDAO();
		
			lista_patologias = new ArrayList<PatologiaDTO>();
			lista_patologias = pdao.getListaPatologias();
			
		return lista_patologias;
	}
	
	public PatologiaDTO buscarPatologiaPorID (int id) throws Throwable
	{
		PatologiaDTO pdto = null;
		PatologiaDAO pdao = new PatologiaDAO();
		
			pdto = pdao.getPatologiaPorID(id);
			//GenerarEstadística
		
		return pdto;
	}
	
	public PatologiaDTO buscarPatologiaPorNombre (String nombre)
	{
		PatologiaDTO pdto = null;
		PatologiaDAO pdao = new PatologiaDAO();
		
			pdto = pdao.getPatologiaPorNombre(nombre);
		
		return pdto;
	}
	
	

}
