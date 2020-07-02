package me.choi.restapiwithtestcode.events;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Project : rest-api-with-testcode
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:24 오후
 */

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = {"id", "name"})
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
    private String location;
    private int basePrice;
    private int maxPrice;
    private int limitOfEnrollment;
    private boolean offline;
    private boolean free;
    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus = EventStatus.DRAFT;

    public void update() {

        if (this.basePrice == 0 && this.maxPrice == 0) {
            this.free = true;
        } else {
            this.free = false;
        }

        if (this.location == null || this.location.isBlank()) {
            this.offline = false;
        } else {
            this.offline = true;
        }
    }
}
