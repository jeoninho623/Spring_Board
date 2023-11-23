package com.koreait.models.board.config;

import com.koreait.commons.constants.BoardAuthority;
import com.koreait.controllers.admins.BoardConfigForm;
import com.koreait.entities.Board;
import com.koreait.repositories.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class BoardConfigSaveService {
    private final BoardRepository boardRepository;

    public void save(BoardConfigForm form) {

        String bId = form.getBId();
        String mode = form.getMode();
        Board board = null;
        if (mode.equals("edit") && StringUtils.hasText(bId)) {
            board = boardRepository.findById(bId).orElseThrow(BoardNotFoundException::new);
        } else { // 추가
            board = new Board();
            board.setBId(bId);
        }

        board.setBName(form.getBName());
        board.setActive(form.isActive());
        board.setAuthority(BoardAuthority.valueOf(form.getAuthority()));
        board.setCategory(form.getCategory());

        boardRepository.saveAndFlush(board);
    }
}