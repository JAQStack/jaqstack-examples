package com.jaqstack.helidon.simpleblog;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.OPTIONS;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

/**
 * JAX-RS resource class that provides operations for blog posts.
 *
 * @author Suren Konathala
 */
@Path("/blog")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class BlogResource {

    private final BlogService blogService;

    /**
     * Using constructor injection to get BlogService.
     *
     * @param blogService the blog service
     */
    @Inject
    public BlogResource(BlogService blogService) {
        this.blogService = blogService;
    }

    private Response addCorsHeaders(Response.ResponseBuilder response) {
        return response
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization")
                .header("Access-Control-Max-Age", "3600")
                .build();
    }

    @OPTIONS
    @Path("/posts")
    public Response optionsPosts() {
        return addCorsHeaders(Response.ok());
    }

    @OPTIONS
    @Path("/post")
    public Response optionsPost() {
        return addCorsHeaders(Response.ok());
    }

    @OPTIONS
    @Path("/post/{id}")
    public Response optionsPostById(@PathParam("id") String id) {
        return addCorsHeaders(Response.ok());
    }

    @GET
    @Path("/posts")
    public Response getAllBlogPosts() {
        List<BlogPost> blogPosts = blogService.getAllBlogPosts();
        return addCorsHeaders(Response.ok(blogPosts));
    }

    @GET
    @Path("/post/{id}")
    public Response getBlogPostById(@PathParam("id") String id) {
        BlogPost blogPost = blogService.getBlogPostById(id);

        if (blogPost == null) {
            return addCorsHeaders(Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\":\"Blog post not found\"}"));
        }

        return addCorsHeaders(Response.ok(blogPost));
    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBlogPost(BlogPost blogPost) {
        System.out.println("\n******* BlogResource.createBlogPost : Title=" + blogPost.getTitle());

        String message = blogService.addBlogPost(blogPost);
        
        Message responseMessage = new Message(message);
        return addCorsHeaders(Response.ok(responseMessage));
    }
}

