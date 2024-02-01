import {Component, OnInit} from '@angular/core';
import {UserService} from "./services/user.service";
import {User} from "./services/user";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'user-management-gui';
}
