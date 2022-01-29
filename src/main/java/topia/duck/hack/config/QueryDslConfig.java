package topia.duck.hack.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class QueryDslConfig {
    @Bean
    JPAQueryFactory JPAQuartFactory(EntityManager em) {
        return new JPAQueryFactory(em);
    }
}

