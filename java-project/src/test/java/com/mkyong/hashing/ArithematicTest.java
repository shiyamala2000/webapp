package com.mkyong.hashing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ArithematicTest {
    private int firstnumber;
    private int secondnumber;
    private int expectedResult;
    private Arithematic arithematic;

    public ArithematicTest(int firstnumber, int secondnumber, int expectedResult) {
        this.firstnumber = firstnumber;
        this.secondnumber = secondnumber;
        this.expectedResult = expectedResult;
    }

    @Before
    public void initialize() {
        arithematic = new Arithematic();
    }

    @Parameterized.Parameters
    public static List<Object[]> input() {
        return Arrays.asList(new Object[][] { { 1, 2, 3 }, { 11, 22, 33 }, { 111, 222, 333 },{10,9,19},{100,9,109}});
    }

    @Test
    public void testArithematictest() {
        System.out.println("sum of numbers:" + expectedResult);
        assertEquals(expectedResult, arithematic.sum(firstnumber, secondnumber));
    }
}
