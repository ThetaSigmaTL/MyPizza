package com.company.sqlite;

import java.util.List;

public interface GenericComs <T>  {
    abstract List getAll();
    abstract List findById(String id);
    abstract List findByName(String name, String lastName);
    abstract boolean insert (T a);
    abstract boolean delete (T a);
    boolean update (int toUpdate, String data);

}
