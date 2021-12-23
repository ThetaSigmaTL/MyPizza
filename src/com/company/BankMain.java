package com.company;
import com.company.menus.MainMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankMain {
    public static void main(String[] args){
        User user = new User("Tom");
        User user1 = new User("Jake");
        System.out.println(User.getAllUsers().toString());
    }
}
  class User {
    public String name;
    private static int id = 0;
    private static  HashMap<Integer, User> allUsers = new HashMap<>();
    User(String name){
        this.name = name;
        id++;
        allUsers.put(id,this);
    }
      public static HashMap<Integer, User> getAllUsers() {
          return allUsers;
      }
  }




