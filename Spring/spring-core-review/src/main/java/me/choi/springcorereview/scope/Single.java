package me.choi.springcorereview.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:36 오전
 */

@Component
public class Single {

    @Autowired
    private Proto proto;

    public Proto getProto() {
        return proto;
    }
}
