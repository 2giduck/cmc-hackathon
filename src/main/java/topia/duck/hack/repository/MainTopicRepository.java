package topia.duck.hack.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class MainTopicRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

}
