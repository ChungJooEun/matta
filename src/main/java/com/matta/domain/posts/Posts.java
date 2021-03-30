package com.matta.domain.posts;

import com.matta.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    // 게시글 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postsId;

    // 글쓴이 id

    // 장소 id

    // 방문 날짜
    @Column(nullable = false)
    private LocalDate visitedDate;

    // 글 내용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // 별점
    @Column(nullable = false)
    private int stars;

    // 폴더 id

    // 글 작성일

    // 글 삭제일
    @Column
    private LocalDateTime regDate;

    // 게시 여부
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private PostsStatus postsStatus;

    @Builder()
    public Posts(String content, int stars, LocalDate visitedDate){

        this.content = content;
        this.stars = stars;
        this.visitedDate = visitedDate;
    }

    // 수정
    public void update(String content, int stars, LocalDate visitedDate){

        this.content = content;
        this.stars = stars;
        this.visitedDate = visitedDate;
    }

    // 삭제

//    @Builder()
//    public Posts(String content, PostsStatus postsStatus){
//        this.content = content;
//        this.postsStatus = postsStatus;
//    }

//    public String getPostsStatusKey(){
//        return this.postsStatus.getKey();
//    }
}
