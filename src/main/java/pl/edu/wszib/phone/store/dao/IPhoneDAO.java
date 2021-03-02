package pl.edu.wszib.phone.store.dao;

import pl.edu.wszib.phone.store.model.Phone;

import java.util.List;

public interface IPhoneDAO {
    Phone getPhoneById(int id);
    void updatePhone(Phone phone);
    List<Phone> getAllPhones();
}
