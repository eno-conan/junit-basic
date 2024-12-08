package com.junitbasic.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

/**
 * Serviceのテストクラス。
 */
@SpringBootTest
class ApiServiceTest {

    @Autowired
    private ApiService apiService;

    // @MockBean
    // @MockitoBean
    // private ApiServiceSub apiServiceSub;

    @MockitoSpyBean
    private ApiServiceSub apiServiceSub;

    @Test
    void successSample() {
        String actual = apiService.sample();
        assertEquals("1", actual);
    }

    @Test
    void successSampleWithSubMocking() {
        // ApiServiceで呼び出す関数全体に対してMock化（apiServiceSubの処理は無視）
        when(apiService.sampleWithSub(anyInt(), anyInt())).thenReturn(2);
        int actual = apiService.sampleWithSub(1, 2);
        assertEquals(2, actual);
    }

    @Test
    void successSampleWithSubUsingSpy() {
        // ApiServiceから呼び出すSubクラスの特定処理のみMock化
        when(apiServiceSub.plusTwoNumbers(anyInt(), anyInt())).thenReturn(3);//plusTwoNumbersはMock化
        // minusParameterNumberは実際の処理を実行
        int actual = apiService.sampleWithSub(1, 2);
        assertEquals(2, actual);
    }

    @Test
    void successSample2_JudgeMinus() {
        String actual = apiService.sample2(-1);
        assertEquals("負の数", actual);
    }

    @Test
    void successSample2_JudgePlus() {
        String actual = apiService.sample2(1);
        assertEquals("正の数", actual);
    }

    @Test
    void successSample2_Judge0() {
        String actual = apiService.sample2(0);
        assertEquals("0", actual);
    }

    @Test
    void successSample3_Judge0() {
        String actual = apiService.sample3(0, 0);
        assertEquals("0", actual);
    }

    @Test
    void successSample3_JudgeElse() {
        String actual = apiService.sample3(1, 0);
        assertEquals("それ以外", actual);
    }

}
