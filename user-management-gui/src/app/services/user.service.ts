import { Injectable } from '@angular/core';
import {User} from "./user";
import { HttpClient } from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  getUserList() : Observable<User[]> {
    return this.httpClient.get<User[]>("/api/users");
  }

  updateUser(user: User) : Observable<User[]> {
    return this.httpClient.put<User[]>("/api/users/" + user.id, user);
  }

  createUser(user: User) : Observable<User[]> {
    return this.httpClient.post<User[]>("/api/users", user);
  }

  removeUser(id: number) : Observable<User[]> {
    return this.httpClient.delete<User[]>("/api/users/" + id);
  }
}
