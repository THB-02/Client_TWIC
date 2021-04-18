package com.twic.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twic.api.Requete;
import com.twic.modeles.Ville;

/**
 * Servlet implementation class Villes
 */
@WebServlet("/Villes")
public class Villes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Villes() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Requete requete = new Requete();
		List<Ville> villes = requete.getVilles();
		
		
		
		if(request.getParameter("page") != null) {
			if(Integer.parseInt(request.getParameter("page")) <1 || Integer.parseInt(request.getParameter("page")) > villes.size()/50 + 1) {
				request.setAttribute("begin", 0);
				request.setAttribute("end", 49);
				request.setAttribute("page", 1);
			}
			else {
				int begin =(Integer.parseInt(request.getParameter("page"))-1) * 50;
				int end = Integer.parseInt(request.getParameter("page")) * 50 -1;
				
				request.setAttribute("begin", begin);
				request.setAttribute("end", end);
				
				request.setAttribute("page", Integer.parseInt(request.getParameter("page")));
			}
		}
		else {
			request.setAttribute("begin", 0);
			request.setAttribute("end", 49);
			request.setAttribute("page", 1);
		}
		
		
		request.setAttribute("villes", villes);
		this.getServletContext().getRequestDispatcher("/WEB-INF/villes.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" : "+request.getParameter("page"));
		doGet(request, response);
	}

}
