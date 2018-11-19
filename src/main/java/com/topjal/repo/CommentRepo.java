package com.topjal.repo;

import com.topjal.entity.Comment;
import com.topjal.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {
    Page<Comment> findTop20ByOrderByPostDesc(Post post, Pageable pageable);
    List<Comment> findAllByPost(Post post);
    int countAllByPost(Post post);
}
