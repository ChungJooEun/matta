package com.matta.web.dto;

import com.matta.domain.Posts.Posts;

import lombok.Getter;
@Getter
public class PostsResponseDto {

    private Long postsId;
    private String content;

    public PostsResponseDto(Posts entity){

        this.postsId = entity.getPostsId();
        this.content = entity.getContent();
    }

}
