package me.aop.service;

/**
 * Project : demoapplicationcontextexercise
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/03/23
 * Time : 9:33 오후
 */
public class TransactionManager {

    public void commit() {
        System.out.println("commit 합니다...!");
    }

    public void rollback() {
        System.out.println("rollback 합니다...!");
    }

    public void startTransaction() {
        System.out.println("트랜잭션을 시작합니다...!");
    }
}
