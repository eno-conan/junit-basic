package com.junitbasic.demo.businesslogic;

import lombok.Data;

/**
 * BusinessLogicに渡すInput情報を定義するクラス。
 */
@Data
public class BusinessLogicInput {

    /** ユーザ名 */
    private String userName;

    /** パスワード */
    private String password;

    /** メールアドレス */
    private String mailAddress;

    /** 契約番号 */
    private String contractNumber;

    /** 契約番号枝番 */
    private String contractNumberBranch;

    /** 契約種別 */
    private String contractType;

    /** 契約状態 */
    private String contractStatus;

    /** 契約開始日 */
    private String contractStartDate;

    /** 契約終了日 */
    private String contractEndDate;

    /** 契約更新予定日 */
    private String contractUpdatePlanDate;

    /** 契約更新理由 */
    private String contractUpdateReason;

}
