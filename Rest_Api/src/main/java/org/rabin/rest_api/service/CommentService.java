package org.rabin.rest_api.service;


/*
 * @author : rabin
 */
import org.rabin.rest_api.entity.BlogPost;
import org.rabin.rest_api.entity.Comment;
import org.rabin.rest_api.exception.ResourceNotFoundException;
import org.rabin.rest_api.repository.BlogPostRepository;
import org.rabin.rest_api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogPostRepository blogPostRepository;

    public Comment addComment(Long postId, Comment comment) throws Exception {
        BlogPost blogPost = blogPostRepository
                .findById(postId).orElseThrow(() -> new ResourceNotFoundException("Blog post not found"));
        comment.setBlog(blogPost);
        return commentRepository.save(comment);
    }
}