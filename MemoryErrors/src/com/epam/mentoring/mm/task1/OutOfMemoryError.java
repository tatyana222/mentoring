package com.epam.mentoring.mm.task1;

import java.math.BigInteger;
import java.util.Random;

// to reproduce the error without waiting a lot (cause max heap size depends on RAM size in your workstation)
// please set -Xms128M -Xmx128M or smaller
public class OutOfMemoryError {

    public static void main(String[] args) {
        String start = new String("Start string");
        Random random = new Random();

        StringBuilder stringBuilder = new StringBuilder(start);
        while(true) {
            String newString = new BigInteger(4096, random).toString(32);
            stringBuilder.append(newString);
            System.out.println(newString);
        }
    }
}
