package com.junitbasic.demo.businesslogic;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BusinessLogicOutput {

    /** 結果ステータス */
    private String resultStatus;

    /** エラーメッセージ */
    private String errorMessage;

    /** 詳細 */
    private List<BusinessLogicOutputDetail> detailList;
    
}
