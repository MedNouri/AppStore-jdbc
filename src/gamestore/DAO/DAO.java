package gamestore.DAO;

import gamestore.model.Customer;

import java.util.List;

public interface DAO<T>
{
    public abstract boolean create(T obj);
    public abstract int delete(int id);
    public abstract boolean update(T obj);
    public abstract T find(int id);

}
