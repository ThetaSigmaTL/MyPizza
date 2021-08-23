package com.company.model;

import java.util.Random;

public class AccountNumGenerator {

    public static String accountNum(){
        String privatePersonAccountNum = "408178";
        String accountNumBlockTwo;
        String accountNumBlockThree;
        Random random = new Random();
        accountNumBlockTwo= random.longs(0,9999999).toString();
        accountNumBlockThree = random.longs(0,9999999).toString();
        return privatePersonAccountNum + accountNumBlockTwo + accountNumBlockThree;

    }


}
