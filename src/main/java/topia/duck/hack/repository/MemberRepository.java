package topia.duck.hack.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import topia.duck.hack.domain.Member;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

import static topia.duck.hack.domain.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Transactional
    public Long save(Member entity){
        em.persist(entity);
        return entity.getMemberNo();
    }

    @Transactional
    public Optional<Member> getMemberNo(String deviceId){
        return queryFactory.selectFrom(member)
                .where(member.deviceId.eq(deviceId))
                .stream().findAny();
    }
}
