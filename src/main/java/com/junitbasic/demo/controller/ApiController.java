package com.junitbasic.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junitbasic.demo.service.ApiService;

import lombok.NoArgsConstructor;

/**
 * Controllerクラス。
 */
@RestController
@NoArgsConstructor
@RequestMapping("api")
public class ApiController {

    @Autowired
    private ApiService apiService;

}
