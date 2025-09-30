package com.supercoding.chapter_44;

public class Main {
    public static void main(String[] args) {
        // +=
        String str = "";
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 500; i++) {
            str += "Cat";
        }
        System.out.println(str);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println(duration + "ms");

        // StringBuilder
        StringBuilder sb = new StringBuilder();

        startTime = System.currentTimeMillis();
        sb.append("cat".repeat(500));
        System.out.println(sb.toString());

        duration = System.currentTimeMillis() - startTime;
        System.out.println(duration + "ms");
    }
}
