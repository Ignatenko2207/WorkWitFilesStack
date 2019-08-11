package com.stdstack.util;

import java.util.Random;

public class Randomizer {
                                    // 20       40
    public static int getRandomInt(int min, int max){
            // 20                  0............(40-20)
        return min + new Random().nextInt(max-min);
    }

    public static String getRandomIp(){
        return  getRandomInt(100, 255) + "." +
                getRandomInt(100, 255) + "." +
                getRandomInt(100, 255) + "." +
                getRandomInt(100, 255);
    }

    public static Integer getRandomSessionId(){
        return getRandomInt(10_000_000, 99_999_999);
    }

}
