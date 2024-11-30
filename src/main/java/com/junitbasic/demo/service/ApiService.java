package com.junitbasic.demo.service;

import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;

/**
 * Serviceクラス。
 */
@Service
@NoArgsConstructor
public class ApiService {

    /**
    * sampleメソッド。
    *
    * @return 1
    */
    public String sample() {
        return "1";
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

}
