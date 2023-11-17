package com.koreait.repositories;

import com.koreait.entities.BoardData;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BoardDateRepository extends JpaRepository<BoardData, Long>, QuerydslPredicateExecutor<BoardData> {

    List<BoardData> findByCreatedAtBetween(LocalDateTime sdate, LocalDateTime edate, Pageable pageable);

    List<BoardData> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);

    @Query("SELECT b FROM BoardData b WHERE b.title LIKE :key1 OR b.content LIKE :key2 ORDER BY b.seq DESC")
    List<BoardData> getList(@Param("key1") String title, @Param("key2") String content);
}
