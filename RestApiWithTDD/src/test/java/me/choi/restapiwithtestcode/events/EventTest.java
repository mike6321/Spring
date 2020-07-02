package me.choi.restapiwithtestcode.events;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : rest-api-with-testcode
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:27 오후
 */
class EventTest {

    @Test
    public void builder() {
        // TODO: [builder] junwoochoi 2020/05/12 11:34 오후
        // 빌더를 사용하면 내가 입력하는 값이 무엇인지 정확하게 알 수 있다.
        Event event = Event.builder()
                            .name("Spring Rest API")
                            .description("Rest API development with Spring")
                            .build();

        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        //Given
        String name = "Event";
        String description = "Spring";


        //When
        Event event = new Event();
        event.setName(name);
        event.setDescription("Spring");


        //Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(description);
    }

    @Test
    public void testFree() {
        //given
        Event event = Event.builder()
                            .basePrice(0)
                            .maxPrice(0)
                            .build()
        ;

        //when
        event.update();

        //then
        assertThat(event.isFree()).isTrue();

        //given
        event = Event.builder()
                    .basePrice(100)
                    .maxPrice(0)
                    .build()
        ;

        //when
        event.update();

        //then
        assertThat(event.isFree()).isFalse();

        //given
        event = Event.builder()
                    .basePrice(0)
                    .maxPrice(100)
                    .build()
        ;

        //when
        event.update();

        //then
        assertThat(event.isFree()).isFalse();

    }

    @Test
    public void testOffline() {
        //given
        Event event = Event.builder()
                .location("서울시 송파구")
                .build()
                ;

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isTrue();

        //given
         event = Event.builder()
                        .location("")
                        .build()
                        ;

        //when
        event.update();

        //then
        assertThat(event.isOffline()).isFalse();
    }

}