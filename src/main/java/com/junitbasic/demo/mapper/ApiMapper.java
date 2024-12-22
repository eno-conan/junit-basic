package com.junitbasic.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.junitbasic.demo.dto.SampleCondition;
import com.junitbasic.demo.dto.SampleResult;

@Component
public class ApiMapper {

    public List<SampleResult> getSampleDataByCondtion(SampleCondition condition) {
        List<SampleResult> resultList = new ArrayList<>();
        SampleResult result = new SampleResult();
        result.setContractNumber(condition.getContractNumber());
        result.setContractStatus(condition.getContractStatus());
        result.setContractAmount("67890");
        resultList.add(result);
        return resultList;
    }
    
}
