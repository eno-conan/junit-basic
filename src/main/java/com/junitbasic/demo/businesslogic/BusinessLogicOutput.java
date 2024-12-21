package com.junitbasic.demo.businesslogic;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BusinessLogicOutput {

    /** 結果ステータス */
    private String resultStatus;

    /** エラーメッセージ */
    private String errorMessage;

    /** 詳細 */
    private List<BusinessLogicOutputDetail> detailList;
    
}
