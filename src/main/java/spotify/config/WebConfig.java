package spotify.config;

import org.jtwig.spring.JtwigViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public ViewResolver viewResolver() {
    JtwigViewResolver jtwigViewResolver = new JtwigViewResolver();
    jtwigViewResolver.setPrefix("classpath:templates/");
    jtwigViewResolver.setSuffix(".twig");
    return jtwigViewResolver;
  }

}
