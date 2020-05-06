<%@ page import="com.Channeling" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Channeling.js"></script>
<title>Doctor Registration</title>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6">
				<h1>Channeling Managemnet</h1>

				<form id="channelingform" name="channelingform" method="post" action="Channeling.jsp">
				
					Patient Name :
					<input id="patientName" name="patientName" type="text" class="form-control form-control-sm"> 
					
					<br> Doctor Name:
					 <input id="doctorName" name="doctorName" type="text" class="form-control form-control-sm">
					
					<br> Hospital Name: 
					<input id="hospitalName" name="hospitalName" type="text" class="form-control form-control-sm">
					
					<br> Specialization : 
					<input id="specialization" name="specialization" type="text" class="form-control form-control-sm">
					
					<br> Date :
					<input id="date" name="date" type="date" class="form-control form-control-sm"> 
					
					<br>
					<input id="btnSubmit" name="btnSubmit" type="button" value="Save" class="btn btn-primary"> 
					<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
				</form>

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

				<br>
				<div id="divItemsGrid">
				<%
					Channeling channelObj = new Channeling();
				    out.print(channelObj.readChannel());
				%>
			</div>
		</div>
	</div>
</div>
</body>
</html>