package com.junitbasic.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

/**
 * Serviceクラス。
 */
@Service
@NoArgsConstructor
public class ApiService {

    @Autowired
    private ApiServiceSub apiServiceSub;

    /**
    * sampleメソッド。
    *
    * @return 1
    */
    public String sample() {
        return "1";
    }

    /**
    * sampleWithSubメソッド。
    *
    * @return 1
    */
    public int sampleWithSub(int number1,int number2) {
        int result = apiServiceSub.plusTwoNumbers(number1, number2);
        int result2 = apiServiceSub.minusParameterNumber(result, 1);
        return result2;
    }

    /**
     * 引数を受け取ってその値に対して処理を行う。
     * @param number 判定対象の数字
     * @return 判定結果
     */
    public String sample2(int number) {
        if (number < 0) {
            return "負の数";
        } else if (number > 0) {
            return "正の数";
        }
        return "0";
    }

    /**
     * 引数を受け取ってその値に対して処理を行う。
     * @param firstNumber 判定対象の数字
     * @param secondNumber 判定対象の数字
     * @return 判定結果
     */
    public String sample3(int firstNumber,int secondNumber) {
        if (firstNumber == 0 && secondNumber == 0) {
            return "0";
        } 
        return "それ以外";
    }

}
