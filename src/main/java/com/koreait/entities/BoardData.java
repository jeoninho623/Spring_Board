package com.koreait.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor @AllArgsConstructor
public class BoardData extends BaseMember{
    @Id @GeneratedValue
    private long seq;   // 게시글 번호

    @Column(length = 100, nullable = false)
    private String title;   // 게시글 제목

    @Lob
    @Column(nullable = false)
    private String content; // 게시글 내용
}
