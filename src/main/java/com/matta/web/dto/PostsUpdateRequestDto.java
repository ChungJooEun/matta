package com.matta.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String content;
    private int stars;
    private LocalDate visitedDate;

    @Builder
    public PostsUpdateRequestDto(String content, int stars, LocalDate visitedDate){

        this.content = content;
        this.stars = stars;
        this.visitedDate = visitedDate;
    }
}
