package com.matta.web.dto;

import com.matta.domain.Posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String content;

    @Builder
    public PostsSaveRequestDto(String content){
        this.content = content;
    }

    public Posts toEntity(){
        return Posts.builder()
                .content(this.content)
                .build();
    }
}
