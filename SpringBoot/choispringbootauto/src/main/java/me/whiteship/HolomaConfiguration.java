package me.whiteship;

import org.springframework.context.annotation.Bean;

public class HolomaConfiguration {

    @Bean
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setName("choi");
        holoman.setNumber(5);

        return holoman;
    }

}
