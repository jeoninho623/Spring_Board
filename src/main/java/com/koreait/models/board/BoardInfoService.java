package com.koreait.models.board;

import com.koreait.entities.BoardData;
import com.koreait.repositories.BoardDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardInfoService {

    private final BoardDataRepository boardDataRepository;

    public BoardData get(Long seq) {
        BoardData data = boardDataRepository.findById(seq).orElseThrow(BoardDataNotFoundException::new);

        return data;
    }
}
