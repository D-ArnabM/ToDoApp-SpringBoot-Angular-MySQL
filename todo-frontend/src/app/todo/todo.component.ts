import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css'],
})
export class TodoComponent {
  ToDoArray: any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;

  toDoHead: string = '';
  toDoBody: string = '';

  currentToDoId = '';

  constructor(private http: HttpClient) {
    this.getAllToDo();
  }

  getAllToDo() {
    this.http
      .get("http://127.0.0.1:8001/api/v1/todo/fetchAllToDo")
      .subscribe((resultData: any) => {
        this.isResultLoaded = true;
        this.ToDoArray = resultData;
      });
  }

  register(){
    let bodyData = {
      "toDoTaskHead": this.toDoHead,
      "toDoTaskBody": this.toDoBody
    };
    this.http.post("http://127.0.0.1:8001/api/v1/todo/saveToDo", bodyData).subscribe((resultData : any)=>{
      alert("Task Added Successfully")
      this.getAllToDo();
      this.toDoHead = '';
      this.toDoBody = '';
    });
  }

  setUpdate(data : any){
    this.toDoHead = data.toDoTaskHead;
    this.toDoBody = data.toDoTaskBody;
    this.currentToDoId = data.toDoId;
  }

  updateRecords(){
    let bodyData = {
      "toDoId" : this.currentToDoId,
      "toDoTaskHead": this.toDoHead,
      "toDoTaskBody": this.toDoBody
    };
    this.http.put("http://127.0.0.1:8001/api/v1/todo/update", bodyData).subscribe((resultData : any)=>{
      alert("Task Updated Successfully")
      this.getAllToDo();
      this.toDoHead = '';
      this.toDoBody = '';
      this.resetFields();
    });
  }

  save(){
    if(this.currentToDoId == ''){
      this.register();
    }
    else{
      this.updateRecords();
    }
  }

  setDelete(data : any){
    this.http.delete("http://127.0.0.1:8001/api/v1/todo/delete/"+data.toDoId).subscribe((resultData : any)=>{
      alert("Task Deleted")
      this.getAllToDo();
    });
  }

  resetFields(){
    this.toDoHead = '';
    this.toDoBody = '';
    this.currentToDoId = '';
  }
}
