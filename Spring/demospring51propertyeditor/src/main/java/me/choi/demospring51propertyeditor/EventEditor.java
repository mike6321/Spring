package me.choi.demospring51propertyeditor;

import java.beans.PropertyEditorSupport;

/*
* 문제점
* setValue
* getValue
*  이 값은 서로 다른 스테드에 공유가 된다.
*
* 이말은, 빈으로 등록하면 큰일난다는 말
* */
public class EventEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        Event event = (Event) getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new Event(Integer.parseInt(text)));

    }
}
