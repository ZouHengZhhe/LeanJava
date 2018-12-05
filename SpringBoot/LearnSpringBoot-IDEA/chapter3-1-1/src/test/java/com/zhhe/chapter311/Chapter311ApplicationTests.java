package com.zhhe.chapter311;

import com.zhhe.chapter311.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter311ApplicationTests
{
    private MockMvc mvc;

    @Test
    public void contextLoads()
    {
    }

    @Before
    public void setUp()
    {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }



}
