package pl.edu.wszib.phone.store.services;

import pl.edu.wszib.phone.store.model.User;
import pl.edu.wszib.phone.store.model.view.RegistrationModel;

public interface IUserService {
    void authenticate(User user);
    void logout();
    boolean register(RegistrationModel registrationModel);
}
