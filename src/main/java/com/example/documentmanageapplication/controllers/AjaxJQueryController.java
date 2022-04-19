package com.example.documentmanageapplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class AjaxJQueryController {
    @GetMapping("/demoGetAjaxJquery")
    public String demoGetAjaxJquery(){
        return "result1";
    }

    @PostMapping("/demoPostAjaxJquery")
    public ResponseEntity demoPostAjaxJquery(String pa1, String pa2){
        System.out.println("Data is sent : " + pa1 + " : " + pa2);
        String returnName = pa1 + pa2 + " Tung!";
        return ResponseEntity.status(500).body( returnName);
    }
}
