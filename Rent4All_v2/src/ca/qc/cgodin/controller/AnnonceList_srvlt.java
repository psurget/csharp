package ca.qc.cgodin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.qc.cgodin.model.AnnManager;
import ca.qc.cgodin.model.Annonce;


@WebServlet("/AnnonceList_srvlt")
public class AnnonceList_srvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnonceList_srvlt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
			AnnManager annMan = new AnnManager();
			List<Annonce> annList = annMan.getAllAnnonces_list();
			
			//Deleguer l'affichage à une JSP
			request.setAttribute("annList", annList);
			RequestDispatcher rd = request.getRequestDispatcher("ouverture.jsp");
			rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
