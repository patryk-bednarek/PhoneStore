package pl.edu.wszib.phone.store.dao.impl;

import pl.edu.wszib.phone.store.dao.IOrderDAO;
import pl.edu.wszib.phone.store.model.Order;

public class OrderDAOStub implements IOrderDAO {
    @Override
    public void saveOrder(Order order) {

    }

    @Override
    public Order getOrderById(int id) {
        return null;
    }
}
