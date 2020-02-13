package me.choi.demospring51;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * Project : demospring51
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 13/02/2020
 * Time : 11:32 오후
 */
@Repository
@Profile("!prod")
public class TestBookRepository implements BookRepository{
}
