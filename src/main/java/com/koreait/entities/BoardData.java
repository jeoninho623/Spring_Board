package com.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name="userNo")
    private Member member;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<HashTag> tags = new ArrayList<>();

}
