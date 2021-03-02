package pl.edu.wszib.phone.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.phone.store.dao.IPhoneDAO;
import pl.edu.wszib.phone.store.model.Phone;
import pl.edu.wszib.phone.store.services.IBasketService;
import pl.edu.wszib.phone.store.session.SessionObject;

import javax.annotation.Resource;

@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    IPhoneDAO phoneDAO;

    @Resource
    SessionObject sessionObject;

    @Override
    public double calculateTotal() {
        double sum = 0;
        for (Phone phone : this.sessionObject.getBasket()) {
            sum = sum + phone.getPrice() * phone.getPieces();
        }
        return sum;
    }

    @Override
    public void addPhoneByIdToBasket(int id) {
        Phone phone = this.phoneDAO.getPhoneById(id);
        for (Phone phoneFromBasket : this.sessionObject.getBasket()) {
            if(phoneFromBasket.getId() == phone.getId()){
                phoneFromBasket.setPieces(phoneFromBasket.getPieces() + 1);
                return;
            }
        }

        phone.setPieces(1);
        this.sessionObject.getBasket().add(phone);
    }
}
