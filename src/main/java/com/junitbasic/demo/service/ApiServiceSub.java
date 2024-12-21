package com.junitbasic.demo.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Component;

@Component
public class ApiServiceSub {

    /**
    * plusTwoNumbersメソッド。
    *
    * @param number1 一つ目の数字
    * @param number2 一つ目の数字
    * @return 2数の和
    */
    public int plusTwoNumbers(int number1, int number2) {
        int calcResult = number1 + number2;
        return calcResult;
    }

    /**
    * minusParameterNumberメソッド。
    *
    * @param targetNumber 対象の数
    * @param minusNumber 減算する数字
    * @return 差の結果
    */
    public int minusParameterNumber(int targetNumber, int minusNumber) {
        int calcResult = targetNumber - minusNumber;
        return calcResult;
    }

    public InputStream readCsv(){
         // CSVデータを文字列で定義（エスケープ済み）
        String csvData = "\"123\",\"ABC\",\"令和080830\",\"あいうえお\"";

        // 文字列をバイト配列に変換
        byte[] byteArray = csvData.getBytes(StandardCharsets.UTF_8);
                // ByteArrayInputStreamを使用してInputStreamを作成
        InputStream inputStream = new ByteArrayInputStream(byteArray);
        return  inputStream;
    }

}
