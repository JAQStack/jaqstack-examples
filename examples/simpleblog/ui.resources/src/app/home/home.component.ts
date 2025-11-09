import { Component, OnInit } from '@angular/core';
import { BlogService } from '../blog.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  standalone: false
})
export class HomeComponent implements OnInit {
  blogPosts: any[] = [];
  newBlogPost: any = { title: '', content: '', author: '' };

  constructor(private blogService: BlogService) { }

  ngOnInit() {
    this.loadBlogPosts();
  }

  loadBlogPosts(): void {
    this.blogService.getAllBlogPosts().subscribe(
      (data) => {
        this.blogPosts = data;
      },
      (error) => {
        console.error('Error fetching blog posts:', error);
      }
    );
  }

  createBlogPost(): void {
    this.blogService.createBlogPost(this.newBlogPost).subscribe(
      (response) => {
        console.log(response);
        this.newBlogPost = { title: '', content: '', author: '' };
        this.loadBlogPosts();
      },
      (error) => {
        console.error('Error creating blog post:', error);
      }
    );
  }
}

