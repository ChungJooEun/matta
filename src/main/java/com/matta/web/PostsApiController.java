package com.matta.web;

import com.matta.service.PostsService;
import com.matta.web.dto.PostsResponseDto;
import com.matta.web.dto.PostsSaveRequestDto;
import com.matta.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{postsId}")
    public Long update(@PathVariable Long postsId, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(postsId, requestDto);
    }

    @GetMapping("/api/v1/posts/{postsId}")
    public PostsResponseDto findById(@PathVariable Long postsId){
        return postsService.findById(postsId);
    }

}
