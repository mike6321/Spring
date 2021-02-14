package me.choi.springcorereview.requestscope.web;

import lombok.RequiredArgsConstructor;
import me.choi.springcorereview.requestscope.common.MyLogger;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 3:44 오후
 */
@Service
@RequiredArgsConstructor
public class LogDemoService {

//    private final MyLogger myLogger;
    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    public void logic(String testId) {
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("service id = " + testId);
    }
}
