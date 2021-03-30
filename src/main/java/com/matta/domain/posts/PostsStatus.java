package com.matta.domain.posts;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PostsStatus {

    POST("STATUS_POST", "게시"),
        DELETE("STATUS_DELETE", "삭제");

    private final String key;
    private final String title;
}
