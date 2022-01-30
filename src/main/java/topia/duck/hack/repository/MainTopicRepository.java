package topia.duck.hack.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import topia.duck.hack.domain.MainTopic;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static topia.duck.hack.domain.QMainTopic.mainTopic;

@Repository
@RequiredArgsConstructor
public class MainTopicRepository {
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Transactional
    public List<MainTopic> getMainTopics(Long memberNo){
        return queryFactory.selectFrom(mainTopic)
                .where(mainTopic.member.memberNo.eq(memberNo))
                .orderBy(mainTopic.startDate.desc())
                .fetchAll()
                .fetch();
    }

    @Transactional
    public void createMainTopic(MainTopic entity){
        em.persist(entity);
    }

    @Transactional
    public void deleteMainTopic(Long mainNo) throws Exception{
        queryFactory.delete(mainTopic).where(mainTopic.mainNo.eq(mainNo)).execute();
    }

    @Transactional
    public MainTopic getMainTopic(Long mainNo){
        return queryFactory.selectFrom(mainTopic).where(mainTopic.mainNo.eq(mainNo)).fetchOne();
    }

    @Transactional
    public void putMainTopic(Long mainNo, String title, LocalDate startDate, LocalDate endDate) {
        MainTopic mainTopic = getMainTopic(mainNo);

        if(title!=null) mainTopic.setTitle(title);
        if(startDate!=null) mainTopic.setStartDate(startDate);
        if(endDate!=null) mainTopic.setEndDate(endDate);
    }
}
