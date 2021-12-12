package com.company.model;

import java.math.BigInteger;
import java.util.UUID;

/**
 * Класс для генерации id
 * @author ThetaSigma 22.08.2021
 */
public class IdGenerator {

   public static String generateID(){
               String id = UUID.randomUUID().toString();
               return id;
   }


}
