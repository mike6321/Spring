package me.choi.restapiwithtestcode.events;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.choi.restapiwithtestcode.common.RestDocsConfiguration;
import me.choi.restapiwithtestcode.common.TestDescription;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.restdocs.headers.HeaderDocumentation.*;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
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
@AutoConfigureRestDocs
@Import(RestDocsConfiguration.class)
@ActiveProfiles("test")
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
                    .location("GangNam Startup D2 Factory")
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
                        //.andExpect(jsonPath("id").value(Matchers.not(100)))
                        //.andExpect(jsonPath("free").value(Matchers.not(true)))
                        .andExpect(jsonPath("free").value(false))
                        .andExpect(jsonPath("offline").value(true))
                        .andExpect(jsonPath("eventStatus").value(EventStatus.DRAFT.name()))


                        .andDo(document("create-event",
                                links(
                                        linkWithRel("self").description("link to self"),
                                        linkWithRel("query-events").description("link to query events"),
                                        linkWithRel("update-event").description("link to update an existing events"),
                                        linkWithRel("profile").description("link to profile")
                                    ),
                                requestHeaders(
                                        headerWithName(HttpHeaders.ACCEPT).description("accept header"),
                                        headerWithName(HttpHeaders.CONTENT_TYPE).description("content type header")
                                ),
                                requestFields(
                                        fieldWithPath("name").description("Name of new Event"),
                                        fieldWithPath("description").description("description of new Event"),
                                        fieldWithPath("beginEnrollmentDateTime").description("date time of begin of Event"),
                                        fieldWithPath("closeEnrollmentDateTime").description("date time of close of Event"),
                                        fieldWithPath("beginEventDateTime").description("date time of begin of Event"),
                                        fieldWithPath("endEventDateTime").description("date time of end of Event"),
                                        fieldWithPath("location").description("location of new Event"),
                                        fieldWithPath("basePrice").description("basePrice of new Event"),
                                        fieldWithPath("maxPrice").description("maxPrice of new Event"),
                                        fieldWithPath("limitOfEnrollment").description("limitOfEnrollment of new Event")
                                ),
                                responseHeaders(
                                        headerWithName(HttpHeaders.LOCATION).description("LOCATION header"),
                                        headerWithName(HttpHeaders.CONTENT_TYPE).description("Content type")
                                ),
                                responseFields(
                                        fieldWithPath("id").description("id of new Event"),
                                        fieldWithPath("name").description("Name of new Event"),
                                        fieldWithPath("description").description("description of new Event"),
                                        fieldWithPath("beginEnrollmentDateTime").description("date time of begin of Event"),
                                        fieldWithPath("closeEnrollmentDateTime").description("date time of close of Event"),
                                        fieldWithPath("beginEventDateTime").description("date time of begin of Event"),
                                        fieldWithPath("endEventDateTime").description("date time of end of Event"),
                                        fieldWithPath("location").description("location of new Event"),
                                        fieldWithPath("basePrice").description("basePrice of new Event"),
                                        fieldWithPath("maxPrice").description("maxPrice of new Event"),
                                        fieldWithPath("limitOfEnrollment").description("limitOfEnrollment of new Event"),
                                        fieldWithPath("free").description("free of new Event"),
                                        fieldWithPath("offline").description("offline of new Event"),
                                        fieldWithPath("eventStatus").description("event Status of new Event"),
                                        fieldWithPath("_links.self.href").description("link to self"),

                                        fieldWithPath("_links.query-events.href").description("link to query-events"),
                                        fieldWithPath("_links.update-event.href").description("link to update-event"),
                                        fieldWithPath("_links.profile.href").description("link to profile")



                                )
                        ));
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
                    .andExpect(jsonPath("content[0].objectName").exists())
                    //.andExpect(jsonPath("$[0].field").exists())
                    .andExpect(jsonPath("content[0].defaultMessage").exists())
                    .andExpect(jsonPath("content[0].code").exists())
                    .andExpect(jsonPath("_links.index").exists())
        ;
    }
}
