package com.hanghe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(value = "com.hanghe.controller.rest")
public class RestAdvise {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Object exception(Exception e){
        if(e instanceof IOException){
            log.error("rest controller IOException");
            return null;
        }
        Map<String, Object> returnMap = new HashMap<>();

        log.error("rest controller error ", e);

        returnMap.put("timestamp", LocalDateTime.now());
        returnMap.put("status", 500);
        returnMap.put("error", e.getClass()+"");
        returnMap.put("message", "오류 발생.\n잠시 후 시도해주세요");

        return returnMap;
    }

}
