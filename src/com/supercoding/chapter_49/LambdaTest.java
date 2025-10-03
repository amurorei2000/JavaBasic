package com.supercoding.chapter_49;

public class LambdaTest {
    public static void main(String[] args) {
        GenericLambda<Integer> gl1 = (num) -> num * 2;
        GenericLambda<String> gl2 = (str) -> str.toUpperCase();

        System.out.println(gl1.calculate(5));
        System.out.println(gl2.calculate("abc"));
    }
}
