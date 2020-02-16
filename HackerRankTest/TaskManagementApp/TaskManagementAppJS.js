// Add your javascript here. Plagiarism is NOT tolerated!
//Event handling, uder interaction is what starts the code execution.

var taskInput=document.getElementById("new-task");//Add a new task.
var addButton=document.getElementsByTagName("button")[0];//first button
var incompleteTaskHolder=document.getElementById("incomplete-tasks");//ul of #incomplete-tasks
var completedTasksHolder=document.getElementById("completed-tasks");//completed-tasks
var selectElement = document.getElementsByClassName("prioritySelect");//first priority level
var deadLineInput=document.getElementById("deadLineId");//Add a new deadLine.

//New task list item
var createNewTaskElement=function(taskString, selectElementValue, deadLineValue){

    var listItem=document.createElement("li");

    //input (checkbox)
    var checkBox=document.createElement("input");//checkbx
    //label
    var label=document.createElement("label");//label
     label.setAttribute("class", "label");

    //input (text)
    var editInput=document.createElement("input");//text
     label.setAttribute("class", "editInput");

    //select Priority
    let optionElementLow,textNodeElementLow,
        optionElementMedium,textNodeElementMedium,
        optionElementHigh,textNodeElementHigh;
    
      this.selectElement = document.createElement("SELECT");
      this.selectElement.setAttribute("class", "prioritySelect");
      document.body.appendChild(this.selectElement);
    
      optionElementLow = document.createElement("option");
      optionElementLow.setAttribute("value", "Low");  
      textNodeElementLow = document.createTextNode("Low");
      optionElementLow.appendChild(textNodeElementLow); 
    
      optionElementMedium = document.createElement("option");
      optionElementMedium.setAttribute("value", "Medium"); 
      textNodeElementMedium = document.createTextNode("Medium");
      optionElementMedium.appendChild(textNodeElementMedium);
    
      optionElementHigh = document.createElement("option");
      optionElementHigh.setAttribute("value", "High");          
      textNodeElementHigh = document.createTextNode("High");
      optionElementHigh.appendChild(textNodeElementHigh);
    
      this.selectElement.appendChild(optionElementLow);
      this.selectElement.appendChild(optionElementMedium);
      this.selectElement.appendChild(optionElementHigh);
    
    var labelDL=document.createElement("label");//label
     labelDL.setAttribute("class", "labelDL");

    //DeadLine
    var dlInput=document.createElement("input");//text
     dlInput.setAttribute("class", "dlInput");

    //button.edit
    var editButton=document.createElement("button");//edit button

    //button.delete
    var deleteButton=document.createElement("button");//delete button

    label.innerText=taskString;
    this.selectElement.value=selectElementValue;
    labelDL.innerText=deadLineValue;

    //Each elements, needs appending
    checkBox.type="checkbox";
    editInput.type="text";
    dlInput.type="text";
    editButton.innerText="Edit";//innerText encodes special characters, HTML does not.
    editButton.className="edit";
    deleteButton.innerText="Delete";
    deleteButton.className="delete";
    
    //label.setAttribute("style","width:239px");

    //and appending.
    listItem.appendChild(checkBox);
    listItem.appendChild(label);
    listItem.appendChild(editInput);
    listItem.appendChild(this.selectElement);
    listItem.appendChild(labelDL);
    listItem.appendChild(dlInput);
    listItem.appendChild(editButton);
    listItem.appendChild(deleteButton);
    return listItem;
}

var addTask=function(){
    console.log("Add Task..."+deadLineInput.value);
    //Create a new list item with the text from the #new-task:
    let listItem;
    if(taskInput.value.trim()!=''){
        let selectElementValues = (document.querySelector(".prioritySelect")).options[(document.querySelector(".prioritySelect")).selectedIndex].value;
        listItem=createNewTaskElement(taskInput.value,selectElementValues, deadLineInput.value);
        incompleteTaskHolder.appendChild(listItem);
        bindTaskEvents(listItem, taskCompleted);
    }
}

//Edit an existing task.

var editTask=function(){
console.log("Edit Task...");
console.log("Change 'edit' to 'save'");

var listItem=this.parentNode;

var editInput=listItem.querySelector('input[type=text]');
var label=listItem.querySelector("label");
var dlInput=listItem.querySelector('.dlInput');
var labelDL=listItem.querySelector(".labelDL");
var containsClass=listItem.classList.contains("editMode");
    //If class of the parent is .editmode
    if(containsClass){
        listItem.querySelector("button.edit").innerText="Edit";
        //switch to .editmode
        //label becomes the inputs value.
        label.innerText=editInput.value;
        labelDL.innerText=dlInput.value;
    }else{
        listItem.querySelector("button.edit").innerText="Save";
        editInput.value=label.innerText;
        dlInput.value=labelDL.innerText;

    }

    //toggle .editmode on the parent.
    listItem.classList.toggle("editMode");
}

//Delete task.
var deleteTask=function(){
    console.log("Delete Task...");
    let listItem=this.parentNode;
    let ul=listItem.parentNode;
    //Remove the parent list item from the ul.
    ul.removeChild(listItem);
}


//Mark task completed
var taskCompleted=function(){
    console.log("Complete Task...");
    //Append the task list item to the #completed-tasks
    var listItem=this.parentNode;
    completedTasksHolder.appendChild(listItem);
    bindTaskEvents(listItem, taskIncomplete);
}


var taskIncomplete=function(){
    console.log("Incomplete Task...");
    //Mark task as incomplete.
    //When the checkbox is unchecked
    //Append the task list item to the #incomplete-tasks.
    var listItem=this.parentNode;
    incompleteTaskHolder.appendChild(listItem);
    bindTaskEvents(listItem,taskCompleted);
}


//Set the click handler to the addTask function.
addButton.addEventListener("click",addTask);

var bindTaskEvents=function(taskListItem,checkBoxEventHandler){
    console.log("bind list item events");
    //select ListItems children
    var checkBox=taskListItem.querySelector("input[type=checkbox]");
    var editButton=taskListItem.querySelector("button.edit");
    var deleteButton=taskListItem.querySelector("button.delete");

    //Bind editTask to edit button.
    editButton.onclick=editTask;
    //Bind deleteTask to delete button.
    deleteButton.onclick=deleteTask;
    //Bind taskCompleted to checkBoxEventHandler.
    checkBox.onchange=checkBoxEventHandler;
}

//for each list item
incompleteTaskHolder.children.forEach(element => bindTaskEvents(element,taskCompleted));
//cycle over completedTasksHolder ul list items
completedTasksHolder.children.forEach(element => bindTaskEvents(element,taskIncomplete));

