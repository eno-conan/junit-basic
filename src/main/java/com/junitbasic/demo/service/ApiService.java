package com.junitbasic.demo.service;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public int sampleWithSub(int number1, int number2) {
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
    public String sample3(int firstNumber, int secondNumber) {
        if (firstNumber == 0 && secondNumber == 0) {
            return "0";
        }
        return "それ以外";
    }

        /**
    * csvメソッド。
    *
    * @return 1
    */
    public List<String> csv() {
        // ByteArrayInputStreamを使用してInputStreamを作成
        InputStream inputStream = apiServiceSub.readCsv();
        // InputStreamを読み取り、カンマ区切りの配列に変換する
        List<String> csvFields = new ArrayList<>();
        // try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8.name())) {
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                // 行を読み取る
                String line = scanner.nextLine();
                // カンマ区切りでフィールドに分割し、配列として保持
                String[] fields = line.split("\",\"");
                for (int i = 0; i < fields.length; i++) {
                    // ダブルクォートを除去
                    fields[i] = fields[i].replaceAll("^\"|\"$", "");
                    csvFields.add(fields[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String finalAnswer = "";
        if ("令和080830".equals(csvFields.get(2))) {
            finalAnswer = csvFields.get(3);
        }else{
            csvFields.add(finalAnswer);
        }
        return csvFields;
    }

}
