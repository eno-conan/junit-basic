package com.junitbasic.demo.businesslogic;

import lombok.AllArgsConstructor;
import lombok.Data;

// カスタムクラス
@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "名前は" + name + "で、年齢は" + age + "歳です";
    }
}
