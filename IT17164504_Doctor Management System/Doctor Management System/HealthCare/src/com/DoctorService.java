package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Doctor;

@Path("/Doctor")
public class DoctorService {

	Doctor docObj = new Doctor();
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readDoctors() {
		
		return docObj.readDoctors();
		
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertDoctor(@FormParam("docName") String docName,
			@FormParam("docNIC") String docNIC,
			@FormParam("specialization") String specialization,
			@FormParam("gender") String gender,
			@FormParam("phoneNo") String phoneNo) {
		
		String output = docObj.insertDoctor(docName, docNIC, specialization, gender, phoneNo);
		return output;
		
	}
	
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateDoctor(String docData) {
		
		//Convert input string to a JSON object
		JsonObject docObject = new JsonParser().parse(docData).getAsJsonObject();
		
		//Read the values from the JSON object
		String docId = docObject.get("docId").getAsString();
		String docName = docObject.get("docName").getAsString();
		String docNIC = docObject.get("docNIC").getAsString();
		String specialization = docObject.get("specialization").getAsString();
		String gender = docObject.get("gender").getAsString();
		String phoneNo = docObject.get("phoneNo").getAsString();
		
		String output = docObj.updateDoctor(docId, docName, docNIC, specialization, gender, phoneNo);
		return output;
	}
	
	
	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteDoctor(String docData) {
		
		//Convert the input String to an XML document
		Document doc = Jsoup.parse(docData, "", Parser.xmlParser());
		
		//Read the value from the element<docId>
		String docId = doc.select("docId").text();
		String output = docObj.deleteDoctor(docId);
		
		return output;
		
	}

}
