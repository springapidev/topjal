package com.topjal.repo;


import com.topjal.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
    Post findByTitle(String title);
    Page<Post> findTop9ByOrderByCreateDateDesc(Pageable pageable);
}
