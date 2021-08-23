package com.company.model;

import java.util.Date;
import java.util.Random;

/**
 * Класс для генерации номера счета
 */
public class AccountNumGenerator {

    public static String accountNum(){
        Date date = new Date();
        date.getTime();
        String privatePersonAccountNum = "408178";
        String accountNumBlockTwo;
        String accountNumBlockThree;
        Random random = new Random();
        accountNumBlockTwo= random.longs(0,9999999).toString();
        accountNumBlockThree = random.longs(0,9999999).toString();
        return privatePersonAccountNum + accountNumBlockTwo + accountNumBlockThree;

    }


}
