package com;

import model.payment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;


/////////////////////////////////read data


@Path("/Payment")////////map to a resource
public class paymentService {

	payment newPayment = new payment();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readPayment() {
		return newPayment.readPayment();
	}
	
	
	
	
	
//////////////////////// insert data
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)

	public String insertPayment(@FormParam("customerId") String customerId, @FormParam("pamentRef") String pamentRef,
			@FormParam("paymentAmount") String paymentAmount, @FormParam("paymentDesc") String paymentDesc) {
		String output = newPayment.insertPayment(customerId, paymentAmount, paymentDesc);

		return output;

	}
	///////////////////////////////////////////Update data
	  @PUT
	  @Path("/")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.TEXT_PLAIN) 
	  public String updatePayment(String payData) {
		  //Convert the input string to a JSON object JsonObject
	  
		  JsonObject payobject = new JsonParser().parse(payData).getAsJsonObject();

	  String customerId = payobject.get("customerId").getAsString(); // String
	  String pamentRef = payobject.get("pamentRef").getAsString(); // String
	  String paymentAmount = payobject.get("paymentAmount").getAsString(); //String
	  String paymentDesc = payobject.get("paymentDesc").getAsString();
	  
	  String output = newPayment.updatePayment(customerId, pamentRef,paymentAmount, paymentDesc);
	  
	  return output;
	 
	  
	  }
	 
///////////////delete data
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)

	public String deletepayement(String payementData) {
		Document doc = Jsoup.parse(payementData, "", Parser.xmlParser());

		String pamentRef = doc.select("pamentRef").text();

		String output = newPayment.deletepayement(pamentRef);
		return output;

	}

}
