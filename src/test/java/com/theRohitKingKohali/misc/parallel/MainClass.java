package com.theRohitKingKohali.misc.parallel;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class MainClass {
    @Test
    public void testMethods() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is:" + id + getClass());
    }

    @Test
    public void testMethods1() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method one.Thread id is:" + id + getClass());
    }

    @Test
    public void testMethod2() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method two.Thread id is:" + id + getClass());
    }

    @Test
    public void testMethods3() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method three.Thread id is:" + id + getClass());
    }

    @Test
    public void testMethods4() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method four.Thread id is:" + id + getClass());
    }

    @Test
    public void testMethods5() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method five.Thread id is:" + id + getClass());

    }

    @Test
    public void testMethods6() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method six.Thread id is:" + id + getClass());

    }

    @AfterTest
    public void afterMethod() {

        long id = Thread.currentThread().getId();
        System.out.println("After test-method six.Thread id is:" + id + getClass());
    }

}