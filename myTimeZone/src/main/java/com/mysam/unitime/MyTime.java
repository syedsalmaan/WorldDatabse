package com.mysam.unitime;

import java.awt.image.RescaleOp;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;



public class MyTime extends HttpServlet {
	public void service(ServletRequest rq,ServletResponse rs) throws IOException{
		try {
			
//		rs.getWriter().println("hello");
		rs.setContentType("text/html");
		PrintWriter out = rs.getWriter();
		String country = rq.getParameter("country");
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.setTimeZone(TimeZone.getTimeZone(country));
		sdf.applyPattern("dd MMM yyyy HH:mm:ss z");
		RequestDispatcher rDispatcher = rq.getRequestDispatcher("/Time.html");
		rDispatcher.include(rq, rs);
		out.println("<h1>"+country+"--------"+sdf.format(Calendar.getInstance().getTime())+"</h1>");
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
		
	

}
