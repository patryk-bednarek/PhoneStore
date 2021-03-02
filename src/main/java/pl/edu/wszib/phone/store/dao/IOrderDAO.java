package pl.edu.wszib.phone.store.dao;

import pl.edu.wszib.phone.store.model.Order;

public interface IOrderDAO {
    void saveOrder(Order order);
    Order getOrderById(int id);
}
