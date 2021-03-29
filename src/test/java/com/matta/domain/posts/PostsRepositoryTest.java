package com.matta.domain.posts;

import com.matta.domain.Posts.Posts;
import com.matta.domain.Posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){

        //given
        String content = "테스트 게시글 본문";

        postsRepository.save(Posts.builder()
                .content(content)
                .build());

        //when
        List<Posts> postsList= postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getContent()).isEqualTo(content);

    }
}
