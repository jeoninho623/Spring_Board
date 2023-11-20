package com.koreait.jpaex;

import com.koreait.commons.constants.MemberType;
import com.koreait.entities.BoardData;
import com.koreait.entities.Member;
import com.koreait.repositories.BoardDataRepository;
import com.koreait.repositories.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex02 {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BoardDataRepository boardDataRepository;

    @PersistenceContext
    private EntityManager em;

    @BeforeEach
    void init() {
        Member member = Member.builder()
                .email("user01@test.org")
                .password("12345678")
                .userNm("사용자01")
                .mtype(MemberType.USER)
                .mobile("01000000000")
                .build();

        memberRepository.saveAndFlush(member);

        List<BoardData> items = new ArrayList<>();

        for(int i = 1; i <= 10; i++) {
            BoardData item = BoardData.builder()
                    .title("제목" + i)
                    .content("내용"+ i)
                    .member(member)
                    .build();

            items.add(item);
        }

        boardDataRepository.saveAllAndFlush(items);
        em.clear();
    }

    @Test
    void test1() {
        List<BoardData> items = boardDataRepository.findAll();      // 10개  // 1차 쿼리
        for (BoardData item : items) {
            Member member = item.getMember();
            String email = member.getEmail();       // 2차 쿼리
            System.out.println(email);
        }
    }

    @Test
    void test2() {
        List<BoardData> items = boardDataRepository.getList2();

    }
}