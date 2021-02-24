package pl.edu.wszib.phone.store.database;

import pl.edu.wszib.phone.store.model.Phone;

import java.util.List;

public interface IPhonesRepository {
    public List<Phone> getAllPhones();
}
