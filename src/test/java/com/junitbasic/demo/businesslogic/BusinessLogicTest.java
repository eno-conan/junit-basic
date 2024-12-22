package com.junitbasic.demo.businesslogic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.junitbasic.demo.dto.SampleCondition;
import com.junitbasic.demo.generic.Person;
import com.junitbasic.demo.generic.Storage;
import com.junitbasic.demo.mapper.ApiMapper;

@SpringBootTest
public class BusinessLogicTest {

    @Autowired
    private BusinessLogic businessLogic;

    @MockitoBean
    private ApiMapper apiMapper;

    @Test
    public void logicTest() {
        // 実行
        BusinessLogicInput input = createInput();
        BusinessLogicOutput output = businessLogic.logic(input);
        assertNotNull(output);

        // SampleConditionに正しく値が設定されているか確認
        ArgumentCaptor<SampleCondition> captor = ArgumentCaptor.forClass(SampleCondition.class);
        verify(apiMapper).getSampleDataByCondtion(captor.capture());
        SampleCondition condition = captor.getValue();
        assertEquals(input.getContractNumber(), condition.getContractNumber());
        assertEquals(input.getContractStatus(), condition.getContractStatus());
    }

    /** privateメソッド(isCheckedOneOfThemIsNull)のテスト。
     * 
     * 2つの引数とも値が設定されている場合。
     * 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
    */
    @Test
    void isCheckedOneOfThemIsNullTest_BothParamterAreNotNull()
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Method method;

        method = BusinessLogic.class.getDeclaredMethod("isCheckedOneOfThemIsNull", String.class, String.class);
        method.setAccessible(true);
        boolean flg = (boolean) method.invoke(businessLogic, "testStr!", "testStr2");
        assertEquals(flg, false);
    }

    /** privateメソッド(isCheckedOneOfThemIsNull)のテスト。
     * 
     * 1つ目の引数がnullの場合。
     * 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
    */
    @Test
    void isCheckedOneOfThemIsNullTest_FirstParamterAreIsNull()
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Method method;

        method = BusinessLogic.class.getDeclaredMethod("isCheckedOneOfThemIsNull", String.class, String.class);
        method.setAccessible(true);
        boolean flg = (boolean) method.invoke(businessLogic, null, "testStr2");
        assertEquals(flg, true);
    }
    
    /** privateメソッド(isCheckedOneOfThemIsNull)のテスト。
     * 
     * 2つ目の引数がnullの場合。
     * 
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     */
    @Test
    void isCheckedOneOfThemIsNullTest_SecondParamterAreIsNull()
    throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Method method;
        
        method = BusinessLogic.class.getDeclaredMethod("isCheckedOneOfThemIsNull", String.class, String.class);
        method.setAccessible(true);
        boolean flg = (boolean) method.invoke(businessLogic, "testStr!", null);
        assertEquals(flg, true);
    }

    /**
     * 仮のBusinessLogicInputを作成。
     */
    private BusinessLogicInput createInput() {
        BusinessLogicInput input = new BusinessLogicInput();
        input.setContractNumber("1234567890");
        input.setContractNumberBranch("123");
        return input;
    }

    @Test
    public void genericsTest() {
        String result = businessLogic.generics();
        assertEquals("名前はAliceで、年齢は30歳です", result);
    }

    /**
     * genericsの結果について、nullになってしまうテストケース
     */
    // @Test
    // public void genericsTest2() {
    //     // モックの作成
    //     // Storage<Person> mockStorage = Mockito.mock(Storage.class);
    //     // // Storageクラスのdescribeメソッドの戻り値をnullに設定
    //     // when(mockStorage.describe()).thenReturn(null);

    //     // これでもダメか。。。
    //     Storage<Person> realStorage = new Storage<>();
    //     Storage<Person> spyStorage = Mockito.spy(realStorage);

    //     // describeメソッドの戻り値をnullに設定
    //     when(spyStorage.describe()).thenReturn(null);

    //     // 実行
    //     String result = businessLogic.generics();
    //     assertNull(result);
    // }

}
