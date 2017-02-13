

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

import proyectoWeb.PatologiaDTO;
import proyectoWeb.PatologiaService;

/**
 * Servlet implementation class BuscarPatologia
 */
@WebServlet("/BuscarPatologia")
public class BuscarPatologia extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    List<PatologiaDTO> lista_patologias;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPatologia() {
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
		
		PatologiaService ps = new PatologiaService();
		/*HashMap<Integer, PatologiaDTO> hm = new HashMap<Integer, PatologiaDTO>();
		
		for (PatologiaDTO patologia : lista_patologias) {
 	    	hm.put(patologia.getId(), patologia);
  	    }
		PrintWriter pw = response.getWriter().append(hm.get(idn).toString());
		System.out.println(hm.get(idn).toString());*/
		try {
			PrintWriter pw = response.getWriter().append(ps.buscarPatologiaPorID(idn).toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		PatologiaService ps = new PatologiaService();
		this.lista_patologias = new ArrayList<PatologiaDTO>();
		
		try {
			this.lista_patologias = ps.listarPatologias();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
