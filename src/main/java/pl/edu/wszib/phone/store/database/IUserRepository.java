package pl.edu.wszib.phone.store.database;

import pl.edu.wszib.phone.store.model.User;

public interface IUserRepository {
   User authenticate(User user);
   boolean register(User user);
}
