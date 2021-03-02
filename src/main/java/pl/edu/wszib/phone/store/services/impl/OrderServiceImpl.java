package pl.edu.wszib.phone.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.phone.store.dao.IOrderDAO;
import pl.edu.wszib.phone.store.model.Order;
import pl.edu.wszib.phone.store.services.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrderDAO orderDAO;

    @Override
    public void saveOrder(Order order) {
        this.orderDAO.saveOrder(order);
    }

    @Override
    public Order getOrderById(int id) {
         return this.orderDAO.getOrderById(id);
    }
}
