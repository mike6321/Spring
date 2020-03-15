package me.choi.restapi.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Project : rest-api
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/15
 * Time : 1:19 오전
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest
public class EventControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    EventRepository eventRepository;

    @Test
    public void createEvent() throws Exception {

        Event event = Event.builder()
                            .name("Spring")
                            .description("REST API Development with Spring")
                            .beginEnrollmentDateTime(LocalDateTime.of(2020,3,15,2,28,55,2))
                            .closeEnrollmentDateTime(LocalDateTime.of(2020,3,16,2,28,55,2))
                            .endEventDateTime(LocalDateTime.of(2020,3,17,2,28,55,2))
                            .basePrice(100)
                            .maxPrice(200)
                            .limitOfEnrollment(100)
                            .location("강남역 D2 스타트업 팩토리")
                            .build();
        event.setId(10);
        Mockito.when(eventRepository.save(event)).thenReturn(event);

        mockMvc.perform(post("/api/events/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaTypes.HAL_JSON)
                    .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists());
    }


}
