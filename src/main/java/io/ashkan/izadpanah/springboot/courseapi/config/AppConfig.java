package io.ashkan.izadpanah.springboot.courseapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig  {
	
	@Autowired
    private Environment env;
	
	@Bean
    public WebMvcConfigurer corsConfigurer() 
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	String serverPort = env.getProperty("server.port");//8080 development , 8089 production
            	String allowedOrigins = "8089".equals(serverPort) ? "http://localhost:9090" : "*";// allow postman in development		
                registry.addMapping("/**").allowedOrigins(allowedOrigins);
                		//.allowedOrigins("http://localhost:4200", "http://localhost:9090");
            }
        };
    }
	

}
