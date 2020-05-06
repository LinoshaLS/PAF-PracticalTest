/**
 * 
 
 */

$(document).ready(function()
		{
	
	
	
	if($("#alertSuccess").text().trim() =="")
		{
		
			$("#alertSuccess").hide();
		}
	$("#alertError").hide();
	
		});








////////////////////////save button


$(document).on("click", "#paymentSubmit", function(event)
{
	//clear alerts
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide("");

//Form validation
	var status = validatePayForm();
	if(status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}else{
	///id form is valid
	var type = ($("#hidenPID").val() == "") ? "POST" : "PUT";

	$.ajax(
			{
			 url : "paymentAPI",
			 type : type,
			 data : $("#paymentForm").serialize(),
			 dataType : "text",
			 complete : function(response, status)
			 {
			 onPayementSaveComplete(response.responseText, status);
			 }
			});

}});
	





function onPayementSaveComplete(response,status)
{
	if (status == "success")
	 {
	 var resultSet = JSON.parse(response);
	 if (resultSet.status.trim() == "success")
	 {
		 $("#alertSuccess").text("Successfully saved.");
		 $("#alertSuccess").show();
	
		 
		 $("#divItemsGrid").html(resultSet.data);
		 
	 } else if (resultSet.status.trim() == "error")
	 {
	 $("#alertError").text(resultSet.data);
	 $("#alertError").show();
	 }
	 } else if (status == "error")
	 {
	 $("#alertError").text("Error while saving.");
	 $("#alertError").show();
	 } else
	 {
	 $("#alertError").text("Unknown error while saving..");
	 $("#alertError").show();
	 }
	 $("#hidenPID").val("");
	 $("#paymentForm")[0].reset();
	
	
}





////////update

$(document).on("click",".btnUpdate",function(event)
		{
	
	$("#hidenPID").val($(this).closets("tr").find('#hidenpaymentUpdate').val());
	$("#customerId").val($(this).closets("tr").find('td:eq(0)').text());
	$("#paymentAmount").val($(this).closets("tr").find('td:eq(1)').text());
	$("#paymentDesc").val($(this).closets("tr").find('td:eq(2)').text());
		});




////////////cleint model
function validatePayForm()
{	
	////customer id
	if($("#customerId").val().trim() == "")
		{
			return "Insert customer ID.";
		}
	
////price
	if($("#paymentAmount").val().trim() == "")
		{
			return "Insert payment amount.";
		}
	
	
	//is numerical value
	
	var tmpPrice = $("#paymentAmount").val().trim();
	if(!$.isNumeric(tmpPrice))
		{
			return "Insert a numerical value for payment"
		}
	
	////////convert to decimal price
	
	$("#paymentAmount").val(parseFloat(tmpPrice).toFixed(2));
	
	//////description
	if($("#paymentDesc").val().trim() == "")
		{
		
			return "Insert payment description"
		}
	
	return true;
}



///////remove
$(document).on("click", ".btnRemove", function(event)
		{
		 $.ajax(
		 {
			 url : "paymentAPI",
			 type : "DELETE",
			 data : "pamentRef=" + $(this).data("pamentref"),
			 dataType : "text",
			 complete : function(response, status)
		 {
				 onpayDeleteComplete(response.responseText, status);
		 }
		 });
	});



function onpayDeleteComplete(response, status)
{
if (status == "success")
 {
	var resultSet = JSON.parse(response);
	if (resultSet.status.trim() == "success")
	{
		$("#alertSuccess").text("Successfully deleted.");
		$("#alertSuccess").show();
		$("#divItemsGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
	 $("#alertError").text(resultSet.data);
	 $("#alertError").show();
 }
 } else if (status == "error")
 {
	 $("#alertError").text("Error while deleting.");
	 $("#alertError").show();
 } else
 {
	 $("#alertError").text("Unknown error while deleting..");
	 $("#alertError").show();
 }
}



