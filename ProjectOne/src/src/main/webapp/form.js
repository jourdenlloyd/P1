function getForms() {
    
    let xhr = new XMLHttpRequest(); // calling get from the servlet
    
    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4 && xhr.status === 200)// checks that the response is ready and done
            {
            let form = JSON.parse(xhr.responseText);
            console.log(form);
            pending(form);
            }
    }
    xhr.open("GET","viewallforms",true); // open xhr (true = asynchronous)
    xhr.send();
 
    // Here we are creating a quick reference variable for the body of the DOM
    var body = document.getElementById("newform"),
    // Create the table
    tbl  = document.createElement('table');
// Create 13 table headers (columns)
for(var i = 0; i < 2; i++) {
    var th =tbl.insertRow();
    switch(i) {
        case 0:
             th.innerHTML = 'rbid';
        case 1:
            th.innerHTML = 'firstname';
        case 2:
            th.innerHTML = 'lastname';


    }
}


    // For X number of form entries create a row
for(var i = 0; i < 5; i++){
    var tr = tbl.insertRow();
    tr.innerHTML = 'dummydata';
    }

body.appendChild(tbl);
}

//EVERYTHING COMMENTED OUT BELOW DID NOT WORK, I TRIED EVERYTHING I COULD FIND AND GOT HELP FROM MULTIPLE PEOPLE


//function pending(form){
	
   // const tableBody = document.getElementById("newform");
    //tableBody.innerHTML="";
       // console.log(form);
    //for(i = 0 ; i < form.length; i++){
    	
       /* tableBody.innerHTML+= `
        <tr>
        <td>${form[i].rbid}</td>
        <td>${form[i].firstname}</td>
        <td>${form[i].lastname}</td>
        <td>${form[i].username}</td>
        <td>${form[i].eventType}</td>
        <td>${form[i].eventDate}</td>
        <td>${form[i].eventTime}</td>
        <td>${form[i].eventAddress}</td>
        <td>${form[i].eventDescription}</td>
        <td>${form[i].gradingFormat}</td>
        <td>${form[i].passingGrade}</td>
        <td>${form[i].workjustification}</td>
        <td>${form[i].eventCost}</td>    
        </tr>
        `;*/
        
        /*let tr = table.insertRow();
        let cell = tr.insertCell().innerText = obj[i].rbid;
        let cell2 = tr.insertCell().innerText = obj[i].firstname;
        let cell3 = tr.insertCell().innerText = obj[i].lastname;
        let cell4 = tr.insertCell().innerText = obj[i].username;
        let cell5 = tr.insertCell().innerText = obj[i].eventType;
        let cell6 = tr.insertCell().innerText = obj[i].eventDate;
        let cell7 = tr.insertCell().innerText = obj[i].eventTime;
        let cell8 = tr.insertCell().innerText = obj[i].eventAddress;
        let cell9 = tr.insertCell().innerText = obj[i].eventDescription;
        let cell10 = tr.insertCell().innerText = obj[i].gradingFormat;
        let cell11 = tr.insertCell().innerText = obj[i].passingGrade;
        let cell12 = tr.insertCell().innerText = obj[i].workjustification;
        let cell13 = tr.insertCell().innerText = obj[i].eventCost;*/
 
    


// window on load spot
window.onload = function() {
	getForms();
	
	}
