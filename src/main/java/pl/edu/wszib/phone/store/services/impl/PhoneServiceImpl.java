package pl.edu.wszib.phone.store.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.edu.wszib.phone.store.dao.IPhoneDAO;
import pl.edu.wszib.phone.store.model.Phone;
import pl.edu.wszib.phone.store.services.IPhoneService;

import java.util.List;

@Service
public class PhoneServiceImpl implements IPhoneService {
    @Autowired
    IPhoneDAO phoneDAO;

    @Override
    public Phone getPhoneById(int id) {
        return this.phoneDAO.getPhoneById(id);
    }

    @Override
    public void updatePhone(Phone phone) {
        Phone phoneFromDB = this.phoneDAO.getPhoneById(phone.getId());
        phoneFromDB.setBrand(phone.getBrand());
        phoneFromDB.setModel(phone.getModel());
        phoneFromDB.setSoftware(phone.getSoftware());
        phoneFromDB.setPrice(phone.getPrice());
        phoneFromDB.setPieces(phone.getPieces());

        this.phoneDAO.updatePhone(phoneFromDB);
    }

    @Override
    public List<Phone> getAllPhones() {
         return this.phoneDAO.getAllPhones();
    }
}
