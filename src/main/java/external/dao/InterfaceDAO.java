package external.dao;

import external.entity.Region;
import org.apache.log4j.Logger;

import java.util.List;

public interface InterfaceDAO<T> {

    T findById(int i);

    T findByName(String name);

    List<T> findAll();

    void save(T t);

    void delete(T t);

    void update(T t);


}
