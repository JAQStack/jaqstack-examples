package com.jaqstack.helidon.simpleblog;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Service that provides operations for Blog Posts
 *
 * @author Suren Konathala
 */
@ApplicationScoped
public class BlogService implements Serializable {

    private final DataService dataService;

    @Inject
    public BlogService(DataService dataService) {
        this.dataService = dataService;
    }

    public String addBlogPost(BlogPost blogPost) {
        return dataService.addBlogPost(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return dataService.getAllBlogPosts();
    }

    public BlogPost getBlogPostById(String id) {
        return dataService.getBlogPostById(id);
    }
}

