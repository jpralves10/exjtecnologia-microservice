package br.com.exj.cadastro.config.ff4j;

import org.ff4j.FF4j;
import org.ff4j.web.FF4jDispatcherServlet;
import org.ff4j.web.embedded.ConsoleServlet;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({ConsoleServlet.class, FF4jDispatcherServlet.class})
@AutoConfigureAfter(FF4JConfiguration.class)
@SuppressWarnings({"unchecked", "rawtypes"})
public class FF4JWebConfiguration {

    @Bean
    public ServletRegistrationBean servletRegistrationBean(ConsoleServlet ff4jConsoleServlet){
        ServletRegistrationBean bean = new ServletRegistrationBean(ff4jConsoleServlet, "/ff4j-console");
        return bean;
    }

    @Bean
    @ConditionalOnMissingBean
    public ConsoleServlet getFF4jServlet(FF4j ff4j){
        ConsoleCustomServlet ff4jConsoleServlet = new ConsoleCustomServlet();
        ff4jConsoleServlet.setFf4j(ff4j);
        return ff4jConsoleServlet;
    }

    @Bean
    public ServletRegistrationBean ff4jDispatcherServletRegistrationBean(FF4jDispatcherServlet ff4jDispatcherServlet){
        ServletRegistrationBean bean = new ServletRegistrationBean(ff4jDispatcherServlet, "/ff4j-web-console/*");
        return bean;
    }

    @Bean
    @ConditionalOnMissingBean
    public FF4jDispatcherServlet getFF4jDispatcherServlet(FF4j ff4j){
        FF4jDispatcherServlet ff4jConsoleServlet = new FF4jDispatcherServlet();
        ff4jConsoleServlet.setFf4j(ff4j);
        return ff4jConsoleServlet;
    }
}
