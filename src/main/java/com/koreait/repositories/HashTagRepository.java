package com.koreait.repositories;

import com.koreait.entities.HashTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HashTagRepository extends JpaRepository<HashTag, String> {
}
