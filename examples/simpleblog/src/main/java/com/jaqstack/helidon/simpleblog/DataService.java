package com.jaqstack.helidon.simpleblog;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.bson.types.ObjectId;

import jakarta.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Service which provides CRUD operations for database.
 *
 * @author Suren Konathala
 */
@ApplicationScoped
public class DataService implements Serializable {

    public String addBlogPost(BlogPost blogPost) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("jaqstack");
        MongoCollection<Document> collection = database.getCollection("blogposts");

        Document doc = new Document("title", blogPost.getTitle())
                .append("content", blogPost.getContent())
                .append("author", blogPost.getAuthor());

        if (blogPost.getDateCreated() != null) {
            doc.append("dateCreated", blogPost.getDateCreated());
        }

        collection.insertOne(doc);
        mongoClient.close();

        return "Blog post '" + blogPost.getTitle() + "' added successfully.";
    }

    public List<BlogPost> getAllBlogPosts() {
        List<BlogPost> blogPostsList = new ArrayList<>();

        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("jaqstack");
        MongoCollection<Document> collection = database.getCollection("blogposts");

        List<Document> documents = collection.find().into(new ArrayList<>());

        for (Document doc : documents) {
            BlogPost post = new BlogPost();
            post.setId(doc.getObjectId("_id").toString());
            post.setTitle(doc.getString("title"));
            post.setContent(doc.getString("content"));
            post.setAuthor(doc.getString("author"));
            if (doc.containsKey("dateCreated")) {
                post.setDateCreated(doc.getString("dateCreated"));
            }
            blogPostsList.add(post);
        }

        mongoClient.close();

        return blogPostsList;
    }

    public BlogPost getBlogPostById(String id) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("jaqstack");
        MongoCollection<Document> collection = database.getCollection("blogposts");

        BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
        Document doc = collection.find(query).first();

        if (doc == null) {
            mongoClient.close();
            return null;
        }

        BlogPost post = new BlogPost();
        post.setId(doc.getObjectId("_id").toString());
        post.setTitle(doc.getString("title"));
        post.setContent(doc.getString("content"));
        post.setAuthor(doc.getString("author"));
        if (doc.containsKey("dateCreated")) {
            post.setDateCreated(doc.getString("dateCreated"));
        }

        mongoClient.close();

        return post;
    }
}

