<%@ page import="model.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/doctor.js"></script>
<title>Doctor Registration</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Doctor Registration</h1>

				<form id="docForm" name="docForm">
					Name : <input id="docName" name="docName" type="text" class="form-control form-control-sm"> 
					<br> NIC :
					<input id="docNIC" name="docNIC" type="text" class="form-control form-control-sm">
					<br> Specialization : 
					<input id="specialization" name="specialization" type="text" class="form-control form-control-sm">
					<br> Gender : 
					<input id="gender" name="gender" type="text" class="form-control form-control-sm">
					<br> Contact Number :
					<input id="phoneNo" name="phoneNo" type="text" class="form-control form-control-sm"> 
					<br>
					<input id="btnSubmit" name="btnSubmit" type="button" value="Save" class="btn btn-primary"> 
					<input type="hidden" id="hidDoctorIDSave" name="hidDoctorIDSave" value="">
				</form>

				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>

				<br>
				<div id="divDoctorsGrid"> 
					<%
						Doctor docObj = new Doctor();
						out.print(docObj.readDoctors());
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>