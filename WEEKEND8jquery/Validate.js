function validate(sstring)
{
    var title;
    var description;
    var person;
    var hours;
    var startdate;
    var enddate;
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;  
    var yyyy = today.getFullYear();
    var today = dd+'-'+mm+'-'+yyyy;
    var i=0;
    var errprint ="err: ";
    if(sstring=="Add")
    {
   title  = $("#mtitle").val();
 description = $("#mdescription").val();
   person = $("#mperson").val();
hours = $("#mhours").val();
     startdate =$("#mstartdate").val();
 enddate = $("#menddate").val();
    
    
    }
    else
    {
         title  = $("#etitle").val();
         description = $("#edescription").val();
         person =$("#eperson").val();
         hours = $("#ehours").val();
         startdate = $("#estartdate").val();
         enddate = $("#eenddate").val();
        }
    

if (title=="")
{
    errprint+="Please enter title of task. \n";
  i++;
      
}

if (description=="")
{
    errprint+="Please enter  description. \n"
  i++;
   
}
if (person=="")
{
    errprint+="Please select  employee. \n";

    i++;
}
if (hours=="")
{
    errprint+="Please enter estimated hours \n";
   i++;
}
else if(hours<=0)
{
    errprint+="Please enter a non zero and non negetive value hours \n";
    i++;
}

if(startdate=="")
{
    errprint+="Please enter startdate \n";
    i++;
}
   
 else if (startdate.split('-')[0]<yyyy)
    {
    errprint+="Please enter valid year in startdate \n";
    
    i++;

}
else if(startdate.split('-')[1]<mm )
{
    errprint+="Please enter valid  month in startdate \n";
    
    i++;
}
else if(startdate.split('-')[2]<dd && startdate.split('-')[1]==mm && startdate.split('-')[0]==yyyy  )
{
    errprint+="Please enter valid day in startdate \n";
    
    i++;
}

if(enddate=="")
{
    errprint+="Please enter enddate \n";
    i++;   
}
else if (enddate.split('-')[0]<yyyy)
{
errprint+="Please enter valid year in enddate \n";

i++;
}
else if(enddate.split('-')[1]<mm )
{
errprint+="Please enter valid month in enddate \n";

i++;
}
else if(enddate.split('-')[2]<dd  && enddate.split('-')[1]==mm && enddate.split('-')[0]==yyyy)
{
errprint+="Please enter valid day in enddate \n";

i++;
}



if(i>0)
{
    alert(errprint);
return false;

}
else{
    return true;
}
}