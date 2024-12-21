package com.junitbasic.demo.controller;

import com.junitbasic.demo.validator.ValidEnum;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiForm {

    @NotEmpty(message = "名前は必須です。")
    private String name;
    
    @NotEmpty(message = "年齢は必須です。")
    private String age;
    
    @ValidEnum
    private String contractType;
}
