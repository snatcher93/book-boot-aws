package org.eternity.book.springboot.web;

import org.eternity.book.springboot.config.oauth.SecurityConfig;
import org.eternity.book.springboot.service.posts.PostsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = IndexController.class,
        excludeFilters = {
                @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes= SecurityConfig.class)
        })
public class IndexControllerUnitTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PostsService postsService;

    @Test
    @WithMockUser(roles = "USER")
    public void 메인폐이지_로딩() throws Exception {
        // when
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(content().string(containsString("스프링 부트로 시작하는 웹서비스")));
    }
}
