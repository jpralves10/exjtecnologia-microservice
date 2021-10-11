package br.com.exj.cadastro.config.ff4j;

import org.ff4j.FF4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4JConfiguration {

    @Bean
    public FF4j getFF4j() {
        return new FF4j("ff4j-features.xml");
    }
}
