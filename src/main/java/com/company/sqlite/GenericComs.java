package com.company.sqlite;

import java.util.List;

public interface GenericComs <T, M>  {
    List getAll();
    abstract M findById(String id);
    abstract List findByName(String name, String lastName);
    abstract boolean insert(T object);
    abstract boolean delete(T object);
    boolean update(T object);
}
