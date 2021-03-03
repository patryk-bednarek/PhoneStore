package pl.edu.wszib.phone.store.dao.impl;

import pl.edu.wszib.phone.store.dao.IPhoneDAO;
import pl.edu.wszib.phone.store.model.Phone;

import java.util.List;

public class PhoneDAOStub implements IPhoneDAO {
    @Override
    public Phone getPhoneById(int id) {
        return null;
    }

    @Override
    public void updatePhone(Phone phone) {

    }

    @Override
    public List<Phone> getAllPhones() {
        return null;
    }
}
