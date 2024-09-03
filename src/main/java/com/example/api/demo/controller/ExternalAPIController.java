package com.example.api.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.demo.service.ExternalAPiService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/v2/")
public class ExternalAPIController {

    @Autowired
    private ExternalAPiService externalAPiService;

    @GetMapping("all/")
    public String getAllData() {
        return externalAPiService.getAllData();
    }
    
}
