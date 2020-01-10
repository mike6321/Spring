package me.choi.demospringmvc.user;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void hello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void createUser_JSON() throws Exception {
        //String userJson = "{\"userrname\":\"choi\", \}";
        JSONObject userJson = new JSONObject();
        userJson.put("username", "choi");
        userJson.put("password", "123");
        userJson.toString();

        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(String.valueOf(userJson)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username",is(equalTo("choi"))))
                .andExpect(jsonPath("$.password",is(equalTo("123"))))
        ;
    }
    @Test
    public void createUser_XML() throws Exception {
        //String userJson = "{\"userrname\":\"choi\", \}";
        JSONObject userJson = new JSONObject();
        userJson.put("username", "choi");
        userJson.put("password", "123");
        userJson.toString();

        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_XML)
                .content(String.valueOf(userJson)))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username")
                        .string("choi"))
                .andExpect(xpath("User/password")
                        .string("123")
                );
    }
}
