package pl.edu.wszib.phone.store.services;

import pl.edu.wszib.phone.store.model.Order;

public interface IOrderService {
    void saveOrder(Order order);
    Order getOrderById(int id);
}
