package me.choi.restapiwithtestcode.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.choi.restapiwithtestcode.common.TestDescription;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Project : rest-api-with-testcode
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:43 오전
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTests {

    @Autowired
    MockMvc mockMvc;
    //{"id":"mike6321"}

    @Autowired
    ObjectMapper objectMapper;



    @Test
    @TestDescription("정상적으로 이벤트를 생성하는 테스트")
    public void createEvent() throws Exception {
        EventDto event = EventDto.builder()
                    .name("Spring")
                    .description("REST API Developmet with Spring")
                    .beginEnrollmentDateTime(LocalDateTime.of(2020,06,28,8,18))
                    .closeEnrollmentDateTime(LocalDateTime.of(2020,06,29,8,18))
                    .beginEventDateTime(LocalDateTime.of(2020,06,29,8,18))
                    .endEventDateTime(LocalDateTime.of(2020,06,30,8,18))
                    .basePrice(100)
                    .maxPrice(200)
                    .limitOfEnrollment(100)
                    .location("강남역 D2 스타트업 팩토리")
                    .build()
                ;


        mockMvc.perform(post("/api/events/")
                        //.contentType("\"id\":\"mike6321\"")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(event))  //json 문자열로 변형
                        ) //요청본문
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(jsonPath("id").exists())
                        .andExpect(header().exists(HttpHeaders.LOCATION))
                        .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE))
                        .andExpect(jsonPath("id").value(Matchers.not(100)))
                        .andExpect(jsonPath("free").value(Matchers.not(true)))
                        .andExpect(jsonPath("eventStatus").value(EventStatus.DRAFT.name()))
        ;
        // 201 - created

    }
    @Test
    @TestDescription("입력 받을 수 없는 값을 사용한 경우에 에러가 발생하는 테스트")
    public void createEvent_Bad_Request() throws Exception {
        Event event = Event.builder()
                    .id(100)
                    .name("Spring")
                    .description("REST API Developmet with Spring")
                    .beginEnrollmentDateTime(LocalDateTime.of(2020,06,28,8,18))
                    .closeEnrollmentDateTime(LocalDateTime.of(2020,06,29,8,18))
                    .beginEventDateTime(LocalDateTime.of(2020,06,29,8,18))
                    .endEventDateTime(LocalDateTime.of(2020,06,30,8,18))
                    .basePrice(100)
                    .maxPrice(200)
                    .limitOfEnrollment(100)
                    .location("강남역 D2 스타트업 팩토리")
                    .free(true)
                    .offline(false)
                    .eventStatus(EventStatus.PUBLISHED)
                    .build()
                ;


        mockMvc.perform(post("/api/events/")
                        //.contentType("\"id\":\"mike6321\"")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaTypes.HAL_JSON)
                        .content(objectMapper.writeValueAsString(event))  //json 문자열로 변형
                        ) //요청본문
                        .andDo(print())
                        .andExpect(status().isBadRequest())
        ;

    }

    @Test
    @TestDescription("입력 값이 잘못된 경우에 에러가 발생하는 테스트")
    public void create_Bad_Request_Empty_Input() throws Exception {
        EventDto eventDto = EventDto.builder()
                                .name("Spring")
                                .description("REST API Developmet with Spring")
                                .beginEnrollmentDateTime(LocalDateTime.of(2020,06,29,8,18))
                                .closeEnrollmentDateTime(LocalDateTime.of(2020,06,28,8,18))
                                .beginEventDateTime(LocalDateTime.of(2020,06,30,8,18))
                                .endEventDateTime(LocalDateTime.of(2020,06,29,8,18))
                                .basePrice(10000)
                                .maxPrice(200)
                                .limitOfEnrollment(100)
                                .location("강남역 D2 스타트업 팩토리")
                                .build()
                                ;

        this.mockMvc.perform(post("/api/events")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(this.objectMapper.writeValueAsString(eventDto)))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$[0].objectName").exists())
                    //.andExpect(jsonPath("$[0].field").exists())
                    .andExpect(jsonPath("$[0].defaultMessage").exists())
                    .andExpect(jsonPath("$[0].code").exists())
                    //.andExpect(jsonPath("$[0].rejectedValue").exists())
        ;
    }
}
