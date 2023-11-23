package com.koreait.entities;

import com.koreait.commons.constants.BoardAuthority;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Board extends BaseMember {
    @Id
    @Column(length = 30)
    private String bId;     // 게시판 아이디

    @Column(length = 20, nullable = false)
    private String bName;       // 게시판 이름

    private boolean active;     // 노출 설정

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private BoardAuthority authority = BoardAuthority.ALL;       // 권한 , 기본값 ALL

    @Lob
    private String category;
}