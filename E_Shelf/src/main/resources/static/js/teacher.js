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
	/*<![CDATA[*/
	
    var teacher = /*[[${teachers}]]*/ 'teachers';
    var resources = /*[[${resources}]]*/ 'resources';
    var schools = /*[[${schools}]]*/ 'schools';
    var classes = /*[[${classes}]]*/ 'classes';
    

/*]]>*/
	
    for(var i = 0; i < resources.length; i ++){
    	console.log(resources[i].resource_URL)
    }
    
	
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
	
	$('table #teacherDetailsButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(teacherInfo, status){
			$('#id_detials').val(teacherInfo.id_teacher)
			$('#last_name_details').val(teacherInfo.last_name)
			$('#first_name_detailst').val(teacherInfo.first_name)
			$('#title_details').val(teacherInfo.tittle)
			$('#email_details').val(teacherInfo.email)
			$('#school_deails').val(teacherInfo.school_name)
			//document.getElementById("teacher_school").innerHTML = teacherInfo.school_name
			document.getElementById("teacher_class_details").innerHTML = teacherInfo.classes
			document.getElementById("teacher_low_grade_details").innerHTML = teacherInfo.low_grade
			document.getElementById("teacher_high_grade_details").innerHTML = teacherInfo.high_grade
			document.getElementById("teacher_resources_details").innerHTML = teacherInfo.resources
			
		});
		
		
		$('#detailsTeacherModal').modal();
		
		
	});
	
	$('table #teacherDeleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$('#confirmTeacherDeleteButoon').attr('href', href);
		
		$('#teacherDeleteModal').modal();
		
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
	
	$('table #resourceDetailsButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(resourcesInfo, status){
			var imgURL = "<img src=" + resourcesInfo.resource_image_URL + "\ width=\"150px\" height=\"150px\">"; 
			console.log(imgURL)
			$('#id_resource_details').val(resourcesInfo.id_resources)
			$('#resource_name_details').val(resourcesInfo.resource_name)
			document.getElementById("current_image_resource_details").innerHTML =  "Current Image: " +  imgURL;
			$('#resource_URL_details').val(resourcesInfo.resource_URL)
			console.log(resourcesInfo.domain);
			document.getElementById("domain_details").innerHTML = "<input type=\"text\" class=\"form-control\" id=\"resource_URL_details\" name = \"resource_URL\" value =" + resourcesInfo.domain + " readonly>";
			document.getElementById("sso_details").innerHTML = resourcesInfo.sso;
			
		});
		
		$('#detailsResourceModal').modal();
		
		
	});
	
	$('table #resourceDeleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$('#confirmResourceDeleteButoon').attr('href', href);
		
		$('#resourceDeleteModal').modal();
		
	});

	$('table #schoolEditButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(school, status){
			$('#id_school_edit').val(school.id_school)
			$('#school_name_edit').val(school.school_name)			
		});
		
		
		$('#editSchoolModal').modal();
		
	});
	

	$('table #schoolDeleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$('#confirmSchoolDeleteButoon').attr('href', href);
		
		$('#schoolDeleteModal').modal();
		
	});
	
	$('table #schoolDetailsButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		var table = document.getElementById('school_classes_details')
		var table_t = document.getElementById('school_teachers_details')
		table.innerHTML = '';
		table_t.innerHTML = '';
		$.get(href, function(school, status){
			$('#id_school_details').val(school.id_school)
			$('#school_name_details').val(school.school_name)	
			for(var i = 0; i < school.classes.length; i ++){
				var row = `<tr>
				<td>${school.classes[i]}</td>
				</tr>`
				table.innerHTML += row;
			}
			for(var i = 0; i < school.teachers.length; i ++){
				var row = `<tr>
				<td>${school.teachers[i]}</td>
				</tr>`
				table_t.innerHTML += row;
			}
			
			//document.getElementById("school_classes_details").innerHTML = school.classes;
			//document.getElementById("school_teachers_details").innerHTML = school.teachers;
		});
		
		
		$('#detailsSchoolModal').modal();
		
	});
	
	
	$('table #classEditButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(classInfo, status){
			$('#id_class_edit').val(classInfo.id_class)
			$('#class_name_edit').val(classInfo.class_name)
			$('#class_school_edit').val(classInfo.school)
		});
		
		
		$('#editClassModal').modal();
		
		
	});
	
	$('table #classDetailsButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		var table = document.getElementById('class_teachers_details')
		table.innerHTML = '';
		$.get(href, function(classInfo, status){
			$('#id_class_details').val(classInfo.id_class)
			$('#class_name_details').val(classInfo.class_name)
			$('#class_school_details').val(classInfo.school)
			for(var i = 0; i < classInfo.teachers.length; i ++){
				var row = `<tr>
				<td>${classInfo.teachers[i]}</td>
				</tr>`
				table.innerHTML += row;
			}
			//document.getElementById("class_teachers_details").innerHTML = classInfo.teachers;
		});
		
		
		$('#detailsClassModal').modal();
		
		
	});
	
	$('table #classDeleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$('#confirmClassDeleteButoon').attr('href', href);
		
		$('#classDeleteModal').modal();
		
	});
	
	
});




