package com.supercoding.chapter_48;

public enum OrderStatus {
    ON_ORDER("주문 처리 중"),
    PAID("입금"),
    NOT_PAID("입금 전"),
    SHIPPED("배송 중");

    private String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
