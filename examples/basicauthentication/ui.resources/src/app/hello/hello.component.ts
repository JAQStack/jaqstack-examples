import { Component, OnInit } from '@angular/core';
import { HelloService } from './hello.service';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  helloFromJava: any;
  public jsonObject: any;
  users: any[] = [];
  loading = false;
  error: string | null = null;

  constructor(private helloService: HelloService) { }

  ngOnInit(): void {
    this.getHelloFromJava();
    this.loadUsers();
  }

  getHelloFromJava(): void {
    console.log('....getHelloFromJava!');
    this.helloService.getHelloWorldFromJava()
      .subscribe(resp => {
        console.log(resp);
        this.helloFromJava = JSON.stringify(resp);
      });
  }

  loadUsers(): void {
    this.loading = true;
    this.error = null;
    console.log('Loading users from API...');
    
    this.helloService.getUsers()
      .subscribe({
        next: (users) => {
          console.log('Users loaded:', users);
          this.users = users;
          this.loading = false;
        },
        error: (err) => {
          console.error('Error loading users:', err);
          this.error = 'Failed to load users: ' + err.message;
          this.loading = false;
        }
      });
  }

  addTestUser(): void {
    const newUser = {
      username: 'user' + Date.now(),
      password: 'password123',
      firstName: 'Test',
      lastName: 'User'
    };

    this.helloService.registerUser(newUser)
      .subscribe({
        next: (response) => {
          console.log('User registered:', response);
          this.loadUsers(); // Reload the users list
        },
        error: (err) => {
          console.error('Error registering user:', err);
          this.error = 'Failed to register user: ' + err.message;
        }
      });
  }
}
