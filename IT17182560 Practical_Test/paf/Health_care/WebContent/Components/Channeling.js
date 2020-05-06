$(document).ready(function()
{
	if($("#alertSuccess").text().trim() == "")
		{
			$("#alertSuccess").hide();
		}
		$("#alertError").hide();
});

//Save
$(document).on("click", "#btnSubmit", function(event)
{
	//Clear alerts
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text();
	$("#alertError").hide();
	
	//Form validation
	var status = validationChannelingForm();
	
	if(status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	else{
	//if valid
	 var type =($("#hidItemIDSave").val() == "") ? "POST" : "PUT";
	 
	 $.ajax(
			 {
		 url: "ChannelingAPI",
		 type: type,
		 data: $("#channelingform").serialize(),
		 dataType: "text",
		 complete: function(response,status)
		 {
			 onItemSaveComplete(response.responseText,status);
		 }
			 
	 });
}
});

function onItemSaveComplete(response,status){

	if(status=="success"){
		
	var resultSet= JSON.parse(response);
	
	if(resultSet.status.trim()=="succcess")
	{
		 $("#alertSuccess").text("Successfully saved.");
		 $("#alertSuccess").show();
		 
		 $("#divItemsGrid").html(resultSet.data);
		 }
	else if (resultSet.status.trim()== "error"){
		
		$("#alertError").text(resultSet.data);
		 $("#alertError").show();
		}
	}
	else if (status == "error")
	{
		
		 $("#alertError").text("Error while saving.");
		 $("#alertError").show();
		
	}else 
	{
		 $("#alertError").text("Unknown error while saving..");
		 $("#alertError").show();
	}
	
	   $("#hidItemIDSave").val("");
	   $("#channelingform")[0].reset();
	}
	
//REMOVE
$(document).on("click", ".btnRemove", function(event)
{
	 $.ajax({
		 url: "ChannelingAPI",
		 type: "DELETE",
		 data: "channelingCode=" + $(this).data("itemid"),
		 dataType: "text",
		 complete: function(response,status)
		 {
			 onItemDeleteComplete(response.responseText,status);
		 }
	 });
});

function onItemDeleteComplete(response,status){

	if(status=="success"){
		
	var resultSet= JSON.parse(response);
	
	if(resultSet.status.trim()=="succcess")
	{
		 $("#alertSuccess").text("Successfully deleted.");
		 $("#alertSuccess").show();
		 
		 $("#divItemsGrid").html(resultSet.data);
		 }
	else if (resultSet.status.trim()== "error"){
		
		$("#alertError").text(resultSet.data);
		 $("#alertError").show();
		}
	}else if (status == "error")
	{
		
		 $("#alertError").text("Error while deleting.");
		 $("#alertError").show();
		
	}else {
		 $("#alertError").text("Unknown error while deleting..");
		 $("#alertError").show();
	}
}

//CLIENT MODEL
function validationChannelingForm() {
	
	//Patient Name
	if ($("#patientName").val().trim() == "")
	{
		return "Insert your patient name.";
	} 
	//Doctor Name
	if ($("#doctorName").val().trim() == "")
	{
		return "Insert doctor name.";  
	}
	//hospital Name
	if ($("#hospitalname").val().trim() == "")
	{
		return "Insert your hospital name.";  
	}
	//Specialization
	if ($("#specialization").val().trim() == "")
	{
		return "Insert your specialization.";  
	}
	//Date
	if ($("#date").val().trim() == "")
	{
		return "Insert your date.";  
	}
	
	return true;
}

 








