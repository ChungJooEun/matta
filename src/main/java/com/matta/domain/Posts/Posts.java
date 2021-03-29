package com.matta.domain.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    // 게시글 id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postsId;

    // 글쓴이 id

    // 장소 id

    // 글 내용
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    // 별점

    // 폴더 id

    // 글 작성일

    // 글 삭제일

    // 게시 여부
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private PostsStatus postsStatus;



    @Builder()
    public Posts(String content){

        this.content = content;
    }

    public void update(String content){
        this.content = content;
    }


//    @Builder()
//    public Posts(String content, PostsStatus postsStatus){
//        this.content = content;
//        this.postsStatus = postsStatus;
//    }

//    public String getPostsStatusKey(){
//        return this.postsStatus.getKey();
//    }

    // 수정

    // 삭제

}
