package org.eternity.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.eternity.book.springboot.config.oauth.LoginUser;
import org.eternity.book.springboot.service.posts.PostsService;
import org.eternity.book.springboot.web.dto.PostsResponseDto;
import org.eternity.book.springboot.web.session.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(@LoginUser SessionUser user, Model model) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable("id") Long id, Model model) {
        PostsResponseDto dto  = postsService.findById(id);
        model.addAttribute("post", dto);
        return "/posts-update";
    }
}
