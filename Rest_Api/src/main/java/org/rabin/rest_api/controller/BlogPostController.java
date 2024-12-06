package org.rabin.rest_api.controller;

import org.rabin.rest_api.entity.BlogPost;
import org.rabin.rest_api.entity.User;
import org.rabin.rest_api.exception.ResourceNotFoundException;
import org.rabin.rest_api.service.BlogPostService;
import org.rabin.rest_api.repository.UserRepository;  // Import UserRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @Autowired
    private UserRepository userRepository;  // Inject UserRepository

    @GetMapping("/")
    public List<BlogPost> getAll() {
        return blogPostService.getAllPosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getBlogById(@PathVariable Long id) {
        try {
            BlogPost blogPost = blogPostService.getBlogPostById(id);
            return ResponseEntity.ok(blogPost);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/{id}")
    public String updateBlog(@PathVariable Long id, @RequestBody BlogPost updatedBlog) throws Exception {
        return blogPostService.updateBlogPost(id, updatedBlog);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {
        blogPostService.deleteBlogPost(id);
        return ResponseEntity.noContent().build();
    }

    /*@PostMapping("/")
    public ResponseEntity<String> createBlog(@RequestParam("file") MultipartFile file,
                                             @RequestParam("title") String title,
                                             @RequestParam("content") String content,
                                             @RequestParam("userId") Long userId) throws IOException {

        // Ensure the directory exists
        String uploadDir = "uploads/";
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }

        // Save the file to the uploads directory
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File uploadFile = new File(uploadDir + filename);
        file.transferTo(uploadFile);

        // Create the blog post object
        BlogPost blog = new BlogPost();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setThumbnail(uploadDir + filename);

        // Get the user and set it on the blog post
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        blog.setUser(user);

        // Save and return the blog post
        blogPostService.createBlogPost(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body("Blog post created successfully!");
    }*/

    @PostMapping("/")
    public ResponseEntity<String> createBlog(@RequestParam("file") MultipartFile file,
                                             @RequestParam("title") String title,
                                             @RequestParam("content") String content,
                                             @RequestParam("userId") Long userId) throws IOException {

        // Ensure the directory exists
        String uploadDir = "uploads/";
        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }

        // Save the file to the uploads directory
        String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        File uploadFile = new File(uploadDir + filename);
        file.transferTo(uploadFile);

        // Create the blog post object
        BlogPost blog = new BlogPost();
        blog.setTitle(title);
        blog.setContent(content);
        blog.setThumbnail(uploadDir + filename);

        // Get the user and set it on the blog post
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        blog.setUser(user);

        // Save the blog post and return the response
        blogPostService.createBlogPost(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body("Blog post created successfully!");
    }



}

