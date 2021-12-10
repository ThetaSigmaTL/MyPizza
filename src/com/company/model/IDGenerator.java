package com.company.model;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Класс для генерации id
 * @author ThetaSigma 22.08.2021
 */
public class IDGenerator {

   public static String generateID(){
               String id = String.format("040d", new BigInteger(UUID.randomUUID().toString().replace("-",""),16));
               return id;
   }


}
