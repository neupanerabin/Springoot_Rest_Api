package org.rabin.rest_api.service;

import org.rabin.rest_api.entity.BlogPost;
import org.rabin.rest_api.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public String createBlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
        return "Blog post created successfully!";
    }

    public List<BlogPost> getAllPosts() {
        List<BlogPost> posts = blogPostRepository.findAll();
        if (posts.isEmpty()) {
            throw new RuntimeException("No blog posts found.");
        }
        return posts;
    }

    public BlogPost getBlogPostById(Long id) throws Exception {
        return blogPostRepository.findById(id).orElseThrow(() -> new Exception("Blog post not found"));
    }

    public String updateBlogPost(Long id, BlogPost updatedBlog) throws Exception {
        BlogPost existingBlog = getBlogPostById(id);
        existingBlog.setTitle(updatedBlog.getTitle());
        existingBlog.setContent(updatedBlog.getContent());
        existingBlog.setThumbnail(updatedBlog.getThumbnail());
        blogPostRepository.save(existingBlog);
        return "Blog post updated successfully!";
    }

    public String deleteBlogPost(Long id) throws Exception {
        if (!blogPostRepository.existsById(id)) throw new Exception("Blog post not found");
        blogPostRepository.deleteById(id);
        return "Blog post deleted successfully!";
    }
}
