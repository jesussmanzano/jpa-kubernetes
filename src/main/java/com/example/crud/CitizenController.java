package com.example.crud;

import com.example.crud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jpa")
public class CitizenController {

    @Autowired
    private OrderService service;


}
