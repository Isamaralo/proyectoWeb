

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proyectoWeb.PatologiaDTOOld;
import proyectoWeb.PatologiaServiceOld;

/**
 * Servlet implementation class BuscarPatologia
 */
@WebServlet("/BuscarPatologia")
public class BuscarPatologiaOld extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    List<PatologiaDTOOld> lista_patologias;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPatologiaOld() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		int idn = Integer.parseInt(id); 
		
		PatologiaServiceOld ps = new PatologiaServiceOld();
		HashMap<Integer, PatologiaDTOOld> hm = new HashMap<Integer, PatologiaDTOOld>();
		
		for (PatologiaDTOOld patologia : lista_patologias) {
 	    	hm.put(patologia.getId(), patologia);
  	    }
		PrintWriter pw = response.getWriter().append(hm.get(idn).toString());
		/*try {
			PrintWriter pw = response.getWriter().append(ps.buscarPatologiaPorID(idn).toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		PatologiaServiceOld ps = new PatologiaServiceOld();
		this.lista_patologias = new ArrayList<PatologiaDTOOld>();
		
		try {
			this.lista_patologias = ps.listarPatologias();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
