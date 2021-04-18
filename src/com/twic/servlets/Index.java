package com.twic.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.twic.api.Requete;
import com.twic.modeles.Ville;
import com.twic.operations.Operation;


@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Index() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Requete requete = new Requete();
		List<Ville> villes = requete.getVilles();
		request.setAttribute("villes", villes);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("recu");
		
		String ville1 = request.getParameter("ville1");
		String ville2 = request.getParameter("ville2");
		Operation op = new Operation();
		double distance = op.calculDistance(ville1,ville2);
		request.setAttribute("distance", distance);
		System.out.println(distance);
		doGet(request, response);

	}

}
