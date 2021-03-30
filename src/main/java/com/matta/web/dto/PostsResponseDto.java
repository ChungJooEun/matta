package com.matta.web.dto;

import com.matta.domain.posts.Posts;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostsResponseDto {

    private Long postsId;
    private String content;
    private int stars;
    private LocalDate visitedDate;

    public PostsResponseDto(Posts entity){

        this.postsId = entity.getPostsId();
        this.content = entity.getContent();
        this.stars = entity.getStars();
        this.visitedDate = entity.getVisitedDate();
    }

}
