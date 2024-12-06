package org.rabin.rest_api.repository;

/*
 * @author : rabin
 */

import org.rabin.rest_api.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}