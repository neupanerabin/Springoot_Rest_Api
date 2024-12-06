package org.rabin.rest_api.controller;


/*
 * @author : rabin
 */

import org.rabin.rest_api.entity.Comment;
import org.rabin.rest_api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}")
    public Comment addComment(@PathVariable Long postId, @RequestBody Comment comment) throws Exception{
        return commentService.addComment(postId, comment);
    }

}