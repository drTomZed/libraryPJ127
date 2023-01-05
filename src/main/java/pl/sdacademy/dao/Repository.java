package pl.sdacademy.dao;

import java.util.List;

public interface Repository<T, ID> {

    T findById();

    List<T> findAll();

    void persist ();

    void delete();

}
