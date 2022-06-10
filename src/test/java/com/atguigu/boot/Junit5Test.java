package com.atguigu.boot;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.function.ObjIntConsumer;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest//用到SpringBoot
@DisplayName("测试junit5功能类")
public class Junit5Test {
    /**
     * 在断言测试失败后，之后的就不会再继续进行了
     */

    public class TestingAStackDemo{
        Stack<Object> stack;
    }

    @ParameterizedTest
    @DisplayName("参数化测试")
    @ValueSource(ints = {1,2,3,4,5})
    void testParameterizedTest(int i){
        System.out.println(i);
    }

    @Test
    @DisplayName("测试简单断言")
    void testSimpleAssertions(){
        int cal = cal(2,3);
        assertEquals(5,cal,"业务逻辑计算失败");
        //Assertions.assertEquals(期望值,真实值)
        Object object1 = new Object();
        Object object2 = new Object();
//        assertSame(object1,object2,"两个对象不一样");  //两个不一样
    }
    @Test
    @DisplayName("Array assertion测试")
    void array(){
        int[] array01 = new int[]{1,2};
        int[] array02 = new int[]{1,2};
        assertArrayEquals(array01,array02,"两个数组内容不相等");
    }

    @Test
    @DisplayName("组合断言测试")
    void all(){
        assertAll("test",
                () -> assertTrue(true && true),
                ()-> assertEquals(1,1));
    }

    int cal(int i,int j){
        return  i+j;
    }
    @Test
    @DisplayName("测试DisplayName注解")
    void testDisplayName(){
        System.out.println(1);
    }
    @Test
    @DisplayName("异常断言")
    void testExpection(){
        assertThrows(ArithmeticException.class,()->{
            int i = 10/0;          //此处不会报错，因为10/0本身就是异常了，断言成功
            //int j = 10/2;        //此处会报错，因为10/2不是异常数学计算
        },"业务逻辑居然正常运行？？？");
    }

    @Test
    @DisplayName("快速失败")
    void testFail(){
        if(1 == 2){
            fail("测试失败");
        }
    }

    @Test
    @DisplayName("测试前置条件assumptions")
    void testassumptions(){
        Assumptions.assumeTrue(true,"结果不是true");
        System.out.println("11111111");
    }
    /**
     * 在这里设置测试时间，超出时间报错
     */
//    @Test
//    @DisplayName("测试方法2")
//    void test2(){
//        System.out.println(2);
//    }
//    @Test
//    @RepeatedTest(5)
//    void test3(){
//        System.out.println(5);
//    }
//    @Test
//    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
//    void testTimeout() throws InterruptedException {
//        Thread.sleep(2);
//    }
//
//    @BeforeEach
//    void testBeforeEach(){
//        System.out.println("测试就要开始啦...");
//    }
//
//    @AfterEach
//    void testAfterEach(){
//        System.out.println("测试结束了");
//    }
//
//    @BeforeAll
//    static  void testBeforeAll(){
//        System.out.println("所有测试要开始了");
//    }
//
//    @AfterAll
//    static  void testAfterAll(){
//        System.out.println("所有测试结束了");
//    }
}
