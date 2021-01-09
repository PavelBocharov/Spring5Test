package com.mar.spring.five.test.conf;

import com.mar.spring.five.test.service.HelloService;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class AppConfiguration {

    @Value("${defaultUser.login}")
    private String defaultUserLogin;

    @Bean
    public HelloService helloService() {
        return new HelloService(defaultUserLogin);
    }

    @Bean
    public CacheManager ehCacheManager() {
        return ehCacheCacheManager().getObject();
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheCacheManager() {
        EhCacheManagerFactoryBean cmfb = new EhCacheManagerFactoryBean();
        cmfb.setConfigLocation(new ClassPathResource("ehcache.xml"));
        cmfb.setShared(true);
        return cmfb;
    }


    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Spring 5. Test REST API.")
                                .version("1.6.пофиг")
                                .contact(new Contact()
                                        .name("Marolok")
                                        .email("marolok@mail.ru")
                                        .url("https://twitter.com/MarolokPavel")
                                )
                );
    }

}
