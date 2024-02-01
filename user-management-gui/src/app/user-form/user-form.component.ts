import {booleanAttribute, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {User} from "../services/user";
import {UserService} from "../services/user.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrl: './user-form.component.css'
})
export class UserFormComponent  implements OnInit {
  @Input() title : string = '';
  @Input() user : User = new User(-1, '', '', '');
  @Input() editionContext : boolean = false;
  @Output() onClosePopup : EventEmitter<any> = new EventEmitter();

  errorMessage: string = '';

  constructor(private userService: UserService) {
  }

  ngOnInit() {
  }

  close(){
    this.onClosePopup.emit();
  }

  save(): void {
    if (this.editionContext) {
      this.updateUser();
    } else {
      this.createUser();
    }
  }

  updateUser(){
    this.userService.updateUser(this.user).subscribe(
      () => this.close(),
      (e: HttpErrorResponse) => console.log(e)
    );
  }

  createUser(){
    this.userService.createUser(this.user).subscribe(
      () => this.close(),
      (e: HttpErrorResponse) => {
               e.error && (this.errorMessage = e.error)
            }
    );
  }

}
