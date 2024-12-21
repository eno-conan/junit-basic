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
    public String logic1(BusinessLogicInput input) {

        // 相関チェック実施
        if (input.getContractNumber() != null && input.getContractNumberBranch() != null) {
            if (input.getContractNumber().length() != 10 || input.getContractNumberBranch().length() != 3) {
                throw new ApplicationException("契約番号は10桁、契約番号枝番は3桁で入力してください。");
            }
        }

        return "1";
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
