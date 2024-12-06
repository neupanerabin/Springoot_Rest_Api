package org.rabin.rest_api.repository;


/*
 * @author : rabin
 */

import org.rabin.rest_api.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}