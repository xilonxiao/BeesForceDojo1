package com.bees.brewery;

import java.util.Random;

public class RandomUtil {
    static double getRandom(int min, int max) {
        Random random = new Random();
        return min + (max - min) * random.nextDouble();
    }
}
