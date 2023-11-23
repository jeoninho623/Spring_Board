package com.koreait.models.board.config;

import com.koreait.commons.Utils;
import com.koreait.commons.exceptions.AlertBackException;
import org.springframework.http.HttpStatus;

public class BoardNotFoundException extends AlertBackException {
    public BoardNotFoundException() {
        super(Utils.getMessage("NotFound.board", "error"));
        setStatus(HttpStatus.NOT_FOUND);
    }
}
