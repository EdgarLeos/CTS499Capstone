		
		
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

/*<![CDATA[*/

    var teacher = /*[[${teachers}]]*/ 'teachers';
    var resources = /*[[${resources}]]*/ 'resources';
    var schools = /*[[${schools}]]*/ 'schools';
    var classes = /*[[${classes}]]*/ 'classes';
    

/*]]>*/
$('#txtSearch').on('keyup', function(){
	var value =$(this).val();
	var data = FilterFunction(value, teacher);
	
	rebuildTable(data);
	
	
})
function FilterFunction(value, data){
	var filteredData = [];
	console.log(data.length);
	for (var i = 0; i < data.length; i++){
		console.log(i);
		value = value.toLowerCase();
		var fname = data[i].first_name.toLowerCase();
		var lname = data[i].last_name.toLowerCase();
		
		if(fname.includes(value)||lname.includes(value)){
			filteredData.push(data[i])
		}
	}
	return filteredData;
}
function rebuildTable(data){
	var table = document.getElementById('teacher_info')
	table.innerHTML = ''
	for(var i= 0; i < data.length; i++){
		var row = `<tr>
		<td> ${data[i].id_teacher}</td>
		<td> ${data[i].last_name}</td>
		<td> ${data[i].first_name}</td>
		<td> ${data[i].email}</td>
		<td> ${data[i].school_name}</td>
	</tr>`
	table.innerHTML += row
	} 
}


$('#txtSearchResources').on('keyup', function(){
	var value =$(this).val();
	var data = FilterFunctionR(value, resources);
	
	rebuildTableR(data);
	
	
})
function FilterFunctionR(value, data){
	var filteredData = [];
	console.log(data.length);
	for (var i = 0; i < data.length; i++){
		console.log(i);
		value = value.toLowerCase();
		var rname = data[i].resource_name.toLowerCase();
		
		if(rname.includes(value)){
			filteredData.push(data[i])
		}
	}
	return filteredData;
}

function rebuildTableR(data){
	var table = document.getElementById('resource_info')
	table.innerHTML = ''
	for(var i= 0; i < data.length; i++){
		var row = `<tr>
		<td> ${data[i].resource_name}</td>
		<td><a href = ${data[i].resource_URL} target ="_blank">${data[i].resource_URL}</a></td>
		<td><img src=${data[i].resource_image_URL} style="width:200px;height:200px;"></td>
	</tr>`
	table.innerHTML += row
	} 
}

$('#txtSearchSchools').on('keyup', function(){
	var value =$(this).val();
	var data = FilterFunctionS(value, schools);
	
	rebuildTableS(data);
	
	
})
function FilterFunctionS(value, data){
	var filteredData = [];
	console.log(data.length);
	for (var i = 0; i < data.length; i++){
		console.log(i);
		value = value.toLowerCase();
		var rname = data[i].school_name.toLowerCase();
		
		if(rname.includes(value)){
			filteredData.push(data[i])
		}
	}
	return filteredData;
}

function rebuildTableS(data){
	var table = document.getElementById('schools_info')
	table.innerHTML = ''
	for(var i= 0; i < data.length; i++){
		var row = `<tr>
		<td> ${data[i].school_name}</td>
	</tr>`
	table.innerHTML += row
	} 
}


$('#txtSearchClasses').on('keyup', function(){
	var value =$(this).val();
	var data = FilterFunctionC(value, classes);
	
	rebuildTableC(data);
	
	
})
function FilterFunctionC(value, data){
	var filteredData = [];
 	for (var i = 0; i < data.length; i++){
		value = value.toLowerCase();
		var cname = data[i].class_name.toLowerCase();
		
		if(cname.includes(value)){
			filteredData.push(data[i])
		}
	} 
/* 	for (var i = 0; i < otherData.length; i++){
		value = value.toLowerCase();
		var rname = otherData[i].school_name.toLowerCase();
		
		if(rname.includes(value)){
			filteredData.push(data[i])
		}
	} */
	return filteredData;
}

function rebuildTableC(data){
	var table = document.getElementById('classes_info')
	table.innerHTML = ''
	for(var i= 0; i < data.length; i++){
		var row = `<tr>
		<td> ${data[i].class_name}</td>
		<td> ${data[i].school}</td>
	</tr>`
	table.innerHTML += row
	} 
}
		/**
 * 
 */