import { Component, signal, inject, PLATFORM_ID } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { UsersService } from './services/users.service';
import {User} from '../app/models/user.model'


@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
  users: User[] = [];
  private platformId = inject(PLATFORM_ID);
  
  constructor (private usersService: UsersService) {
    // Only load users in browser, not on server
    if (isPlatformBrowser(this.platformId)) {
      this.loadUsers();
    }
  }

  loadUsers()
  {
    this.usersService.getAllUsers().subscribe(
      {
       next: (data) => {
        this.users = data;
        console.log('Users loaded: ', this.users)
       }, 
       error: (err) => console.error('Error loading users: ', err)
      }
    );
  }
}



