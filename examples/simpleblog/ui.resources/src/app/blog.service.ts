import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BlogService {
  private baseUrl: string = environment.BACKEND_URL + "/blog";

  constructor(private http: HttpClient) { }

  getAllBlogPosts(): Observable<any> {
    return this.http.get(`${this.baseUrl}/posts`);
  }

  getBlogPostById(id: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/post/${id}`);
  }

  createBlogPost(blogPost: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/post`, blogPost);
  }
}

