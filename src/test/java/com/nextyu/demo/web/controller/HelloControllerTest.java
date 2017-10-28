package com.nextyu.demo.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 2017-10-28 16:43
 *
 * @author nextyu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void sayHello() throws Exception {
        // 模拟 get 请求
        mockMvc.perform(
                get("/hello") // get 请求 url /hello
                        .param("name", "tom") // 参数 name=tom
                        .contentType(MediaType.APPLICATION_JSON_UTF8)) // 设置请求头 Content-Type = application/json;charset=UTF-8
                .andExpect(status().isOk()) // 期望返回的状态码为200
                .andExpect(content().string("hello tom")); // 期望返回值为"hello tom"
    }

}