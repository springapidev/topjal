package com.topjal.service;


import com.topjal.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface PostService {
    Post save(Post post);
    Post update(Post post);
    void delete(Long id);
    Optional<Post> getPost(Long id);
    Page<Post> getAllPosts(int page, int perPageRow);
    Post isAlreadyExist(String title);
    boolean isExist(long id);
    Page<Post> findTopBy9ByOrderByCreateDateDesc(int page, int perPageRow);




}
