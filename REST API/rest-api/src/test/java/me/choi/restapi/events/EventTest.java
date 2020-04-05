package me.choi.restapi.events;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : rest-api
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/14
 * Time : 10:14 오후
 */
public class EventTest {

    @Test
    public void builder() {
        Event event = Event.builder()
                .name("Inflearn Spring REST API")
                .description("Inflearn Spring REST API")
                .build();

        assertThat(event).isNotNull();
    }

    @Test
    public void javaBean() {
        //Given
        String name = "Event";
        String spring = "Spring";

        //When
        Event event = new Event();
        event.setName(name);
        event.setDescription("Spring");

        //Then
        assertThat(event.getName()).isEqualTo(name);
        assertThat(event.getDescription()).isEqualTo(spring);


    }

    @Test
    public void testFree() {
            //Given
            Event event = Event.builder()
                        .basePrice(0)
                        .maxPrice(0)
                        .build();
            //When
            event.update();

            //Then
            assertThat(event.isFree()).isTrue();

            //Given
            event = Event.builder()
                    .basePrice(100)
                    .maxPrice(0)
                    .build();
            //When
            event.update();

            //Then
            assertThat(event.isFree()).isFalse();

            //Given
            event = Event.builder()
                    .basePrice(0)
                    .maxPrice(100)
                    .build();
            //When
            event.update();

            //Then
            assertThat(event.isFree()).isFalse();
    }



}