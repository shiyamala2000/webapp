package com.mkyong.hashing;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalcTest {
    @BeforeClass
    public static void beforeClasstest(){
       System.out.println("before class"); 
    }
    @Before
    public void AfterClasstest(){
       System.out.println("before "); 
    }
    @Test
    public void test1(){
        System.out.println("Test1");

    }
    @Ignore
    public void test2(){
        System.out.println("Test2");

    }
    @After
    public void beforetest(){
       System.out.println("after Test"); 
    }
    @AfterClass
    public static void afterClasstest(){
       System.out.println("after class"); 
    }
    @Test
    public void addtest(){
        Calc c=new Calc();
        int ar=c.add(10, 20);
        assertEquals(30, ar);
        System.out.println(ar);
    }


    
}
