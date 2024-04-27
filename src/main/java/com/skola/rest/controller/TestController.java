package com.skola.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/health")
public class TestController {

    @GetMapping()
    ResponseEntity<String> health() {
        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }


}
