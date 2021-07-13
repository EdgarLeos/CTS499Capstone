	function showDiv(div_name, button_to_hide, button_to_show){
		document.getElementById(div_name).style.display = "block";
		document.getElementById(div_name).style.visibility = "visible";
		document.getElementById(button_to_hide).style.display="none";
		document.getElementById(button_to_show).style.display="block";
	}
	function hideDiv(div_name, button_to_show, button_to_hide){
		document.getElementById(div_name).style.display = "none";
		document.getElementById(div_name).style.visibility = "hidden";
		document.getElementById(button_to_show).style.display="block";
		document.getElementById( button_to_hide).style.display="none";
	}


$('document').ready(function(){
	
	$('table #teacherEditButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(teacherInfo, status){
			$('#id-edit').val(teacherInfo.id_teacher)
			$('#last-name-edit').val(teacherInfo.last_name)
			$('#first-name-edit').val(teacherInfo.first_name)
			$('#title-edit').val(teacherInfo.tittle)
			$('#email-edit').val(teacherInfo.email)
			document.getElementById("teacher_school").innerHTML = teacherInfo.school_name
			document.getElementById("teacher_class").innerHTML = teacherInfo.classes
			document.getElementById("teacher_low_grade").innerHTML = teacherInfo.low_grade
			document.getElementById("teacher_high_grade").innerHTML = teacherInfo.high_grade
			document.getElementById("teacher_resources").innerHTML = teacherInfo.resources
			
		});
		
		
		$('#editTeacherModal').modal();
		
		
	});
	
	$('table #resourceEditButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(resourcesInfo, status){
			var imgURL = "<img src=" + resourcesInfo.resource_image_URL + "\ width=\"150px\" height=\"150px\">"; 
			console.log(imgURL)
			$('#id-edit-resource').val(resourcesInfo.id_resources)
			$('#resource_name-edit').val(resourcesInfo.resource_name)
			document.getElementById("current_image_resource").innerHTML =  "Current Image: " +  imgURL;
			$('#resource_URL-edit').val(resourcesInfo.resource_URL)
			
		});
		
		
		$('#editResourceModal').modal();
		
		
	});
	


	
	
	
});




