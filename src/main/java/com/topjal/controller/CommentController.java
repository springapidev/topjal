package com.topjal.controller;

import com.topjal.entity.Comment;
import com.topjal.entity.Post;
import com.topjal.service.CommentService;
import com.topjal.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CommentController {
    @Autowired
    private CommentService service;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public ModelAndView saveComment(@Valid Comment comment, BindingResult bindingResult, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int perPage) {
        ModelAndView modelAndView = new ModelAndView();
        Post post = new Post();
        post.setId(comment.getId());
        if (comment.getDescription() != null) {
            bindingResult.rejectValue("description", "error.comment", "Write Your Comment First");
           //odelAndView.addObject("commentList", service.findTop20ByOrderByPostDesc(post, page, perPage));
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("post-single");
        } else {
            comment.setId(0L);
           service.save(comment);
            modelAndView.addObject("comment", new Comment());
         // modelAndView.addObject("commentList", service.findTop20ByOrderByPostDesc(post, page, perPage));
            modelAndView.setViewName("post-single");
        }
        return modelAndView;
    }


}
