package com.simulationcredit.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simulationcredit.model.Model;
import com.simulationcredit.model.Proprietes;
import com.simulationcredit.model.Simulateurs;
import com.simulationcredit.metier.*;

/**
 * Servlet implementation class ServletSimulationCredit
 */
//@WebServlet("/ServletSimulationCredit")
public class ServletSimulationCredit extends HttpServlet {
	private ICalculMensualite mensualiteCalcul;
	private IPropertiesListToString convert;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init(ServletConfig config) throws ServletException{
		
		super.init(config);
		
		mensualiteCalcul = new CalculMensualiteImpl();
		convert = new PropertiesListToString();

		
		File JSONFile = new File(getServletContext().getRealPath("/properties.json"));
		Simulateurs simulateur = ReadJSONFile.readJSONFile(JSONFile);
		
		System.out.println(simulateur);
		List<Model> modelList = new ArrayList<Model>();
		simulateur.getBanques().forEach((banque)->{
			Model model = new Model(banque, 0, 0);
			modelList.add(model);
		});
		ServletContext sc = this.getServletContext();
		sc.setAttribute("modelList", modelList);
		System.out.println("-------------"+modelList.get(1).getBanque().getTypesCredits().get(2).getPropertiesString().get(0));

	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.getRequestDispatcher("/SimlationCredit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		int monthDuration = Integer.parseInt(request.getParameter("monthDuration"));
		double rate = Double.parseDouble(request.getParameter("rate"));
		double amountCredit = Double.parseDouble(request.getParameter("amountCredit"));
		double mensualite = mensualiteCalcul.calculMensualite(rate, amountCredit, monthDuration);
		String array[] = request.getParameterValues("properties");

        out.println(mensualite+"---------------"+array[0]);
        //request.getRequestDispatcher("/SimlationCredit.jsp").forward(request, response);
		
	}

}
