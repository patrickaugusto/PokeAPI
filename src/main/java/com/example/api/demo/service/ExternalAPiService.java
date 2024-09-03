package com.example.api.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAPiService {
    private final String url = "https://api.kanye.rest";

    @Autowired
    private RestTemplate restTemplate;

    public String getAllData(){
        return restTemplate.getForObject(this.url, String.class);
    }
}
