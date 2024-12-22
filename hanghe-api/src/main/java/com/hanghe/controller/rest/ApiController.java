package com.hanghe.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "")
@RestController
@RequiredArgsConstructor
public class ApiController {

    @GetMapping("/health")
    public String healthCheck(){
        return "health Check";
    }

    @GetMapping("")
    public String main(){
        return "항해 사전스터디 API";
    }

}
