package com.bees.brewery.core;

import java.util.Random;

public class RandomUtil {
    public static double getRandom(int min, int max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}
