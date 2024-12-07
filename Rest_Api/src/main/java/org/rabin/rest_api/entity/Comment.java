package org.rabin.rest_api.entity;


/*
 * @author : rabin
 */


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore  // This prevents the Blog entity from being serialized in the response
    private User commenter;

    @ManyToOne
    @JoinColumn(name = "blog_post_id")
    private BlogPost blog;


}