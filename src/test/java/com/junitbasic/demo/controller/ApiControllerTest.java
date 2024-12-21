package com.junitbasic.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

import com.junitbasic.demo.exception.ApplicationException;
// import com.junitbasic.demo.service.ApiService;

@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    private static final String ROOT_PATH = "/api";

    @Autowired
    private MockMvc mockMvc;

    /**
    * /custom-validator：正常系<br/>
    *
    * @throws Exception
    */
    @Test
    void customValidatorEndpoint() throws Exception {
        ApiForm form = new ApiForm();
        form.setName("name");
        form.setAge("12");
        form.setContractType("01");
        String[] layers = { "custom-validator" };
        mockMvc.perform(post(composeUrl(layers))
                .flashAttr("ApiForm", form))
                .andExpect(status().isOk())
                .andExpect(content().string("OK"));
    }

    /**
    * /custom-validator：異常系<br/>
    *
    * @throws Exception
    */
    @Test
    void customValidatorEndpoint_nameIsEmpty() throws Exception {
        ApiForm form = new ApiForm();
        form.setAge("12");
        form.setContractType("01");
        String[] layers = { "custom-validator" };
        mockMvc.perform(post(composeUrl(layers))
                .flashAttr("ApiForm", form))
                .andExpect(status().isOk())
                .andExpect(content().string("NG"));
    }

    /**
    * UriComponentsBuilderを用いて、Uriを構成。 複数階層に対応できる形にしよう。
    *
    * @param firstLayer 第1階層の値
    * @return Uri
    * @throws ApplicationException
    */
    private String composeUrl(String[] layers) {
        if (layers.length <= 0) {
            throw new ApplicationException("パスの値が設定されていません。");
        }
        String finalPath = ROOT_PATH;
        for (String layer : layers) {
            String tempUri = UriComponentsBuilder.fromPath(finalPath).pathSegment(layer).toUriString();
            finalPath = tempUri;
        }
        return finalPath;
    }

}
