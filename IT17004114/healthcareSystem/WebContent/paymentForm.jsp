




<%@page import="model.payment"%>




<%-- <%


////delete
if (request.getParameter("pamentRef") != null)
{
	payment p2 = new payment();
String stsMsg = p2.deletepayement(request.getParameter("pamentRef"));
session.setAttribute("statusMsg", stsMsg);
}
%>
<%
//save
if (request.getParameter("customerId") != null)
{
	
	
	payment p1 = new payment();
	///p1.connect();
	String stsMsg1 = "";
//////////////insert

if(request.getParameter("hidenPID") == ""){
	 stsMsg1 = p1.insertPayment(request.getParameter("customerId"),
			//request.getParameter("pamentRef"),
			 request.getParameter("paymentAmount"),
			 request.getParameter("paymentDesc")
			 );
}
else{//update
	
	stsMsg1 = p1.updatePayment(
			request.getParameter("customerId"),
			request.getParameter("hidenPID"),
			request.getParameter("paymentAmount"),
			request.getParameter("paymentDesc")	
			);
}
 session.setAttribute("statusMsg", stsMsg1); 
	 
	 
// session.setAttribute("customerId", request.getParameter("customerId"));
 //session.setAttribute("pamentRef", request.getParameter("pamentRef"));
 //session.setAttribute("paymentAmount", request.getParameter("paymentAmount"));
 //session.setAttribute("paymentDesc", request.getParameter("paymentDesc"));

}
%> --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


<script src="Components/paymentsJ.js"></script>
<script src="views/js/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="views/bootstrap.min.css">


<meta charset="ISO-8859-1">
<title>Payment</title>


</head>
<body>





<div class="d-flex justify-content-center">
<h3>Payment Details</h3>
</div>
<div class="row">
  <div class="col-sm-3"></div><div class="col-sm-8">
<form method="post" action="paymentForm.jsp" class="form-horizontal" id="paymentForm" name="paymentForm">
<div class="form-group">
<div class="col-sm-8">
<b>Customer ID</b><input id="customerId" name="customerId" placeholder=" C001" type="text" class="form-control"><br>
</div>
<!-- <div class="form-group">
<div class="col-sm-8">
<b>Payment Ref. No</b> <input id="pamentRef" name="pamentRef" placeholder=" 001" type="text" class="form-control"><br>
</div> -->
<div class="form-group">
<div class="col-sm-8">
<b>Payment(Rs.)</b><input id="paymentAmount" name="paymentAmount" placeholder=" 00.00" type="text" class="form-control"><br>
</div>
<div class="form-group">
<div class="col-sm-8">
<b>Description</b><textarea id="paymentDesc" name="paymentDesc"  placeholder="Description" class="form-control"></textarea><br>
</div>

<div class="form-group">
<div class="col-sm-8">
<input id="paymentSubmit" name="paymentSubmit" type="button" value="save"  class="btn btn-primary btn-lg">

<input id="paymentSubmit" name="paymentSubmit" type="RESET" value="cancel"  class="btn btn-primary btn-lg">
<input type="hidden" id="hidenPID" name="hidenPID" value="">
</div>
</div>
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger col-md-8 col-md-offset-50 " >

</div>

<%-- 

<%
		out.print(session.getAttribute("statusMsg"));
%>

</div>


 --%>

<br>
<%-- <table border="1">


<tr>
	<th>Customer ID</th>
	<th>Payment Ref. No</th>
	<th>Payment(Rs.)</th>
	<th>Description</th>
	<th>Update</th>
	<th>remove</th>	
</tr>
<tr>

	
 <td><%out.print(session.getAttribute("customerId")); %></td>
 <td><%out.print(session.getAttribute("pamentRef")); %></td>
 <td><%out.print(session.getAttribute("paymentAmount")); %></td>
 <td><%out.print(session.getAttribute("paymentDesc")); %></td>


	
 <td><input name="paymentBtnUpdate" type="button" value="update"></td>
 <td><input name="paymentBtnRemove" type="button" value="remove"></td>

</tr>
</table> --%>
<div class="container">
<table class="table">
<div id="divItemsGrid">
<%


payment itemObj = new payment();
 out.print(itemObj.readPayment());
%>

</div>

</table></div>

<%-- <% out.print(session.getAttribute("statusMsg")); %> --%>
</body>
</html>




<!-- if (request.getParameter("customerId") != null)
{
	
	
	payment p1 = new payment();
	///p1.connect();
	
	String stsMsg1 = p1.insertPayment(request.getParameter("customerId"),
			//request.getParameter("pamentRef"),
			 request.getParameter("paymentAmount"),
			 request.getParameter("paymentDesc")
			 ); -->