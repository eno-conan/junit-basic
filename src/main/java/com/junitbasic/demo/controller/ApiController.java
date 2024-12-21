package com.junitbasic.demo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.junitbasic.demo.service.ApiService;

import lombok.NoArgsConstructor;

/**
 * Controllerクラス。
 */
@RestController
@NoArgsConstructor
@RequestMapping("api")
public class ApiController {

    @PostMapping("custom-validator")
    public String customValidator(@ModelAttribute("ApiForm") @Validated ApiForm form, BindingResult result) {

        if (result.hasErrors()) {
            result.getAllErrors().forEach(e -> System.out.println(e.getDefaultMessage()));
            return "NG";
        }
        return "OK";
    }

}
