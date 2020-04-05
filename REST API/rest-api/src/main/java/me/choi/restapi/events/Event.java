package me.choi.restapi.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Project : rest-api
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/14
 * Time : 10:10 오후
 */
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter  @Setter @EqualsAndHashCode(of = "id")
@Entity
public class Event {

    @Id @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime beginEnrollmentDateTime;
    private LocalDateTime closeEnrollmentDateTime;
    private LocalDateTime beginEventDateTime;
    private LocalDateTime endEventDateTime;
    private String location;    // (optional) 이게 없으면 온라인 모임
    private int basePrice;     // (optional)
    private int maxPrice;      // (optional)
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)
    private EventStaus eventStaus = EventStaus.DRAFT;

    public void update() {

        this.free = this.basePrice == 0 && this.maxPrice == 0;
    }
}
