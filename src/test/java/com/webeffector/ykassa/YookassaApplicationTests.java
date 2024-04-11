package com.webeffector.ykassa;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
@ContextConfiguration(classes = YookassaApplication.class)
public class YookassaApplicationTests {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Getter
    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void initMockWvc() {
        mockMvc = webAppContextSetup(webApplicationContext)
                .addFilter(((request, response, chain) -> {
                    String charsetUtf8 = "UTF-8";
                    request.setCharacterEncoding(charsetUtf8);
                    response.setCharacterEncoding(charsetUtf8);
                    chain.doFilter(request, response);
                })).build();
    }

}
