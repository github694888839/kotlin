package org.example.gson;

import java.util.Arrays;

public class UUIDTest {
    public static void main(String[] args) {
        System.out.println(createUUID());
        long time = System.currentTimeMillis();
        System.out.println(time);
        System.out.println(time % 1000);
    }

    public static String createUUID() {
        return String.valueOf(java.util.UUID.randomUUID());
                //+ String.valueOf(System.currentTimeMillis() % 1000);
    }
}
