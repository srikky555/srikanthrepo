

        function appendtotable(Task) {
            $("#myTable").append("<tr><td>" + Task.Title + "</td><td>" +Task.Description + "</td><td>" + Task.Assignee + "</td><td>" + Task.EstimatedHrs + "</td><td>" + Task.StartDate + "</td><td>" + Task.EndDate + "</td><td><input type='radio' name='task'></td></tr>");
                    }

        
        function onLoading() {
            $("#myTable").append("<tr><th>Title</th><th>Description</th><th>Assignee</th><th>EstimatedHours</th><th>STartDate</th><th>EndDate</th><th>Select</th></tr>");
            $("#myTable").css({"border": "0.65"});
            var x = getDefault();
             var obj = JSON.parse(x);
            for (i = 0; i < obj.TaskArray.length; i++) {

                glbTaskList.push(obj.TaskArray[i]);

                appendtotable(obj.TaskArray[i]);

            }
        }
        function getDefault() {
                        var testArray = '{"TaskArray":[  {  "Title":"Mainpage", "Description":"main page creation" ,"Assignee":"indu","EstimatedHrs":9, "StartDate":"2011-05-31" ,"EndDate":"2011-05-31"} ,    {  "Title":"Subpage", "Description":"sub page details" ,"Assignee":"Ananth","EstimatedHrs":8, "StartDate":"2011-05-31" ,"EndDate":"2011-05-31" }, {  "Title":"Styling", "Description":"css" ,"Assignee":"sailaja","EstimatedHrs":7, "StartDate":"2011-05-31" ,"EndDate":"2011-05-31" } ]  }';
                        return testArray;
                            }