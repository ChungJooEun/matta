package com.matta.web.dto;

import com.matta.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String content;
    private int stars = 0;

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate visitedDate;

    @Builder
    public PostsSaveRequestDto(String content, int stars, LocalDate visitedDate){

        this.content = content;
        this.stars = stars;
        this.visitedDate = visitedDate;
    }

    public Posts toEntity(){

        return Posts.builder()
                .content(this.content)
                .stars(this.stars)
                .visitedDate(this.visitedDate)
                .build();
    }
}
