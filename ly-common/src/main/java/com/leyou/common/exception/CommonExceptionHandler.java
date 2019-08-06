package com.leyou.common.exception;

import com.leyou.common.expojo.ExceptionResult;
import com.leyou.common.myexception.LyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author tianwenwen
 * @date 2019/8/3 23:00
 **/
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(LyException.class)
    public ResponseEntity<ExceptionResult> handlerException(LyException e) {
        return ResponseEntity.status(e.getExceptionEnums().getCode()).
                body(new ExceptionResult(e.getExceptionEnums()));
    }
}
