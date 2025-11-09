import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BlogService } from '../blog.service';

@Component({
  selector: 'app-blog-detail',
  templateUrl: './blog-detail.component.html',
  styleUrls: ['./blog-detail.component.css'],
  standalone: false
})
export class BlogDetailComponent implements OnInit {
  blogPost: any;

  constructor(
    private route: ActivatedRoute,
    private blogService: BlogService
  ) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id) {
        this.blogService.getBlogPostById(id).subscribe(
          (data) => {
            this.blogPost = data;
          },
          (error) => {
            console.error('Error fetching blog post:', error);
          }
        );
      }
    });
  }
}

