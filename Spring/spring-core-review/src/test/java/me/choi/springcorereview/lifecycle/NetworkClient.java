package me.choi.springcorereview.lifecycle;

import org.junit.jupiter.api.Test;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:18 오전
 */
// TODO: 빈의 생명주기  
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url " + url);
        connect();
        call("초기화 연결 메세지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect " + url);
    }

    public void call(String message) {
        System.out.println("call " + url + "message = " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close" + url);
    }
}
