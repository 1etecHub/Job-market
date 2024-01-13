package com.jobmarket.jobmarketapp.utils;

public class RandomTokenGen {

    public static String generateRandomToken(){
        int randNum = (int) (Math.random() * 1000000);

        return String.format("SWS-%s", randNum);
    }
}
