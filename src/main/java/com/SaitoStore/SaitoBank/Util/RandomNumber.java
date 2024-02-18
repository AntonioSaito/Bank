package com.SaitoStore.SaitoBank.Util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomNumber {

    public static String generateAccountNumber() {
        Random random = new Random();
        int accountRandomNumber = 1000 + random.nextInt(9000);
        return String.valueOf(accountRandomNumber);
    }
}
