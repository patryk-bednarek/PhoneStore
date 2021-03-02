package pl.edu.wszib.phone.store.services;

import pl.edu.wszib.phone.store.model.Phone;

import java.util.ArrayList;
import java.util.List;

public interface IPhoneService {
    Phone getPhoneById(int id);
    void updatePhone(Phone phone);
    List<Phone> getAllPhones();
}
