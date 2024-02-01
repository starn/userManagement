import {Component, OnInit} from '@angular/core';
import {User} from "../services/user";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-user-management',
  templateUrl: './user-management.component.html',
  styleUrl: './user-management.component.css'
})
export class UserManagementComponent implements OnInit {
  userList: User[] = [];
  searchString: string = '';
  showCreateUserPanel = false;
  userToEdit?: User = undefined;

  constructor(private userService: UserService) {
  }

  ngOnInit() {
    this.loadUserList();
  }

  loadUserList(){
    this.userService.getUserList().subscribe((response => {
      this.userList = response;
    }));
  }

  search(){
    console.log(this.searchString);
  }

  filteredUsers(): User[] {
    return this.userList.filter((user) =>
      user.lastname?.toLowerCase().indexOf(this.searchString.toLowerCase()) != -1 || user.firstname?.toLowerCase().indexOf(this.searchString.toLowerCase()) != -1);
  }

  editUser(user: User) {
    this.showCreateUserPanel = false;
    this.userToEdit = user;
  }

  createUser() {
    this.userToEdit = undefined;
    this.showCreateUserPanel = true;
  }

  deleteUser(id: number){
    this.userService.removeUser(id).subscribe(result => this.loadUserList());
  }

  onClosePopup($event: any){
    this.userToEdit = undefined;
    this.showCreateUserPanel = false;
    this.loadUserList();
  }
}
