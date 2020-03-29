package org.eternity.book.springboot.web;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class IndexControllerUnitTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void 메인폐이지_로딩() throws Exception {
        // when
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(content().string(containsString("스프링 부트로 시작하는 웹서비스")));
    }
}
