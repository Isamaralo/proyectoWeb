package proyectoWeb;

public class PatologiaService {
	
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
