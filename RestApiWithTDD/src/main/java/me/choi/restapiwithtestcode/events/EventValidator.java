package me.choi.restapiwithtestcode.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import java.time.LocalDateTime;

/**
 * Project : rest-api-with-testcode
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 5:44 오후
 */
@Component
public class EventValidator {

    public void validate(EventDto eventDto, Errors errors) {

        // TODO: [validate] junwoochoi 2020/07/02 5:47 오후
        // 무제한 경매가 아닌 maxPrice가 0이 아닌 경우
        if (eventDto.getBasePrice() > eventDto.getMaxPrice() && eventDto.getMaxPrice() != 0) {
            errors.rejectValue("basePrice", "wrongValue", "basePrice is WrongValue");
            errors.rejectValue("maxPrice", "wrongValue", "maxPrice is WrongValue");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if (endEventDateTime.isBefore(eventDto.getEndEventDateTime())
        || endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime())
        || endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
            errors.rejectValue("endEventDateTime", "wrongValue", "endEventDateTime is wrongValue");
        }
    }
}



