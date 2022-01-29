package topia.duck.hack.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@DynamicInsert
@Data
@Table(name="MEMBER")
public class Member {
    @Id
    @Column(name="member_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(name="device_id")
    private String deviceId;
}
