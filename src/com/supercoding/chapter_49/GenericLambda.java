package com.supercoding.chapter_49;

@FunctionalInterface
public interface GenericLambda<T> {
    T calculate(T val);
}
