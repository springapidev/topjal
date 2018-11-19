package com.topjal.service;

import com.topjal.entity.Comment;
import com.topjal.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


public interface CommentService {
    Comment save(Comment comment);
    void delete(Long id);
    Page<Comment> findTop20ByOrderByPostDesc(Post post, int page, int perPageRow);
}
