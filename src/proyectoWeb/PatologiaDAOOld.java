package proyectoWeb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class PatologiaDAOOld {

	private final static String S_PATH_FILE_PRIVATE_KEY = "C:/Users/Administrador.000/workspace/proyectoWeb/id_rsa.ppk";
	private final static String S_PATH_FILE_KNOWN_HOSTS = "C:/Users/Administrador.000/workspace/proyectoWeb/known_hosts";
	private final static String S_PASS_PHRASE = "mypassphrase";
	private final static int LOCAl_PORT = 3307; 
	private final static int REMOTE_PORT = 3306; 
	private final static int SSH_REMOTE_PORT = 22; 
	private final static String SSH_USER = "587fca0889f5cf057100004b";
	private final static String SSH_REMOTE_SERVER = "femxa-ebtm.rhcloud.com";
	private final static String MYSQL_REMOTE_SERVER = "127.11.220.2";
	private static Session sesion; 
	private final static String cadena_conexion = "jdbc:mysql://localhost:3307/femxa";
	private final static String user = "adminGXjlxzG";
	private final static String password = "QBShkFDW_69e";
	
	private static void conectate_A_SSH () throws Throwable
	{
		JSch jsch = new JSch();
        jsch.setKnownHosts(S_PATH_FILE_KNOWN_HOSTS);
        jsch.addIdentity(S_PATH_FILE_PRIVATE_KEY, S_PASS_PHRASE.getBytes());

        sesion = jsch.getSession(SSH_USER, SSH_REMOTE_SERVER, SSH_REMOTE_PORT);
        sesion.connect(); 
    
        sesion.setPortForwardingL(LOCAl_PORT, MYSQL_REMOTE_SERVER, REMOTE_PORT); 
	}
	
	private static void desconectate_D_SSH ()
	{
		sesion.disconnect();
	}
	
	public PatologiaDTOOld getPatologiaPorID (int id) throws Throwable
	{
		Connection conn = null;
		ResultSet rset = null;
		Statement stmt = null;
		PatologiaDTOOld patologia = null;
		
		try
		{
			conectate_A_SSH();
			
			DriverManager.registerDriver (new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection (cadena_conexion, user, password);
  	        stmt = conn.createStatement();
  	        
  	        rset = stmt.executeQuery(Consulta.CONSULTA_PATOLOGIAS_POR_ID+id);
			while (rset.next())
		    {
				patologia = new PatologiaDTOOld(rset.getInt(1), rset.getNString(2), rset.getString(3), rset.getString(4), rset.getNString(5), getSintomasPorPatologiaID(conn, rset.getInt(1)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  	desconectate_D_SSH(); 
		}   
		return patologia;
	}
	
	public PatologiaDTOOld getPatologiaPorNombre (String nombre)
	{
		return null;
	}
	
	public static List<SintomaDTO> getSintomasPorPatologiaID (Connection conn, int id) throws SQLException
	{
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
			
			String descripcion_sintoma = null;
			int id_sintoma = 0;
			SintomaDTO sintoma = null;
			ResultSet rset2 = null;
			Statement stmt2 = null;
			stmt2 = conn.createStatement();
			rset2 = stmt2.executeQuery(Consulta.CONSULTA_SINTOMAS_POR_PATOLOGIA+id+"'))");
			while (rset2.next())
		    {
				id_sintoma = rset2.getInt(1);
				descripcion_sintoma = rset2.getString(2);
				sintoma = new SintomaDTO(id_sintoma, descripcion_sintoma);
				lista_sintomas.add(sintoma);
			}
			if (rset2 != null) 	{ try { rset2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (stmt2 != null)	{ try {	stmt2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			
		return lista_sintomas;
	}
	
	public List<PatologiaDTOOld> getListaPatologias () throws Throwable
	{
		List<PatologiaDTOOld> lista_patologias = new ArrayList<PatologiaDTOOld>();
			
			PatologiaDTOOld patologia = null;
			Connection conn = null;
			ResultSet rset = null;
			Statement stmt = null;
			
			try
			{
				conectate_A_SSH();
				
				DriverManager.registerDriver (new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection (cadena_conexion, user, password);
				stmt = conn.createStatement();
	  	        
				rset = stmt.executeQuery(Consulta.CONSULTA_LISTAR_PATOLOGIAS);
				while (rset.next())
			    {
					patologia = new PatologiaDTOOld(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), getSintomasPorPatologiaID(conn, rset.getInt(1)));
					lista_patologias.add(patologia);
			    }
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally 
			{
				if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
				if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
				if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
			  	desconectate_D_SSH(); 
			}
			
		return lista_patologias;
	}
	
}
