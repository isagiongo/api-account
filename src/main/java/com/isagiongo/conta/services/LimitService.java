package com.isagiongo.conta.services;

import com.isagiongo.conta.entities.LimitCreateRequest;
import com.isagiongo.conta.entities.LimitCreateResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LimitService {

    private final RestTemplate restTemplate;

    public LimitService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createLimit(String id) {

        LimitCreateRequest request = new LimitCreateRequest(id);
        restTemplate.postForEntity("http://localhost:8080/api/account-limit",
                request, LimitCreateResponse.class);
    }
}
