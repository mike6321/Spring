package me.choi.restapi.events;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Project : rest-api
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/15
 * Time : 5:08 오후
 */
@Component
public class EventValidator {
    public void validate(EventDto eventDto, Errors errors) {
        // TODO: [validate] junwoochoi 2020/03/15 5:10 오후
        // base값이 맥스 갑보다 클때 (max 값이 0이 아닌경우 - 무제한 경매가 아닌경우
        if (eventDto.getMaxPrice() < eventDto.getBasePrice() && eventDto.getMaxPrice() != 0) {
            errors.rejectValue("basePrice", "WrongValue", "BasePrice is bigger than MaxPrice");
        }

        LocalDateTime endEventDateTime = eventDto.getEndEventDateTime();
        if (endEventDateTime.isBefore(eventDto.getBeginEventDateTime())
            || endEventDateTime.isBefore(eventDto.getCloseEnrollmentDateTime())
            || endEventDateTime.isBefore(eventDto.getBeginEnrollmentDateTime())) {
                errors.rejectValue("endEventDateTime", "wrong Value");
                errors.reject("Wrong Prices", "value for Wrong Prices");
        }
    }
}
