package external.DAO;

import java.util.List;

public interface InterfaceDAO<T> {


    T findById(Integer id);

    void save(T t);

    void delete(T t);

    void update(T t);

    List<T> findAll();

    T findByName(String name);
}
