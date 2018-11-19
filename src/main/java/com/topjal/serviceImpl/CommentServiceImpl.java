package com.topjal.serviceImpl;

import com.topjal.entity.Comment;
import com.topjal.entity.Post;
import com.topjal.repo.CommentRepo;
import com.topjal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo repo;

    @Override
    public Comment save(Comment comment) {
        return repo.saveAndFlush(comment);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public Page<Comment> findTop20ByOrderByPostDesc(Post post, int page, int perPageRow) {
        return repo.findTop20ByOrderByPostDesc(post,PageRequest.of(page,perPageRow));
    }

    @Override
    public List<Comment> findAllByPost(Post post) {
        return repo.findAllByPost(post);
    }

    @Override
    public int countAllByPost(Post post) {
        return repo.countAllByPost(post);
    }
}
