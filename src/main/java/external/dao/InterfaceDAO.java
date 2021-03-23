package external.dao;

import external.entity.Region;
import org.apache.log4j.Logger;

import java.util.List;

public interface InterfaceDAO<T> {


    T findById(Integer i);

    void save(T t);

    void delete(T t);

    void update(T t);

    List<T> findAll();

    List<T> findByName(String name);
}
