package com.matta.service;

import com.matta.domain.posts.Posts;
import com.matta.domain.posts.PostsRepository;
import com.matta.web.dto.PostsResponseDto;
import com.matta.web.dto.PostsSaveRequestDto;
import com.matta.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getPostsId();
    }

    @Transactional
    public Long update(Long postsId, PostsUpdateRequestDto requestDto){

        Posts posts = postsRepository.findById(postsId).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다. posts id : " + postsId));
        posts.update(requestDto.getContent(), requestDto.getStars(), requestDto.getVisitedDate());

        return postsId;
    }

    public PostsResponseDto findById(Long postsId){

        Posts entity = postsRepository.findById(postsId).orElseThrow(()->
                new IllegalArgumentException("해당 게시글이 없습니다. posts ID : " + postsId));
        return new PostsResponseDto(entity);
    }

}
