package com.company.model;

import java.util.UUID;

/**
 * Класс для генерации id
 * @author ThetaSigma 22.08.2021
 */
public class IDGenerator {

   public String generateID(){
       return UUID.randomUUID().toString();
   }


}
