package kr.co.choi.eatgo.interfaces;

import kr.co.choi.eatgo.application.RestaurantService;
import kr.co.choi.eatgo.domin.MenuItemRepositoryImpl;
import kr.co.choi.eatgo.domin.RestaurantRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@ExtendWith({SpringExtension.class})
@WebMvcTest(RestaurantController.class)
public class RestaurantControllerTest {
    @Autowired
    private MockMvc mvc;
    @SpyBean(RestaurantService.class)
    private RestaurantService restaurantService;

    @SpyBean
    private RestaurantRepositoryImpl restaurantRepositoryImpl;
    @SpyBean
    private MenuItemRepositoryImpl menuItemRepository;

    @Test
    public void list() throws Exception {
        mvc.perform(get("/restaurants"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"name\":\"bob zip~\"")))
                .andExpect(content().string(
                    containsString("\"id\":1004")));

    }

    @Test
    public void detail() throws Exception {
        mvc.perform(get("/restaurants/1004"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"name\":\"bob zip~\"")))
                .andExpect(content().string(
                        containsString("\"id\":1004")));

        mvc.perform(get("/restaurants/2020"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"name\":\"Cyber Food\"")))
                .andExpect(content().string(
                        containsString("\"id\":2020")))
                .andExpect(content().string(
                        containsString("Kimchi")
                ));
    }

}