package topia.duck.hack.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import topia.duck.hack.domain.MainTopic;
import topia.duck.hack.domain.QSubTopic;
import topia.duck.hack.domain.SubTopic;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static topia.duck.hack.domain.QSubTopic.subTopic;

@Repository
@RequiredArgsConstructor
public class SubTopicRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Transactional
    public List<LocalDateTime> getPlanDtsByMainNo(Long mainNo){
        return queryFactory.select(subTopic.planDt)
                .from(subTopic)
                .where(subTopic.mainTopic.mainNo.eq(mainNo))
                .fetchAll()
                .fetch();
    }
}
