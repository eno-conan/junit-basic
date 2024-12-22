package com.junitbasic.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SampleResult {
    /** 契約番号 */
    private String contractNumber;

    /** 契約名 */
    private String contractName;

    /** 契約種別 */
    private String contractType;

    /** 契約期間 */
    private String contractPeriod;

    /** 契約金額 */
    private String contractAmount;

    /** 契約日 */
    private String contractDate;

    /** 契約者 */
    private String contractOwner;

    /** 契約内容 */
    private String contractContent;

    /** 契約状態 */
    private String contractStatus;

    /** 契約備考 */
    private String contractRemarks;
}
