package com.matta.web;

import com.matta.domain.posts.Posts;
import com.matta.domain.posts.PostsRepository;
import com.matta.web.dto.PostsSaveRequestDto;
import com.matta.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostsApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @After
    public void tearDown() throws Exception{
        postsRepository.deleteAll();
    }

    @Test
    public void Posts_등록된다() throws Exception{

        // given
        String content = "테스트 게시물 내용";
        int stars = 5;
        LocalDate visitedDate = LocalDate.of(2020,10,31);

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .content(content)
                .stars(stars)
                .visitedDate(visitedDate)
                .build();
        String url = "http://localhost:" + port + "/api/v1/posts";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getStars()).isEqualTo(stars);
        assertThat(all.get(0).getVisitedDate()).isEqualTo(visitedDate);
    }

    @Test
    public void Posts_수정된다() throws Exception{

        //given
        Posts savePosts = postsRepository.save(
                Posts.builder()
                        .content("테스트 내용")
                        .stars(1)
                        .visitedDate(LocalDate.of(2020,10,31))
                        .build());

        Long updatePostsId = savePosts.getPostsId();
        String expectedContent = "CONTENT";
        int expectedStars = 3;
        LocalDate expectedVisitedDate = LocalDate.of(2019,10,31);

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto
                .builder()
                .content(expectedContent)
                .stars(expectedStars)
                .visitedDate(expectedVisitedDate)
                .build();

        String url = "http://localhost:" + port + "/api/v1/posts/" + updatePostsId;

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
        assertThat(all.get(0).getStars()).isEqualTo(expectedStars);
        assertThat(all.get(0).getVisitedDate()).isEqualTo(expectedVisitedDate);
    }

}
