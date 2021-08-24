package com.company;
import com.company.model.Account;
import com.company.model.Customer;
import com.company.model.Employee;
import com.company.repository.data.*;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> listik= new ArrayList<>();
        String fileAcc = PathStrings.accountsFIlePathString;
        Scanner readAccountFile = new Scanner(PathStrings.accountsFIlePathString);
        while (readAccountFile.hasNext()){
            listik.add(readAccountFile.next());
        }
        try{

        listik.add(Files.readString(Paths.get(PathStrings.accountsFIlePathString)));
        }
        catch (Exception ex) {

        }
        for (String a: listik) {
            System.out.println(a);

        }
        Path pathFile = Paths.get(PathStrings.accountsFIlePathString);
        try {
            BufferedReader br = Files.newBufferedReader(pathFile, Charset.defaultCharset());
            System.out.print(br.readLine());
        }
        catch (Exception ex){

        }



    }
}
