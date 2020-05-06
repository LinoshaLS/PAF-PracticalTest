package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChannelingAPI
 */
@WebServlet("/ChannelingAPI")
public class ChannelingAPI extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	Channeling channelObj=new Channeling();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChannelingAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String output =channelObj.insertChannel(request.getParameter("patientName"),
				request.getParameter("doctorName"),
				request.getParameter("hospitalName"),
				request.getParameter("specialization"),
				request.getParameter("date"));
		
		response.getWriter().write(output);
				
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map paras =getParasMap(request);
		
		String output =channelObj.updateChannel(paras.get("hidItemIDSave").toString(),
				paras.get("patientName").toString(),
				paras.get("doctorName").toString(),
				paras.get("hospitalName").toString(),
				paras.get("specialization").toString(),
				paras.get("date").toString());
		response.getWriter().write(output);
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		String output =channelObj.deleteChannel(paras.get("channelingCode").toString());
		response.getWriter().write(output);
	}
	
	private static Map getParasMap(HttpServletRequest request) 
	{
		Map<String, String> map = new HashMap<String, String>();
	
		try
		 {
			 Scanner scanner = new Scanner(request.getInputStream(),"utf-8");
			 String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next(): "";
			scanner.close();
			
			String[] params = queryString.split("&");
			for(String param : params) 
			{
				
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		 }
		 catch(Exception e) 
		{
		 }
		 return map;
		 }
	}


