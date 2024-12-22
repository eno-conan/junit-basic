package com.junitbasic.demo.businesslogic;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junitbasic.demo.dto.SampleCondition;
import com.junitbasic.demo.dto.SampleResult;
import com.junitbasic.demo.exception.ApplicationException;
import com.junitbasic.demo.generic.Person;
import com.junitbasic.demo.generic.Storage;
import com.junitbasic.demo.mapper.ApiMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BusinessLogic {

    private final ApiMapper apiMapper;

    /**
    * sampleメソッド。
    *
    * @return 1
    */
    public BusinessLogicOutput logic(BusinessLogicInput input) {

        // 相関チェック実施
        if (input.getContractNumber() == null || input.getContractNumberBranch() == null) {
            throw new ApplicationException("契約番号と契約番号枝番は必須です。");
        }

        if (input.getContractNumber().length() != 10 || input.getContractNumberBranch().length() != 3) {
            throw new ApplicationException("契約番号は10桁、契約番号枝番は3桁で入力してください。");
        }

        // 処理結果クラスのインスタンスを生成
        BusinessLogicOutput output = new BusinessLogicOutput();
        if (input.getContractUpdatePlanDate() != null && input.getContractUpdateReason() == null) {
            output.setErrorMessage("契約更新日付を入力した場合は、契約更新理由を入力してください。");
            output.setResultStatus("NG");
            return output;
        }

        // DBから契約の詳細を取得
        SampleCondition condition = new SampleCondition();
        condition.setContractNumber(input.getContractNumber());
        condition.setContractStatus(input.getContractStatus());
        List<SampleResult> resultList = apiMapper.getSampleDataByCondtion(condition);
        output.setResultStatus("OK");
        return output;
    }

    public String generics() {
        // GenericsクラスでPersonを使用
        Storage<Person> personStorage = new Storage<>();
        personStorage.initialize(new Person("Alice", 30));
        String result = personStorage.describe();
        // personStorage.clear();
        return result;
    }
}
