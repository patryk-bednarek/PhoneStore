package pl.edu.wszib.phone.store.database.impl;

import org.springframework.stereotype.Component;
import pl.edu.wszib.phone.store.database.IPhonesRepository;
import pl.edu.wszib.phone.store.model.Phone;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhonesRepository implements IPhonesRepository {

    private final List<Phone> phones = new ArrayList<>();

    public PhonesRepository() {
        this.phones.add (new Phone("Iphone","11","iOS",1999,19 ));
        this.phones.add (new Phone("Samsung","Galaxy Note 20","Android",4999,20 ));
        this.phones.add (new Phone("Xiaomi","Redmi Note 10","MIUI",999,39 ));
        this.phones.add (new Phone("Huawei","P30 Pro","EMUI",1999,19 ));
    }

    @Override
    public List<Phone> getAllPhones() {
        return this.phones;
    }

    @Override
    public Phone getPhoneByModel(String model) {
        for(Phone phone : this.phones) {
            if(phone.getModel().equals(model)) {
                return phone;
            }
        }
        return null;
    }
}
