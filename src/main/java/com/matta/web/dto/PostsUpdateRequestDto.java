package com.matta.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String content;

    @Builder
    public PostsUpdateRequestDto(String content){
        this.content = content;
    }
}
