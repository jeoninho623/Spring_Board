package com.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class BoardData extends BaseMember {

    @Id
    @GeneratedValue
    private Long seq;

    @Column(length = 100, nullable = false)
    private String title;

    @Lob
    @Column(length = 100, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="userNo")
    private Member member;
}
