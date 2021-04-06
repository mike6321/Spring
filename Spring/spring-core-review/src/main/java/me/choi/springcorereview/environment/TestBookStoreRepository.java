package me.choi.springcorereview.environment;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * Project : spring-core-review
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 1:24 오전
 */
@Repository
@Profile("test")
public class TestBookStoreRepository implements BookStoreRepository{
    // TODO: class에 profile을 정의하는 방법 2021/04/07 1:27 오전
}
