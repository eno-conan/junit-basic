package com.junitbasic.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Serviceのテストクラス。
 */
// mvn clean jacoco:prepare-agent test jacoco:report
@SpringBootTest
class ApiServiceTest {

    @Autowired
    private ApiService apiService;

    @Test
    void successSample(){
        String actual = apiService.sample();
        assertEquals("1", actual);
    }

    @Test
    void successSample2JudgeMinus(){
        String actual = apiService.sample2(-1);
        assertEquals("負の数", actual);
    }
    @Test
    void successSample2JudgePlus(){
        String actual = apiService.sample2(1);
        assertEquals("正の数", actual);
    }
    @Test
    void successSampleJudge0(){
        String actual = apiService.sample2(0);
        assertEquals("0", actual);
    }

}
