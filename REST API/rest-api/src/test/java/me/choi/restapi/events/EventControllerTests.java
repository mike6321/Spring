package me.choi.restapi.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
//@WebMvcTest
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

//    @MockBean
//    EventRepository eventRepository;

    @Test
    @DisplayName("정상적으로 이벤트를 생성하는 테스트")
    public void createEvent() throws Exception {

        Event event = Event.builder()
                            .name("Spring")
                            .description("REST API Development with Spring")
                            .beginEnrollmentDateTime(LocalDateTime.of(2020,3,15,2,28,55,2))
                            .closeEnrollmentDateTime(LocalDateTime.of(2020,3,16,2,28,55,2))
                            .beginEventDateTime(LocalDateTime.of(2020,3,17,2,28,55,2))
                            .endEventDateTime(LocalDateTime.of(2020,3,18,2,28,55,2))
                            .basePrice(100)
                            .maxPrice(200)
                            .limitOfEnrollment(100)
                            .location("강남역 D2 스타트업 팩토리")
                            .build();

        // TODO: [createEvent] junwoochoi 2020/03/15 3:55 오후
        // 컨트롤러의 객체와 mock 객체와 다르기때문에 오류가 떨어진다.
//        Mockito.when(eventRepository.save(event)).thenReturn(event);

        mockMvc.perform(post("/api/events/")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaTypes.HAL_JSON)
                    .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists())
                .andExpect(jsonPath("free").value(Matchers.not(false)))
                .andExpect(jsonPath("offline").value(Matchers.not(true)))
                .andExpect(jsonPath("eventStaus").value(Matchers.not(EventStaus.DRAFT.name())));
    }

    @Test
    @DisplayName("입력받을 수 없는 값을 사용하는 경우에 에러가 발생하는 이벤트를 생성하는 테스트")
    public void badRequest() throws Exception {

        Event event = Event.builder()
                .id(100)
                .name("Spring")
                .description("REST API Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2020,3,15,2,28,55,2))
                .closeEnrollmentDateTime(LocalDateTime.of(2020,3,16,2,28,55,2))
                .endEventDateTime(LocalDateTime.of(2020,3,17,2,28,55,2))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타트업 팩토리")
                .free(true)
                .offline(false)
                .eventStaus(EventStaus.PUBLISHED)
                .build();

        // TODO: [createEvent] junwoochoi 2020/03/15 3:55 오후
        mockMvc.perform(post("/api/events/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isBadRequest());

        // TODO: [badRequest] junwoochoi 2020/03/15 4:36 오후
        // 받을 수 없는 프로퍼티를 넘길 경우 BadRequest 처리를 한다.
        //  이를 위해서 application properties에서 설정을 한다.

    }

    @Test
    @DisplayName("입력값이 비어있는경우에 에러가 발생하는 이벤트를 생성하는 테스트")
    public void createEvent_Bad_Request_Empty_Input() throws Exception {
        EventDto eventDto = EventDto.builder().build();

        this.mockMvc.perform(post("/api/events")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(this.objectMapper.writeValueAsString(eventDto))
                    )
                    .andExpect(status().isBadRequest());
    }
    @Test
    @DisplayName("입력값이 잘못된 경우에 에러가 발생하는 이벤트를 생성하는 테스트")
    public void createEvent_Bad_Request_Wrong_Input() throws Exception {

        // TODO: [createEvent_Bad_Request_Wrong_Input] junwoochoi 2020/03/15 4:53 오후
        // 이벤트 시작하는 날짜보다 종료하는 날짜가 빠르게끔 설정 , basePrice가 맥스 값 보다 크게 설
       EventDto eventDto = EventDto.builder()
                                    .name("Spring")
                                    .description("REST API Development with Spring")
                                    .beginEnrollmentDateTime(LocalDateTime.of(2020,3,26,2,28,55,2))
                                    .closeEnrollmentDateTime(LocalDateTime.of(2020,3,25,2,28,55,2))
                                    .beginEventDateTime(LocalDateTime.of(2020,3,24,2,28,55,2))
                                    .endEventDateTime(LocalDateTime.of(2020,3,23,2,28,55,2))
                                    .basePrice(10000)
                                    .maxPrice(200)
                                    .limitOfEnrollment(100)
                                    .location("강남역 D2 스타트업 팩토리")
                                    .build();


        this.mockMvc.perform(post("/api/events")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(this.objectMapper.writeValueAsString(eventDto)))
                    .andDo(print())
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$[0].objectName").exists())
                    .andExpect(jsonPath("$[0].field").exists())
                    .andExpect(jsonPath("$[0].defaultMessage").exists())
                    .andExpect(jsonPath("$[0].code").exists())
                    .andExpect(jsonPath("$[0].rejectedValue").exists())
        ;
    }





}
