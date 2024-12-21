package com.junitbasic.demo.businesslogic;

import org.springframework.stereotype.Service;

import com.junitbasic.demo.exception.ApplicationException;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class BusinessLogic {

    /**
    * sampleメソッド。
    *
    * @return 1
    */
    public BusinessLogicOutput logic1(BusinessLogicInput input) {

        // 相関チェック実施
        if (input.getContractNumber() != null && input.getContractNumberBranch() != null) {
            if (input.getContractNumber().length() != 10 || input.getContractNumberBranch().length() != 3) {
                throw new ApplicationException("契約番号は10桁、契約番号枝番は3桁で入力してください。");
            }
        }

        BusinessLogicOutput output = new BusinessLogicOutput();
        if(input.getContractUpdatePlanDate() != null && input.getContractUpdateReason() == null){
            output.setErrorMessage("契約更新日付を入力した場合は、契約更新理由を入力してください。");
            output.setResultStatus("NG");
            return output;
        }

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
