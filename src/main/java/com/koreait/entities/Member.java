package com.koreait.entities;

import com.koreait.commons.constants.MemberType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
@Table(indexes = {
        @Index(name="idx_member_userNm", columnList="userNm"),
        @Index(name="idx_member_mobile", columnList="mobile")
})
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO) // 그럼 뭐하러 쓴거죠 이거는.
    private Long userNo;

    @Column(length = 65, unique = true, nullable = false)        // primary key
    private String email;

    @Column(length = 65, name = "PW", nullable = false)
    private String password;

    @Column(length = 40, nullable = false)
    private String userNm;

    @Column(length = 11)
    private String mobile;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberType mtype = MemberType.USER;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime regDt;

    @Column(insertable = false)
    @UpdateTimestamp
    private LocalDateTime modDt;

    /*@Transient
    private String tmpData;*/

    /*
    @Temporal()
    private Date date;

    */
}
