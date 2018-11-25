package com.topjal.controller;

import com.topjal.entity.Comment;
import com.topjal.entity.Post;
import com.topjal.service.CommentService;
import com.topjal.service.PostService;
import com.topjal.util.SystemInfoCollect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    private CommentService service;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/post/{id}", method = RequestMethod.POST)
    public String saveComment(@Valid Comment comment, BindingResult bindingResult, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int perPage, @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        comment.setStatus(true);
        comment.setCommentDate(new Date());

        comment.setUpdateDate(new Date());

        comment.setIpAddress(SystemInfoCollect.getIPAddress());

        Post post = new Post();
        post.setId(id);
        comment.setPost(post);
        if (comment.getDescription() == null) {
            bindingResult.rejectValue("description", "error.comment", "Write Your Comment First");
           //odelAndView.addObject("commentList", service.findTop20ByOrderByPostDesc(post, page, perPage));
        }
        if (bindingResult.hasErrors()) {
            //modelAndView.setViewName("post-single");
            return "redirect:/post/"+id;
        } else {
            System.out.println(comment);
            service.save(comment);
            modelAndView.addObject("comment", new Comment());
          // modelAndView.addObject("commentList", service.findTop20ByOrderByPostDesc(post, page, perPage));
            modelAndView.setViewName("post-single");
        }
        return "redirect:/post/"+id;
    }


}
