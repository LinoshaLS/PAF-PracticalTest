package model;

import model.payment;
import com.paymentService;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Servlet implementation class paymentAPI
 */
@WebServlet("/paymentAPI")
public class paymentAPI extends HttpServlet {
	// private static final long serialVersionUID = 1L;
  
	payment newPay = new payment();
	
	  public paymentAPI() {
	  super();
	  }
	 

	  
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String output = newPay.insertPayment
				(request.getParameter("customerId"),
				// request.getParameter("pamentRef"),
				request.getParameter("paymentAmount"),
				request.getParameter("paymentDesc"));

		response.getWriter().write(output);
		//doGet(request, response);
	}

	

	// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";
	 scanner.close();
	 String[] params = queryString.split("&");
	 for (String param : params)
	 { 
	
	String[] p = param.split("=");
	 map.put(p[0], p[1]);
	 }
	 }
	catch (Exception e)
	 {
	 }
	return map; 
	}
	
	
	
	
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map paras = getParasMap(request); 
		
		
		String output = newPay.updatePayment(
				paras.get("customerId").toString(),
				paras.get("hidenPID").toString(),
				paras.get("paymentAmount").toString(),
				paras.get("paymentDesc").toString()
				);

				
		
		response.getWriter().write(output);
		
		// TODO Auto-generated method stub
	}
	
	
	
	

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Map paras = getParasMap(request);

		String output = newPay.deletepayement(paras.get("pamentRef").toString());
				
				response.getWriter().write(output);
	}

	
	
	
	
	
	
	
}


