package com.junitbasic.demo.businesslogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BusinessLogicTest {

    @Autowired
    private BusinessLogic businessLogic;

    @Test
    public void genericsTest() {
        String result = businessLogic.generics();
        assertEquals("名前はAliceで、年齢は30歳です", result);
    }

    /**
     * genericsの結果について、nullになってしまうテストケース
     */
    @Test
    public void genericsTest2() {
        // モックの作成
        // Storage<Person> mockStorage = Mockito.mock(Storage.class);
        // // Storageクラスのdescribeメソッドの戻り値をnullに設定
        // when(mockStorage.describe()).thenReturn(null);

        // これでもダメか。。。
        Storage<Person> realStorage = new Storage<>();
        Storage<Person> spyStorage = Mockito.spy(realStorage);

        // describeメソッドの戻り値をnullに設定
        when(spyStorage.describe()).thenReturn(null);

        // 実行
        String result = businessLogic.generics();
        assertNull(result);
    }

}
