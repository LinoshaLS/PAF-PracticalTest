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
	var status = validationDoctorForm();
	if(status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	else{
	//if valid
	var type = ($("#hidDoctorIDSave").val() == "") ? "POST" : "PUT";
	$.ajax(
	{
		url : "DoctorsAPI",
		type : type,
		data : $("#docForm").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onDoctorSaveComplete(response.responseText, status);
		}
	});
	}
});

function onDoctorSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show(); 
			
			$("#divDoctorsGrid").html(resultSet.data);
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

		$("#hidDoctorIDSave").val("");
		$("#docForm")[0].reset();
}

//UPDATE
$(document).on("click", ".btnUpdate", function(event)
{
	$("#hidDoctorIDSave").val($(this).closest("tr").find('#hidDoctorIDUpdate').val());
	$("#docName").val($(this).closest("tr").find('td:eq(0)').text());
	$("#docNIC").val($(this).closest("tr").find('td:eq(1)').text());
	$("#specialization").val($(this).closest("tr").find('td:eq(2)').text());
	$("#gender").val($(this).closest("tr").find('td:eq(3)').text());
	$("#phoneNo").val($(this).closest("tr").find('td:eq(4)').text());
});

//Delete
$(document).on("click", ".btnRemove", function(event)
{
	$.ajax(
	{
		url : "DoctorsAPI",
		type : "DELETE",
		data : "docId=" + $(this).data("docid"),
		dataType : "text",
		complete : function(response, status)
		{
			onDoctorDeleteComplete(response.responseText, status);
		}
	});
});

function onDoctorDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response); 
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show(); 
			
			$("#divDoctorsGrid").html(resultSet.data);
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

//CLIENT MODEL
function validationDoctorForm() {
	
	//Name
	if ($("#docName").val().trim() == "")
	{
		return "Insert your Name.";
	} 
	//NIC
	if ($("#docNIC").val().trim() == "")
	{
		return "Insert National Identity Card Number(NIC).";  
	}
	//Specialization
	if ($("#specialization").val().trim() == "")
	{
		return "Insert your Specialization.";  
	}
	//Gender
	if ($("#gender").val().trim() == "")
	{
		return "Insert your Gender.";  
	}
	//Specialization
	if ($("#phoneNo").val().trim() == "")
	{
		return "Insert your Phone Number.";  
	}
	
	return true;
}

 








