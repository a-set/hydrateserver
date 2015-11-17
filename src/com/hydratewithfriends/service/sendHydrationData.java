package com.hydratewithfriends.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hydratewithfriends.utility.DatabaseConnection;

/**
 * Servlet implementation class sendHydrationData
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/sendHydrationData" })
public class sendHydrationData extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<body>" + 
		"<h1 align=center>Use this service URL to make a POST request with parameters \"amount\"</h1>" + "</body>" + "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the parameters from request
		try{
		Long amountOfWater = Long.valueOf(request.getParameter("amount"));
		//Long duration = Long.valueOf(request.getParameter("Duration"));
		
		//Make DB connection
		DatabaseConnection dbConn = new DatabaseConnection();
		if(dbConn.makeConnection())
			//Insert into a MySql table
			dbConn.insertInto(amountOfWater,(long)System.currentTimeMillis()/1000);
		}
		catch(NumberFormatException exception){
			//TODO handler it
		}
	}

}
