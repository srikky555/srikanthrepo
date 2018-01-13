
$(function () {
    $("#displayButton").click(function(){
            alert(JSON.stringify(glbTaskList));
        });
    });
        
function addtoTable() {
    var isValid = validate("Add");
    if(isValid)
    {
    var Taskstr = JSON.stringify({ Title: $("#mtitle").val(), Description: $("#mdescription").val(), Assignee: $("#mperson").val(), EstimatedHrs: $("#mhours").val(), StartDate: $("#mstartdate").val(),EndDate: $("#menddate").val() });
    var Task = JSON.parse(Taskstr);
    glbTaskList.push(Task);   
    appendtotable(Task);
    $("#mtitle").val("");
    $("#mdescription").val("");
    $("#mperson").val("");
    $("#mhours").val("");
    $("#mstartdate").val("");
    $("#menddate").val("");
    $("#addform").toggle();
    }
   }


   $(function () {$("#addbutton").click(function () {
    $("#addform").toggle();
});
});
$(function () {$("#editbutton").click(function () {
   if(populateEditForm())
   {
    $("#editform").toggle();
   }
   else 
   {
       alert("please select the row to be edited ");
   }
});
});


function populateEditForm() {

    var row = getSelectedRow();
    var selectedrow = row.Row;
    if(!(typeof selectedrow=="undefined"))
    {
        $("#etitle").val(selectedrow.childNodes[0].firstChild.nodeValue);   
        $("#edescription").val(selectedrow.childNodes[1].firstChild.nodeValue);
        $("#eperson").val(selectedrow.childNodes[2].firstChild.nodeValue);   
        $("#ehours").val(selectedrow.childNodes[3].firstChild.nodeValue);
        $("#estartdate").val(selectedrow.childNodes[4].firstChild.nodeValue);   
        $("#eenddate").val(selectedrow.childNodes[5].firstChild.nodeValue);
    return true;
    }
    else{
        return false;
    }


}
function getEditedDetails() {
var isvalid= validate("edit");
    if(isvalid)
    {
    var row = getSelectedRow();
    var selectedrow = row.Row;
  
    var selectedrowindex = row.Index;  

    var Taskstr = JSON.stringify({ Title: document.getElementById("etitle").value, Description: document.getElementById("edescription").value, Assignee: document.getElementById("eperson").value, EstimatedHrs: document.getElementById("ehours").value, StartDate: document.getElementById("estartdate").value });
    var Task = JSON.parse(Taskstr);
    selectedrow.childNodes[0].firstChild.nodeValue = $("#etitle").val();
    selectedrow.childNodes[1].firstChild.nodeValue = $("#edescription").val();
    selectedrow.childNodes[2].firstChild.nodeValue = $("#eperson").val();
    selectedrow.childNodes[3].firstChild.nodeValue =  $("#ehours").val();
    selectedrow.childNodes[4].firstChild.nodeValue =  $("#estartdate").val();
    selectedrow.childNodes[5].firstChild.nodeValue =  $("#eenddate").val();
    glbTaskList[selectedrowindex] = Task;
    editFormControl();
    }
    }
  


function getSelectedRow() {
    var row;
    var index;
    var radio =$("[name='task']");

    for (i = 0; i < radio.length; i++) {
        if (radio[i].checked) {

            row = radio[i].parentElement.parentElement;

            index = i;


        }

    }
    var Rows = { "Index": index, "Row": row };
    return Rows;

}
$(function () {$("#removetheRow").click(function(){

   
    var row = getSelectedRow();
    var selectedrow=row.Row;
    var selectedrowindex=row.Index;
    if (typeof selectedrow !== "undefined") {
        var result = confirm("Do you want to delete really? ");
        if (result) {    
   selectedrow.parentNode.removeChild(selectedrow);
  
   glbTaskList.splice(selectedrowindex, 1);
        }
    }
    else
    {
        alert("please select the row to be Remove");
    }


});
});
