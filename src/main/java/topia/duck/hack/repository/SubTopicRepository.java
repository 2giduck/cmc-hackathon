package topia.duck.hack.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import topia.duck.hack.domain.MainTopic;
import topia.duck.hack.domain.QSubTopic;
import topia.duck.hack.domain.SubTopic;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @Transactional
    public List<SubTopic> getSubTopics(Long mainNo, LocalDate date){
        return queryFactory.selectFrom(subTopic)
                .where(subTopic.mainTopic.mainNo.eq(mainNo), subTopic.planDt.between(
                        date.atStartOfDay(),
                        LocalDateTime.of(date, LocalTime.MAX).withNano(0)
                ))
                .fetchAll()
                .fetch();
    }

    @Transactional
    public void createSubTopic(SubTopic subTopic) throws Exception{
        em.persist(subTopic);
    }

    @Transactional
    public void changeStatus(Long subNo, boolean isComplete) throws Exception{
        queryFactory.update(subTopic)
                .set(subTopic.isComplete, isComplete)
                .where(subTopic.subNo.eq(subNo))
                .execute();
    }
}
