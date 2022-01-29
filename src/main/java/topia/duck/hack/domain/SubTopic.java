package topia.duck.hack.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@DynamicInsert
@Data
@Table(name="SUB_TOPIC")
public class SubTopic {
    @Id
    @Column(name="sub_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subNo;

    @Column(name="title", columnDefinition = "TEXT")
    private String title;

    @Column(name="plan_dt")
    private LocalDateTime planDt;

    @Column(name="description")
    private String description;

    @Column(name="is_complete")
    private boolean isComplete;

    @Column(name="latitude")
    private double latitude;

    @Column(name="longitude")
    private double longitude;

    @Column(name="address")
    private String address;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="main_no")
    private MainTopic mainTopic;
}
