package topia.duck.hack.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DynamicInsert
@Data
@Table(name="MAIN_TOPIC")
public class MainTopic {
    @Id
    @Column(name="main_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mainNo;

    @Column(name="title", columnDefinition = "TEXT")
    private String title;

    @Column(name="start_date")
    private LocalDate startDate;

    @Column(name="end_date")
    private LocalDate endDate;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_no")
    private Member member;
}
