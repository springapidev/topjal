package com.topjal.controller;


import com.topjal.entity.Category;
import com.topjal.entity.Post;
import com.topjal.entity.Tag;
import com.topjal.entity.User;
import com.topjal.repo.CategoryRepo;
import com.topjal.repo.TagRepo;
import com.topjal.service.PostService;
import com.topjal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;


@Controller
public class PostController {
    @Autowired
    private PostService service;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private TagRepo tagRepo;

    @Autowired
    private UserService userService;

    private static int currentPage = 1;
    private static int pageSize = 5;

    @RequestMapping(value = "/post/create", method = RequestMethod.GET)
    public ModelAndView getPost(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "40") int perPage) {
        ModelAndView modelAndView = new ModelAndView();
        Post post = new Post();
        modelAndView.addObject("post", post);
//        modelAndView.addObject("list", service.getAllPosts(page, perPage));
        modelAndView.addObject("allCategories", categoryRepo.findAll());
        modelAndView.addObject("allTags", tagRepo.findAll());
        modelAndView.setViewName("post-create");
        return modelAndView;
    }

    @RequestMapping(value = "/post/create", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult bindingResult, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int perPage, @RequestParam("checkcategories") Long markedCategories, @RequestParam("checktags") Long[] markedtags, Authentication authentication) {
        Category category = new Category();
        category.setId(markedCategories);
        post.setCategory(category);
        post.setCreateDate(new Date());
        post.setUpdateDate(new Date());
        User user=userService.isUserNameAlreadyExist(authentication.getName());
        user.setId(user.getId());
        post.setUser(user);
        Set<Tag> sets=new HashSet<>();
        if(markedtags.length > 0) {
            for (Long i : markedtags) {
                Tag t = new Tag();
                t.setId(i);
                sets.add(t);
            }
        }
post.setTags(sets);

        ModelAndView modelAndView = new ModelAndView();
        Post postExit = service.isAlreadyExist(post.getTitle().trim());
        System.out.println("===== " + post.getTitle());
        if (postExit != null && post.getId() != null) {
            bindingResult.rejectValue("title", "error.title", "You already have inserted this Post Title");
            modelAndView.addObject("allCategories", categoryRepo.findAll());
            modelAndView.addObject("allTags", tagRepo.findAll());
        }
        if (bindingResult.hasErrors()) {
            return "post-create";
        } else {
                if(post.getDescription().length() < 400) {
                    bindingResult.rejectValue("description", "error.description", "Input at least 400 Characters");
                    modelAndView.addObject("allCategories", categoryRepo.findAll());
                }else{
                    service.save(post);
                    modelAndView.addObject("successMessage", "Insert Success");
                    modelAndView.addObject("post", new Post());
                    modelAndView.addObject("allCategories", categoryRepo.findAll());
                    modelAndView.addObject("allTags", tagRepo.findAll());
                }
            }


            modelAndView.addObject("post", new Post());
            modelAndView.addObject("allCategories", categoryRepo.findAll());
               return "post-create";
    }
    @RequestMapping(value = "/post/edit", method = RequestMethod.GET)
    public ModelAndView getEditPost() {
        ModelAndView modelAndView = new ModelAndView();
        Post post = new Post();
        modelAndView.addObject("post", post);
        modelAndView.addObject("allCategories", categoryRepo.findAll());
        modelAndView.addObject("allTags", tagRepo.findAll());
        modelAndView.setViewName("edit-post");
        return modelAndView;
    }

    @RequestMapping(value = "/post/edit/{id}", method = RequestMethod.GET)
    public String updatePost(@PathVariable Long id, Model model, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int perPage) {
        Optional<Post> post1 = service.getPost(id);
        Post post = new Post();
        post.setTitle(post1.get().getTitle());
        post.setDescription(post1.get().getDescription());
        post.setCategory(post1.get().getCategory());
        post.setId(id);
        System.out.println("======" + post.getId() + ", " + post.getTitle());
        model.addAttribute("post", post);
        model.addAttribute("list", service.getAllPosts(page, perPage));
        model.addAttribute("allCategories", categoryRepo.findAll());
        model.addAttribute("allTags", tagRepo.findAll());
        return "post-create";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/post/del/{id}", method = RequestMethod.GET)
    public String delPost(@PathVariable Long id, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "4") int perPage) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("successMessage", "Delete Success");
        modelAndView.addObject("list", service.getAllPosts(page, perPage));
        modelAndView.addObject("allCategories", categoryRepo.findAll());
        modelAndView.addObject("allTags", tagRepo.findAll());
        return "redirect:/post/create";
    }
    int clicks=0;
    int likes=0;
    @RequestMapping(value = "/post/list", method = RequestMethod.GET)
    public ModelAndView getPostList(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "9") int perPage) {
        ModelAndView modelAndView = new ModelAndView();
        Post post = new Post();
        modelAndView.addObject("post", post);
        modelAndView.addObject("list", service.findTopBy9ByOrderByCreateDateDesc(page, perPage));
        modelAndView.addObject("allTags", tagRepo.findAll());
        modelAndView.addObject("clicks", clicks);
        modelAndView.addObject("likes", likes);
        modelAndView.setViewName("post-list");
        return modelAndView;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ModelAndView getSinglePost(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Post post = new Post();
        modelAndView.addObject("post", service.getPost(id));
                modelAndView.setViewName("post-single");
                clicks++;
        modelAndView.addObject("clicks", clicks);
        System.out.println("clicks: "+id+" : "+clicks);
        modelAndView.addObject("likes", likes);
        return modelAndView;
    }
    @RequestMapping(value = "/post/{id}/{like}", method = RequestMethod.GET)
    public String getSinglePostLikes(@PathVariable Long id,@PathVariable String like) {
        ModelAndView modelAndView = new ModelAndView();
        Post post = new Post();
        modelAndView.addObject("post", service.getPost(id));
        modelAndView.setViewName("post-single");
        likes++;
        modelAndView.addObject("clicks", clicks);
        modelAndView.addObject("likes", likes);
        System.out.println("clicks: "+id+" : "+clicks);

        return "redirect:/post/list";
    }
    @RequestMapping(value = "/post/list/{like}", method = RequestMethod.GET)
    public String getPostLikes(@PathVariable String like) {
        ModelAndView modelAndView = new ModelAndView();

        likes++;
        modelAndView.addObject("likes", likes);

        modelAndView.setViewName("post-list");
        return "redirect:/post/list";
    }
}
